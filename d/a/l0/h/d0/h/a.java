package d.a.l0.h.d0.h;

import java.util.Comparator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f50965a;

    /* renamed from: b  reason: collision with root package name */
    public long f50966b;

    /* renamed from: d.a.l0.h.d0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1076a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.f50965a - aVar2.f50965a);
        }
    }

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.f50965a, aVar.f50966b};
    }

    public boolean b(a aVar) {
        long j = this.f50965a;
        if (j <= aVar.f50966b) {
            long j2 = this.f50966b;
            long j3 = aVar.f50965a;
            if (j2 < j3) {
                return false;
            }
            this.f50965a = Math.min(j, j3);
            this.f50966b = Math.max(this.f50966b, aVar.f50966b);
            return true;
        }
        return false;
    }
}
