package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.rb4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class bb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(o84<T> o84Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, o84Var, t, str, str2)) == null) {
            if (t == null || o84Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, o84Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, o84Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, o84<T> o84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, o84Var)) == null) {
            if (o84Var == null || t == null) {
                return false;
            }
            if (t instanceof v94) {
                v94 v94Var = (v94) t;
                return a(o84Var, t, v94Var.l, v94Var.n);
            } else if (t instanceof rb4.a) {
                w94 w94Var = ((rb4.a) t).d;
                return a(o84Var, t, w94Var.l, w94Var.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static za4<s94> c(s94 s94Var, s84 s84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, s94Var, s84Var)) == null) {
            if (s84Var != null && b(s94Var, s84Var.r())) {
                return new za4<>(new ya4(s94Var), s94Var, new wa4(s84Var.r()));
            }
            return null;
        }
        return (za4) invokeLL.objValue;
    }

    public static za4<u94> d(u94 u94Var, s84 s84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, u94Var, s84Var)) == null) {
            if (s84Var != null && b(u94Var, s84Var.s())) {
                return new za4<>(new ya4(u94Var), u94Var, new wa4(s84Var.s()));
            }
            return null;
        }
        return (za4) invokeLL.objValue;
    }

    public static List<za4<y94>> e(List<y94> list, s84 s84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, s84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (s84Var != null && list != null && list.size() > 0) {
                for (y94 y94Var : list) {
                    if (b(y94Var, s84Var.q())) {
                        arrayList.add(new za4(new ya4(y94Var), y94Var, new wa4(s84Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<za4<rb4.a>> f(List<rb4.a> list, s84 s84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, s84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (s84Var != null && list != null && list.size() > 0) {
                for (rb4.a aVar : list) {
                    w94 w94Var = aVar.d;
                    if (w94Var != null && b(aVar, s84Var.v())) {
                        arrayList.add(new za4(new ya4(w94Var), aVar, new wa4(s84Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static za4<w94> g(w94 w94Var, s84 s84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, w94Var, s84Var)) == null) {
            if (s84Var != null && b(w94Var, s84Var.u())) {
                return new za4<>(new ya4(w94Var), w94Var, new wa4(s84Var.u()));
            }
            return null;
        }
        return (za4) invokeLL.objValue;
    }

    public static List<za4<x94>> h(List<x94> list, s84 s84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, s84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (s84Var != null && list != null && list.size() > 0) {
                for (x94 x94Var : list) {
                    if (b(x94Var, s84Var.A())) {
                        arrayList.add(new za4(new ya4(x94Var), x94Var, new wa4(s84Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static za4<y94> i(y94 y94Var, s84 s84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, y94Var, s84Var)) == null) {
            if (s84Var != null && b(y94Var, s84Var.x())) {
                return new za4<>(new ya4(y94Var), y94Var, new wa4(s84Var.x()));
            }
            return null;
        }
        return (za4) invokeLL.objValue;
    }

    public static za4<z94> j(z94 z94Var, s84 s84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, z94Var, s84Var)) == null) {
            if (s84Var != null && b(z94Var, s84Var.z())) {
                return new za4<>(new ya4(z94Var), z94Var, new wa4(s84Var.z()));
            }
            return null;
        }
        return (za4) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, o84<T> o84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, o84Var) == null) {
            o84Var.e(t, new r94(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
