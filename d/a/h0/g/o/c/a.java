package d.a.h0.g.o.c;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.i.a f46736a;

    public boolean a(MotionEvent motionEvent) {
        d.a.h0.g.i.a aVar = this.f46736a;
        if (aVar == null) {
            return false;
        }
        boolean f2 = b.f(aVar.o());
        boolean f3 = b.f(this.f46736a.x());
        JSEvent jSEvent = null;
        if (f2 || f3) {
            jSEvent = b.j(motionEvent);
        }
        boolean Q = f2 ? this.f46736a.Q(jSEvent) : false;
        if (f3 && this.f46736a.q0()) {
            this.f46736a.x().dispatchEvent(jSEvent);
        }
        b.g(true);
        return Q;
    }

    public void b(int i2, int i3) {
        b.m(i2, i3);
    }

    public void c(d.a.h0.g.i.a aVar) {
        this.f46736a = aVar;
    }

    public void d(int i2, int i3) {
        b.l(i2, i3);
    }
}
