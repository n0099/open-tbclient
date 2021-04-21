package d.b.h0.g.a0.h;

import java.util.Comparator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f48585a;

    /* renamed from: b  reason: collision with root package name */
    public long f48586b;

    /* renamed from: d.b.h0.g.a0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0980a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.f48585a - aVar2.f48585a);
        }
    }

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.f48585a, aVar.f48586b};
    }

    public boolean b(a aVar) {
        long j = this.f48585a;
        if (j <= aVar.f48586b) {
            long j2 = this.f48586b;
            long j3 = aVar.f48585a;
            if (j2 < j3) {
                return false;
            }
            this.f48585a = Math.min(j, j3);
            this.f48586b = Math.max(this.f48586b, aVar.f48586b);
            return true;
        }
        return false;
    }
}
