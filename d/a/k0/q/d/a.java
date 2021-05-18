package d.a.k0.q.d;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f58175c;

    /* renamed from: a  reason: collision with root package name */
    public List<InterfaceC1470a> f58176a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.j0.s.f.a> f58177b;

    /* renamed from: d.a.k0.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1470a {
        void e(List<d.a.j0.s.f.a> list);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f58175c == null) {
                f58175c = new a();
            }
            aVar = f58175c;
        }
        return aVar;
    }

    public void a(d.a.j0.s.f.a aVar) {
        if (this.f58177b == null || aVar == null) {
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
        for (d.a.j0.s.f.a aVar2 : this.f58177b) {
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
            d.a.j0.s.f.a aVar3 = new d.a.j0.s.f.a();
            aVar3.k(a2);
            this.f58177b.add(aVar3);
        }
        this.f58177b.add(aVar);
        Collections.sort(this.f58177b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<d.a.j0.s.f.a> list = this.f58177b;
        if (list == null) {
            return;
        }
        String str = null;
        Iterator<d.a.j0.s.f.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.j0.s.f.a next = it.next();
            if (next.e() == j) {
                str = next.a();
                this.f58177b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (d.a.j0.s.f.a aVar : this.f58177b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f58177b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<d.a.j0.s.f.a> c() {
        return this.f58177b;
    }

    public final void e() {
        for (InterfaceC1470a interfaceC1470a : this.f58176a) {
            interfaceC1470a.e(this.f58177b);
        }
    }

    public void f(InterfaceC1470a interfaceC1470a) {
        if (interfaceC1470a == null || this.f58176a.contains(interfaceC1470a)) {
            return;
        }
        this.f58176a.add(interfaceC1470a);
    }

    public void g(List<d.a.j0.s.f.a> list) {
        this.f58177b = list;
        if (list != null) {
            Collections.sort(list, new ContactComparator());
        }
        e();
    }

    public void h(InterfaceC1470a interfaceC1470a) {
        if (interfaceC1470a != null) {
            this.f58176a.remove(interfaceC1470a);
        }
    }
}
