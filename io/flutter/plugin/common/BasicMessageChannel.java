package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;
/* loaded from: classes4.dex */
public final class BasicMessageChannel<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHANNEL_BUFFERS_CHANNEL = "dev.flutter/channel-buffers";
    public static final String TAG = "BasicMessageChannel#";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final MessageCodec<T> codec;
    @NonNull
    public final BinaryMessenger messenger;
    @NonNull
    public final String name;

    /* renamed from: io.flutter.plugin.common.BasicMessageChannel$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public final class IncomingMessageHandler implements BinaryMessenger.BinaryMessageHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MessageHandler<T> handler;
        public final /* synthetic */ BasicMessageChannel this$0;

        public /* synthetic */ IncomingMessageHandler(BasicMessageChannel basicMessageChannel, MessageHandler messageHandler, AnonymousClass1 anonymousClass1) {
            this(basicMessageChannel, messageHandler);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: io.flutter.plugin.common.BasicMessageChannel$MessageHandler<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
        public void onMessage(@Nullable ByteBuffer byteBuffer, @NonNull BinaryMessenger.BinaryReply binaryReply) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, byteBuffer, binaryReply) == null) {
                try {
                    this.handler.onMessage(this.this$0.codec.decodeMessage(byteBuffer), new Reply<T>(this, binaryReply) { // from class: io.flutter.plugin.common.BasicMessageChannel.IncomingMessageHandler.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ IncomingMessageHandler this$1;
                        public final /* synthetic */ BinaryMessenger.BinaryReply val$callback;

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
                            this.val$callback = binaryReply;
                        }

                        @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                        public void reply(T t) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, t) == null) {
                                this.val$callback.reply(this.this$1.this$0.codec.encodeMessage(t));
                            }
                        }
                    });
                } catch (RuntimeException e2) {
                    Log.e(BasicMessageChannel.TAG + this.this$0.name, "Failed to handle message", e2);
                    binaryReply.reply(null);
                }
            }
        }

        public IncomingMessageHandler(@NonNull BasicMessageChannel basicMessageChannel, MessageHandler<T> messageHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {basicMessageChannel, messageHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = basicMessageChannel;
            this.handler = messageHandler;
        }
    }

    /* loaded from: classes4.dex */
    public final class IncomingReplyHandler implements BinaryMessenger.BinaryReply {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Reply<T> callback;
        public final /* synthetic */ BasicMessageChannel this$0;

        public /* synthetic */ IncomingReplyHandler(BasicMessageChannel basicMessageChannel, Reply reply, AnonymousClass1 anonymousClass1) {
            this(basicMessageChannel, reply);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: io.flutter.plugin.common.BasicMessageChannel$Reply<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
        public void reply(@Nullable ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
                try {
                    this.callback.reply(this.this$0.codec.decodeMessage(byteBuffer));
                } catch (RuntimeException e2) {
                    Log.e(BasicMessageChannel.TAG + this.this$0.name, "Failed to handle message reply", e2);
                }
            }
        }

        public IncomingReplyHandler(@NonNull BasicMessageChannel basicMessageChannel, Reply<T> reply) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {basicMessageChannel, reply};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = basicMessageChannel;
            this.callback = reply;
        }
    }

    /* loaded from: classes4.dex */
    public interface MessageHandler<T> {
        void onMessage(@Nullable T t, @NonNull Reply<T> reply);
    }

    /* loaded from: classes4.dex */
    public interface Reply<T> {
        void reply(@Nullable T t);
    }

    public BasicMessageChannel(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, @NonNull MessageCodec<T> messageCodec) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {binaryMessenger, str, messageCodec};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = messageCodec;
    }

    public void resizeChannelBuffer(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            resizeChannelBuffer(this.messenger, this.name, i2);
        }
    }

    public void send(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            send(t, null);
        }
    }

    @UiThread
    public void setMessageHandler(@Nullable MessageHandler<T> messageHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, messageHandler) == null) {
            this.messenger.setMessageHandler(this.name, messageHandler != null ? new IncomingMessageHandler(this, messageHandler, null) : null);
        }
    }

    public static void resizeChannelBuffer(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, null, binaryMessenger, str, i2) == null) {
            binaryMessenger.send(CHANNEL_BUFFERS_CHANNEL, ByteBuffer.wrap(String.format(Locale.US, "resize\r%s\r%d", str, Integer.valueOf(i2)).getBytes(Charset.forName("UTF-8"))));
        }
    }

    @UiThread
    public void send(@Nullable T t, @Nullable Reply<T> reply) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t, reply) == null) {
            this.messenger.send(this.name, this.codec.encodeMessage(t), reply != null ? new IncomingReplyHandler(this, reply, null) : null);
        }
    }
}
