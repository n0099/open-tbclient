package com.repackage;

import android.os.Build;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class wl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<rl8> a;

    public wl8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
    }

    public void a(rl8 rl8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rl8Var) == null) {
            this.a.add(rl8Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) || webView == null || pi.isEmpty(str) || pi.isEmpty(str2)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
    }

    public tl8 c(vl8 vl8Var, tl8 tl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, vl8Var, tl8Var)) == null) {
            if (tl8Var == null) {
                tl8Var = new tl8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(vl8Var.c()) && "addObserver".equals(vl8Var.a())) {
                Iterator<rl8> it = this.a.iterator();
                while (it.hasNext()) {
                    tl8Var = it.next().addObserver(vl8Var.d(), tl8Var, true);
                    if (tl8Var.j()) {
                        return tl8Var;
                    }
                }
                if (!tl8Var.j()) {
                    tl8Var.y(202);
                    tl8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0367));
                }
            } else {
                String c = vl8Var.c();
                if (!pi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    tl8Var.y(201);
                    return tl8Var;
                }
                Iterator<rl8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    tl8Var = it2.next().dispatch(vl8Var, tl8Var);
                    if (tl8Var.i()) {
                        return tl8Var;
                    }
                }
                if (!tl8Var.i()) {
                    tl8Var.y(202);
                }
            }
            return tl8Var;
        }
        return (tl8) invokeLL.objValue;
    }

    public void d(WebView webView, tl8 tl8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, tl8Var) == null) || webView == null || tl8Var == null || !tl8Var.k()) {
            return;
        }
        b(webView, tl8Var.c(), tl8Var.d());
    }

    public void e(WebView webView, List<tl8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) || webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (tl8 tl8Var : list) {
            if (tl8Var != null && tl8Var.k()) {
                b(webView, tl8Var.c(), tl8Var.d());
            }
        }
    }

    public List<tl8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<tl8> list = null;
            if (pi.isEmpty(str)) {
                return null;
            }
            Iterator<rl8> it = this.a.iterator();
            while (it.hasNext()) {
                list = it.next().processNotification(str, hashMap);
                if (!ListUtils.isEmpty(list)) {
                    break;
                }
            }
            return list;
        }
        return (List) invokeLL.objValue;
    }
}
