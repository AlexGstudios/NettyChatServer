package com.chattserver;

import java.util.ArrayList;
import java.util.List;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    static final List<Channel> channels = new ArrayList<Channel>();

    @Override
    public void channelActive(final ChannelHandlerContext ctx) {

        System.out.println("Client joined ... " + ctx);
        channels.add(ctx.channel());
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("Server recieved ... " + msg);
        for (Channel channel : channels) {
            channel.writeAndFlush("-> " + msg + "\n");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("Closing connection for client ... " + ctx);
        ctx.close();
    }
}