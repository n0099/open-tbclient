package d.a.m0.h.j0;

import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class b {
    public static void a(d.a.m0.a.l0.a aVar) {
        if (aVar != null && aVar.p().hasEventListener("audiointerruptionbegin") && d.a.m0.h.c.j.b.h().i()) {
            aVar.F(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(d.a.m0.a.l0.a aVar) {
        if (aVar != null && aVar.p().hasEventListener("audiointerruptionend")) {
            aVar.F(new JSEvent("audiointerruptionend"));
        }
    }
}
