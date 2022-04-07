package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class bz0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bz0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, yy0> a;

    public bz0() {
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

    public static bz0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (bz0.class) {
                    if (b == null) {
                        b = new bz0();
                    }
                }
            }
            return b;
        }
        return (bz0) invokeV.objValue;
    }

    @NonNull
    public yy0 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            yy0 yy0Var = (yy0) vy0.b(this.a, str);
            if (yy0Var == null) {
                synchronized (bz0.class) {
                    yy0Var = (yy0) vy0.b(this.a, str);
                    if (yy0Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            yy0Var = az0.a().a();
                        } else {
                            yy0Var = az0.a().b(str);
                        }
                        vy0.e(this.a, str, yy0Var);
                    }
                }
            }
            return yy0Var;
        }
        return (yy0) invokeL.objValue;
    }
}
