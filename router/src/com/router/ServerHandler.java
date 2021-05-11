package com.router;

import com.core.message.FIXMessage;
import com.core.message.MessageAcceptConnection;
import com.core.message.MessageTypes;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        FIXMessage message = (FIXMessage) msg;
        if (message.getMessageType().equals(MessageTypes.MESSAGE_ACCEPT_CONNECTION.toString()))
            acceptNewConnection(ctx, msg);
//        else if (message.getMessageType().equals(MessageTypes.MESSAGE_BUY.toString()) ||
//                message.getMessageType().equals(MessageTypes.MESSAGE_SELL.toString())) {
//            MessageSellOrBuy ret = (MessageSellOrBuy)msg;
//            try {
//                checkForErrors(ret);
//                if (checkIfMessageIsRejectedOrExecuted(ret))
//                    return;
//                System.out.println("Sending request to market with ID " + ret.getMarketId());
//                getFromTableById(ret.getMarketId()).channel().writeAndFlush(ret);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                ret.setMessageAction(MessageTypes.MESSAGE_REJECT.toString());
//                ret.setNewCheckSum();
//                ctx.writeAndFlush(ret);
//            }
//        }
    }

    private void acceptNewConnection(ChannelHandlerContext ctx, Object msg) {
//        MessageAcceptConnection ret  = (MessageAcceptConnection)msg;
//        String newID = ctx.channel().remoteAddress().toString().substring(11);
//        newID = newID.concat(serverType != MARKET_SERVER ? "2" : "3");
//        ret.setId(Integer.valueOf(newID));
//        ret.setNewCheckSum();
//        ctx.writeAndFlush(ret);
//        routingTable.put(ret.getId(), ctx);
//        System.out.println("Accepted a connection from " + brokerOrMarketString() + ": " + newID);
    }
}
