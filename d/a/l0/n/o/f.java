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
    public Set<a> f48186a = Collections.synchronizedSet(new HashSet());

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public d.a.l0.n.h.e f48187a;

        /* renamed from: b  reason: collision with root package name */
        public PMSPkgStatus f48188b;

        public a(d.a.l0.n.h.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.f48187a = eVar;
            this.f48188b = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj != null && (obj instanceof a)) {
                return this.f48187a.equals(((a) obj).f48187a);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f48187a);
        }
    }

    public void a(d.a.l0.n.h.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.f48186a.add(new a(eVar, pMSPkgStatus));
    }

    public boolean b() {
        for (a aVar : this.f48186a) {
            if (aVar != null && (aVar.f48187a instanceof d.a.l0.n.h.b)) {
                return true;
            }
        }
        return false;
    }

    public boolean c() {
        for (a aVar : this.f48186a) {
            if (aVar != null && (aVar.f48187a instanceof d.a.l0.n.h.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        for (a aVar : this.f48186a) {
            if (aVar != null && (aVar.f48187a instanceof d.a.l0.n.h.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean e() {
        for (a aVar : this.f48186a) {
            if (aVar != null && (aVar.f48187a instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        for (a aVar : this.f48186a) {
            if (aVar != null && (aVar.f48187a instanceof d.a.l0.n.h.g)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean g() {
        for (a aVar : this.f48186a) {
            if (aVar != null && (aVar.f48187a instanceof d.a.l0.n.h.g) && aVar.f48188b == PMSPkgStatus.WAIT) {
                return true;
            }
        }
        return false;
    }

    public synchronized Set<d.a.l0.n.h.e> h() {
        HashSet hashSet;
        a[] aVarArr;
        hashSet = new HashSet();
        for (a aVar : (a[]) this.f48186a.toArray(new a[0])) {
            if (aVar != null && aVar.f48187a != null) {
                hashSet.add(aVar.f48187a);
            }
        }
        return hashSet;
    }

    public boolean i() {
        return this.f48186a.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        r1.f48188b = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void j(d.a.l0.n.h.e eVar) {
        if (eVar == null) {
            return;
        }
        Iterator<a> it = this.f48186a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.f48187a.equals(eVar)) {
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        r1.f48188b = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(d.a.l0.n.h.e eVar) {
        if (eVar == null) {
            return;
        }
        Iterator<a> it = this.f48186a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.f48187a.equals(eVar)) {
                break;
            }
        }
    }

    public int l() {
        return this.f48186a.size();
    }
}
