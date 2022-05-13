package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class il2 {
    public static /* synthetic */ Interceptable $ic;
    public static final jl2[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755614686, "Lcom/repackage/il2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755614686, "Lcom/repackage/il2;");
                return;
            }
        }
        a = new jl2[]{new gl2(), new hl2()};
    }

    public static String a() {
        InterceptResult invokeV;
        jl2[] jl2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            for (jl2 jl2Var : a) {
                sb.append(jl2Var.b());
                sb.append(jl2Var.enable() ? 1 : 0);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static List<jl2> b() {
        InterceptResult invokeV;
        jl2[] jl2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (jl2 jl2Var : a) {
                if (jl2Var.enable()) {
                    arrayList.add(jl2Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
