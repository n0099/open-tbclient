package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class PlatformViewsChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PlatformViewsChannel";
    public transient /* synthetic */ FieldHolder $fh;
    public final MethodChannel channel;
    public PlatformViewsHandler handler;
    public final MethodChannel.MethodCallHandler parsingHandler;

    /* loaded from: classes8.dex */
    public static class PlatformViewCreationRequest {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int direction;
        public final double logicalHeight;
        public final double logicalWidth;
        @Nullable
        public final ByteBuffer params;
        public final int viewId;
        @NonNull
        public final String viewType;

        public PlatformViewCreationRequest(int i2, @NonNull String str, double d2, double d3, int i3, @Nullable ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, Double.valueOf(d2), Double.valueOf(d3), Integer.valueOf(i3), byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.viewId = i2;
            this.viewType = str;
            this.logicalWidth = d2;
            this.logicalHeight = d3;
            this.direction = i3;
            this.params = byteBuffer;
        }
    }

    /* loaded from: classes8.dex */
    public static class PlatformViewResizeRequest {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final double newLogicalHeight;
        public final double newLogicalWidth;
        public final int viewId;

        public PlatformViewResizeRequest(int i2, double d2, double d3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(d3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.viewId = i2;
            this.newLogicalWidth = d2;
            this.newLogicalHeight = d3;
        }
    }

    /* loaded from: classes8.dex */
    public static class PlatformViewTouch {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int action;
        public final int buttonState;
        public final int deviceId;
        @NonNull
        public final Number downTime;
        public final int edgeFlags;
        @NonNull
        public final Number eventTime;
        public final int flags;
        public final int metaState;
        public final long motionEventId;
        public final int pointerCount;
        @NonNull
        public final Object rawPointerCoords;
        @NonNull
        public final Object rawPointerPropertiesList;
        public final int source;
        public final int viewId;
        public final float xPrecision;
        public final float yPrecision;

        public PlatformViewTouch(int i2, @NonNull Number number, @NonNull Number number2, int i3, int i4, @NonNull Object obj, @NonNull Object obj2, int i5, int i6, float f2, float f3, int i7, int i8, int i9, int i10, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), number, number2, Integer.valueOf(i3), Integer.valueOf(i4), obj, obj2, Integer.valueOf(i5), Integer.valueOf(i6), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i11 = newInitContext.flag;
                if ((i11 & 1) != 0) {
                    int i12 = i11 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.viewId = i2;
            this.downTime = number;
            this.eventTime = number2;
            this.action = i3;
            this.pointerCount = i4;
            this.rawPointerPropertiesList = obj;
            this.rawPointerCoords = obj2;
            this.metaState = i5;
            this.buttonState = i6;
            this.xPrecision = f2;
            this.yPrecision = f3;
            this.deviceId = i7;
            this.edgeFlags = i8;
            this.source = i9;
            this.flags = i10;
            this.motionEventId = j2;
        }
    }

    /* loaded from: classes8.dex */
    public interface PlatformViewsHandler {
        void clearFocus(int i2);

        void createAndroidViewForPlatformView(@NonNull PlatformViewCreationRequest platformViewCreationRequest);

        long createVirtualDisplayForPlatformView(@NonNull PlatformViewCreationRequest platformViewCreationRequest);

        void disposeAndroidViewForPlatformView(int i2);

        void disposeVirtualDisplayForPlatformView(int i2);

        void onTouch(@NonNull PlatformViewTouch platformViewTouch);

        void resizePlatformView(@NonNull PlatformViewResizeRequest platformViewResizeRequest, @NonNull Runnable runnable);

        void setDirection(int i2, int i3);

        void synchronizeToNativeViewHierarchy(boolean z);
    }

    public PlatformViewsChannel(@NonNull DartExecutor dartExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dartExecutor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parsingHandler = new MethodChannel.MethodCallHandler(this) { // from class: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlatformViewsChannel this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            private void clearFocus(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(65537, this, methodCall, result) == null) {
                    try {
                        this.this$0.handler.clearFocus(((Integer) methodCall.arguments()).intValue());
                        result.success(null);
                    } catch (IllegalStateException e2) {
                        result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
                    }
                }
            }

            private void create(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(65538, this, methodCall, result) == null) {
                    Map map = (Map) methodCall.arguments();
                    boolean z = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
                    PlatformViewCreationRequest platformViewCreationRequest = new PlatformViewCreationRequest(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), z ? 0.0d : ((Double) map.get("width")).doubleValue(), z ? 0.0d : ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null);
                    try {
                        if (z) {
                            this.this$0.handler.createAndroidViewForPlatformView(platformViewCreationRequest);
                            result.success(null);
                        } else {
                            result.success(Long.valueOf(this.this$0.handler.createVirtualDisplayForPlatformView(platformViewCreationRequest)));
                        }
                    } catch (IllegalStateException e2) {
                        result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
                    }
                }
            }

            private void dispose(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(65539, this, methodCall, result) == null) {
                    Map map = (Map) methodCall.arguments();
                    int intValue = ((Integer) map.get("id")).intValue();
                    try {
                        if (map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue()) {
                            this.this$0.handler.disposeAndroidViewForPlatformView(intValue);
                        } else {
                            this.this$0.handler.disposeVirtualDisplayForPlatformView(intValue);
                        }
                        result.success(null);
                    } catch (IllegalStateException e2) {
                        result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
                    }
                }
            }

            private void resize(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, methodCall, result) == null) {
                    Map map = (Map) methodCall.arguments();
                    try {
                        this.this$0.handler.resizePlatformView(new PlatformViewResizeRequest(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new Runnable(this, result) { // from class: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 this$1;
                            public final /* synthetic */ MethodChannel.Result val$result;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr2 = {this, result};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i4 = newInitContext2.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$result = result;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.val$result.success(null);
                                }
                            }
                        });
                    } catch (IllegalStateException e2) {
                        result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
                    }
                }
            }

            private void setDirection(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(65541, this, methodCall, result) == null) {
                    Map map = (Map) methodCall.arguments();
                    try {
                        this.this$0.handler.setDirection(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                        result.success(null);
                    } catch (IllegalStateException e2) {
                        result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
                    }
                }
            }

            private void synchronizeToNativeViewHierarchy(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(65542, this, methodCall, result) == null) {
                    try {
                        this.this$0.handler.synchronizeToNativeViewHierarchy(((Boolean) methodCall.arguments()).booleanValue());
                        result.success(null);
                    } catch (IllegalStateException e2) {
                        result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
                    }
                }
            }

            private void touch(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                MethodChannel.Result result2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeLL(65543, this, methodCall, result) != null) {
                    return;
                }
                List list = (List) methodCall.arguments();
                try {
                    this.this$0.handler.onTouch(new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                    result2 = result;
                    try {
                        result2.success(null);
                    } catch (IllegalStateException e2) {
                        e = e2;
                        result2.error("error", PlatformViewsChannel.detailedExceptionString(e), null);
                    }
                } catch (IllegalStateException e3) {
                    e = e3;
                    result2 = result;
                }
            }

            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, methodCall, result) == null) || this.this$0.handler == null) {
                    return;
                }
                Log.v(PlatformViewsChannel.TAG, "Received '" + methodCall.method + "' message.");
                String str = methodCall.method;
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1352294148:
                        if (str.equals("create")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -934437708:
                        if (str.equals("resize")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -756050293:
                        if (str.equals("clearFocus")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -308988850:
                        if (str.equals("synchronizeToNativeViewHierarchy")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 110550847:
                        if (str.equals("touch")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 576796989:
                        if (str.equals("setDirection")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1671767583:
                        if (str.equals("dispose")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        create(methodCall, result);
                        return;
                    case 1:
                        dispose(methodCall, result);
                        return;
                    case 2:
                        resize(methodCall, result);
                        return;
                    case 3:
                        touch(methodCall, result);
                        return;
                    case 4:
                        setDirection(methodCall, result);
                        return;
                    case 5:
                        clearFocus(methodCall, result);
                        return;
                    case 6:
                        synchronizeToNativeViewHierarchy(methodCall, result);
                        return;
                    default:
                        result.notImplemented();
                        return;
                }
            }
        };
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingHandler);
    }

    public static String detailedExceptionString(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, exc)) == null) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }

    public void invokeViewFocused(int i2) {
        MethodChannel methodChannel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (methodChannel = this.channel) == null) {
            return;
        }
        methodChannel.invokeMethod("viewFocused", Integer.valueOf(i2));
    }

    public void setPlatformViewsHandler(@Nullable PlatformViewsHandler platformViewsHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, platformViewsHandler) == null) {
            this.handler = platformViewsHandler;
        }
    }
}
