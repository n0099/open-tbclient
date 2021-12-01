package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class MouseCursorChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MouseCursorChannel";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final MethodChannel channel;
    @Nullable
    public MouseCursorMethodHandler mouseCursorMethodHandler;
    @NonNull
    public final MethodChannel.MethodCallHandler parsingMethodCallHandler;

    /* loaded from: classes3.dex */
    public interface MouseCursorMethodHandler {
        void activateSystemCursor(@NonNull String str);
    }

    public MouseCursorChannel(@NonNull DartExecutor dartExecutor) {
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
        this.parsingMethodCallHandler = new MethodChannel.MethodCallHandler(this) { // from class: io.flutter.embedding.engine.systemchannels.MouseCursorChannel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MouseCursorChannel this$0;

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

            /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
                return;
             */
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, methodCall, result) == null) || this.this$0.mouseCursorMethodHandler == null) {
                    return;
                }
                String str = methodCall.method;
                Log.v(MouseCursorChannel.TAG, "Received '" + str + "' message.");
                char c2 = 65535;
                try {
                    if (str.hashCode() == -1307105544 && str.equals("activateSystemCursor")) {
                        c2 = 0;
                    }
                    try {
                        this.this$0.mouseCursorMethodHandler.activateSystemCursor((String) ((HashMap) methodCall.arguments).get("kind"));
                        result.success(Boolean.TRUE);
                    } catch (Exception e2) {
                        result.error("error", "Error when setting cursors: " + e2.getMessage(), null);
                    }
                } catch (Exception e3) {
                    result.error("error", "Unhandled error: " + e3.getMessage(), null);
                }
            }
        };
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/mousecursor", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.parsingMethodCallHandler);
    }

    public void setMethodHandler(@Nullable MouseCursorMethodHandler mouseCursorMethodHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mouseCursorMethodHandler) == null) {
            this.mouseCursorMethodHandler = mouseCursorMethodHandler;
        }
    }

    @VisibleForTesting
    public void synthesizeMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, methodCall, result) == null) {
            this.parsingMethodCallHandler.onMethodCall(methodCall, result);
        }
    }
}
