package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.StringCodec;
/* loaded from: classes9.dex */
public class LifecycleChannel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LifecycleChannel";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final BasicMessageChannel<String> channel;

    public LifecycleChannel(@NonNull DartExecutor dartExecutor) {
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
        this.channel = new BasicMessageChannel<>(dartExecutor, "flutter/lifecycle", StringCodec.INSTANCE);
    }

    public void appIsDetached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.v(TAG, "Sending AppLifecycleState.detached message.");
            this.channel.send("AppLifecycleState.detached");
        }
    }

    public void appIsInactive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Log.v(TAG, "Sending AppLifecycleState.inactive message.");
            this.channel.send("AppLifecycleState.inactive");
        }
    }

    public void appIsPaused() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Log.v(TAG, "Sending AppLifecycleState.paused message.");
            this.channel.send("AppLifecycleState.paused");
        }
    }

    public void appIsResumed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Log.v(TAG, "Sending AppLifecycleState.resumed message.");
            this.channel.send("AppLifecycleState.resumed");
        }
    }
}
