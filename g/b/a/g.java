package g.b.a;

import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f71694a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f71695b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f71696c;

    public static void a(g gVar, a aVar) {
        int length = gVar.f71696c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            gVar.f71696c[i3] = i2;
            d.n(gVar.f71694a, gVar.f71695b, i2, aVar);
            i2 += IdCardOcrCameraActivity.G;
        }
    }

    public static void b(g gVar, int i2, int i3) {
        gVar.f71694a = i2;
        gVar.f71695b = new int[i3 * IdCardOcrCameraActivity.G];
        gVar.f71696c = new int[i3];
    }
}
