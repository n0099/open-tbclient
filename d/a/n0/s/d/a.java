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
    public static a f64027c;

    /* renamed from: a  reason: collision with root package name */
    public List<InterfaceC1642a> f64028a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.m0.s.f.a> f64029b;

    /* renamed from: d.a.n0.s.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1642a {
        void e(List<d.a.m0.s.f.a> list);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f64027c == null) {
                f64027c = new a();
            }
            aVar = f64027c;
        }
        return aVar;
    }

    public void a(d.a.m0.s.f.a aVar) {
        if (this.f64029b == null || aVar == null) {
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
        for (d.a.m0.s.f.a aVar2 : this.f64029b) {
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
            this.f64029b.add(aVar3);
        }
        this.f64029b.add(aVar);
        Collections.sort(this.f64029b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<d.a.m0.s.f.a> list = this.f64029b;
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
                this.f64029b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (d.a.m0.s.f.a aVar : this.f64029b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f64029b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<d.a.m0.s.f.a> c() {
        return this.f64029b;
    }

    public final void e() {
        for (InterfaceC1642a interfaceC1642a : this.f64028a) {
            interfaceC1642a.e(this.f64029b);
        }
    }

    public void f(InterfaceC1642a interfaceC1642a) {
        if (interfaceC1642a == null || this.f64028a.contains(interfaceC1642a)) {
            return;
        }
        this.f64028a.add(interfaceC1642a);
    }

    public void g(List<d.a.m0.s.f.a> list) {
        this.f64029b = list;
        if (list != null) {
            Collections.sort(list, new ContactComparator());
        }
        e();
    }

    public void h(InterfaceC1642a interfaceC1642a) {
        if (interfaceC1642a != null) {
            this.f64028a.remove(interfaceC1642a);
        }
    }
}
