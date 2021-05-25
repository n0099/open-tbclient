package d.a.l0.h.d0.h;

import java.util.Comparator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f47291a;

    /* renamed from: b  reason: collision with root package name */
    public long f47292b;

    /* renamed from: d.a.l0.h.d0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1020a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.f47291a - aVar2.f47291a);
        }
    }

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.f47291a, aVar.f47292b};
    }

    public boolean b(a aVar) {
        long j = this.f47291a;
        if (j <= aVar.f47292b) {
            long j2 = this.f47292b;
            long j3 = aVar.f47291a;
            if (j2 < j3) {
                return false;
            }
            this.f47291a = Math.min(j, j3);
            this.f47292b = Math.max(this.f47292b, aVar.f47292b);
            return true;
        }
        return false;
    }
}
