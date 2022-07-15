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
public class vk2 {
    public static /* synthetic */ Interceptable $ic;
    public static final wk2[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755228364, "Lcom/repackage/vk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755228364, "Lcom/repackage/vk2;");
                return;
            }
        }
        a = new wk2[]{new tk2(), new uk2()};
    }

    public static String a() {
        InterceptResult invokeV;
        wk2[] wk2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            for (wk2 wk2Var : a) {
                sb.append(wk2Var.b());
                sb.append(wk2Var.enable() ? 1 : 0);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static List<wk2> b() {
        InterceptResult invokeV;
        wk2[] wk2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (wk2 wk2Var : a) {
                if (wk2Var.enable()) {
                    arrayList.add(wk2Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
