package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.cb4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ma4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(z74<T> z74Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, z74Var, t, str, str2)) == null) {
            if (t == null || z74Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, z74Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, z74Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, z74<T> z74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, z74Var)) == null) {
            if (z74Var == null || t == null) {
                return false;
            }
            if (t instanceof g94) {
                g94 g94Var = (g94) t;
                return a(z74Var, t, g94Var.l, g94Var.n);
            } else if (t instanceof cb4.a) {
                h94 h94Var = ((cb4.a) t).d;
                return a(z74Var, t, h94Var.l, h94Var.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static ka4<d94> c(d94 d94Var, d84 d84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, d94Var, d84Var)) == null) {
            if (d84Var != null && b(d94Var, d84Var.s())) {
                return new ka4<>(new ja4(d94Var), d94Var, new ha4(d84Var.s()));
            }
            return null;
        }
        return (ka4) invokeLL.objValue;
    }

    public static ka4<f94> d(f94 f94Var, d84 d84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, f94Var, d84Var)) == null) {
            if (d84Var != null && b(f94Var, d84Var.t())) {
                return new ka4<>(new ja4(f94Var), f94Var, new ha4(d84Var.t()));
            }
            return null;
        }
        return (ka4) invokeLL.objValue;
    }

    public static List<ka4<j94>> e(List<j94> list, d84 d84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, d84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (d84Var != null && list != null && list.size() > 0) {
                for (j94 j94Var : list) {
                    if (b(j94Var, d84Var.r())) {
                        arrayList.add(new ka4(new ja4(j94Var), j94Var, new ha4(d84Var.r())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ka4<cb4.a>> f(List<cb4.a> list, d84 d84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, d84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (d84Var != null && list != null && list.size() > 0) {
                for (cb4.a aVar : list) {
                    h94 h94Var = aVar.d;
                    if (h94Var != null && b(aVar, d84Var.w())) {
                        arrayList.add(new ka4(new ja4(h94Var), aVar, new ha4(d84Var.w())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ka4<h94> g(h94 h94Var, d84 d84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, h94Var, d84Var)) == null) {
            if (d84Var != null && b(h94Var, d84Var.v())) {
                return new ka4<>(new ja4(h94Var), h94Var, new ha4(d84Var.v()));
            }
            return null;
        }
        return (ka4) invokeLL.objValue;
    }

    public static List<ka4<i94>> h(List<i94> list, d84 d84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, d84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (d84Var != null && list != null && list.size() > 0) {
                for (i94 i94Var : list) {
                    if (b(i94Var, d84Var.B())) {
                        arrayList.add(new ka4(new ja4(i94Var), i94Var, new ha4(d84Var.B())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ka4<j94> i(j94 j94Var, d84 d84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, j94Var, d84Var)) == null) {
            if (d84Var != null && b(j94Var, d84Var.y())) {
                return new ka4<>(new ja4(j94Var), j94Var, new ha4(d84Var.y()));
            }
            return null;
        }
        return (ka4) invokeLL.objValue;
    }

    public static ka4<k94> j(k94 k94Var, d84 d84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, k94Var, d84Var)) == null) {
            if (d84Var != null && b(k94Var, d84Var.A())) {
                return new ka4<>(new ja4(k94Var), k94Var, new ha4(d84Var.A()));
            }
            return null;
        }
        return (ka4) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, z74<T> z74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, z74Var) == null) {
            z74Var.e(t, new c94(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
