package d.b.g0.g.g0;

import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class a {
    public static void a(d.b.g0.g.i.a aVar, String str) {
        if (aVar != null && aVar.t().hasEventListener("deviceOrientationChange")) {
            JSEvent jSEvent = new JSEvent("deviceOrientationChange");
            jSEvent.data = new d.b.g0.g.g0.c.a(str);
            aVar.d0(jSEvent);
        }
    }
}
