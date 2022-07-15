package com.repackage;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class fv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(nu3 nu3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, nu3Var, jsObject) == null) {
            gv3 gv3Var = new gv3();
            os1 F = os1.F(jsObject);
            if (F == null) {
                F = new os1();
            }
            boolean z = false;
            if (nu3Var == null) {
                gv3Var.errMsg = "openCustomerServiceConversation:fail";
                s24.call(F, false, gv3Var);
                return;
            }
            if (qw3.c()) {
                h03 M = h03.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(oj2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        gv3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        gv3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    gv3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                gv3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            s24.call(F, z, gv3Var);
        }
    }
}
