package d.a.j0.q.d;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f57433c;

    /* renamed from: a  reason: collision with root package name */
    public List<InterfaceC1396a> f57434a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.i0.s.f.a> f57435b;

    /* renamed from: d.a.j0.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1396a {
        void e(List<d.a.i0.s.f.a> list);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f57433c == null) {
                f57433c = new a();
            }
            aVar = f57433c;
        }
        return aVar;
    }

    public void a(d.a.i0.s.f.a aVar) {
        if (this.f57435b == null || aVar == null) {
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
        for (d.a.i0.s.f.a aVar2 : this.f57435b) {
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
            d.a.i0.s.f.a aVar3 = new d.a.i0.s.f.a();
            aVar3.k(a2);
            this.f57435b.add(aVar3);
        }
        this.f57435b.add(aVar);
        Collections.sort(this.f57435b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<d.a.i0.s.f.a> list = this.f57435b;
        if (list == null) {
            return;
        }
        String str = null;
        Iterator<d.a.i0.s.f.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.i0.s.f.a next = it.next();
            if (next.e() == j) {
                str = next.a();
                this.f57435b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (d.a.i0.s.f.a aVar : this.f57435b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f57435b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<d.a.i0.s.f.a> c() {
        return this.f57435b;
    }

    public final void e() {
        for (InterfaceC1396a interfaceC1396a : this.f57434a) {
            interfaceC1396a.e(this.f57435b);
        }
    }

    public void f(InterfaceC1396a interfaceC1396a) {
        if (interfaceC1396a == null || this.f57434a.contains(interfaceC1396a)) {
            return;
        }
        this.f57434a.add(interfaceC1396a);
    }

    public void g(List<d.a.i0.s.f.a> list) {
        this.f57435b = list;
        if (list != null) {
            Collections.sort(list, new ContactComparator());
        }
        e();
    }

    public void h(InterfaceC1396a interfaceC1396a) {
        if (interfaceC1396a != null) {
            this.f57434a.remove(interfaceC1396a);
        }
    }
}
