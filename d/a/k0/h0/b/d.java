package d.a.k0.h0.b;

import com.baidu.tbadk.imageManager.TbFaceManager;
import d.a.j0.w.p.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.j0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static d f55476f = new d();

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.j0.w.p.c> f55477e;

    public static synchronized d f() {
        d dVar;
        synchronized (d.class) {
            dVar = f55476f;
        }
        return dVar;
    }

    @Override // d.a.j0.w.p.a
    public void b(a.InterfaceC1158a interfaceC1158a) {
        LinkedList<d.a.j0.w.p.c> linkedList = this.f55477e;
        if (linkedList != null && !linkedList.isEmpty()) {
            Iterator<d.a.j0.w.p.c> it = this.f55477e.iterator();
            while (it.hasNext()) {
                d.a.j0.w.p.c next = it.next();
                if (interfaceC1158a != null) {
                    interfaceC1158a.a(next);
                }
            }
            return;
        }
        this.f55477e = new LinkedList<>();
        if (TbFaceManager.e().h() > 0) {
            c cVar = new c();
            this.f55477e.add(cVar);
            if (interfaceC1158a != null) {
                interfaceC1158a.a(cVar);
            }
        }
    }

    @Override // d.a.j0.w.p.a
    public int c() {
        return 1;
    }

    @Override // d.a.j0.w.p.a
    public void d() {
    }

    public List<d.a.j0.w.p.c> e() {
        return this.f55477e;
    }

    public boolean g() {
        LinkedList<d.a.j0.w.p.c> linkedList = this.f55477e;
        return linkedList == null || linkedList.size() == 0;
    }
}
