package d.b.j.a;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static int f52523b = 5;

    /* renamed from: c  reason: collision with root package name */
    public static int f52524c = 40;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.cesium.a.b f52525a;

    public d() {
        com.baidu.cesium.a.b bVar = new com.baidu.cesium.a.b(f52524c);
        this.f52525a = bVar;
        bVar.a(0, f52524c, true);
    }

    public void a(com.baidu.cesium.a.b bVar, int i, int i2, int i3) {
        com.baidu.cesium.a.b d2 = this.f52525a.d(i, i + i2);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    d2.e(bVar);
                } else if (i3 == 3) {
                    d2.c(bVar);
                }
            }
            d2.d(bVar);
        } else {
            d2.b(bVar);
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.f52525a.a(i + i4, d2.d(i4));
        }
    }

    public byte[] b() {
        return this.f52525a.a();
    }
}
