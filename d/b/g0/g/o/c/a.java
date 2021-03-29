package d.b.g0.g.o.c;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.i.a f48521a;

    public boolean a(MotionEvent motionEvent) {
        d.b.g0.g.i.a aVar = this.f48521a;
        if (aVar == null) {
            return false;
        }
        boolean f2 = b.f(aVar.t());
        boolean f3 = b.f(this.f48521a.Z());
        JSEvent jSEvent = null;
        if (f2 || f3) {
            jSEvent = b.j(motionEvent);
        }
        boolean c0 = f2 ? this.f48521a.c0(jSEvent) : false;
        if (f3 && this.f48521a.p0()) {
            this.f48521a.Z().dispatchEvent(jSEvent);
        }
        b.g(true);
        return c0;
    }

    public void b(int i, int i2) {
        b.m(i, i2);
    }

    public void c(d.b.g0.g.i.a aVar) {
        this.f48521a = aVar;
    }

    public void d(int i, int i2) {
        b.l(i, i2);
    }
}
