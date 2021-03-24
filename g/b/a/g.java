package g.b.a;
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f67589a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f67590b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f67591c;

    public static void a(g gVar, a aVar) {
        int length = gVar.f67591c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.f67591c[i2] = i;
            d.n(gVar.f67589a, gVar.f67590b, i, aVar);
            i += 1080;
        }
    }

    public static void b(g gVar, int i, int i2) {
        gVar.f67589a = i;
        gVar.f67590b = new int[i2 * 1080];
        gVar.f67591c = new int[i2];
    }
}
