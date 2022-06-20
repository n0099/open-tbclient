package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class sx0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sx0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, px0> a;

    public sx0() {
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
        this.a = new ConcurrentHashMap<>();
    }

    public static sx0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (sx0.class) {
                    if (b == null) {
                        b = new sx0();
                    }
                }
            }
            return b;
        }
        return (sx0) invokeV.objValue;
    }

    @NonNull
    public px0 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            px0 px0Var = (px0) mx0.b(this.a, str);
            if (px0Var == null) {
                synchronized (sx0.class) {
                    px0Var = (px0) mx0.b(this.a, str);
                    if (px0Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            px0Var = rx0.a().a();
                        } else {
                            px0Var = rx0.a().b(str);
                        }
                        mx0.e(this.a, str, px0Var);
                    }
                }
            }
            return px0Var;
        }
        return (px0) invokeL.objValue;
    }
}
