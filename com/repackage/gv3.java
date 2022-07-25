package com.repackage;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class gv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ou3 ou3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ou3Var, jsObject) == null) {
            hv3 hv3Var = new hv3();
            ps1 F = ps1.F(jsObject);
            if (F == null) {
                F = new ps1();
            }
            boolean z = false;
            if (ou3Var == null) {
                hv3Var.errMsg = "openCustomerServiceConversation:fail";
                t24.call(F, false, hv3Var);
                return;
            }
            if (rw3.c()) {
                i03 M = i03.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(pj2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        hv3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        hv3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    hv3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                hv3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            t24.call(F, z, hv3Var);
        }
    }
}
