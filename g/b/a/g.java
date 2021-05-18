package g.b.a;

import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
/* loaded from: classes7.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public int f68291a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f68292b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f68293c;

    public static void a(g gVar, a aVar) {
        int length = gVar.f68293c.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            gVar.f68293c[i3] = i2;
            d.n(gVar.f68291a, gVar.f68292b, i2, aVar);
            i2 += IdCardOcrCameraActivity.G;
        }
    }

    public static void b(g gVar, int i2, int i3) {
        gVar.f68291a = i2;
        gVar.f68292b = new int[i3 * IdCardOcrCameraActivity.G];
        gVar.f68293c = new int[i3];
    }
}
