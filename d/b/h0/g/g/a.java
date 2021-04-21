package d.b.h0.g.g;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import d.b.h0.a.r1.e;
import d.b.h0.g.e.c;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class a {
    public static void a(c cVar, JsObject jsObject) {
        b bVar = new b();
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            F = new d.b.h0.g.e.d.c();
        }
        boolean z = false;
        if (cVar == null) {
            bVar.errMsg = "openCustomerServiceConversation:fail";
            d.b.h0.g.i0.b.a(F, false, bVar);
            return;
        }
        if (d.b.h0.g.o.c.b.c()) {
            e y = e.y();
            if (y != null) {
                String str = "{\"appKey\":\"" + y.B() + "\"}";
                if (SchemeRouter.invoke(d.b.h0.a.w0.a.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
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
        d.b.h0.g.i0.b.a(F, z, bVar);
    }
}
