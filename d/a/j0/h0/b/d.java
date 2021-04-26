package d.a.j0.h0.b;

import com.baidu.tbadk.imageManager.TbFaceManager;
import d.a.i0.w.p.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.i0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static d f54769f = new d();

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.i0.w.p.c> f54770e;

    public static synchronized d f() {
        d dVar;
        synchronized (d.class) {
            dVar = f54769f;
        }
        return dVar;
    }

    @Override // d.a.i0.w.p.a
    public void b(a.InterfaceC1083a interfaceC1083a) {
        LinkedList<d.a.i0.w.p.c> linkedList = this.f54770e;
        if (linkedList != null && !linkedList.isEmpty()) {
            Iterator<d.a.i0.w.p.c> it = this.f54770e.iterator();
            while (it.hasNext()) {
                d.a.i0.w.p.c next = it.next();
                if (interfaceC1083a != null) {
                    interfaceC1083a.a(next);
                }
            }
            return;
        }
        this.f54770e = new LinkedList<>();
        if (TbFaceManager.e().h() > 0) {
            c cVar = new c();
            this.f54770e.add(cVar);
            if (interfaceC1083a != null) {
                interfaceC1083a.a(cVar);
            }
        }
    }

    @Override // d.a.i0.w.p.a
    public int c() {
        return 1;
    }

    @Override // d.a.i0.w.p.a
    public void d() {
    }

    public List<d.a.i0.w.p.c> e() {
        return this.f54770e;
    }

    public boolean g() {
        LinkedList<d.a.i0.w.p.c> linkedList = this.f54770e;
        return linkedList == null || linkedList.size() == 0;
    }
}
