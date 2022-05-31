package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class bj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ei0> a;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final bj0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-498569940, "Lcom/repackage/bj0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-498569940, "Lcom/repackage/bj0$a;");
                    return;
                }
            }
            a = new bj0(null);
        }
    }

    public /* synthetic */ bj0(aj0 aj0Var) {
        this();
    }

    public static bj0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (bj0) invokeV.objValue;
    }

    public void b(ei0 ei0Var) {
        File file;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ei0Var) == null) || ei0Var == null || (file = ei0Var.h) == null || !file.exists()) {
            return;
        }
        String str = ei0Var.p.h;
        String absolutePath = ei0Var.h.getAbsolutePath();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(absolutePath)) {
            return;
        }
        ei0Var.q.m = "reminded_type_none";
        gx0.b(this.a, ei0Var);
    }

    public bj0() {
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
        this.a = new ArrayList();
    }
}
