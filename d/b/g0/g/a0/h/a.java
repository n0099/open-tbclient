package d.b.g0.g.a0.h;

import java.util.Comparator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f47864a;

    /* renamed from: b  reason: collision with root package name */
    public long f47865b;

    /* renamed from: d.b.g0.g.a0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0948a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.f47864a - aVar2.f47864a);
        }
    }

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.f47864a, aVar.f47865b};
    }

    public boolean b(a aVar) {
        long j = this.f47864a;
        if (j <= aVar.f47865b) {
            long j2 = this.f47865b;
            long j3 = aVar.f47864a;
            if (j2 < j3) {
                return false;
            }
            this.f47864a = Math.min(j, j3);
            this.f47865b = Math.max(this.f47865b, aVar.f47865b);
            return true;
        }
        return false;
    }
}
