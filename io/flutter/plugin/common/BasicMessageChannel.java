package io.flutter.plugin.common;

import android.util.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;
/* loaded from: classes9.dex */
public final class BasicMessageChannel<T> {
    public static final String CHANNEL_BUFFERS_CHANNEL = "dev.flutter/channel-buffers";
    private static final String TAG = "BasicMessageChannel#";
    private final MessageCodec<T> codec;
    private final BinaryMessenger messenger;
    private final String name;

    /* loaded from: classes9.dex */
    public interface MessageHandler<T> {
        void onMessage(T t, Reply<T> reply);
    }

    /* loaded from: classes9.dex */
    public interface Reply<T> {
        void reply(T t);
    }

    public BasicMessageChannel(BinaryMessenger binaryMessenger, String str, MessageCodec<T> messageCodec) {
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = messageCodec;
    }

    public void send(T t) {
        send(t, null);
    }

    public void send(T t, Reply<T> reply) {
        this.messenger.send(this.name, this.codec.encodeMessage(t), reply != null ? new IncomingReplyHandler(reply) : null);
    }

    public void setMessageHandler(MessageHandler<T> messageHandler) {
        this.messenger.setMessageHandler(this.name, messageHandler != null ? new IncomingMessageHandler(messageHandler) : null);
    }

    public void resizeChannelBuffer(int i) {
        resizeChannelBuffer(this.messenger, this.name, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void resizeChannelBuffer(BinaryMessenger binaryMessenger, String str, int i) {
        binaryMessenger.send(CHANNEL_BUFFERS_CHANNEL, ByteBuffer.wrap(String.format(Locale.US, "resize\r%s\r%d", str, Integer.valueOf(i)).getBytes(Charset.forName("UTF-8"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public final class IncomingReplyHandler implements BinaryMessenger.BinaryReply {
        private final Reply<T> callback;

        private IncomingReplyHandler(Reply<T> reply) {
            this.callback = reply;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: io.flutter.plugin.common.BasicMessageChannel$Reply<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
        public void reply(ByteBuffer byteBuffer) {
            try {
                this.callback.reply(BasicMessageChannel.this.codec.decodeMessage(byteBuffer));
            } catch (RuntimeException e) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message reply", e);
            }
        }
    }

    /* loaded from: classes9.dex */
    private final class IncomingMessageHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MessageHandler<T> handler;

        private IncomingMessageHandler(MessageHandler<T> messageHandler) {
            this.handler = messageHandler;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.flutter.plugin.common.BasicMessageChannel$MessageHandler<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
        public void onMessage(ByteBuffer byteBuffer, final BinaryMessenger.BinaryReply binaryReply) {
            try {
                this.handler.onMessage(BasicMessageChannel.this.codec.decodeMessage(byteBuffer), new Reply<T>() { // from class: io.flutter.plugin.common.BasicMessageChannel.IncomingMessageHandler.1
                    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                    public void reply(T t) {
                        binaryReply.reply(BasicMessageChannel.this.codec.encodeMessage(t));
                    }
                });
            } catch (RuntimeException e) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message", e);
                binaryReply.reply(null);
            }
        }
    }
}
