package d.a.o0.s.d;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f64152c;

    /* renamed from: a  reason: collision with root package name */
    public List<InterfaceC1646a> f64153a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.n0.s.f.a> f64154b;

    /* renamed from: d.a.o0.s.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1646a {
        void e(List<d.a.n0.s.f.a> list);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f64152c == null) {
                f64152c = new a();
            }
            aVar = f64152c;
        }
        return aVar;
    }

    public void a(d.a.n0.s.f.a aVar) {
        if (this.f64154b == null || aVar == null) {
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
        for (d.a.n0.s.f.a aVar2 : this.f64154b) {
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
            d.a.n0.s.f.a aVar3 = new d.a.n0.s.f.a();
            aVar3.k(a2);
            this.f64154b.add(aVar3);
        }
        this.f64154b.add(aVar);
        Collections.sort(this.f64154b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<d.a.n0.s.f.a> list = this.f64154b;
        if (list == null) {
            return;
        }
        String str = null;
        Iterator<d.a.n0.s.f.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.n0.s.f.a next = it.next();
            if (next.e() == j) {
                str = next.a();
                this.f64154b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (d.a.n0.s.f.a aVar : this.f64154b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f64154b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<d.a.n0.s.f.a> c() {
        return this.f64154b;
    }

    public final void e() {
        for (InterfaceC1646a interfaceC1646a : this.f64153a) {
            interfaceC1646a.e(this.f64154b);
        }
    }

    public void f(InterfaceC1646a interfaceC1646a) {
        if (interfaceC1646a == null || this.f64153a.contains(interfaceC1646a)) {
            return;
        }
        this.f64153a.add(interfaceC1646a);
    }

    public void g(List<d.a.n0.s.f.a> list) {
        this.f64154b = list;
        if (list != null) {
            Collections.sort(list, new ContactComparator());
        }
        e();
    }

    public void h(InterfaceC1646a interfaceC1646a) {
        if (interfaceC1646a != null) {
            this.f64153a.remove(interfaceC1646a);
        }
    }
}
