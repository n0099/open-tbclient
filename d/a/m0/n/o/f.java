package d.a.m0.n.o;

import com.baidu.swan.pms.model.PMSPkgStatus;
import d.a.m0.n.h.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Set<a> f51968a = Collections.synchronizedSet(new HashSet());

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public d.a.m0.n.h.e f51969a;

        /* renamed from: b  reason: collision with root package name */
        public PMSPkgStatus f51970b;

        public a(d.a.m0.n.h.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.f51969a = eVar;
            this.f51970b = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj != null && (obj instanceof a)) {
                return this.f51969a.equals(((a) obj).f51969a);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f51969a);
        }
    }

    public void a(d.a.m0.n.h.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.f51968a.add(new a(eVar, pMSPkgStatus));
    }

    public boolean b() {
        for (a aVar : this.f51968a) {
            if (aVar != null && (aVar.f51969a instanceof d.a.m0.n.h.b)) {
                return true;
            }
        }
        return false;
    }

    public boolean c() {
        for (a aVar : this.f51968a) {
            if (aVar != null && (aVar.f51969a instanceof d.a.m0.n.h.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        for (a aVar : this.f51968a) {
            if (aVar != null && (aVar.f51969a instanceof d.a.m0.n.h.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean e() {
        for (a aVar : this.f51968a) {
            if (aVar != null && (aVar.f51969a instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        for (a aVar : this.f51968a) {
            if (aVar != null && (aVar.f51969a instanceof d.a.m0.n.h.g)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean g() {
        for (a aVar : this.f51968a) {
            if (aVar != null && (aVar.f51969a instanceof d.a.m0.n.h.g) && aVar.f51970b == PMSPkgStatus.WAIT) {
                return true;
            }
        }
        return false;
    }

    public synchronized Set<d.a.m0.n.h.e> h() {
        HashSet hashSet;
        a[] aVarArr;
        hashSet = new HashSet();
        for (a aVar : (a[]) this.f51968a.toArray(new a[0])) {
            if (aVar != null && aVar.f51969a != null) {
                hashSet.add(aVar.f51969a);
            }
        }
        return hashSet;
    }

    public boolean i() {
        return this.f51968a.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        r1.f51970b = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void j(d.a.m0.n.h.e eVar) {
        if (eVar == null) {
            return;
        }
        Iterator<a> it = this.f51968a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.f51969a.equals(eVar)) {
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        r1.f51970b = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(d.a.m0.n.h.e eVar) {
        if (eVar == null) {
            return;
        }
        Iterator<a> it = this.f51968a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.f51969a.equals(eVar)) {
                break;
            }
        }
    }

    public int l() {
        return this.f51968a.size();
    }
}
