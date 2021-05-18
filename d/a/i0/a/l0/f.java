package d.a.i0.a.l0;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43134a = k.f43025a;

    public static a a(g gVar, d.a.i0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        h b2 = b(gVar);
        a b3 = b2.b(gVar.a(), bVar, v8ThreadDelegatePolicy);
        b3.I0(b2.a());
        return b3;
    }

    @NonNull
    public static h b(g gVar) {
        int b2 = gVar.b();
        if (b2 != 1) {
            if (b2 != 2) {
                if (b2 != 3) {
                    if (!f43134a) {
                        return new d.a.i0.a.m0.a();
                    }
                    throw new IllegalArgumentException("invalid model object:" + gVar);
                }
                return new d.a.i0.a.h0.k.e();
            }
            return d.a.i0.a.c1.b.b();
        }
        return new d.a.i0.a.m0.a();
    }

    public static a c(g gVar, d.a.i0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        a a2 = a(gVar, bVar, v8ThreadDelegatePolicy);
        a2.q0();
        return a2;
    }
}
