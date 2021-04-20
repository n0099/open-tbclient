package d.b.g0.g.i;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes3.dex */
public final class g {
    public static a a(h hVar, d.b.g0.g.i.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        i b2 = b(hVar);
        a a2 = b2.a(hVar.a(), bVar, v8ThreadDelegatePolicy);
        a2.D0(b2.b());
        return a2;
    }

    @NonNull
    public static i b(h hVar) {
        int b2 = hVar.b();
        if (b2 != 1) {
            if (b2 == 2) {
                return new d.b.g0.a.i0.b();
            }
            throw new IllegalArgumentException("invalid model object:" + hVar);
        }
        return new d.b.g0.a.i0.a();
    }

    public static a c(h hVar, d.b.g0.g.i.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        a a2 = a(hVar, bVar, v8ThreadDelegatePolicy);
        a2.u(new d.b.g0.g.i.k.b(a2));
        a2.B0(new d.b.g0.g.i.k.c(a2));
        a2.m0();
        return a2;
    }
}
