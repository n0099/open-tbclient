package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class gl9 {
    public static /* synthetic */ Interceptable $ic;
    public static gl9 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap a;

    public gl9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
    }

    public static gl9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (gl9.class) {
                    if (b == null) {
                        b = new gl9();
                    }
                }
            }
            return b;
        }
        return (gl9) invokeV.objValue;
    }

    public Info b(String str) {
        InterceptResult invokeL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (gl9.class) {
                info = (Info) this.a.remove(str);
            }
            return info;
        }
        return (Info) invokeL.objValue;
    }

    public void c(String str, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, info) == null) {
            synchronized (gl9.class) {
                this.a.put(str, info);
            }
        }
    }
}
