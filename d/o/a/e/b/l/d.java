package d.o.a.e.b.l;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public b f68099a;

    /* renamed from: b  reason: collision with root package name */
    public b f68100b;

    /* renamed from: c  reason: collision with root package name */
    public int f68101c;

    /* renamed from: d  reason: collision with root package name */
    public int f68102d = 10;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f68103a;

        /* renamed from: b  reason: collision with root package name */
        public long f68104b;

        /* renamed from: c  reason: collision with root package name */
        public b f68105c;

        /* renamed from: d  reason: collision with root package name */
        public b f68106d;

        public b() {
        }
    }

    public final b a() {
        b bVar;
        if (this.f68101c >= this.f68102d && (bVar = this.f68100b) != null) {
            b bVar2 = bVar.f68106d;
            bVar.f68106d = null;
            this.f68100b = bVar2;
            if (bVar2 != null) {
                bVar2.f68105c = null;
            }
            return bVar;
        }
        this.f68101c++;
        return new b();
    }

    public final b b(long j) {
        b bVar = this.f68099a;
        b bVar2 = null;
        while (bVar != null && bVar.f68104b > j) {
            bVar2 = bVar;
            bVar = bVar.f68105c;
        }
        return (bVar == null || bVar2 == null || bVar == bVar2 || j - bVar.f68104b >= bVar2.f68104b - j) ? bVar2 : bVar;
    }

    public boolean c(long j, long j2) {
        synchronized (this) {
            b bVar = this.f68099a;
            if (bVar != null) {
                if (j >= bVar.f68103a && j2 >= bVar.f68104b) {
                    b bVar2 = bVar.f68105c;
                    if (bVar2 != null && j2 - bVar2.f68104b < 1000) {
                        bVar.f68103a = j;
                        bVar.f68104b = j2;
                        return true;
                    }
                }
                return false;
            }
            b a2 = a();
            a2.f68103a = j;
            a2.f68104b = j2;
            if (bVar != null) {
                a2.f68105c = bVar;
                bVar.f68106d = a2;
            }
            this.f68099a = a2;
            return true;
        }
    }

    public long d(long j, long j2) {
        synchronized (this) {
            b bVar = this.f68099a;
            if (bVar == null) {
                return -1L;
            }
            b b2 = b(j);
            if (b2 == null) {
                return -1L;
            }
            long j3 = bVar.f68103a - b2.f68103a;
            long j4 = j2 - b2.f68104b;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }
}
