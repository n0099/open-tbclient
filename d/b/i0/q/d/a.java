package d.b.i0.q.d;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f59220c;

    /* renamed from: a  reason: collision with root package name */
    public List<InterfaceC1473a> f59221a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.h0.s.f.a> f59222b;

    /* renamed from: d.b.i0.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1473a {
        void g(List<d.b.h0.s.f.a> list);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f59220c == null) {
                f59220c = new a();
            }
            aVar = f59220c;
        }
        return aVar;
    }

    public void a(d.b.h0.s.f.a aVar) {
        if (this.f59222b == null || aVar == null) {
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
        for (d.b.h0.s.f.a aVar2 : this.f59222b) {
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
            d.b.h0.s.f.a aVar3 = new d.b.h0.s.f.a();
            aVar3.k(a2);
            this.f59222b.add(aVar3);
        }
        this.f59222b.add(aVar);
        Collections.sort(this.f59222b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<d.b.h0.s.f.a> list = this.f59222b;
        if (list == null) {
            return;
        }
        String str = null;
        Iterator<d.b.h0.s.f.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.b.h0.s.f.a next = it.next();
            if (next.e() == j) {
                str = next.a();
                this.f59222b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (d.b.h0.s.f.a aVar : this.f59222b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f59222b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<d.b.h0.s.f.a> c() {
        return this.f59222b;
    }

    public final void e() {
        for (InterfaceC1473a interfaceC1473a : this.f59221a) {
            interfaceC1473a.g(this.f59222b);
        }
    }

    public void f(InterfaceC1473a interfaceC1473a) {
        if (interfaceC1473a == null || this.f59221a.contains(interfaceC1473a)) {
            return;
        }
        this.f59221a.add(interfaceC1473a);
    }

    public void g(List<d.b.h0.s.f.a> list) {
        this.f59222b = list;
        if (list != null) {
            Collections.sort(list, new ContactComparator());
        }
        e();
    }

    public void h(InterfaceC1473a interfaceC1473a) {
        if (interfaceC1473a != null) {
            this.f59221a.remove(interfaceC1473a);
        }
    }
}
