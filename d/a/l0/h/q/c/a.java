package d.a.l0.h.q.c;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.l0.a f51324a;

    public boolean a(MotionEvent motionEvent) {
        d.a.l0.a.l0.a aVar = this.f51324a;
        if (aVar == null) {
            return false;
        }
        boolean f2 = b.f(aVar.p());
        boolean f3 = b.f(this.f51324a.z());
        JSEvent jSEvent = null;
        if (f2 || f3) {
            jSEvent = b.j(motionEvent);
        }
        boolean F = f2 ? this.f51324a.F(jSEvent) : false;
        if (f3 && this.f51324a.u0()) {
            this.f51324a.z().dispatchEvent(jSEvent);
        }
        b.g(true);
        return F;
    }

    public void b(int i2, int i3) {
        b.m(i2, i3);
    }

    public void c(d.a.l0.a.l0.a aVar) {
        this.f51324a = aVar;
    }

    public void d(int i2, int i3) {
        b.l(i2, i3);
    }
}
