package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class DartMessenger implements BinaryMessenger, PlatformMessageHandler {
    public static final String TAG = "DartMessenger";
    @NonNull
    public final FlutterJNI flutterJNI;
    public int nextReplyId = 1;
    @NonNull
    public final Map<String, BinaryMessenger.BinaryMessageHandler> messageHandlers = new HashMap();
    @NonNull
    public final Map<Integer, BinaryMessenger.BinaryReply> pendingReplies = new HashMap();

    /* loaded from: classes7.dex */
    public static class Reply implements BinaryMessenger.BinaryReply {
        public final AtomicBoolean done = new AtomicBoolean(false);
        @NonNull
        public final FlutterJNI flutterJNI;
        public final int replyId;

        public Reply(@NonNull FlutterJNI flutterJNI, int i) {
            this.flutterJNI = flutterJNI;
            this.replyId = i;
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
        public void reply(@Nullable ByteBuffer byteBuffer) {
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

    public DartMessenger(@NonNull FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    @UiThread
    public int getPendingChannelResponseCount() {
        return this.pendingReplies.size();
    }

    @Override // io.flutter.embedding.engine.dart.PlatformMessageHandler
    public void handleMessageFromDart(@NonNull String str, @Nullable byte[] bArr, int i) {
        Log.v(TAG, "Received message from Dart over channel '" + str + "'");
        BinaryMessenger.BinaryMessageHandler binaryMessageHandler = this.messageHandlers.get(str);
        if (binaryMessageHandler != null) {
            try {
                Log.v(TAG, "Deferring to registered handler to process message.");
                binaryMessageHandler.onMessage(bArr == null ? null : ByteBuffer.wrap(bArr), new Reply(this.flutterJNI, i));
                return;
            } catch (Exception e2) {
                Log.e(TAG, "Uncaught exception in binary message listener", e2);
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i);
                return;
            }
        }
        Log.v(TAG, "No registered handler for message. Responding to Dart with empty reply message.");
        this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i);
    }

    @Override // io.flutter.embedding.engine.dart.PlatformMessageHandler
    public void handlePlatformMessageResponse(int i, @Nullable byte[] bArr) {
        Log.v(TAG, "Received message reply from Dart.");
        BinaryMessenger.BinaryReply remove = this.pendingReplies.remove(Integer.valueOf(i));
        if (remove != null) {
            try {
                Log.v(TAG, "Invoking registered callback for reply from Dart.");
                remove.reply(bArr == null ? null : ByteBuffer.wrap(bArr));
            } catch (Exception e2) {
                Log.e(TAG, "Uncaught exception in binary message reply handler", e2);
            }
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    public void send(@NonNull String str, @NonNull ByteBuffer byteBuffer) {
        Log.v(TAG, "Sending message over channel '" + str + "'");
        send(str, byteBuffer, null);
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void setMessageHandler(@NonNull String str, @Nullable BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        if (binaryMessageHandler == null) {
            Log.v(TAG, "Removing handler for channel '" + str + "'");
            this.messageHandlers.remove(str);
            return;
        }
        Log.v(TAG, "Setting handler for channel '" + str + "'");
        this.messageHandlers.put(str, binaryMessageHandler);
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void send(@NonNull String str, @Nullable ByteBuffer byteBuffer, @Nullable BinaryMessenger.BinaryReply binaryReply) {
        int i;
        Log.v(TAG, "Sending message with callback over channel '" + str + "'");
        if (binaryReply != null) {
            i = this.nextReplyId;
            this.nextReplyId = i + 1;
            this.pendingReplies.put(Integer.valueOf(i), binaryReply);
        } else {
            i = 0;
        }
        if (byteBuffer == null) {
            this.flutterJNI.dispatchEmptyPlatformMessage(str, i);
        } else {
            this.flutterJNI.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i);
        }
    }
}
