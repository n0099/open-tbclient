package d.a.i0.h.d0.h;

import java.util.Comparator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f47115a;

    /* renamed from: b  reason: collision with root package name */
    public long f47116b;

    /* renamed from: d.a.i0.h.d0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1009a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.f47115a - aVar2.f47115a);
        }
    }

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.f47115a, aVar.f47116b};
    }

    public boolean b(a aVar) {
        long j = this.f47115a;
        if (j <= aVar.f47116b) {
            long j2 = this.f47116b;
            long j3 = aVar.f47115a;
            if (j2 < j3) {
                return false;
            }
            this.f47115a = Math.min(j, j3);
            this.f47116b = Math.max(this.f47116b, aVar.f47116b);
            return true;
        }
        return false;
    }
}
