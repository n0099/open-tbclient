package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.ka4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class u94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(h74<T> h74Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, h74Var, t, str, str2)) == null) {
            if (t == null || h74Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, h74Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, h74Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, h74<T> h74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, h74Var)) == null) {
            if (h74Var == null || t == null) {
                return false;
            }
            if (t instanceof o84) {
                o84 o84Var = (o84) t;
                return a(h74Var, t, o84Var.l, o84Var.n);
            } else if (t instanceof ka4.a) {
                p84 p84Var = ((ka4.a) t).d;
                return a(h74Var, t, p84Var.l, p84Var.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static s94<l84> c(l84 l84Var, l74 l74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, l84Var, l74Var)) == null) {
            if (l74Var != null && b(l84Var, l74Var.r())) {
                return new s94<>(new r94(l84Var), l84Var, new p94(l74Var.r()));
            }
            return null;
        }
        return (s94) invokeLL.objValue;
    }

    public static s94<n84> d(n84 n84Var, l74 l74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, n84Var, l74Var)) == null) {
            if (l74Var != null && b(n84Var, l74Var.s())) {
                return new s94<>(new r94(n84Var), n84Var, new p94(l74Var.s()));
            }
            return null;
        }
        return (s94) invokeLL.objValue;
    }

    public static List<s94<r84>> e(List<r84> list, l74 l74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, l74Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (l74Var != null && list != null && list.size() > 0) {
                for (r84 r84Var : list) {
                    if (b(r84Var, l74Var.q())) {
                        arrayList.add(new s94(new r94(r84Var), r84Var, new p94(l74Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<s94<ka4.a>> f(List<ka4.a> list, l74 l74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, l74Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (l74Var != null && list != null && list.size() > 0) {
                for (ka4.a aVar : list) {
                    p84 p84Var = aVar.d;
                    if (p84Var != null && b(aVar, l74Var.v())) {
                        arrayList.add(new s94(new r94(p84Var), aVar, new p94(l74Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static s94<p84> g(p84 p84Var, l74 l74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, p84Var, l74Var)) == null) {
            if (l74Var != null && b(p84Var, l74Var.u())) {
                return new s94<>(new r94(p84Var), p84Var, new p94(l74Var.u()));
            }
            return null;
        }
        return (s94) invokeLL.objValue;
    }

    public static List<s94<q84>> h(List<q84> list, l74 l74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, l74Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (l74Var != null && list != null && list.size() > 0) {
                for (q84 q84Var : list) {
                    if (b(q84Var, l74Var.A())) {
                        arrayList.add(new s94(new r94(q84Var), q84Var, new p94(l74Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static s94<r84> i(r84 r84Var, l74 l74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, r84Var, l74Var)) == null) {
            if (l74Var != null && b(r84Var, l74Var.x())) {
                return new s94<>(new r94(r84Var), r84Var, new p94(l74Var.x()));
            }
            return null;
        }
        return (s94) invokeLL.objValue;
    }

    public static s94<s84> j(s84 s84Var, l74 l74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, s84Var, l74Var)) == null) {
            if (l74Var != null && b(s84Var, l74Var.z())) {
                return new s94<>(new r94(s84Var), s84Var, new p94(l74Var.z()));
            }
            return null;
        }
        return (s94) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, h74<T> h74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, h74Var) == null) {
            h74Var.e(t, new k84(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
