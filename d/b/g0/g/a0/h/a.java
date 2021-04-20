package d.b.g0.g.a0.h;

import java.util.Comparator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f48256a;

    /* renamed from: b  reason: collision with root package name */
    public long f48257b;

    /* renamed from: d.b.g0.g.a0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0960a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.f48256a - aVar2.f48256a);
        }
    }

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.f48256a, aVar.f48257b};
    }

    public boolean b(a aVar) {
        long j = this.f48256a;
        if (j <= aVar.f48257b) {
            long j2 = this.f48257b;
            long j3 = aVar.f48256a;
            if (j2 < j3) {
                return false;
            }
            this.f48256a = Math.min(j, j3);
            this.f48257b = Math.max(this.f48257b, aVar.f48257b);
            return true;
        }
        return false;
    }
}
