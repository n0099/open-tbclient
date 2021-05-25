package d.o.a.e.b.l;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public b f67345a;

    /* renamed from: b  reason: collision with root package name */
    public b f67346b;

    /* renamed from: c  reason: collision with root package name */
    public int f67347c;

    /* renamed from: d  reason: collision with root package name */
    public int f67348d = 10;

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f67349a;

        /* renamed from: b  reason: collision with root package name */
        public long f67350b;

        /* renamed from: c  reason: collision with root package name */
        public b f67351c;

        /* renamed from: d  reason: collision with root package name */
        public b f67352d;

        public b() {
        }
    }

    public final b a() {
        b bVar;
        if (this.f67347c >= this.f67348d && (bVar = this.f67346b) != null) {
            b bVar2 = bVar.f67352d;
            bVar.f67352d = null;
            this.f67346b = bVar2;
            if (bVar2 != null) {
                bVar2.f67351c = null;
            }
            return bVar;
        }
        this.f67347c++;
        return new b();
    }

    public final b b(long j) {
        b bVar = this.f67345a;
        b bVar2 = null;
        while (bVar != null && bVar.f67350b > j) {
            bVar2 = bVar;
            bVar = bVar.f67351c;
        }
        return (bVar == null || bVar2 == null || bVar == bVar2 || j - bVar.f67350b >= bVar2.f67350b - j) ? bVar2 : bVar;
    }

    public boolean c(long j, long j2) {
        synchronized (this) {
            b bVar = this.f67345a;
            if (bVar != null) {
                if (j >= bVar.f67349a && j2 >= bVar.f67350b) {
                    b bVar2 = bVar.f67351c;
                    if (bVar2 != null && j2 - bVar2.f67350b < 1000) {
                        bVar.f67349a = j;
                        bVar.f67350b = j2;
                        return true;
                    }
                }
                return false;
            }
            b a2 = a();
            a2.f67349a = j;
            a2.f67350b = j2;
            if (bVar != null) {
                a2.f67351c = bVar;
                bVar.f67352d = a2;
            }
            this.f67345a = a2;
            return true;
        }
    }

    public long d(long j, long j2) {
        synchronized (this) {
            b bVar = this.f67345a;
            if (bVar == null) {
                return -1L;
            }
            b b2 = b(j);
            if (b2 == null) {
                return -1L;
            }
            long j3 = bVar.f67349a - b2.f67349a;
            long j4 = j2 - b2.f67350b;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }
}
