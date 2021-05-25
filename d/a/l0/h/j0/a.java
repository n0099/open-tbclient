package d.a.l0.h.j0;

import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class a {
    public static void a(d.a.l0.a.l0.a aVar, String str) {
        if (aVar != null && aVar.p().hasEventListener("deviceOrientationChange")) {
            JSEvent jSEvent = new JSEvent("deviceOrientationChange");
            jSEvent.data = new d.a.l0.h.j0.c.a(str);
            aVar.F(jSEvent);
        }
    }
}
