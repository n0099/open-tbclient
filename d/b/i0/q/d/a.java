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
    public static a f59221c;

    /* renamed from: a  reason: collision with root package name */
    public List<InterfaceC1474a> f59222a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.h0.s.f.a> f59223b;

    /* renamed from: d.b.i0.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1474a {
        void g(List<d.b.h0.s.f.a> list);
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (f59221c == null) {
                f59221c = new a();
            }
            aVar = f59221c;
        }
        return aVar;
    }

    public void a(d.b.h0.s.f.a aVar) {
        if (this.f59223b == null || aVar == null) {
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
        for (d.b.h0.s.f.a aVar2 : this.f59223b) {
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
            this.f59223b.add(aVar3);
        }
        this.f59223b.add(aVar);
        Collections.sort(this.f59223b, new ContactComparator());
        e();
    }

    public void b(long j) {
        List<d.b.h0.s.f.a> list = this.f59223b;
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
                this.f59223b.remove(next);
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (d.b.h0.s.f.a aVar : this.f59223b) {
                if (str.equals(aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 1) {
                this.f59223b.removeAll(arrayList);
            }
        }
        e();
    }

    public List<d.b.h0.s.f.a> c() {
        return this.f59223b;
    }

    public final void e() {
        for (InterfaceC1474a interfaceC1474a : this.f59222a) {
            interfaceC1474a.g(this.f59223b);
        }
    }

    public void f(InterfaceC1474a interfaceC1474a) {
        if (interfaceC1474a == null || this.f59222a.contains(interfaceC1474a)) {
            return;
        }
        this.f59222a.add(interfaceC1474a);
    }

    public void g(List<d.b.h0.s.f.a> list) {
        this.f59223b = list;
        if (list != null) {
            Collections.sort(list, new ContactComparator());
        }
        e();
    }

    public void h(InterfaceC1474a interfaceC1474a) {
        if (interfaceC1474a != null) {
            this.f59222a.remove(interfaceC1474a);
        }
    }
}
