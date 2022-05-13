package com.repackage;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes7.dex */
public class sv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(av3 av3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, av3Var, jsObject) == null) {
            tv3 tv3Var = new tv3();
            bt1 F = bt1.F(jsObject);
            if (F == null) {
                F = new bt1();
            }
            boolean z = false;
            if (av3Var == null) {
                tv3Var.errMsg = "openCustomerServiceConversation:fail";
                f34.call(F, false, tv3Var);
                return;
            }
            if (dx3.c()) {
                u03 L = u03.L();
                if (L != null) {
                    String str = "{\"appKey\":\"" + L.N() + "\"}";
                    if (SchemeRouter.invoke(bk2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        tv3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        tv3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    tv3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                tv3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            f34.call(F, z, tv3Var);
        }
    }
}
