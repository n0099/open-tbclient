package d.a.n0.i0.b;

import com.baidu.tbadk.imageManager.TbFaceManager;
import d.a.m0.w.p.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.m0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static d f55664f = new d();

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.m0.w.p.c> f55665e;

    public static synchronized d f() {
        d dVar;
        synchronized (d.class) {
            dVar = f55664f;
        }
        return dVar;
    }

    @Override // d.a.m0.w.p.a
    public void b(a.InterfaceC1167a interfaceC1167a) {
        LinkedList<d.a.m0.w.p.c> linkedList = this.f55665e;
        if (linkedList != null && !linkedList.isEmpty()) {
            Iterator<d.a.m0.w.p.c> it = this.f55665e.iterator();
            while (it.hasNext()) {
                d.a.m0.w.p.c next = it.next();
                if (interfaceC1167a != null) {
                    interfaceC1167a.a(next);
                }
            }
            return;
        }
        this.f55665e = new LinkedList<>();
        if (TbFaceManager.e().h() > 0) {
            c cVar = new c();
            this.f55665e.add(cVar);
            if (interfaceC1167a != null) {
                interfaceC1167a.a(cVar);
            }
        }
    }

    @Override // d.a.m0.w.p.a
    public int c() {
        return 1;
    }

    @Override // d.a.m0.w.p.a
    public void d() {
    }

    public List<d.a.m0.w.p.c> e() {
        return this.f55665e;
    }

    public boolean g() {
        LinkedList<d.a.m0.w.p.c> linkedList = this.f55665e;
        return linkedList == null || linkedList.size() == 0;
    }
}
