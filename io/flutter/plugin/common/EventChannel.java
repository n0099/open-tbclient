package io.flutter.plugin.common;

import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class EventChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "EventChannel#";
    public transient /* synthetic */ FieldHolder $fh;
    public final MethodCodec codec;
    public final BinaryMessenger messenger;
    public final String name;

    /* renamed from: io.flutter.plugin.common.EventChannel$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public interface EventSink {
        void endOfStream();

        void error(String str, String str2, Object obj);

        void success(Object obj);
    }

    /* loaded from: classes8.dex */
    public final class IncomingStreamRequestHandler implements BinaryMessenger.BinaryMessageHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReference<EventSink> activeSink;
        public final StreamHandler handler;
        public final /* synthetic */ EventChannel this$0;

        public IncomingStreamRequestHandler(EventChannel eventChannel, StreamHandler streamHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eventChannel, streamHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = eventChannel;
            this.activeSink = new AtomicReference<>(null);
            this.handler = streamHandler;
        }

        private void onCancel(Object obj, BinaryMessenger.BinaryReply binaryReply) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, obj, binaryReply) == null) {
                if (this.activeSink.getAndSet(null) == null) {
                    binaryReply.reply(this.this$0.codec.encodeErrorEnvelope("error", "No active stream to cancel", null));
                    return;
                }
                try {
                    this.handler.onCancel(obj);
                    binaryReply.reply(this.this$0.codec.encodeSuccessEnvelope(null));
                } catch (RuntimeException e2) {
                    Log.e(EventChannel.TAG + this.this$0.name, "Failed to close event stream", e2);
                    binaryReply.reply(this.this$0.codec.encodeErrorEnvelope("error", e2.getMessage(), null));
                }
            }
        }

        private void onListen(Object obj, BinaryMessenger.BinaryReply binaryReply) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, obj, binaryReply) == null) {
                EventSinkImplementation eventSinkImplementation = new EventSinkImplementation(this, null);
                if (this.activeSink.getAndSet(eventSinkImplementation) != null) {
                    try {
                        this.handler.onCancel(null);
                    } catch (RuntimeException e2) {
                        Log.e(EventChannel.TAG + this.this$0.name, "Failed to close existing event stream", e2);
                    }
                }
                try {
                    this.handler.onListen(obj, eventSinkImplementation);
                    binaryReply.reply(this.this$0.codec.encodeSuccessEnvelope(null));
                } catch (RuntimeException e3) {
                    this.activeSink.set(null);
                    Log.e(EventChannel.TAG + this.this$0.name, "Failed to open event stream", e3);
                    binaryReply.reply(this.this$0.codec.encodeErrorEnvelope("error", e3.getMessage(), null));
                }
            }
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
        public void onMessage(ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, byteBuffer, binaryReply) == null) {
                MethodCall decodeMethodCall = this.this$0.codec.decodeMethodCall(byteBuffer);
                if (decodeMethodCall.method.equals("listen")) {
                    onListen(decodeMethodCall.arguments, binaryReply);
                } else if (decodeMethodCall.method.equals(QueryResponse.Options.CANCEL)) {
                    onCancel(decodeMethodCall.arguments, binaryReply);
                } else {
                    binaryReply.reply(null);
                }
            }
        }

        /* loaded from: classes8.dex */
        public final class EventSinkImplementation implements EventSink {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final AtomicBoolean hasEnded;
            public final /* synthetic */ IncomingStreamRequestHandler this$1;

            public EventSinkImplementation(IncomingStreamRequestHandler incomingStreamRequestHandler) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {incomingStreamRequestHandler};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = incomingStreamRequestHandler;
                this.hasEnded = new AtomicBoolean(false);
            }

            @Override // io.flutter.plugin.common.EventChannel.EventSink
            @UiThread
            public void endOfStream() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.hasEnded.getAndSet(true) && this.this$1.activeSink.get() == this) {
                    this.this$1.this$0.messenger.send(this.this$1.this$0.name, null);
                }
            }

            @Override // io.flutter.plugin.common.EventChannel.EventSink
            @UiThread
            public void error(String str, String str2, Object obj) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, obj) == null) && !this.hasEnded.get() && this.this$1.activeSink.get() == this) {
                    this.this$1.this$0.messenger.send(this.this$1.this$0.name, this.this$1.this$0.codec.encodeErrorEnvelope(str, str2, obj));
                }
            }

            @Override // io.flutter.plugin.common.EventChannel.EventSink
            @UiThread
            public void success(Object obj) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && !this.hasEnded.get() && this.this$1.activeSink.get() == this) {
                    this.this$1.this$0.messenger.send(this.this$1.this$0.name, this.this$1.this$0.codec.encodeSuccessEnvelope(obj));
                }
            }

            public /* synthetic */ EventSinkImplementation(IncomingStreamRequestHandler incomingStreamRequestHandler, AnonymousClass1 anonymousClass1) {
                this(incomingStreamRequestHandler);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface StreamHandler {
        void onCancel(Object obj);

        void onListen(Object obj, EventSink eventSink);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EventChannel(BinaryMessenger binaryMessenger, String str) {
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
    public void setStreamHandler(StreamHandler streamHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, streamHandler) == null) {
            this.messenger.setMessageHandler(this.name, streamHandler == null ? null : new IncomingStreamRequestHandler(this, streamHandler));
        }
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec) {
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
}
