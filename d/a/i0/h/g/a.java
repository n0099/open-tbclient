package d.a.i0.h.g;

import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import d.a.i0.a.a2.e;
import d.a.i0.h.m0.c;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class a {
    public static void a(d.a.i0.h.d.b bVar, JsObject jsObject) {
        b bVar2 = new b();
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        if (G == null) {
            G = new d.a.i0.a.y.b.a();
        }
        boolean z = false;
        if (bVar == null) {
            bVar2.errMsg = "openCustomerServiceConversation:fail";
            c.a(G, false, bVar2);
            return;
        }
        if (d.a.i0.h.q.c.b.c()) {
            e i2 = e.i();
            if (i2 != null) {
                String str = "{\"appKey\":\"" + i2.D() + "\"}";
                if (SchemeRouter.invoke(d.a.i0.a.c1.a.b(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                    bVar2.errMsg = "openCustomerServiceConversation:ok";
                    z = true;
                } else {
                    bVar2.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                bVar2.errMsg = "openCustomerServiceConversation:fail";
            }
        } else {
            bVar2.errMsg = "openCustomerServiceConversation:fail require user interaction";
        }
        c.a(G, z, bVar2);
    }
}
