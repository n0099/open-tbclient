package g.b.a;
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f67594a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f67595b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f67596c;

    public static void a(g gVar, a aVar) {
        int length = gVar.f67596c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            gVar.f67596c[i2] = i;
            d.n(gVar.f67594a, gVar.f67595b, i, aVar);
            i += 1080;
        }
    }

    public static void b(g gVar, int i, int i2) {
        gVar.f67594a = i;
        gVar.f67595b = new int[i2 * 1080];
        gVar.f67596c = new int[i2];
    }
}
