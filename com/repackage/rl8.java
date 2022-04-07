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
public class rl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ml8> a;

    public rl8() {
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

    public void a(ml8 ml8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ml8Var) == null) {
            this.a.add(ml8Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) || webView == null || ni.isEmpty(str) || ni.isEmpty(str2)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
    }

    public ol8 c(ql8 ql8Var, ol8 ol8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ql8Var, ol8Var)) == null) {
            if (ol8Var == null) {
                ol8Var = new ol8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(ql8Var.c()) && "addObserver".equals(ql8Var.a())) {
                Iterator<ml8> it = this.a.iterator();
                while (it.hasNext()) {
                    ol8Var = it.next().addObserver(ql8Var.d(), ol8Var, true);
                    if (ol8Var.j()) {
                        return ol8Var;
                    }
                }
                if (!ol8Var.j()) {
                    ol8Var.y(202);
                    ol8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0365));
                }
            } else {
                String c = ql8Var.c();
                if (!ni.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    ol8Var.y(201);
                    return ol8Var;
                }
                Iterator<ml8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    ol8Var = it2.next().dispatch(ql8Var, ol8Var);
                    if (ol8Var.i()) {
                        return ol8Var;
                    }
                }
                if (!ol8Var.i()) {
                    ol8Var.y(202);
                }
            }
            return ol8Var;
        }
        return (ol8) invokeLL.objValue;
    }

    public void d(WebView webView, ol8 ol8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, ol8Var) == null) || webView == null || ol8Var == null || !ol8Var.k()) {
            return;
        }
        b(webView, ol8Var.c(), ol8Var.d());
    }

    public void e(WebView webView, List<ol8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) || webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (ol8 ol8Var : list) {
            if (ol8Var != null && ol8Var.k()) {
                b(webView, ol8Var.c(), ol8Var.d());
            }
        }
    }

    public List<ol8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<ol8> list = null;
            if (ni.isEmpty(str)) {
                return null;
            }
            Iterator<ml8> it = this.a.iterator();
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
