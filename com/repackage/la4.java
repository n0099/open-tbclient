package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.repackage.bb4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class la4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(y74<T> y74Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, y74Var, t, str, str2)) == null) {
            if (t == null || y74Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, y74Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, y74Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, y74<T> y74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, y74Var)) == null) {
            if (y74Var == null || t == null) {
                return false;
            }
            if (t instanceof f94) {
                f94 f94Var = (f94) t;
                return a(y74Var, t, f94Var.l, f94Var.n);
            } else if (t instanceof bb4.a) {
                g94 g94Var = ((bb4.a) t).d;
                return a(y74Var, t, g94Var.l, g94Var.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static ja4<c94> c(c94 c94Var, c84 c84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, c94Var, c84Var)) == null) {
            if (c84Var != null && b(c94Var, c84Var.s())) {
                return new ja4<>(new ia4(c94Var), c94Var, new ga4(c84Var.s()));
            }
            return null;
        }
        return (ja4) invokeLL.objValue;
    }

    public static ja4<e94> d(e94 e94Var, c84 c84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, e94Var, c84Var)) == null) {
            if (c84Var != null && b(e94Var, c84Var.t())) {
                return new ja4<>(new ia4(e94Var), e94Var, new ga4(c84Var.t()));
            }
            return null;
        }
        return (ja4) invokeLL.objValue;
    }

    public static List<ja4<i94>> e(List<i94> list, c84 c84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, c84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (c84Var != null && list != null && list.size() > 0) {
                for (i94 i94Var : list) {
                    if (b(i94Var, c84Var.r())) {
                        arrayList.add(new ja4(new ia4(i94Var), i94Var, new ga4(c84Var.r())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ja4<bb4.a>> f(List<bb4.a> list, c84 c84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, c84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (c84Var != null && list != null && list.size() > 0) {
                for (bb4.a aVar : list) {
                    g94 g94Var = aVar.d;
                    if (g94Var != null && b(aVar, c84Var.w())) {
                        arrayList.add(new ja4(new ia4(g94Var), aVar, new ga4(c84Var.w())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ja4<g94> g(g94 g94Var, c84 c84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, g94Var, c84Var)) == null) {
            if (c84Var != null && b(g94Var, c84Var.v())) {
                return new ja4<>(new ia4(g94Var), g94Var, new ga4(c84Var.v()));
            }
            return null;
        }
        return (ja4) invokeLL.objValue;
    }

    public static List<ja4<h94>> h(List<h94> list, c84 c84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, c84Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (c84Var != null && list != null && list.size() > 0) {
                for (h94 h94Var : list) {
                    if (b(h94Var, c84Var.B())) {
                        arrayList.add(new ja4(new ia4(h94Var), h94Var, new ga4(c84Var.B())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static ja4<i94> i(i94 i94Var, c84 c84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, i94Var, c84Var)) == null) {
            if (c84Var != null && b(i94Var, c84Var.y())) {
                return new ja4<>(new ia4(i94Var), i94Var, new ga4(c84Var.y()));
            }
            return null;
        }
        return (ja4) invokeLL.objValue;
    }

    public static ja4<j94> j(j94 j94Var, c84 c84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, j94Var, c84Var)) == null) {
            if (c84Var != null && b(j94Var, c84Var.A())) {
                return new ja4<>(new ia4(j94Var), j94Var, new ga4(c84Var.A()));
            }
            return null;
        }
        return (ja4) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, y74<T> y74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, y74Var) == null) {
            y74Var.e(t, new b94(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
