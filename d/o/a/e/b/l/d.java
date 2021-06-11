package d.o.a.e.b.l;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public b f71131a;

    /* renamed from: b  reason: collision with root package name */
    public b f71132b;

    /* renamed from: c  reason: collision with root package name */
    public int f71133c;

    /* renamed from: d  reason: collision with root package name */
    public int f71134d = 10;

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f71135a;

        /* renamed from: b  reason: collision with root package name */
        public long f71136b;

        /* renamed from: c  reason: collision with root package name */
        public b f71137c;

        /* renamed from: d  reason: collision with root package name */
        public b f71138d;

        public b() {
        }
    }

    public final b a() {
        b bVar;
        if (this.f71133c >= this.f71134d && (bVar = this.f71132b) != null) {
            b bVar2 = bVar.f71138d;
            bVar.f71138d = null;
            this.f71132b = bVar2;
            if (bVar2 != null) {
                bVar2.f71137c = null;
            }
            return bVar;
        }
        this.f71133c++;
        return new b();
    }

    public final b b(long j) {
        b bVar = this.f71131a;
        b bVar2 = null;
        while (bVar != null && bVar.f71136b > j) {
            bVar2 = bVar;
            bVar = bVar.f71137c;
        }
        return (bVar == null || bVar2 == null || bVar == bVar2 || j - bVar.f71136b >= bVar2.f71136b - j) ? bVar2 : bVar;
    }

    public boolean c(long j, long j2) {
        synchronized (this) {
            b bVar = this.f71131a;
            if (bVar != null) {
                if (j >= bVar.f71135a && j2 >= bVar.f71136b) {
                    b bVar2 = bVar.f71137c;
                    if (bVar2 != null && j2 - bVar2.f71136b < 1000) {
                        bVar.f71135a = j;
                        bVar.f71136b = j2;
                        return true;
                    }
                }
                return false;
            }
            b a2 = a();
            a2.f71135a = j;
            a2.f71136b = j2;
            if (bVar != null) {
                a2.f71137c = bVar;
                bVar.f71138d = a2;
            }
            this.f71131a = a2;
            return true;
        }
    }

    public long d(long j, long j2) {
        synchronized (this) {
            b bVar = this.f71131a;
            if (bVar == null) {
                return -1L;
            }
            b b2 = b(j);
            if (b2 == null) {
                return -1L;
            }
            long j3 = bVar.f71135a - b2.f71135a;
            long j4 = j2 - b2.f71136b;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }
}
