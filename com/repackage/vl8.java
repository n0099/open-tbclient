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
public class vl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ql8> a;

    public vl8() {
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

    public void a(ql8 ql8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ql8Var) == null) {
            this.a.add(ql8Var);
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

    public sl8 c(ul8 ul8Var, sl8 sl8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ul8Var, sl8Var)) == null) {
            if (sl8Var == null) {
                sl8Var = new sl8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(ul8Var.c()) && "addObserver".equals(ul8Var.a())) {
                Iterator<ql8> it = this.a.iterator();
                while (it.hasNext()) {
                    sl8Var = it.next().addObserver(ul8Var.d(), sl8Var, true);
                    if (sl8Var.j()) {
                        return sl8Var;
                    }
                }
                if (!sl8Var.j()) {
                    sl8Var.y(202);
                    sl8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0367));
                }
            } else {
                String c = ul8Var.c();
                if (!pi.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    sl8Var.y(201);
                    return sl8Var;
                }
                Iterator<ql8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    sl8Var = it2.next().dispatch(ul8Var, sl8Var);
                    if (sl8Var.i()) {
                        return sl8Var;
                    }
                }
                if (!sl8Var.i()) {
                    sl8Var.y(202);
                }
            }
            return sl8Var;
        }
        return (sl8) invokeLL.objValue;
    }

    public void d(WebView webView, sl8 sl8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, sl8Var) == null) || webView == null || sl8Var == null || !sl8Var.k()) {
            return;
        }
        b(webView, sl8Var.c(), sl8Var.d());
    }

    public void e(WebView webView, List<sl8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) || webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (sl8 sl8Var : list) {
            if (sl8Var != null && sl8Var.k()) {
                b(webView, sl8Var.c(), sl8Var.d());
            }
        }
    }

    public List<sl8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<sl8> list = null;
            if (pi.isEmpty(str)) {
                return null;
            }
            Iterator<ql8> it = this.a.iterator();
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
