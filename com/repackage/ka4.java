package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.ab4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ka4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(x74<T> x74Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, x74Var, t, str, str2)) == null) {
            if (t == null || x74Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, x74Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, x74Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, x74<T> x74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, x74Var)) == null) {
            if (x74Var == null || t == null) {
                return false;
            }
            if (t instanceof e94) {
                e94 e94Var = (e94) t;
                return a(x74Var, t, e94Var.l, e94Var.n);
            } else if (t instanceof ab4.a) {
                f94 f94Var = ((ab4.a) t).d;
                return a(x74Var, t, f94Var.l, f94Var.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static ia4<b94> c(b94 b94Var, b84 b84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, b94Var, b84Var)) == null) {
            if (b84Var != null && b(b94Var, b84Var.r())) {
                return new ia4<>(new ha4(b94Var), b94Var, new fa4(b84Var.r()));
            }
            return null;
        }
        return (ia4) invokeLL.objValue;
    }

    public static ia4<d94> d(d94 d94Var, b84 b84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, d94Var, b84Var)) == null) {
            if (b84Var != null && b(d94Var, b84Var.s())) {
                return new ia4<>(new ha4(d94Var), d94Var, new fa4(b84Var.s()));
            }
            return null;
        }
        return (ia4) invokeLL.objValue;
    }

    public static List<ia4<h94>> e(List<h94> list, b84 b84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, b84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (b84Var != null && list != null && list.size() > 0) {
                for (h94 h94Var : list) {
                    if (b(h94Var, b84Var.q())) {
                        arrayList.add(new ia4(new ha4(h94Var), h94Var, new fa4(b84Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ia4<ab4.a>> f(List<ab4.a> list, b84 b84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, b84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (b84Var != null && list != null && list.size() > 0) {
                for (ab4.a aVar : list) {
                    f94 f94Var = aVar.d;
                    if (f94Var != null && b(aVar, b84Var.v())) {
                        arrayList.add(new ia4(new ha4(f94Var), aVar, new fa4(b84Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ia4<f94> g(f94 f94Var, b84 b84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, f94Var, b84Var)) == null) {
            if (b84Var != null && b(f94Var, b84Var.u())) {
                return new ia4<>(new ha4(f94Var), f94Var, new fa4(b84Var.u()));
            }
            return null;
        }
        return (ia4) invokeLL.objValue;
    }

    public static List<ia4<g94>> h(List<g94> list, b84 b84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, b84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (b84Var != null && list != null && list.size() > 0) {
                for (g94 g94Var : list) {
                    if (b(g94Var, b84Var.A())) {
                        arrayList.add(new ia4(new ha4(g94Var), g94Var, new fa4(b84Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ia4<h94> i(h94 h94Var, b84 b84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, h94Var, b84Var)) == null) {
            if (b84Var != null && b(h94Var, b84Var.x())) {
                return new ia4<>(new ha4(h94Var), h94Var, new fa4(b84Var.x()));
            }
            return null;
        }
        return (ia4) invokeLL.objValue;
    }

    public static ia4<i94> j(i94 i94Var, b84 b84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, i94Var, b84Var)) == null) {
            if (b84Var != null && b(i94Var, b84Var.z())) {
                return new ia4<>(new ha4(i94Var), i94Var, new fa4(b84Var.z()));
            }
            return null;
        }
        return (ia4) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, x74<T> x74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, x74Var) == null) {
            x74Var.e(t, new a94(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
