package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class xx {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, wx> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964022523, "Lcom/repackage/xx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964022523, "Lcom/repackage/xx;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized wx a(String str) {
        InterceptResult invokeL;
        wx b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (xx.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (wx) invokeL.objValue;
    }

    public static synchronized wx b(String str, int i) {
        InterceptResult invokeLI;
        wx wxVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (xx.class) {
                if (!a.containsKey(str) || (wxVar = a.get(str)) == null) {
                    wx wxVar2 = new wx(str, i);
                    try {
                        wxVar2.start();
                    } catch (Exception unused) {
                    }
                    a.put(str, wxVar2);
                    return wxVar2;
                }
                return wxVar;
            }
        }
        return (wx) invokeLI.objValue;
    }

    public static synchronized void c(wx wxVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, wxVar) == null) {
            synchronized (xx.class) {
                if (wxVar != null) {
                    wxVar.a();
                    a.values().remove(wxVar);
                }
            }
        }
    }
}
