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
    public static a f58974c;

    /* renamed from: a  reason: collision with root package name */
    public List<InterfaceC1434a> f58975a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.h0.s.f.a> f58976b;

    /* renamed from: d.b.i0.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1434a {
        void g(List<d.b.h0.s.f.a> list);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f58974c == null) {
                f58974c = new a();
            }
            aVar = f58974c;
        }
        return aVar;
    }

    public void a(d.b.h0.s.f.a aVar) {
        if (this.f58976b == null || aVar == null) {
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
        for (d.b.h0.s.f.a aVar2 : this.f58976b) {
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
            this.f58976b.add(aVar3);
        }
        this.f58976b.add(aVar);
        Collections.sort(this.f58976b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<d.b.h0.s.f.a> list = this.f58976b;
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
                this.f58976b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (d.b.h0.s.f.a aVar : this.f58976b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f58976b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<d.b.h0.s.f.a> c() {
        return this.f58976b;
    }

    public final void e() {
        for (InterfaceC1434a interfaceC1434a : this.f58975a) {
            interfaceC1434a.g(this.f58976b);
        }
    }

    public void f(InterfaceC1434a interfaceC1434a) {
        if (interfaceC1434a == null || this.f58975a.contains(interfaceC1434a)) {
            return;
        }
        this.f58975a.add(interfaceC1434a);
    }

    public void g(List<d.b.h0.s.f.a> list) {
        this.f58976b = list;
        if (list != null) {
            Collections.sort(list, new ContactComparator());
        }
        e();
    }

    public void h(InterfaceC1434a interfaceC1434a) {
        if (interfaceC1434a != null) {
            this.f58975a.remove(interfaceC1434a);
        }
    }
}
