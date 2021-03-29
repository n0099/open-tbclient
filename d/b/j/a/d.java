package d.b.j.a;
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static int f63628b = 5;

    /* renamed from: c  reason: collision with root package name */
    public static int f63629c = 40;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.cesium.a.b f63630a;

    public d() {
        com.baidu.cesium.a.b bVar = new com.baidu.cesium.a.b(f63629c);
        this.f63630a = bVar;
        bVar.a(0, f63629c, true);
    }

    public void a(com.baidu.cesium.a.b bVar, int i, int i2, int i3) {
        com.baidu.cesium.a.b d2 = this.f63630a.d(i, i + i2);
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
            this.f63630a.a(i + i4, d2.d(i4));
        }
    }

    public byte[] b() {
        return this.f63630a.a();
    }
}
