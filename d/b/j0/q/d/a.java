package d.b.j0.q.d;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f59395c;

    /* renamed from: a  reason: collision with root package name */
    public List<InterfaceC1457a> f59396a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.i0.s.f.a> f59397b;

    /* renamed from: d.b.j0.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1457a {
        void g(List<d.b.i0.s.f.a> list);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f59395c == null) {
                f59395c = new a();
            }
            aVar = f59395c;
        }
        return aVar;
    }

    public void a(d.b.i0.s.f.a aVar) {
        if (this.f59397b == null || aVar == null) {
            return;
        }
        String a2 = aVar.a();
        if (TextUtils.isEmpty(a2)) {
            a2 = "#";
            aVar.k("#");
        }
        String f2 = aVar.f();
        if (f2 == null) {
            f2 = "";
        }
        boolean z = false;
        boolean z2 = false;
        for (d.b.i0.s.f.a aVar2 : this.f59397b) {
            if (f2.equals(aVar2.f())) {
                z = true;
            }
            if (a2.equals(aVar2.a())) {
                z2 = true;
            }
        }
        if (z) {
            return;
        }
        if (!z2) {
            d.b.i0.s.f.a aVar3 = new d.b.i0.s.f.a();
            aVar3.k(a2);
            this.f59397b.add(aVar3);
        }
        this.f59397b.add(aVar);
        Collections.sort(this.f59397b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<d.b.i0.s.f.a> list = this.f59397b;
        if (list == null) {
            return;
        }
        String str = null;
        Iterator<d.b.i0.s.f.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.b.i0.s.f.a next = it.next();
            if (next.e() == j) {
                str = next.a();
                this.f59397b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (d.b.i0.s.f.a aVar : this.f59397b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f59397b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<d.b.i0.s.f.a> c() {
        return this.f59397b;
    }

    public final void e() {
        for (InterfaceC1457a interfaceC1457a : this.f59396a) {
            interfaceC1457a.g(this.f59397b);
        }
    }

    public void f(InterfaceC1457a interfaceC1457a) {
        if (interfaceC1457a == null || this.f59396a.contains(interfaceC1457a)) {
            return;
        }
        this.f59396a.add(interfaceC1457a);
    }

    public void g(List<d.b.i0.s.f.a> list) {
        this.f59397b = list;
        if (list != null) {
            Collections.sort(list, new ContactComparator());
        }
        e();
    }

    public void h(InterfaceC1457a interfaceC1457a) {
        if (interfaceC1457a != null) {
            this.f59396a.remove(interfaceC1457a);
        }
    }
}
