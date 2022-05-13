package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.mb4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class wa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(j84<T> j84Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, j84Var, t, str, str2)) == null) {
            if (t == null || j84Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, j84Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, j84Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, j84<T> j84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, j84Var)) == null) {
            if (j84Var == null || t == null) {
                return false;
            }
            if (t instanceof q94) {
                q94 q94Var = (q94) t;
                return a(j84Var, t, q94Var.l, q94Var.n);
            } else if (t instanceof mb4.a) {
                r94 r94Var = ((mb4.a) t).d;
                return a(j84Var, t, r94Var.l, r94Var.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static ua4<n94> c(n94 n94Var, n84 n84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, n94Var, n84Var)) == null) {
            if (n84Var != null && b(n94Var, n84Var.s())) {
                return new ua4<>(new ta4(n94Var), n94Var, new ra4(n84Var.s()));
            }
            return null;
        }
        return (ua4) invokeLL.objValue;
    }

    public static ua4<p94> d(p94 p94Var, n84 n84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, p94Var, n84Var)) == null) {
            if (n84Var != null && b(p94Var, n84Var.t())) {
                return new ua4<>(new ta4(p94Var), p94Var, new ra4(n84Var.t()));
            }
            return null;
        }
        return (ua4) invokeLL.objValue;
    }

    public static List<ua4<t94>> e(List<t94> list, n84 n84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, n84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (n84Var != null && list != null && list.size() > 0) {
                for (t94 t94Var : list) {
                    if (b(t94Var, n84Var.r())) {
                        arrayList.add(new ua4(new ta4(t94Var), t94Var, new ra4(n84Var.r())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ua4<mb4.a>> f(List<mb4.a> list, n84 n84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, n84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (n84Var != null && list != null && list.size() > 0) {
                for (mb4.a aVar : list) {
                    r94 r94Var = aVar.d;
                    if (r94Var != null && b(aVar, n84Var.w())) {
                        arrayList.add(new ua4(new ta4(r94Var), aVar, new ra4(n84Var.w())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ua4<r94> g(r94 r94Var, n84 n84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, r94Var, n84Var)) == null) {
            if (n84Var != null && b(r94Var, n84Var.v())) {
                return new ua4<>(new ta4(r94Var), r94Var, new ra4(n84Var.v()));
            }
            return null;
        }
        return (ua4) invokeLL.objValue;
    }

    public static List<ua4<s94>> h(List<s94> list, n84 n84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, n84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (n84Var != null && list != null && list.size() > 0) {
                for (s94 s94Var : list) {
                    if (b(s94Var, n84Var.B())) {
                        arrayList.add(new ua4(new ta4(s94Var), s94Var, new ra4(n84Var.B())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ua4<t94> i(t94 t94Var, n84 n84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, t94Var, n84Var)) == null) {
            if (n84Var != null && b(t94Var, n84Var.y())) {
                return new ua4<>(new ta4(t94Var), t94Var, new ra4(n84Var.y()));
            }
            return null;
        }
        return (ua4) invokeLL.objValue;
    }

    public static ua4<u94> j(u94 u94Var, n84 n84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, u94Var, n84Var)) == null) {
            if (n84Var != null && b(u94Var, n84Var.A())) {
                return new ua4<>(new ta4(u94Var), u94Var, new ra4(n84Var.A()));
            }
            return null;
        }
        return (ua4) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, j84<T> j84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, j84Var) == null) {
            j84Var.e(t, new m94(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
