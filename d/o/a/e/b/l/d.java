package d.o.a.e.b.l;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public b f67106a;

    /* renamed from: b  reason: collision with root package name */
    public b f67107b;

    /* renamed from: c  reason: collision with root package name */
    public int f67108c;

    /* renamed from: d  reason: collision with root package name */
    public int f67109d = 10;

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f67110a;

        /* renamed from: b  reason: collision with root package name */
        public long f67111b;

        /* renamed from: c  reason: collision with root package name */
        public b f67112c;

        /* renamed from: d  reason: collision with root package name */
        public b f67113d;

        public b() {
        }
    }

    public final b a() {
        b bVar;
        if (this.f67108c >= this.f67109d && (bVar = this.f67107b) != null) {
            b bVar2 = bVar.f67113d;
            bVar.f67113d = null;
            this.f67107b = bVar2;
            if (bVar2 != null) {
                bVar2.f67112c = null;
            }
            return bVar;
        }
        this.f67108c++;
        return new b();
    }

    public final b b(long j) {
        b bVar = this.f67106a;
        b bVar2 = null;
        while (bVar != null && bVar.f67111b > j) {
            bVar2 = bVar;
            bVar = bVar.f67112c;
        }
        return (bVar == null || bVar2 == null || bVar == bVar2 || j - bVar.f67111b >= bVar2.f67111b - j) ? bVar2 : bVar;
    }

    public boolean c(long j, long j2) {
        synchronized (this) {
            b bVar = this.f67106a;
            if (bVar != null) {
                if (j >= bVar.f67110a && j2 >= bVar.f67111b) {
                    b bVar2 = bVar.f67112c;
                    if (bVar2 != null && j2 - bVar2.f67111b < 1000) {
                        bVar.f67110a = j;
                        bVar.f67111b = j2;
                        return true;
                    }
                }
                return false;
            }
            b a2 = a();
            a2.f67110a = j;
            a2.f67111b = j2;
            if (bVar != null) {
                a2.f67112c = bVar;
                bVar.f67113d = a2;
            }
            this.f67106a = a2;
            return true;
        }
    }

    public long d(long j, long j2) {
        synchronized (this) {
            b bVar = this.f67106a;
            if (bVar == null) {
                return -1L;
            }
            b b2 = b(j);
            if (b2 == null) {
                return -1L;
            }
            long j3 = bVar.f67110a - b2.f67110a;
            long j4 = j2 - b2.f67111b;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }
}
