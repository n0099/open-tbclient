package d.o.a.e.b.l;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public b f67302a;

    /* renamed from: b  reason: collision with root package name */
    public b f67303b;

    /* renamed from: c  reason: collision with root package name */
    public int f67304c;

    /* renamed from: d  reason: collision with root package name */
    public int f67305d = 10;

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f67306a;

        /* renamed from: b  reason: collision with root package name */
        public long f67307b;

        /* renamed from: c  reason: collision with root package name */
        public b f67308c;

        /* renamed from: d  reason: collision with root package name */
        public b f67309d;

        public b() {
        }
    }

    public final b a() {
        b bVar;
        if (this.f67304c >= this.f67305d && (bVar = this.f67303b) != null) {
            b bVar2 = bVar.f67309d;
            bVar.f67309d = null;
            this.f67303b = bVar2;
            if (bVar2 != null) {
                bVar2.f67308c = null;
            }
            return bVar;
        }
        this.f67304c++;
        return new b();
    }

    public final b b(long j) {
        b bVar = this.f67302a;
        b bVar2 = null;
        while (bVar != null && bVar.f67307b > j) {
            bVar2 = bVar;
            bVar = bVar.f67308c;
        }
        return (bVar == null || bVar2 == null || bVar == bVar2 || j - bVar.f67307b >= bVar2.f67307b - j) ? bVar2 : bVar;
    }

    public boolean c(long j, long j2) {
        synchronized (this) {
            b bVar = this.f67302a;
            if (bVar != null) {
                if (j >= bVar.f67306a && j2 >= bVar.f67307b) {
                    b bVar2 = bVar.f67308c;
                    if (bVar2 != null && j2 - bVar2.f67307b < 1000) {
                        bVar.f67306a = j;
                        bVar.f67307b = j2;
                        return true;
                    }
                }
                return false;
            }
            b a2 = a();
            a2.f67306a = j;
            a2.f67307b = j2;
            if (bVar != null) {
                a2.f67308c = bVar;
                bVar.f67309d = a2;
            }
            this.f67302a = a2;
            return true;
        }
    }

    public long d(long j, long j2) {
        synchronized (this) {
            b bVar = this.f67302a;
            if (bVar == null) {
                return -1L;
            }
            b b2 = b(j);
            if (b2 == null) {
                return -1L;
            }
            long j3 = bVar.f67306a - b2.f67306a;
            long j4 = j2 - b2.f67307b;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }
}
