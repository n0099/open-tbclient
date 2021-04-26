package d.a.h0.g.g0;

import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class b {
    public static void a(d.a.h0.g.i.a aVar) {
        if (aVar != null && aVar.o().hasEventListener("audiointerruptionbegin") && d.a.h0.g.c.j.b.h().i()) {
            aVar.Q(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(d.a.h0.g.i.a aVar) {
        if (aVar != null && aVar.o().hasEventListener("audiointerruptionend")) {
            aVar.Q(new JSEvent("audiointerruptionend"));
        }
    }
}
