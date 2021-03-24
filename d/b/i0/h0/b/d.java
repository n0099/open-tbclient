package d.b.i0.h0.b;

import com.baidu.tbadk.imageManager.TbFaceManager;
import d.b.h0.w.p.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.b.h0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static d f55124f = new d();

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.b.h0.w.p.c> f55125e;

    public static synchronized d f() {
        d dVar;
        synchronized (d.class) {
            dVar = f55124f;
        }
        return dVar;
    }

    @Override // d.b.h0.w.p.a
    public void b(a.InterfaceC1108a interfaceC1108a) {
        LinkedList<d.b.h0.w.p.c> linkedList = this.f55125e;
        if (linkedList != null && !linkedList.isEmpty()) {
            Iterator<d.b.h0.w.p.c> it = this.f55125e.iterator();
            while (it.hasNext()) {
                d.b.h0.w.p.c next = it.next();
                if (interfaceC1108a != null) {
                    interfaceC1108a.a(next);
                }
            }
            return;
        }
        this.f55125e = new LinkedList<>();
        if (TbFaceManager.e().h() > 0) {
            c cVar = new c();
            this.f55125e.add(cVar);
            if (interfaceC1108a != null) {
                interfaceC1108a.a(cVar);
            }
        }
    }

    @Override // d.b.h0.w.p.a
    public int c() {
        return 1;
    }

    @Override // d.b.h0.w.p.a
    public void d() {
    }

    public List<d.b.h0.w.p.c> e() {
        return this.f55125e;
    }

    public boolean g() {
        LinkedList<d.b.h0.w.p.c> linkedList = this.f55125e;
        return linkedList == null || linkedList.size() == 0;
    }
}
