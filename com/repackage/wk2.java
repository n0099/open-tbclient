package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class wk2 {
    public static /* synthetic */ Interceptable $ic;
    public static final xk2[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755198573, "Lcom/repackage/wk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755198573, "Lcom/repackage/wk2;");
                return;
            }
        }
        a = new xk2[]{new uk2(), new vk2()};
    }

    public static String a() {
        InterceptResult invokeV;
        xk2[] xk2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            for (xk2 xk2Var : a) {
                sb.append(xk2Var.b());
                sb.append(xk2Var.enable() ? 1 : 0);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static List<xk2> b() {
        InterceptResult invokeV;
        xk2[] xk2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (xk2 xk2Var : a) {
                if (xk2Var.enable()) {
                    arrayList.add(xk2Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
