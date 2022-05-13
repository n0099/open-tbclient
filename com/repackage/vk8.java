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
public class vk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<qk8> a;

    public vk8() {
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

    public void a(qk8 qk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qk8Var) == null) {
            this.a.add(qk8Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) || webView == null || li.isEmpty(str) || li.isEmpty(str2)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
    }

    public sk8 c(uk8 uk8Var, sk8 sk8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uk8Var, sk8Var)) == null) {
            if (sk8Var == null) {
                sk8Var = new sk8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(uk8Var.c()) && "addObserver".equals(uk8Var.a())) {
                Iterator<qk8> it = this.a.iterator();
                while (it.hasNext()) {
                    sk8Var = it.next().addObserver(uk8Var.d(), sk8Var, true);
                    if (sk8Var.j()) {
                        return sk8Var;
                    }
                }
                if (!sk8Var.j()) {
                    sk8Var.y(202);
                    sk8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f036b));
                }
            } else {
                String c = uk8Var.c();
                if (!li.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    sk8Var.y(201);
                    return sk8Var;
                }
                Iterator<qk8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    sk8Var = it2.next().dispatch(uk8Var, sk8Var);
                    if (sk8Var.i()) {
                        return sk8Var;
                    }
                }
                if (!sk8Var.i()) {
                    sk8Var.y(202);
                }
            }
            return sk8Var;
        }
        return (sk8) invokeLL.objValue;
    }

    public void d(WebView webView, sk8 sk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, sk8Var) == null) || webView == null || sk8Var == null || !sk8Var.k()) {
            return;
        }
        b(webView, sk8Var.c(), sk8Var.d());
    }

    public void e(WebView webView, List<sk8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) || webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (sk8 sk8Var : list) {
            if (sk8Var != null && sk8Var.k()) {
                b(webView, sk8Var.c(), sk8Var.d());
            }
        }
    }

    public List<sk8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<sk8> list = null;
            if (li.isEmpty(str)) {
                return null;
            }
            Iterator<qk8> it = this.a.iterator();
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
