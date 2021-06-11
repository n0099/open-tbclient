package g.b.a;

import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f71590a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f71591b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f71592c;

    public static void a(g gVar, a aVar) {
        int length = gVar.f71592c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            gVar.f71592c[i3] = i2;
            d.n(gVar.f71590a, gVar.f71591b, i2, aVar);
            i2 += IdCardOcrCameraActivity.G;
        }
    }

    public static void b(g gVar, int i2, int i3) {
        gVar.f71590a = i2;
        gVar.f71591b = new int[i3 * IdCardOcrCameraActivity.G];
        gVar.f71592c = new int[i3];
    }
}
