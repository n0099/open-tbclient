package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.za4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ja4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(w74<T> w74Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, w74Var, t, str, str2)) == null) {
            if (t == null || w74Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, w74Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, w74Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, w74<T> w74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, w74Var)) == null) {
            if (w74Var == null || t == null) {
                return false;
            }
            if (t instanceof d94) {
                d94 d94Var = (d94) t;
                return a(w74Var, t, d94Var.l, d94Var.n);
            } else if (t instanceof za4.a) {
                e94 e94Var = ((za4.a) t).d;
                return a(w74Var, t, e94Var.l, e94Var.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static ha4<a94> c(a94 a94Var, a84 a84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, a94Var, a84Var)) == null) {
            if (a84Var != null && b(a94Var, a84Var.r())) {
                return new ha4<>(new ga4(a94Var), a94Var, new ea4(a84Var.r()));
            }
            return null;
        }
        return (ha4) invokeLL.objValue;
    }

    public static ha4<c94> d(c94 c94Var, a84 a84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, c94Var, a84Var)) == null) {
            if (a84Var != null && b(c94Var, a84Var.s())) {
                return new ha4<>(new ga4(c94Var), c94Var, new ea4(a84Var.s()));
            }
            return null;
        }
        return (ha4) invokeLL.objValue;
    }

    public static List<ha4<g94>> e(List<g94> list, a84 a84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, a84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (a84Var != null && list != null && list.size() > 0) {
                for (g94 g94Var : list) {
                    if (b(g94Var, a84Var.q())) {
                        arrayList.add(new ha4(new ga4(g94Var), g94Var, new ea4(a84Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ha4<za4.a>> f(List<za4.a> list, a84 a84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, a84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (a84Var != null && list != null && list.size() > 0) {
                for (za4.a aVar : list) {
                    e94 e94Var = aVar.d;
                    if (e94Var != null && b(aVar, a84Var.v())) {
                        arrayList.add(new ha4(new ga4(e94Var), aVar, new ea4(a84Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ha4<e94> g(e94 e94Var, a84 a84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, e94Var, a84Var)) == null) {
            if (a84Var != null && b(e94Var, a84Var.u())) {
                return new ha4<>(new ga4(e94Var), e94Var, new ea4(a84Var.u()));
            }
            return null;
        }
        return (ha4) invokeLL.objValue;
    }

    public static List<ha4<f94>> h(List<f94> list, a84 a84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, a84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (a84Var != null && list != null && list.size() > 0) {
                for (f94 f94Var : list) {
                    if (b(f94Var, a84Var.A())) {
                        arrayList.add(new ha4(new ga4(f94Var), f94Var, new ea4(a84Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ha4<g94> i(g94 g94Var, a84 a84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, g94Var, a84Var)) == null) {
            if (a84Var != null && b(g94Var, a84Var.x())) {
                return new ha4<>(new ga4(g94Var), g94Var, new ea4(a84Var.x()));
            }
            return null;
        }
        return (ha4) invokeLL.objValue;
    }

    public static ha4<h94> j(h94 h94Var, a84 a84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, h94Var, a84Var)) == null) {
            if (a84Var != null && b(h94Var, a84Var.z())) {
                return new ha4<>(new ga4(h94Var), h94Var, new ea4(a84Var.z()));
            }
            return null;
        }
        return (ha4) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, w74<T> w74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, w74Var) == null) {
            w74Var.e(t, new z84(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
