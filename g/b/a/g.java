package g.b.a;
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f68747a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f68748b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f68749c;

    public static void a(g gVar, a aVar) {
        int length = gVar.f68749c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.f68749c[i2] = i;
            d.n(gVar.f68747a, gVar.f68748b, i, aVar);
            i += 1080;
        }
    }

    public static void b(g gVar, int i, int i2) {
        gVar.f68747a = i;
        gVar.f68748b = new int[i2 * 1080];
        gVar.f68749c = new int[i2];
    }
}
