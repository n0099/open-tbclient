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
public class kj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<fj8> a;

    public kj8() {
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

    public void a(fj8 fj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fj8Var) == null) {
            this.a.add(fj8Var);
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

    public hj8 c(jj8 jj8Var, hj8 hj8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jj8Var, hj8Var)) == null) {
            if (hj8Var == null) {
                hj8Var = new hj8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(jj8Var.c()) && "addObserver".equals(jj8Var.a())) {
                Iterator<fj8> it = this.a.iterator();
                while (it.hasNext()) {
                    hj8Var = it.next().addObserver(jj8Var.d(), hj8Var, true);
                    if (hj8Var.j()) {
                        return hj8Var;
                    }
                }
                if (!hj8Var.j()) {
                    hj8Var.y(202);
                    hj8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0361));
                }
            } else {
                String c = jj8Var.c();
                if (!oi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    hj8Var.y(201);
                    return hj8Var;
                }
                Iterator<fj8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    hj8Var = it2.next().dispatch(jj8Var, hj8Var);
                    if (hj8Var.i()) {
                        return hj8Var;
                    }
                }
                if (!hj8Var.i()) {
                    hj8Var.y(202);
                }
            }
            return hj8Var;
        }
        return (hj8) invokeLL.objValue;
    }

    public void d(WebView webView, hj8 hj8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, hj8Var) == null) || webView == null || hj8Var == null || !hj8Var.k()) {
            return;
        }
        b(webView, hj8Var.c(), hj8Var.d());
    }

    public void e(WebView webView, List<hj8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) || webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (hj8 hj8Var : list) {
            if (hj8Var != null && hj8Var.k()) {
                b(webView, hj8Var.c(), hj8Var.d());
            }
        }
    }

    public List<hj8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<hj8> list = null;
            if (oi.isEmpty(str)) {
                return null;
            }
            Iterator<fj8> it = this.a.iterator();
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
