package com.qq.e.comm.constants;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class Sig {
    public static /* synthetic */ Interceptable $ic = null;
    public static String ASSET_PLUGIN_SIG = "jwtTpyGtck3k6nLjZ7vGvWPDc5sZObyWxdOqa2p7uYgzl2C/j0aTliPLi9ucc6jpbBe2EfxVMqafcEmyfUO+sCBaBSmJrU29/yd2yQoAVkpOwN1851GSF5sRby+hHNpT3Z9mGt0UJwmBAJZtzBHRSgKl768gRO4ayS7GV4rvT6o=";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1477611406, "Lcom/qq/e/comm/constants/Sig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1477611406, "Lcom/qq/e/comm/constants/Sig;");
        }
    }

    public Sig() {
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
}
