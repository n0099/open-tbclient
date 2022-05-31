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
public class ox0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ox0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, lx0> a;

    public ox0() {
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

    public static ox0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (ox0.class) {
                    if (b == null) {
                        b = new ox0();
                    }
                }
            }
            return b;
        }
        return (ox0) invokeV.objValue;
    }

    @NonNull
    public lx0 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            lx0 lx0Var = (lx0) ix0.b(this.a, str);
            if (lx0Var == null) {
                synchronized (ox0.class) {
                    lx0Var = (lx0) ix0.b(this.a, str);
                    if (lx0Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            lx0Var = nx0.a().a();
                        } else {
                            lx0Var = nx0.a().b(str);
                        }
                        ix0.e(this.a, str, lx0Var);
                    }
                }
            }
            return lx0Var;
        }
        return (lx0) invokeL.objValue;
    }
}
