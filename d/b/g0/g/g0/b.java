package d.b.g0.g.g0;

import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class b {
    public static void a(d.b.g0.g.i.a aVar) {
        if (aVar != null && aVar.t().hasEventListener("audiointerruptionbegin") && d.b.g0.g.c.j.b.h().i()) {
            aVar.d0(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(d.b.g0.g.i.a aVar) {
        if (aVar != null && aVar.t().hasEventListener("audiointerruptionend")) {
            aVar.d0(new JSEvent("audiointerruptionend"));
        }
    }
}
