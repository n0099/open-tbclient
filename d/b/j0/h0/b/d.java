package d.b.j0.h0.b;

import com.baidu.tbadk.imageManager.TbFaceManager;
import d.b.i0.w.p.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.b.i0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static d f56859f = new d();

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.b.i0.w.p.c> f56860e;

    public static synchronized d f() {
        d dVar;
        synchronized (d.class) {
            dVar = f56859f;
        }
        return dVar;
    }

    @Override // d.b.i0.w.p.a
    public void b(a.InterfaceC1144a interfaceC1144a) {
        LinkedList<d.b.i0.w.p.c> linkedList = this.f56860e;
        if (linkedList != null && !linkedList.isEmpty()) {
            Iterator<d.b.i0.w.p.c> it = this.f56860e.iterator();
            while (it.hasNext()) {
                d.b.i0.w.p.c next = it.next();
                if (interfaceC1144a != null) {
                    interfaceC1144a.a(next);
                }
            }
            return;
        }
        this.f56860e = new LinkedList<>();
        if (TbFaceManager.e().h() > 0) {
            c cVar = new c();
            this.f56860e.add(cVar);
            if (interfaceC1144a != null) {
                interfaceC1144a.a(cVar);
            }
        }
    }

    @Override // d.b.i0.w.p.a
    public int c() {
        return 1;
    }

    @Override // d.b.i0.w.p.a
    public void d() {
    }

    public List<d.b.i0.w.p.c> e() {
        return this.f56860e;
    }

    public boolean g() {
        LinkedList<d.b.i0.w.p.c> linkedList = this.f56860e;
        return linkedList == null || linkedList.size() == 0;
    }
}
