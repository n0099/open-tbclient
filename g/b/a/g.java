package g.b.a;

import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f68334a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f68335b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f68336c;

    public static void a(g gVar, a aVar) {
        int length = gVar.f68336c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            gVar.f68336c[i3] = i2;
            d.n(gVar.f68334a, gVar.f68335b, i2, aVar);
            i2 += IdCardOcrCameraActivity.G;
        }
    }

    public static void b(g gVar, int i2, int i3) {
        gVar.f68334a = i2;
        gVar.f68335b = new int[i3 * IdCardOcrCameraActivity.G];
        gVar.f68336c = new int[i3];
    }
}
