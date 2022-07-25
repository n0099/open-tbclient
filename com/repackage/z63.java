package com.repackage;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z63 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z63 b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes7.dex */
    public interface a {
        void a(String str, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755160102, "Lcom/repackage/z63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755160102, "Lcom/repackage/z63;");
                return;
            }
        }
        boolean z = sg1.a;
    }

    public z63() {
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

    public static z63 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (z63.class) {
                    if (b == null) {
                        b = new z63();
                    }
                }
            }
            return b;
        }
        return (z63) invokeV.objValue;
    }

    public void b(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (ProcessUtils.isMainProcess() && (aVar = this.a) != null) {
                aVar.a("swanLauncherTag", str);
            } else {
                c("swanLauncherTag", str);
            }
        }
    }

    public final void c(String str, String str2) {
        dx2 y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || (y = h03.K().y()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("statTag", str);
        bundle.putString("statisticData", str2);
        y.W(bundle, y63.class);
    }
}
