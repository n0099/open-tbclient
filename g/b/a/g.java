package g.b.a;
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f68600a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f68601b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f68602c;

    public static void a(g gVar, a aVar) {
        int length = gVar.f68602c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.f68602c[i2] = i;
            d.n(gVar.f68600a, gVar.f68601b, i, aVar);
            i += 1080;
        }
    }

    public static void b(g gVar, int i, int i2) {
        gVar.f68600a = i;
        gVar.f68601b = new int[i2 * 1080];
        gVar.f68602c = new int[i2];
    }
}
