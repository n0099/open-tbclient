package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.z94;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class j94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(w64<T> w64Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, w64Var, t, str, str2)) == null) {
            if (t == null || w64Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, w64Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, w64Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, w64<T> w64Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, w64Var)) == null) {
            if (w64Var == null || t == null) {
                return false;
            }
            if (t instanceof d84) {
                d84 d84Var = (d84) t;
                return a(w64Var, t, d84Var.l, d84Var.n);
            } else if (t instanceof z94.a) {
                e84 e84Var = ((z94.a) t).d;
                return a(w64Var, t, e84Var.l, e84Var.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static h94<a84> c(a84 a84Var, a74 a74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, a84Var, a74Var)) == null) {
            if (a74Var != null && b(a84Var, a74Var.s())) {
                return new h94<>(new g94(a84Var), a84Var, new e94(a74Var.s()));
            }
            return null;
        }
        return (h94) invokeLL.objValue;
    }

    public static h94<c84> d(c84 c84Var, a74 a74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, c84Var, a74Var)) == null) {
            if (a74Var != null && b(c84Var, a74Var.t())) {
                return new h94<>(new g94(c84Var), c84Var, new e94(a74Var.t()));
            }
            return null;
        }
        return (h94) invokeLL.objValue;
    }

    public static List<h94<g84>> e(List<g84> list, a74 a74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, a74Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (a74Var != null && list != null && list.size() > 0) {
                for (g84 g84Var : list) {
                    if (b(g84Var, a74Var.r())) {
                        arrayList.add(new h94(new g94(g84Var), g84Var, new e94(a74Var.r())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<h94<z94.a>> f(List<z94.a> list, a74 a74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, a74Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (a74Var != null && list != null && list.size() > 0) {
                for (z94.a aVar : list) {
                    e84 e84Var = aVar.d;
                    if (e84Var != null && b(aVar, a74Var.w())) {
                        arrayList.add(new h94(new g94(e84Var), aVar, new e94(a74Var.w())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static h94<e84> g(e84 e84Var, a74 a74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, e84Var, a74Var)) == null) {
            if (a74Var != null && b(e84Var, a74Var.v())) {
                return new h94<>(new g94(e84Var), e84Var, new e94(a74Var.v()));
            }
            return null;
        }
        return (h94) invokeLL.objValue;
    }

    public static List<h94<f84>> h(List<f84> list, a74 a74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, a74Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (a74Var != null && list != null && list.size() > 0) {
                for (f84 f84Var : list) {
                    if (b(f84Var, a74Var.B())) {
                        arrayList.add(new h94(new g94(f84Var), f84Var, new e94(a74Var.B())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static h94<g84> i(g84 g84Var, a74 a74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, g84Var, a74Var)) == null) {
            if (a74Var != null && b(g84Var, a74Var.y())) {
                return new h94<>(new g94(g84Var), g84Var, new e94(a74Var.y()));
            }
            return null;
        }
        return (h94) invokeLL.objValue;
    }

    public static h94<h84> j(h84 h84Var, a74 a74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, h84Var, a74Var)) == null) {
            if (a74Var != null && b(h84Var, a74Var.A())) {
                return new h94<>(new g94(h84Var), h84Var, new e94(a74Var.A()));
            }
            return null;
        }
        return (h94) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, w64<T> w64Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, w64Var) == null) {
            w64Var.e(t, new z74(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
