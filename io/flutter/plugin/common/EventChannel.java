package io.flutter.plugin.common;

import android.util.Log;
import androidx.annotation.UiThread;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class EventChannel {
    public static final String TAG = "EventChannel#";
    public final MethodCodec codec;
    public final BinaryMessenger messenger;
    public final String name;

    /* loaded from: classes7.dex */
    public interface EventSink {
        void endOfStream();

        void error(String str, String str2, Object obj);

        void success(Object obj);
    }

    /* loaded from: classes7.dex */
    public final class IncomingStreamRequestHandler implements BinaryMessenger.BinaryMessageHandler {
        public final AtomicReference<EventSink> activeSink = new AtomicReference<>(null);
        public final StreamHandler handler;

        /* loaded from: classes7.dex */
        public final class EventSinkImplementation implements EventSink {
            public final AtomicBoolean hasEnded;

            public EventSinkImplementation() {
                this.hasEnded = new AtomicBoolean(false);
            }

            @Override // io.flutter.plugin.common.EventChannel.EventSink
            @UiThread
            public void endOfStream() {
                if (this.hasEnded.getAndSet(true) || IncomingStreamRequestHandler.this.activeSink.get() != this) {
                    return;
                }
                EventChannel.this.messenger.send(EventChannel.this.name, null);
            }

            @Override // io.flutter.plugin.common.EventChannel.EventSink
            @UiThread
            public void error(String str, String str2, Object obj) {
                if (this.hasEnded.get() || IncomingStreamRequestHandler.this.activeSink.get() != this) {
                    return;
                }
                EventChannel.this.messenger.send(EventChannel.this.name, EventChannel.this.codec.encodeErrorEnvelope(str, str2, obj));
            }

            @Override // io.flutter.plugin.common.EventChannel.EventSink
            @UiThread
            public void success(Object obj) {
                if (this.hasEnded.get() || IncomingStreamRequestHandler.this.activeSink.get() != this) {
                    return;
                }
                EventChannel.this.messenger.send(EventChannel.this.name, EventChannel.this.codec.encodeSuccessEnvelope(obj));
            }
        }

        public IncomingStreamRequestHandler(StreamHandler streamHandler) {
            this.handler = streamHandler;
        }

        private void onCancel(Object obj, BinaryMessenger.BinaryReply binaryReply) {
            if (this.activeSink.getAndSet(null) == null) {
                binaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope("error", "No active stream to cancel", null));
                return;
            }
            try {
                this.handler.onCancel(obj);
                binaryReply.reply(EventChannel.this.codec.encodeSuccessEnvelope(null));
            } catch (RuntimeException e2) {
                Log.e(EventChannel.TAG + EventChannel.this.name, "Failed to close event stream", e2);
                binaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope("error", e2.getMessage(), null));
            }
        }

        private void onListen(Object obj, BinaryMessenger.BinaryReply binaryReply) {
            EventSinkImplementation eventSinkImplementation = new EventSinkImplementation();
            if (this.activeSink.getAndSet(eventSinkImplementation) != null) {
                try {
                    this.handler.onCancel(null);
                } catch (RuntimeException e2) {
                    Log.e(EventChannel.TAG + EventChannel.this.name, "Failed to close existing event stream", e2);
                }
            }
            try {
                this.handler.onListen(obj, eventSinkImplementation);
                binaryReply.reply(EventChannel.this.codec.encodeSuccessEnvelope(null));
            } catch (RuntimeException e3) {
                this.activeSink.set(null);
                Log.e(EventChannel.TAG + EventChannel.this.name, "Failed to open event stream", e3);
                binaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope("error", e3.getMessage(), null));
            }
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
        public void onMessage(ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
            MethodCall decodeMethodCall = EventChannel.this.codec.decodeMethodCall(byteBuffer);
            if (decodeMethodCall.method.equals("listen")) {
                onListen(decodeMethodCall.arguments, binaryReply);
            } else if (decodeMethodCall.method.equals(QueryResponse.Options.CANCEL)) {
                onCancel(decodeMethodCall.arguments, binaryReply);
            } else {
                binaryReply.reply(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface StreamHandler {
        void onCancel(Object obj);

        void onListen(Object obj, EventSink eventSink);
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str) {
        this(binaryMessenger, str, StandardMethodCodec.INSTANCE);
    }

    @UiThread
    public void setStreamHandler(StreamHandler streamHandler) {
        this.messenger.setMessageHandler(this.name, streamHandler == null ? null : new IncomingStreamRequestHandler(streamHandler));
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec) {
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = methodCodec;
    }
}
