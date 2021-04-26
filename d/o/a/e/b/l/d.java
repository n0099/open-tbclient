package d.o.a.e.b.l;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public b f66616a;

    /* renamed from: b  reason: collision with root package name */
    public b f66617b;

    /* renamed from: c  reason: collision with root package name */
    public int f66618c;

    /* renamed from: d  reason: collision with root package name */
    public int f66619d = 10;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f66620a;

        /* renamed from: b  reason: collision with root package name */
        public long f66621b;

        /* renamed from: c  reason: collision with root package name */
        public b f66622c;

        /* renamed from: d  reason: collision with root package name */
        public b f66623d;

        public b() {
        }
    }

    public final b a() {
        b bVar;
        if (this.f66618c >= this.f66619d && (bVar = this.f66617b) != null) {
            b bVar2 = bVar.f66623d;
            bVar.f66623d = null;
            this.f66617b = bVar2;
            if (bVar2 != null) {
                bVar2.f66622c = null;
            }
            return bVar;
        }
        this.f66618c++;
        return new b();
    }

    public final b b(long j) {
        b bVar = this.f66616a;
        b bVar2 = null;
        while (bVar != null && bVar.f66621b > j) {
            bVar2 = bVar;
            bVar = bVar.f66622c;
        }
        return (bVar == null || bVar2 == null || bVar == bVar2 || j - bVar.f66621b >= bVar2.f66621b - j) ? bVar2 : bVar;
    }

    public boolean c(long j, long j2) {
        synchronized (this) {
            b bVar = this.f66616a;
            if (bVar != null) {
                if (j >= bVar.f66620a && j2 >= bVar.f66621b) {
                    b bVar2 = bVar.f66622c;
                    if (bVar2 != null && j2 - bVar2.f66621b < 1000) {
                        bVar.f66620a = j;
                        bVar.f66621b = j2;
                        return true;
                    }
                }
                return false;
            }
            b a2 = a();
            a2.f66620a = j;
            a2.f66621b = j2;
            if (bVar != null) {
                a2.f66622c = bVar;
                bVar.f66623d = a2;
            }
            this.f66616a = a2;
            return true;
        }
    }

    public long d(long j, long j2) {
        synchronized (this) {
            b bVar = this.f66616a;
            if (bVar == null) {
                return -1L;
            }
            b b2 = b(j);
            if (b2 == null) {
                return -1L;
            }
            long j3 = bVar.f66620a - b2.f66620a;
            long j4 = j2 - b2.f66621b;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }
}
