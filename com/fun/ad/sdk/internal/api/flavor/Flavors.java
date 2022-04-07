package com.fun.ad.sdk.internal.api.flavor;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class Flavors {
    public static /* synthetic */ Interceptable $ic;
    public static final CachingAware CACHING_AWARE;
    public static final CallBackAware CALL_BACK_AWARE;
    public static final CpmAware CPM_AWARE;
    public static final PluginRC PLUGIN_RC;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-784515929, "Lcom/fun/ad/sdk/internal/api/flavor/Flavors;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-784515929, "Lcom/fun/ad/sdk/internal/api/flavor/Flavors;");
                return;
            }
        }
        CACHING_AWARE = new DefaultCachingAware();
        CALL_BACK_AWARE = new DefultCallBackAware();
        PLUGIN_RC = new DefaultPluginRC();
        CPM_AWARE = new DefultCpmImpl();
    }

    public Flavors() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
