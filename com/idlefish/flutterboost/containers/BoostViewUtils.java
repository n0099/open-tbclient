package com.idlefish.flutterboost.containers;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.XPlatformPlugin;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
/* loaded from: classes7.dex */
public class BoostViewUtils {
    public static /* synthetic */ Interceptable $ic;
    public static volatile XPlatformPlugin mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    public BoostViewUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static XPlatformPlugin getPlatformPlugin(PlatformChannel platformChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, platformChannel)) == null) {
            if (mInstance == null) {
                synchronized (BoostViewUtils.class) {
                    if (mInstance == null) {
                        mInstance = new XPlatformPlugin(platformChannel);
                    }
                }
            }
            return mInstance;
        }
        return (XPlatformPlugin) invokeL.objValue;
    }
}
