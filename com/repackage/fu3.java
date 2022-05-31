package com.repackage;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class fu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(nt3 nt3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, nt3Var, jsObject) == null) {
            gu3 gu3Var = new gu3();
            or1 F = or1.F(jsObject);
            if (F == null) {
                F = new or1();
            }
            boolean z = false;
            if (nt3Var == null) {
                gu3Var.errMsg = "openCustomerServiceConversation:fail";
                s14.call(F, false, gu3Var);
                return;
            }
            if (qv3.c()) {
                hz2 L = hz2.L();
                if (L != null) {
                    String str = "{\"appKey\":\"" + L.N() + "\"}";
                    if (SchemeRouter.invoke(oi2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        gu3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        gu3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    gu3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                gu3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            s14.call(F, z, gu3Var);
        }
    }
}
