package d.a.m0.h.o0;

import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import d.a.m0.a.g1.f;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.p.b.a.i;
import d.a.m0.a.u.e.d.a;
import java.util.ArrayList;
import java.util.Iterator;
@Service
/* loaded from: classes3.dex */
public class a extends d.a.m0.a.u.e.d.a implements i {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a.InterfaceC0895a> f51324a = new ArrayList<>();

    @Nullable
    public static a d() {
        d.a.m0.h.n.a aVar;
        g W = f.V().W();
        if (W == null || (aVar = (d.a.m0.h.n.a) W.n(d.a.m0.h.n.a.class)) == null) {
            return null;
        }
        return aVar.g3();
    }

    @Override // d.a.m0.a.p.b.a.i
    public d.a.m0.a.u.e.d.a a() {
        return d();
    }

    @Override // d.a.m0.a.u.e.d.a
    public synchronized void b(a.InterfaceC0895a interfaceC0895a) {
        if (!this.f51324a.contains(interfaceC0895a)) {
            this.f51324a.add(interfaceC0895a);
        }
    }

    @Override // d.a.m0.a.u.e.d.a
    public synchronized void c(int i2) {
        Iterator<a.InterfaceC0895a> it = this.f51324a.iterator();
        while (it.hasNext()) {
            it.next().b(i2);
        }
    }

    public synchronized void e() {
        Iterator<a.InterfaceC0895a> it = this.f51324a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f51324a.clear();
    }
}
