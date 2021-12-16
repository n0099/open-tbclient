package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes4.dex */
public class NavigationChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NavigationChannel";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final MethodChannel channel;

    public NavigationChannel(@NonNull DartExecutor dartExecutor) {
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
        this.channel = new MethodChannel(dartExecutor, "flutter/navigation", JSONMethodCodec.INSTANCE);
    }

    public void popRoute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.v(TAG, "Sending message to pop route.");
            this.channel.invokeMethod("popRoute", null);
        }
    }

    public void pushRoute(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            Log.v(TAG, "Sending message to push route '" + str + "'");
            this.channel.invokeMethod("pushRoute", str);
        }
    }

    public void setInitialRoute(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Log.v(TAG, "Sending message to set initial route to '" + str + "'");
            this.channel.invokeMethod("setInitialRoute", str);
        }
    }

    public void setMethodCallHandler(@Nullable MethodChannel.MethodCallHandler methodCallHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, methodCallHandler) == null) {
            this.channel.setMethodCallHandler(methodCallHandler);
        }
    }
}
