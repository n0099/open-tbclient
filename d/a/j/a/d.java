package d.a.j.a;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static int f50205b = 5;

    /* renamed from: c  reason: collision with root package name */
    public static int f50206c = 40;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.cesium.a.b f50207a;

    public d() {
        com.baidu.cesium.a.b bVar = new com.baidu.cesium.a.b(f50206c);
        this.f50207a = bVar;
        bVar.a(0, f50206c, true);
    }

    public void a(com.baidu.cesium.a.b bVar, int i2, int i3, int i4) {
        com.baidu.cesium.a.b d2 = this.f50207a.d(i2, i2 + i3);
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    d2.e(bVar);
                } else if (i4 == 3) {
                    d2.c(bVar);
                }
            }
            d2.d(bVar);
        } else {
            d2.b(bVar);
        }
        for (int i5 = 0; i5 < i3; i5++) {
            this.f50207a.a(i2 + i5, d2.d(i5));
        }
    }

    public byte[] b() {
        return this.f50207a.a();
    }
}
