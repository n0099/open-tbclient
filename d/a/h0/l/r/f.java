package d.a.h0.l.r;

import com.baidu.swan.pms.model.PMSPkgStatus;
import d.a.h0.l.k.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Set<a> f47295a = Collections.synchronizedSet(new HashSet());

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public d.a.h0.l.k.e f47296a;

        /* renamed from: b  reason: collision with root package name */
        public PMSPkgStatus f47297b;

        public a(d.a.h0.l.k.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.f47296a = eVar;
            this.f47297b = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj != null && (obj instanceof a)) {
                return this.f47296a.equals(((a) obj).f47296a);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f47296a);
        }
    }

    public void a(d.a.h0.l.k.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.f47295a.add(new a(eVar, pMSPkgStatus));
    }

    public boolean b() {
        for (a aVar : this.f47295a) {
            if (aVar != null && (aVar.f47296a instanceof d.a.h0.l.k.b)) {
                return true;
            }
        }
        return false;
    }

    public boolean c() {
        for (a aVar : this.f47295a) {
            if (aVar != null && (aVar.f47296a instanceof d.a.h0.l.k.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        for (a aVar : this.f47295a) {
            if (aVar != null && (aVar.f47296a instanceof d.a.h0.l.k.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean e() {
        for (a aVar : this.f47295a) {
            if (aVar != null && (aVar.f47296a instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        for (a aVar : this.f47295a) {
            if (aVar != null && (aVar.f47296a instanceof d.a.h0.l.k.g)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean g() {
        for (a aVar : this.f47295a) {
            if (aVar != null && (aVar.f47296a instanceof d.a.h0.l.k.g) && aVar.f47297b == PMSPkgStatus.WAIT) {
                return true;
            }
        }
        return false;
    }

    public boolean h() {
        return this.f47295a.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r1.f47297b = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void i(d.a.h0.l.k.e eVar) {
        if (eVar == null) {
            return;
        }
        Iterator<a> it = this.f47295a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.f47296a.equals(eVar)) {
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r1.f47297b = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void j(d.a.h0.l.k.e eVar) {
        if (eVar == null) {
            return;
        }
        Iterator<a> it = this.f47295a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.f47296a.equals(eVar)) {
                break;
            }
        }
    }

    public int k() {
        return this.f47295a.size();
    }
}
