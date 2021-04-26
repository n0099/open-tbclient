package g.b.a;

import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f67605a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f67606b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f67607c;

    public static void a(g gVar, a aVar) {
        int length = gVar.f67607c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            gVar.f67607c[i3] = i2;
            d.n(gVar.f67605a, gVar.f67606b, i2, aVar);
            i2 += IdCardOcrCameraActivity.G;
        }
    }

    public static void b(g gVar, int i2, int i3) {
        gVar.f67605a = i2;
        gVar.f67606b = new int[i3 * IdCardOcrCameraActivity.G];
        gVar.f67607c = new int[i3];
    }
}
