package com.core.client;

import com.core.encoder.AcceptConnectionEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client implements Runnable {

    private String  clientName;
    private EventLoopGroup workerGroup;
    private int uniqueID;

    private String name;

    private final String host = "localhost";
    private int port;

    public Client(String name) {
        this.name = name;
        if (name.equalsIgnoreCase("broker")) {
            this.port = 5000;
        } else if (name.equalsIgnoreCase("market")) {
            this.port = 5001;
        }
    }

    @Override
    public void run() {
        workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(
//                                    new Decoder(),
                                    new AcceptConnectionEncoder(),
//                                    new SellOrBuyEncoder(),
                                    new ClientHandler());
                        }
                    }).option(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public static void handleInput(Client client) {

    }
}
