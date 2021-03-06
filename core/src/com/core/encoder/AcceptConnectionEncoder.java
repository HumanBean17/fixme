package com.core.encoder;

import com.core.message.MessageAcceptConnection;
import com.core.message.MessageTypes;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class AcceptConnectionEncoder extends MessageToByteEncoder<MessageAcceptConnection> {

	private final Charset charset = StandardCharsets.UTF_8;

	@Override
	protected void encode(ChannelHandlerContext ctx, MessageAcceptConnection msg, ByteBuf out) {
		out.writeInt(msg.getTypeLength());
		out.writeCharSequence(msg.getMessageType(), charset);
		if (msg.getMessageType().equals(MessageTypes.MESSAGE_ACCEPT_CONNECTION.toString())) {
			out.writeInt(msg.getId());
			out.writeInt(msg.getChecksumLength());
			out.writeCharSequence(msg.getChecksum(), charset);
		}
	}
}