package d.a.o0.i0.b;

import com.baidu.tbadk.imageManager.TbFaceManager;
import d.a.n0.w.p.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.n0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static d f59478f = new d();

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.n0.w.p.c> f59479e;

    public static synchronized d f() {
        d dVar;
        synchronized (d.class) {
            dVar = f59478f;
        }
        return dVar;
    }

    @Override // d.a.n0.w.p.a
    public void b(a.InterfaceC1226a interfaceC1226a) {
        LinkedList<d.a.n0.w.p.c> linkedList = this.f59479e;
        if (linkedList != null && !linkedList.isEmpty()) {
            Iterator<d.a.n0.w.p.c> it = this.f59479e.iterator();
            while (it.hasNext()) {
                d.a.n0.w.p.c next = it.next();
                if (interfaceC1226a != null) {
                    interfaceC1226a.a(next);
                }
            }
            return;
        }
        this.f59479e = new LinkedList<>();
        if (TbFaceManager.e().h() > 0) {
            c cVar = new c();
            this.f59479e.add(cVar);
            if (interfaceC1226a != null) {
                interfaceC1226a.a(cVar);
            }
        }
    }

    @Override // d.a.n0.w.p.a
    public int c() {
        return 1;
    }

    @Override // d.a.n0.w.p.a
    public void d() {
    }

    public List<d.a.n0.w.p.c> e() {
        return this.f59479e;
    }

    public boolean g() {
        LinkedList<d.a.n0.w.p.c> linkedList = this.f59479e;
        return linkedList == null || linkedList.size() == 0;
    }
}
