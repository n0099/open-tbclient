package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class ey0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ey0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, by0> a;

    public ey0() {
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

    public static ey0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (ey0.class) {
                    if (b == null) {
                        b = new ey0();
                    }
                }
            }
            return b;
        }
        return (ey0) invokeV.objValue;
    }

    @NonNull
    public by0 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            by0 by0Var = (by0) yx0.b(this.a, str);
            if (by0Var == null) {
                synchronized (ey0.class) {
                    by0Var = (by0) yx0.b(this.a, str);
                    if (by0Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            by0Var = dy0.a().a();
                        } else {
                            by0Var = dy0.a().b(str);
                        }
                        yx0.e(this.a, str, by0Var);
                    }
                }
            }
            return by0Var;
        }
        return (by0) invokeL.objValue;
    }
}
