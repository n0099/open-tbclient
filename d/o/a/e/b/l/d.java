package d.o.a.e.b.l;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public b f71235a;

    /* renamed from: b  reason: collision with root package name */
    public b f71236b;

    /* renamed from: c  reason: collision with root package name */
    public int f71237c;

    /* renamed from: d  reason: collision with root package name */
    public int f71238d = 10;

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f71239a;

        /* renamed from: b  reason: collision with root package name */
        public long f71240b;

        /* renamed from: c  reason: collision with root package name */
        public b f71241c;

        /* renamed from: d  reason: collision with root package name */
        public b f71242d;

        public b() {
        }
    }

    public final b a() {
        b bVar;
        if (this.f71237c >= this.f71238d && (bVar = this.f71236b) != null) {
            b bVar2 = bVar.f71242d;
            bVar.f71242d = null;
            this.f71236b = bVar2;
            if (bVar2 != null) {
                bVar2.f71241c = null;
            }
            return bVar;
        }
        this.f71237c++;
        return new b();
    }

    public final b b(long j) {
        b bVar = this.f71235a;
        b bVar2 = null;
        while (bVar != null && bVar.f71240b > j) {
            bVar2 = bVar;
            bVar = bVar.f71241c;
        }
        return (bVar == null || bVar2 == null || bVar == bVar2 || j - bVar.f71240b >= bVar2.f71240b - j) ? bVar2 : bVar;
    }

    public boolean c(long j, long j2) {
        synchronized (this) {
            b bVar = this.f71235a;
            if (bVar != null) {
                if (j >= bVar.f71239a && j2 >= bVar.f71240b) {
                    b bVar2 = bVar.f71241c;
                    if (bVar2 != null && j2 - bVar2.f71240b < 1000) {
                        bVar.f71239a = j;
                        bVar.f71240b = j2;
                        return true;
                    }
                }
                return false;
            }
            b a2 = a();
            a2.f71239a = j;
            a2.f71240b = j2;
            if (bVar != null) {
                a2.f71241c = bVar;
                bVar.f71242d = a2;
            }
            this.f71235a = a2;
            return true;
        }
    }

    public long d(long j, long j2) {
        synchronized (this) {
            b bVar = this.f71235a;
            if (bVar == null) {
                return -1L;
            }
            b b2 = b(j);
            if (b2 == null) {
                return -1L;
            }
            long j3 = bVar.f71239a - b2.f71239a;
            long j4 = j2 - b2.f71240b;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }
}
