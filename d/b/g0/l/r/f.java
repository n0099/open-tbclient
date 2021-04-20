package d.b.g0.l.r;

import com.baidu.swan.pms.model.PMSPkgStatus;
import d.b.g0.l.k.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Set<a> f49452a = Collections.synchronizedSet(new HashSet());

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public d.b.g0.l.k.e f49453a;

        /* renamed from: b  reason: collision with root package name */
        public PMSPkgStatus f49454b;

        public a(d.b.g0.l.k.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.f49453a = eVar;
            this.f49454b = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj != null && (obj instanceof a)) {
                return this.f49453a.equals(((a) obj).f49453a);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f49453a);
        }
    }

    public void a(d.b.g0.l.k.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.f49452a.add(new a(eVar, pMSPkgStatus));
    }

    public boolean b() {
        for (a aVar : this.f49452a) {
            if (aVar != null && (aVar.f49453a instanceof d.b.g0.l.k.b)) {
                return true;
            }
        }
        return false;
    }

    public boolean c() {
        for (a aVar : this.f49452a) {
            if (aVar != null && (aVar.f49453a instanceof d.b.g0.l.k.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        for (a aVar : this.f49452a) {
            if (aVar != null && (aVar.f49453a instanceof d.b.g0.l.k.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean e() {
        for (a aVar : this.f49452a) {
            if (aVar != null && (aVar.f49453a instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        for (a aVar : this.f49452a) {
            if (aVar != null && (aVar.f49453a instanceof d.b.g0.l.k.g)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean g() {
        for (a aVar : this.f49452a) {
            if (aVar != null && (aVar.f49453a instanceof d.b.g0.l.k.g) && aVar.f49454b == PMSPkgStatus.WAIT) {
                return true;
            }
        }
        return false;
    }

    public boolean h() {
        return this.f49452a.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r1.f49454b = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void i(d.b.g0.l.k.e eVar) {
        if (eVar == null) {
            return;
        }
        Iterator<a> it = this.f49452a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.f49453a.equals(eVar)) {
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r1.f49454b = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void j(d.b.g0.l.k.e eVar) {
        if (eVar == null) {
            return;
        }
        Iterator<a> it = this.f49452a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next != null && next.f49453a.equals(eVar)) {
                break;
            }
        }
    }

    public int k() {
        return this.f49452a.size();
    }
}
