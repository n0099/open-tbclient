package io.flutter.plugin.common;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;
/* loaded from: classes7.dex */
public final class BasicMessageChannel<T> {
    public static final String CHANNEL_BUFFERS_CHANNEL = "dev.flutter/channel-buffers";
    public static final String TAG = "BasicMessageChannel#";
    @NonNull
    public final MessageCodec<T> codec;
    @NonNull
    public final BinaryMessenger messenger;
    @NonNull
    public final String name;

    /* loaded from: classes7.dex */
    public final class IncomingMessageHandler implements BinaryMessenger.BinaryMessageHandler {
        public final MessageHandler<T> handler;

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.flutter.plugin.common.BasicMessageChannel$MessageHandler<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
        public void onMessage(@Nullable ByteBuffer byteBuffer, @NonNull final BinaryMessenger.BinaryReply binaryReply) {
            try {
                this.handler.onMessage(BasicMessageChannel.this.codec.decodeMessage(byteBuffer), new Reply<T>() { // from class: io.flutter.plugin.common.BasicMessageChannel.IncomingMessageHandler.1
                    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                    public void reply(T t) {
                        binaryReply.reply(BasicMessageChannel.this.codec.encodeMessage(t));
                    }
                });
            } catch (RuntimeException e2) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message", e2);
                binaryReply.reply(null);
            }
        }

        public IncomingMessageHandler(@NonNull MessageHandler<T> messageHandler) {
            this.handler = messageHandler;
        }
    }

    /* loaded from: classes7.dex */
    public final class IncomingReplyHandler implements BinaryMessenger.BinaryReply {
        public final Reply<T> callback;

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.flutter.plugin.common.BasicMessageChannel$Reply<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
        public void reply(@Nullable ByteBuffer byteBuffer) {
            try {
                this.callback.reply(BasicMessageChannel.this.codec.decodeMessage(byteBuffer));
            } catch (RuntimeException e2) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message reply", e2);
            }
        }

        public IncomingReplyHandler(@NonNull Reply<T> reply) {
            this.callback = reply;
        }
    }

    /* loaded from: classes7.dex */
    public interface MessageHandler<T> {
        void onMessage(@Nullable T t, @NonNull Reply<T> reply);
    }

    /* loaded from: classes7.dex */
    public interface Reply<T> {
        void reply(@Nullable T t);
    }

    public BasicMessageChannel(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, @NonNull MessageCodec<T> messageCodec) {
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = messageCodec;
    }

    public void resizeChannelBuffer(int i2) {
        resizeChannelBuffer(this.messenger, this.name, i2);
    }

    public void send(@Nullable T t) {
        send(t, null);
    }

    @UiThread
    public void setMessageHandler(@Nullable MessageHandler<T> messageHandler) {
        this.messenger.setMessageHandler(this.name, messageHandler != null ? new IncomingMessageHandler(messageHandler) : null);
    }

    public static void resizeChannelBuffer(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, int i2) {
        binaryMessenger.send(CHANNEL_BUFFERS_CHANNEL, ByteBuffer.wrap(String.format(Locale.US, "resize\r%s\r%d", str, Integer.valueOf(i2)).getBytes(Charset.forName("UTF-8"))));
    }

    @UiThread
    public void send(@Nullable T t, @Nullable Reply<T> reply) {
        this.messenger.send(this.name, this.codec.encodeMessage(t), reply != null ? new IncomingReplyHandler(reply) : null);
    }
}
