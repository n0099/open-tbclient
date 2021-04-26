package d.a.h0.g.g0;

import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class a {
    public static void a(d.a.h0.g.i.a aVar, String str) {
        if (aVar != null && aVar.o().hasEventListener("deviceOrientationChange")) {
            JSEvent jSEvent = new JSEvent("deviceOrientationChange");
            jSEvent.data = new d.a.h0.g.g0.c.a(str);
            aVar.Q(jSEvent);
        }
    }
}
