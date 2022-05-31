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
public class wh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<rh8> a;

    public wh8() {
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

    public void a(rh8 rh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rh8Var) == null) {
            this.a.add(rh8Var);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) || webView == null || ki.isEmpty(str) || ki.isEmpty(str2)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
    }

    public th8 c(vh8 vh8Var, th8 th8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, vh8Var, th8Var)) == null) {
            if (th8Var == null) {
                th8Var = new th8();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(vh8Var.c()) && "addObserver".equals(vh8Var.a())) {
                Iterator<rh8> it = this.a.iterator();
                while (it.hasNext()) {
                    th8Var = it.next().addObserver(vh8Var.d(), th8Var, true);
                    if (th8Var.j()) {
                        return th8Var;
                    }
                }
                if (!th8Var.j()) {
                    th8Var.y(202);
                    th8Var.u(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f036d));
                }
            } else {
                String c = vh8Var.c();
                if (!ki.isEmpty(c) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c)) {
                    th8Var.y(201);
                    return th8Var;
                }
                Iterator<rh8> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    th8Var = it2.next().dispatch(vh8Var, th8Var);
                    if (th8Var.i()) {
                        return th8Var;
                    }
                }
                if (!th8Var.i()) {
                    th8Var.y(202);
                }
            }
            return th8Var;
        }
        return (th8) invokeLL.objValue;
    }

    public void d(WebView webView, th8 th8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, th8Var) == null) || webView == null || th8Var == null || !th8Var.k()) {
            return;
        }
        b(webView, th8Var.c(), th8Var.d());
    }

    public void e(WebView webView, List<th8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) || webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (th8 th8Var : list) {
            if (th8Var != null && th8Var.k()) {
                b(webView, th8Var.c(), th8Var.d());
            }
        }
    }

    public List<th8> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<th8> list = null;
            if (ki.isEmpty(str)) {
                return null;
            }
            Iterator<rh8> it = this.a.iterator();
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
