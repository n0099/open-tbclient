package io.flutter.embedding.engine.dart;

import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class DartMessenger implements PlatformMessageHandler, BinaryMessenger {
    private static final String TAG = "DartMessenger";
    private final FlutterJNI flutterJNI;
    private int nextReplyId = 1;
    private final Map<String, BinaryMessenger.BinaryMessageHandler> messageHandlers = new HashMap();
    private final Map<Integer, BinaryMessenger.BinaryReply> pendingReplies = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DartMessenger(FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        if (binaryMessageHandler == null) {
            Log.v(TAG, "Removing handler for channel '" + str + "'");
            this.messageHandlers.remove(str);
            return;
        }
        Log.v(TAG, "Setting handler for channel '" + str + "'");
        this.messageHandlers.put(str, binaryMessageHandler);
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void send(String str, ByteBuffer byteBuffer) {
        Log.v(TAG, "Sending message over channel '" + str + "'");
        send(str, byteBuffer, null);
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        Log.v(TAG, "Sending message with callback over channel '" + str + "'");
        int i = 0;
        if (binaryReply != null) {
            i = this.nextReplyId;
            this.nextReplyId = i + 1;
            this.pendingReplies.put(Integer.valueOf(i), binaryReply);
        }
        if (byteBuffer == null) {
            this.flutterJNI.dispatchEmptyPlatformMessage(str, i);
        } else {
            this.flutterJNI.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i);
        }
    }

    @Override // io.flutter.embedding.engine.dart.PlatformMessageHandler
    public void handleMessageFromDart(String str, byte[] bArr, int i) {
        Log.v(TAG, "Received message from Dart over channel '" + str + "'");
        BinaryMessenger.BinaryMessageHandler binaryMessageHandler = this.messageHandlers.get(str);
        if (binaryMessageHandler != null) {
            try {
                Log.v(TAG, "Deferring to registered handler to process message.");
                binaryMessageHandler.onMessage(bArr == null ? null : ByteBuffer.wrap(bArr), new Reply(this.flutterJNI, i));
                return;
            } catch (Exception e) {
                Log.e(TAG, "Uncaught exception in binary message listener", e);
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i);
                return;
            }
        }
        Log.v(TAG, "No registered handler for message. Responding to Dart with empty reply message.");
        this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i);
    }

    @Override // io.flutter.embedding.engine.dart.PlatformMessageHandler
    public void handlePlatformMessageResponse(int i, byte[] bArr) {
        Log.v(TAG, "Received message reply from Dart.");
        BinaryMessenger.BinaryReply remove = this.pendingReplies.remove(Integer.valueOf(i));
        if (remove != null) {
            try {
                Log.v(TAG, "Invoking registered callback for reply from Dart.");
                remove.reply(bArr == null ? null : ByteBuffer.wrap(bArr));
            } catch (Exception e) {
                Log.e(TAG, "Uncaught exception in binary message reply handler", e);
            }
        }
    }

    public int getPendingChannelResponseCount() {
        return this.pendingReplies.size();
    }

    /* loaded from: classes9.dex */
    private static class Reply implements BinaryMessenger.BinaryReply {
        private final AtomicBoolean done = new AtomicBoolean(false);
        private final FlutterJNI flutterJNI;
        private final int replyId;

        Reply(FlutterJNI flutterJNI, int i) {
            this.flutterJNI = flutterJNI;
            this.replyId = i;
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
        public void reply(ByteBuffer byteBuffer) {
            if (this.done.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            if (byteBuffer == null) {
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(this.replyId);
            } else {
                this.flutterJNI.invokePlatformMessageResponseCallback(this.replyId, byteBuffer, byteBuffer.position());
            }
        }
    }
}
