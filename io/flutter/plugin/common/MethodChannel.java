package io.flutter.plugin.common;

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
import io.flutter.plugin.common.BinaryMessenger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class MethodChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MethodChannel#";
    public transient /* synthetic */ FieldHolder $fh;
    public final MethodCodec codec;
    public final BinaryMessenger messenger;
    public final String name;

    /* loaded from: classes3.dex */
    public final class IncomingMethodCallHandler implements BinaryMessenger.BinaryMessageHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MethodCallHandler handler;
        public final /* synthetic */ MethodChannel this$0;

        public IncomingMethodCallHandler(MethodChannel methodChannel, MethodCallHandler methodCallHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {methodChannel, methodCallHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = methodChannel;
            this.handler = methodCallHandler;
        }

        private String getStackTrace(Exception exc) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, exc)) == null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                return stringWriter.toString();
            }
            return (String) invokeL.objValue;
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
        @UiThread
        public void onMessage(ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, byteBuffer, binaryReply) == null) {
                try {
                    this.handler.onMethodCall(this.this$0.codec.decodeMethodCall(byteBuffer), new Result(this, binaryReply) { // from class: io.flutter.plugin.common.MethodChannel.IncomingMethodCallHandler.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ IncomingMethodCallHandler this$1;
                        public final /* synthetic */ BinaryMessenger.BinaryReply val$reply;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, binaryReply};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$reply = binaryReply;
                        }

                        @Override // io.flutter.plugin.common.MethodChannel.Result
                        public void error(String str, String str2, Object obj) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, str2, obj) == null) {
                                this.val$reply.reply(this.this$1.this$0.codec.encodeErrorEnvelope(str, str2, obj));
                            }
                        }

                        @Override // io.flutter.plugin.common.MethodChannel.Result
                        public void notImplemented() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                this.val$reply.reply(null);
                            }
                        }

                        @Override // io.flutter.plugin.common.MethodChannel.Result
                        public void success(Object obj) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                                this.val$reply.reply(this.this$1.this$0.codec.encodeSuccessEnvelope(obj));
                            }
                        }
                    });
                } catch (RuntimeException e2) {
                    Log.e(MethodChannel.TAG + this.this$0.name, "Failed to handle method call", e2);
                    binaryReply.reply(this.this$0.codec.encodeErrorEnvelopeWithStacktrace("error", e2.getMessage(), null, getStackTrace(e2)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class IncomingResultHandler implements BinaryMessenger.BinaryReply {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Result callback;
        public final /* synthetic */ MethodChannel this$0;

        public IncomingResultHandler(MethodChannel methodChannel, Result result) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {methodChannel, result};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = methodChannel;
            this.callback = result;
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
        @UiThread
        public void reply(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
                try {
                    if (byteBuffer == null) {
                        this.callback.notImplemented();
                    } else {
                        try {
                            this.callback.success(this.this$0.codec.decodeEnvelope(byteBuffer));
                        } catch (FlutterException e2) {
                            this.callback.error(e2.code, e2.getMessage(), e2.details);
                        }
                    }
                } catch (RuntimeException e3) {
                    Log.e(MethodChannel.TAG + this.this$0.name, "Failed to handle method call result", e3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface MethodCallHandler {
        @UiThread
        void onMethodCall(@NonNull MethodCall methodCall, @NonNull Result result);
    }

    /* loaded from: classes3.dex */
    public interface Result {
        @UiThread
        void error(String str, @Nullable String str2, @Nullable Object obj);

        @UiThread
        void notImplemented();

        @UiThread
        void success(@Nullable Object obj);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MethodChannel(BinaryMessenger binaryMessenger, String str) {
        this(binaryMessenger, str, StandardMethodCodec.INSTANCE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {binaryMessenger, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((BinaryMessenger) objArr2[0], (String) objArr2[1], (MethodCodec) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @UiThread
    public void invokeMethod(@NonNull String str, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            invokeMethod(str, obj, null);
        }
    }

    public void resizeChannelBuffer(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            BasicMessageChannel.resizeChannelBuffer(this.messenger, this.name, i2);
        }
    }

    @UiThread
    public void setMethodCallHandler(@Nullable MethodCallHandler methodCallHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, methodCallHandler) == null) {
            this.messenger.setMessageHandler(this.name, methodCallHandler == null ? null : new IncomingMethodCallHandler(this, methodCallHandler));
        }
    }

    public MethodChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {binaryMessenger, str, methodCodec};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = methodCodec;
    }

    @UiThread
    public void invokeMethod(String str, @Nullable Object obj, @Nullable Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj, result) == null) {
            this.messenger.send(this.name, this.codec.encodeMethodCall(new MethodCall(str, obj)), result == null ? null : new IncomingResultHandler(this, result));
        }
    }
}
