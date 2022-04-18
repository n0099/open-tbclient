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
public class yl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<tl8> a;

    public yl8() {
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

    public void a(tl8 tl8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tl8Var) == null) {
            this.a.add(tl8Var);
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

    public vl8 c(xl8 xl8Var, vl8 vl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, xl8Var, vl8Var)) == null) {
            if (vl8Var == null) {
                vl8Var = new vl8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(xl8Var.c()) && "addObserver".equals(xl8Var.a())) {
                Iterator<tl8> it = this.a.iterator();
                while (it.hasNext()) {
                    vl8Var = it.next().addObserver(xl8Var.d(), vl8Var, true);
                    if (vl8Var.j()) {
                        return vl8Var;
                    }
                }
                if (!vl8Var.j()) {
                    vl8Var.y(202);
                    vl8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0365));
                }
            } else {
                String c = xl8Var.c();
                if (!ni.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    vl8Var.y(201);
                    return vl8Var;
                }
                Iterator<tl8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    vl8Var = it2.next().dispatch(xl8Var, vl8Var);
                    if (vl8Var.i()) {
                        return vl8Var;
                    }
                }
                if (!vl8Var.i()) {
                    vl8Var.y(202);
                }
            }
            return vl8Var;
        }
        return (vl8) invokeLL.objValue;
    }

    public void d(WebView webView, vl8 vl8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, vl8Var) == null) || webView == null || vl8Var == null || !vl8Var.k()) {
            return;
        }
        b(webView, vl8Var.c(), vl8Var.d());
    }

    public void e(WebView webView, List<vl8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) || webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (vl8 vl8Var : list) {
            if (vl8Var != null && vl8Var.k()) {
                b(webView, vl8Var.c(), vl8Var.d());
            }
        }
    }

    public List<vl8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<vl8> list = null;
            if (ni.isEmpty(str)) {
                return null;
            }
            Iterator<tl8> it = this.a.iterator();
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
