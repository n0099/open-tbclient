package io.flutter.plugin.common;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public final class MethodChannel {
    private static final String TAG = "MethodChannel#";
    private final MethodCodec codec;
    private final BinaryMessenger messenger;
    private final String name;

    /* loaded from: classes9.dex */
    public interface MethodCallHandler {
        void onMethodCall(MethodCall methodCall, Result result);
    }

    /* loaded from: classes9.dex */
    public interface Result {
        void error(String str, String str2, Object obj);

        void notImplemented();

        void success(Object obj);
    }

    public MethodChannel(BinaryMessenger binaryMessenger, String str) {
        this(binaryMessenger, str, StandardMethodCodec.INSTANCE);
    }

    public MethodChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec) {
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = methodCodec;
    }

    public void invokeMethod(String str, Object obj) {
        invokeMethod(str, obj, null);
    }

    public void invokeMethod(String str, Object obj, Result result) {
        this.messenger.send(this.name, this.codec.encodeMethodCall(new MethodCall(str, obj)), result == null ? null : new IncomingResultHandler(result));
    }

    public void setMethodCallHandler(MethodCallHandler methodCallHandler) {
        this.messenger.setMessageHandler(this.name, methodCallHandler == null ? null : new IncomingMethodCallHandler(methodCallHandler));
    }

    public void resizeChannelBuffer(int i) {
        BasicMessageChannel.resizeChannelBuffer(this.messenger, this.name, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public final class IncomingResultHandler implements BinaryMessenger.BinaryReply {
        private final Result callback;

        IncomingResultHandler(Result result) {
            this.callback = result;
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
        public void reply(ByteBuffer byteBuffer) {
            try {
                if (byteBuffer != null) {
                    try {
                        this.callback.success(MethodChannel.this.codec.decodeEnvelope(byteBuffer));
                    } catch (FlutterException e) {
                        this.callback.error(e.code, e.getMessage(), e.details);
                    }
                } else {
                    this.callback.notImplemented();
                }
            } catch (RuntimeException e2) {
                Log.e(MethodChannel.TAG + MethodChannel.this.name, "Failed to handle method call result", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public final class IncomingMethodCallHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MethodCallHandler handler;

        IncomingMethodCallHandler(MethodCallHandler methodCallHandler) {
            this.handler = methodCallHandler;
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
        public void onMessage(ByteBuffer byteBuffer, final BinaryMessenger.BinaryReply binaryReply) {
            try {
                this.handler.onMethodCall(MethodChannel.this.codec.decodeMethodCall(byteBuffer), new Result() { // from class: io.flutter.plugin.common.MethodChannel.IncomingMethodCallHandler.1
                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void success(Object obj) {
                        binaryReply.reply(MethodChannel.this.codec.encodeSuccessEnvelope(obj));
                    }

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void error(String str, String str2, Object obj) {
                        binaryReply.reply(MethodChannel.this.codec.encodeErrorEnvelope(str, str2, obj));
                    }

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void notImplemented() {
                        binaryReply.reply(null);
                    }
                });
            } catch (RuntimeException e) {
                Log.e(MethodChannel.TAG + MethodChannel.this.name, "Failed to handle method call", e);
                binaryReply.reply(MethodChannel.this.codec.encodeErrorEnvelope(BdStatsConstant.StatsType.ERROR, e.getMessage(), null));
            }
        }
    }
}
