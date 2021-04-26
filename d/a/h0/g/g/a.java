package d.a.h0.g.g;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import d.a.h0.a.r1.e;
import d.a.h0.g.e.c;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class a {
    public static void a(c cVar, JsObject jsObject) {
        b bVar = new b();
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            F = new d.a.h0.g.e.d.c();
        }
        boolean z = false;
        if (cVar == null) {
            bVar.errMsg = "openCustomerServiceConversation:fail";
            d.a.h0.g.i0.b.a(F, false, bVar);
            return;
        }
        if (d.a.h0.g.o.c.b.c()) {
            e h2 = e.h();
            if (h2 != null) {
                String str = "{\"appKey\":\"" + h2.B() + "\"}";
                if (SchemeRouter.invoke(d.a.h0.a.w0.a.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                    bVar.errMsg = "openCustomerServiceConversation:ok";
                    z = true;
                } else {
                    bVar.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                bVar.errMsg = "openCustomerServiceConversation:fail";
            }
        } else {
            bVar.errMsg = "openCustomerServiceConversation:fail require user interaction";
        }
        d.a.h0.g.i0.b.a(F, z, bVar);
    }
}
