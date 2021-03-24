package d.o.a.e.b.l;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public b f67101a;

    /* renamed from: b  reason: collision with root package name */
    public b f67102b;

    /* renamed from: c  reason: collision with root package name */
    public int f67103c;

    /* renamed from: d  reason: collision with root package name */
    public int f67104d = 10;

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f67105a;

        /* renamed from: b  reason: collision with root package name */
        public long f67106b;

        /* renamed from: c  reason: collision with root package name */
        public b f67107c;

        /* renamed from: d  reason: collision with root package name */
        public b f67108d;

        public b() {
        }
    }

    public final b a() {
        b bVar;
        if (this.f67103c >= this.f67104d && (bVar = this.f67102b) != null) {
            b bVar2 = bVar.f67108d;
            bVar.f67108d = null;
            this.f67102b = bVar2;
            if (bVar2 != null) {
                bVar2.f67107c = null;
            }
            return bVar;
        }
        this.f67103c++;
        return new b();
    }

    public final b b(long j) {
        b bVar = this.f67101a;
        b bVar2 = null;
        while (bVar != null && bVar.f67106b > j) {
            bVar2 = bVar;
            bVar = bVar.f67107c;
        }
        return (bVar == null || bVar2 == null || bVar == bVar2 || j - bVar.f67106b >= bVar2.f67106b - j) ? bVar2 : bVar;
    }

    public boolean c(long j, long j2) {
        synchronized (this) {
            b bVar = this.f67101a;
            if (bVar != null) {
                if (j >= bVar.f67105a && j2 >= bVar.f67106b) {
                    b bVar2 = bVar.f67107c;
                    if (bVar2 != null && j2 - bVar2.f67106b < 1000) {
                        bVar.f67105a = j;
                        bVar.f67106b = j2;
                        return true;
                    }
                }
                return false;
            }
            b a2 = a();
            a2.f67105a = j;
            a2.f67106b = j2;
            if (bVar != null) {
                a2.f67107c = bVar;
                bVar.f67108d = a2;
            }
            this.f67101a = a2;
            return true;
        }
    }

    public long d(long j, long j2) {
        synchronized (this) {
            b bVar = this.f67101a;
            if (bVar == null) {
                return -1L;
            }
            b b2 = b(j);
            if (b2 == null) {
                return -1L;
            }
            long j3 = bVar.f67105a - b2.f67105a;
            long j4 = j2 - b2.f67106b;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }
}
