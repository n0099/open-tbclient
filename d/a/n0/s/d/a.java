package d.a.n0.s.d;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f60338c;

    /* renamed from: a  reason: collision with root package name */
    public List<InterfaceC1586a> f60339a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.m0.s.f.a> f60340b;

    /* renamed from: d.a.n0.s.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1586a {
        void e(List<d.a.m0.s.f.a> list);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f60338c == null) {
                f60338c = new a();
            }
            aVar = f60338c;
        }
        return aVar;
    }

    public void a(d.a.m0.s.f.a aVar) {
        if (this.f60340b == null || aVar == null) {
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
        for (d.a.m0.s.f.a aVar2 : this.f60340b) {
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
            d.a.m0.s.f.a aVar3 = new d.a.m0.s.f.a();
            aVar3.k(a2);
            this.f60340b.add(aVar3);
        }
        this.f60340b.add(aVar);
        Collections.sort(this.f60340b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<d.a.m0.s.f.a> list = this.f60340b;
        if (list == null) {
            return;
        }
        String str = null;
        Iterator<d.a.m0.s.f.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.m0.s.f.a next = it.next();
            if (next.e() == j) {
                str = next.a();
                this.f60340b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (d.a.m0.s.f.a aVar : this.f60340b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f60340b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<d.a.m0.s.f.a> c() {
        return this.f60340b;
    }

    public final void e() {
        for (InterfaceC1586a interfaceC1586a : this.f60339a) {
            interfaceC1586a.e(this.f60340b);
        }
    }

    public void f(InterfaceC1586a interfaceC1586a) {
        if (interfaceC1586a == null || this.f60339a.contains(interfaceC1586a)) {
            return;
        }
        this.f60339a.add(interfaceC1586a);
    }

    public void g(List<d.a.m0.s.f.a> list) {
        this.f60340b = list;
        if (list != null) {
            Collections.sort(list, new ContactComparator());
        }
        e();
    }

    public void h(InterfaceC1586a interfaceC1586a) {
        if (interfaceC1586a != null) {
            this.f60339a.remove(interfaceC1586a);
        }
    }
}
