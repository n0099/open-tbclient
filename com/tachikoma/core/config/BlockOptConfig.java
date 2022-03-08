package com.tachikoma.core.config;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.Tachikoma;
import java.util.Map;
/* loaded from: classes8.dex */
public class BlockOptConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BLOCK_OPT_ENABLE = "blockOptEnable";
    public static Boolean sBlockTrackEnable;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1963626908, "Lcom/tachikoma/core/config/BlockOptConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1963626908, "Lcom/tachikoma/core/config/BlockOptConfig;");
        }
    }

    public BlockOptConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean blockOpt() {
        InterceptResult invokeV;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Boolean bool2 = sBlockTrackEnable;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            Map<String, Object> config = Tachikoma.getInstance().getConfig();
            if (config == null || !config.containsKey(BLOCK_OPT_ENABLE)) {
                bool = Boolean.FALSE;
            } else {
                bool = Boolean.valueOf(config.get(BLOCK_OPT_ENABLE) == Boolean.TRUE);
            }
            sBlockTrackEnable = bool;
            return sBlockTrackEnable.booleanValue();
        }
        return invokeV.booleanValue;
    }
}
