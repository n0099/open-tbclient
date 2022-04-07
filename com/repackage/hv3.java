package com.repackage;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class hv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(pu3 pu3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, pu3Var, jsObject) == null) {
            iv3 iv3Var = new iv3();
            qs1 F = qs1.F(jsObject);
            if (F == null) {
                F = new qs1();
            }
            boolean z = false;
            if (pu3Var == null) {
                iv3Var.errMsg = "openCustomerServiceConversation:fail";
                v24.call(F, false, iv3Var);
                return;
            }
            if (sw3.c()) {
                j03 L = j03.L();
                if (L != null) {
                    String str = "{\"appKey\":\"" + L.N() + "\"}";
                    if (SchemeRouter.invoke(qj2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        iv3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        iv3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    iv3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                iv3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            v24.call(F, z, iv3Var);
        }
    }
}
