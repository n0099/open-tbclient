package com.repackage;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes7.dex */
public class qu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(yt3 yt3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, yt3Var, jsObject) == null) {
            ru3 ru3Var = new ru3();
            zr1 F = zr1.F(jsObject);
            if (F == null) {
                F = new zr1();
            }
            boolean z = false;
            if (yt3Var == null) {
                ru3Var.errMsg = "openCustomerServiceConversation:fail";
                d24.call(F, false, ru3Var);
                return;
            }
            if (bw3.c()) {
                sz2 M = sz2.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(zi2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        ru3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        ru3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    ru3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                ru3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            d24.call(F, z, ru3Var);
        }
    }
}
