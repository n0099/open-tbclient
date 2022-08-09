package com.repackage;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes7.dex */
public class xv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(fv3 fv3Var, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, fv3Var, jsObject) == null) {
            yv3 yv3Var = new yv3();
            gt1 F = gt1.F(jsObject);
            if (F == null) {
                F = new gt1();
            }
            boolean z = false;
            if (fv3Var == null) {
                yv3Var.errMsg = "openCustomerServiceConversation:fail";
                k34.call(F, false, yv3Var);
                return;
            }
            if (ix3.c()) {
                z03 M = z03.M();
                if (M != null) {
                    String str = "{\"appKey\":\"" + M.O() + "\"}";
                    if (SchemeRouter.invoke(gk2.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        yv3Var.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        yv3Var.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    yv3Var.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                yv3Var.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            k34.call(F, z, yv3Var);
        }
    }
}
