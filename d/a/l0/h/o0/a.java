package d.a.l0.h.o0;

import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import d.a.l0.a.g1.f;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.p.b.a.i;
import d.a.l0.a.u.e.d.a;
import java.util.ArrayList;
import java.util.Iterator;
@Service
/* loaded from: classes3.dex */
public class a extends d.a.l0.a.u.e.d.a implements i {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a.InterfaceC0836a> f47542a = new ArrayList<>();

    @Nullable
    public static a d() {
        d.a.l0.h.n.a aVar;
        g W = f.V().W();
        if (W == null || (aVar = (d.a.l0.h.n.a) W.n(d.a.l0.h.n.a.class)) == null) {
            return null;
        }
        return aVar.g3();
    }

    @Override // d.a.l0.a.p.b.a.i
    public d.a.l0.a.u.e.d.a a() {
        return d();
    }

    @Override // d.a.l0.a.u.e.d.a
    public synchronized void b(a.InterfaceC0836a interfaceC0836a) {
        if (!this.f47542a.contains(interfaceC0836a)) {
            this.f47542a.add(interfaceC0836a);
        }
    }

    @Override // d.a.l0.a.u.e.d.a
    public synchronized void c(int i2) {
        Iterator<a.InterfaceC0836a> it = this.f47542a.iterator();
        while (it.hasNext()) {
            it.next().b(i2);
        }
    }

    public synchronized void e() {
        Iterator<a.InterfaceC0836a> it = this.f47542a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f47542a.clear();
    }
}
