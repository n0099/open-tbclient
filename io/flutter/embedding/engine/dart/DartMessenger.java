package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class DartMessenger implements BinaryMessenger, PlatformMessageHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DartMessenger";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final FlutterJNI flutterJNI;
    @NonNull
    public final Map<String, BinaryMessenger.BinaryMessageHandler> messageHandlers;
    public int nextReplyId;
    @NonNull
    public final Map<Integer, BinaryMessenger.BinaryReply> pendingReplies;

    /* loaded from: classes10.dex */
    public static class Reply implements BinaryMessenger.BinaryReply {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicBoolean done;
        @NonNull
        public final FlutterJNI flutterJNI;
        public final int replyId;

        public Reply(@NonNull FlutterJNI flutterJNI, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flutterJNI, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.done = new AtomicBoolean(false);
            this.flutterJNI = flutterJNI;
            this.replyId = i2;
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
        public void reply(@Nullable ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
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

    public DartMessenger(@NonNull FlutterJNI flutterJNI) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flutterJNI};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nextReplyId = 1;
        this.flutterJNI = flutterJNI;
        this.messageHandlers = new HashMap();
        this.pendingReplies = new HashMap();
    }

    @UiThread
    public int getPendingChannelResponseCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.pendingReplies.size() : invokeV.intValue;
    }

    @Override // io.flutter.embedding.engine.dart.PlatformMessageHandler
    public void handleMessageFromDart(@NonNull String str, @Nullable byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr, i2) == null) {
            Log.v(TAG, "Received message from Dart over channel '" + str + "'");
            BinaryMessenger.BinaryMessageHandler binaryMessageHandler = this.messageHandlers.get(str);
            if (binaryMessageHandler != null) {
                try {
                    Log.v(TAG, "Deferring to registered handler to process message.");
                    binaryMessageHandler.onMessage(bArr == null ? null : ByteBuffer.wrap(bArr), new Reply(this.flutterJNI, i2));
                    return;
                } catch (Exception e2) {
                    Log.e(TAG, "Uncaught exception in binary message listener", e2);
                    this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i2);
                    return;
                }
            }
            Log.v(TAG, "No registered handler for message. Responding to Dart with empty reply message.");
            this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i2);
        }
    }

    @Override // io.flutter.embedding.engine.dart.PlatformMessageHandler
    public void handlePlatformMessageResponse(int i2, @Nullable byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bArr) == null) {
            Log.v(TAG, "Received message reply from Dart.");
            BinaryMessenger.BinaryReply remove = this.pendingReplies.remove(Integer.valueOf(i2));
            if (remove != null) {
                try {
                    Log.v(TAG, "Invoking registered callback for reply from Dart.");
                    remove.reply(bArr == null ? null : ByteBuffer.wrap(bArr));
                } catch (Exception e2) {
                    Log.e(TAG, "Uncaught exception in binary message reply handler", e2);
                }
            }
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    public void send(@NonNull String str, @NonNull ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, byteBuffer) == null) {
            Log.v(TAG, "Sending message over channel '" + str + "'");
            send(str, byteBuffer, null);
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void setMessageHandler(@NonNull String str, @Nullable BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, binaryMessageHandler) == null) {
            if (binaryMessageHandler == null) {
                Log.v(TAG, "Removing handler for channel '" + str + "'");
                this.messageHandlers.remove(str);
                return;
            }
            Log.v(TAG, "Setting handler for channel '" + str + "'");
            this.messageHandlers.put(str, binaryMessageHandler);
        }
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    public void send(@NonNull String str, @Nullable ByteBuffer byteBuffer, @Nullable BinaryMessenger.BinaryReply binaryReply) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, byteBuffer, binaryReply) == null) {
            Log.v(TAG, "Sending message with callback over channel '" + str + "'");
            if (binaryReply != null) {
                i2 = this.nextReplyId;
                this.nextReplyId = i2 + 1;
                this.pendingReplies.put(Integer.valueOf(i2), binaryReply);
            } else {
                i2 = 0;
            }
            if (byteBuffer == null) {
                this.flutterJNI.dispatchEmptyPlatformMessage(str, i2);
            } else {
                this.flutterJNI.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i2);
            }
        }
    }
}
