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
/* loaded from: classes6.dex */
public class oi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ji8> a;

    public oi8() {
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

    public void a(ji8 ji8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ji8Var) == null) {
            this.a.add(ji8Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) || webView == null || oi.isEmpty(str) || oi.isEmpty(str2)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
    }

    public li8 c(ni8 ni8Var, li8 li8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ni8Var, li8Var)) == null) {
            if (li8Var == null) {
                li8Var = new li8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(ni8Var.c()) && "addObserver".equals(ni8Var.a())) {
                Iterator<ji8> it = this.a.iterator();
                while (it.hasNext()) {
                    li8Var = it.next().addObserver(ni8Var.d(), li8Var, true);
                    if (li8Var.j()) {
                        return li8Var;
                    }
                }
                if (!li8Var.j()) {
                    li8Var.y(202);
                    li8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f035d));
                }
            } else {
                String c = ni8Var.c();
                if (!oi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    li8Var.y(201);
                    return li8Var;
                }
                Iterator<ji8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    li8Var = it2.next().dispatch(ni8Var, li8Var);
                    if (li8Var.i()) {
                        return li8Var;
                    }
                }
                if (!li8Var.i()) {
                    li8Var.y(202);
                }
            }
            return li8Var;
        }
        return (li8) invokeLL.objValue;
    }

    public void d(WebView webView, li8 li8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, li8Var) == null) || webView == null || li8Var == null || !li8Var.k()) {
            return;
        }
        b(webView, li8Var.c(), li8Var.d());
    }

    public void e(WebView webView, List<li8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) || webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (li8 li8Var : list) {
            if (li8Var != null && li8Var.k()) {
                b(webView, li8Var.c(), li8Var.d());
            }
        }
    }

    public List<li8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<li8> list = null;
            if (oi.isEmpty(str)) {
                return null;
            }
            Iterator<ji8> it = this.a.iterator();
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
