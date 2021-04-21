package d.p.a.e.b.l;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public b f68246a;

    /* renamed from: b  reason: collision with root package name */
    public b f68247b;

    /* renamed from: c  reason: collision with root package name */
    public int f68248c;

    /* renamed from: d  reason: collision with root package name */
    public int f68249d = 10;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f68250a;

        /* renamed from: b  reason: collision with root package name */
        public long f68251b;

        /* renamed from: c  reason: collision with root package name */
        public b f68252c;

        /* renamed from: d  reason: collision with root package name */
        public b f68253d;

        public b() {
        }
    }

    public final b a() {
        b bVar;
        if (this.f68248c >= this.f68249d && (bVar = this.f68247b) != null) {
            b bVar2 = bVar.f68253d;
            bVar.f68253d = null;
            this.f68247b = bVar2;
            if (bVar2 != null) {
                bVar2.f68252c = null;
            }
            return bVar;
        }
        this.f68248c++;
        return new b();
    }

    public final b b(long j) {
        b bVar = this.f68246a;
        b bVar2 = null;
        while (bVar != null && bVar.f68251b > j) {
            bVar2 = bVar;
            bVar = bVar.f68252c;
        }
        return (bVar == null || bVar2 == null || bVar == bVar2 || j - bVar.f68251b >= bVar2.f68251b - j) ? bVar2 : bVar;
    }

    public boolean c(long j, long j2) {
        synchronized (this) {
            b bVar = this.f68246a;
            if (bVar != null) {
                if (j >= bVar.f68250a && j2 >= bVar.f68251b) {
                    b bVar2 = bVar.f68252c;
                    if (bVar2 != null && j2 - bVar2.f68251b < 1000) {
                        bVar.f68250a = j;
                        bVar.f68251b = j2;
                        return true;
                    }
                }
                return false;
            }
            b a2 = a();
            a2.f68250a = j;
            a2.f68251b = j2;
            if (bVar != null) {
                a2.f68252c = bVar;
                bVar.f68253d = a2;
            }
            this.f68246a = a2;
            return true;
        }
    }

    public long d(long j, long j2) {
        synchronized (this) {
            b bVar = this.f68246a;
            if (bVar == null) {
                return -1L;
            }
            b b2 = b(j);
            if (b2 == null) {
                return -1L;
            }
            long j3 = bVar.f68250a - b2.f68250a;
            long j4 = j2 - b2.f68251b;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }
}
