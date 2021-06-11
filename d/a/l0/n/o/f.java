package d.a.l0.n.o;

import com.baidu.swan.pms.model.PMSPkgStatus;
import d.a.l0.n.h.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Set<a> f51860a = Collections.synchronizedSet(new HashSet());

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public d.a.l0.n.h.e f51861a;

        /* renamed from: b  reason: collision with root package name */
        public PMSPkgStatus f51862b;

        public a(d.a.l0.n.h.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.f51861a = eVar;
            this.f51862b = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj != null && (obj instanceof a)) {
                return this.f51861a.equals(((a) obj).f51861a);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f51861a);
        }
    }

    public void a(d.a.l0.n.h.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.f51860a.add(new a(eVar, pMSPkgStatus));
    }

    public boolean b() {
        for (a aVar : this.f51860a) {
            if (aVar != null && (aVar.f51861a instanceof d.a.l0.n.h.b)) {
                return true;
            }
        }
        return false;
    }

    public boolean c() {
        for (a aVar : this.f51860a) {
            if (aVar != null && (aVar.f51861a instanceof d.a.l0.n.h.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        for (a aVar : this.f51860a) {
            if (aVar != null && (aVar.f51861a instanceof d.a.l0.n.h.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean e() {
        for (a aVar : this.f51860a) {
            if (aVar != null && (aVar.f51861a instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        for (a aVar : this.f51860a) {
            if (aVar != null && (aVar.f51861a instanceof d.a.l0.n.h.g)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean g() {
        for (a aVar : this.f51860a) {
            if (aVar != null && (aVar.f51861a instanceof d.a.l0.n.h.g) && aVar.f51862b == PMSPkgStatus.WAIT) {
                return true;
            }
        }
        return false;
    }

    public synchronized Set<d.a.l0.n.h.e> h() {
        HashSet hashSet;
        a[] aVarArr;
        hashSet = new HashSet();
        for (a aVar : (a[]) this.f51860a.toArray(new a[0])) {
            if (aVar != null && aVar.f51861a != null) {
                hashSet.add(aVar.f51861a);
            }
        }
        return hashSet;
    }

    public boolean i() {
        return this.f51860a.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        r1.f51862b = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void j(d.a.l0.n.h.e eVar) {
        if (eVar == null) {
            return;
        }
        Iterator<a> it = this.f51860a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.f51861a.equals(eVar)) {
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        r1.f51862b = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(d.a.l0.n.h.e eVar) {
        if (eVar == null) {
            return;
        }
        Iterator<a> it = this.f51860a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.f51861a.equals(eVar)) {
                break;
            }
        }
    }

    public int l() {
        return this.f51860a.size();
    }
}
