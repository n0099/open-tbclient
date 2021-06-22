package d.a.m0.h.d0.h;

import java.util.Comparator;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f51073a;

    /* renamed from: b  reason: collision with root package name */
    public long f51074b;

    /* renamed from: d.a.m0.h.d0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1079a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            return (int) (aVar.f51073a - aVar2.f51073a);
        }
    }

    public static long[] a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new long[]{aVar.f51073a, aVar.f51074b};
    }

    public boolean b(a aVar) {
        long j = this.f51073a;
        if (j <= aVar.f51074b) {
            long j2 = this.f51074b;
            long j3 = aVar.f51073a;
            if (j2 < j3) {
                return false;
            }
            this.f51073a = Math.min(j, j3);
            this.f51074b = Math.max(this.f51074b, aVar.f51074b);
            return true;
        }
        return false;
    }
}
