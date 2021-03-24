package d.b.g0.g.a0.h;

import java.util.Comparator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f47863a;

    /* renamed from: b  reason: collision with root package name */
    public long f47864b;

    /* renamed from: d.b.g0.g.a0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0947a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.f47863a - aVar2.f47863a);
        }
    }

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.f47863a, aVar.f47864b};
    }

    public boolean b(a aVar) {
        long j = this.f47863a;
        if (j <= aVar.f47864b) {
            long j2 = this.f47864b;
            long j3 = aVar.f47863a;
            if (j2 < j3) {
                return false;
            }
            this.f47863a = Math.min(j, j3);
            this.f47864b = Math.max(this.f47864b, aVar.f47864b);
            return true;
        }
        return false;
    }
}
