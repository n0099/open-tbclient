package d.a.h0.g.a0.h;

import java.util.Comparator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f46047a;

    /* renamed from: b  reason: collision with root package name */
    public long f46048b;

    /* renamed from: d.a.h0.g.a0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0919a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.f46047a - aVar2.f46047a);
        }
    }

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.f46047a, aVar.f46048b};
    }

    public boolean b(a aVar) {
        long j = this.f46047a;
        if (j <= aVar.f46048b) {
            long j2 = this.f46048b;
            long j3 = aVar.f46047a;
            if (j2 < j3) {
                return false;
            }
            this.f46047a = Math.min(j, j3);
            this.f46048b = Math.max(this.f46048b, aVar.f46048b);
            return true;
        }
        return false;
    }
}
