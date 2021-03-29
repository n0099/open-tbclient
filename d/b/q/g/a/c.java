package d.b.q.g.a;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static int f64402b = 5;

    /* renamed from: c  reason: collision with root package name */
    public static int f64403c = 40;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.helios.common.cc.a f64404a;

    public c() {
        com.baidu.helios.common.cc.a aVar = new com.baidu.helios.common.cc.a(f64403c);
        this.f64404a = aVar;
        aVar.a(0, f64403c, true);
    }

    public void a(com.baidu.helios.common.cc.a aVar, int i, int i2, int i3) {
        com.baidu.helios.common.cc.a d2 = this.f64404a.d(i, i + i2);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    d2.e(aVar);
                } else if (i3 == 3) {
                    d2.c(aVar);
                }
            }
            d2.d(aVar);
        } else {
            d2.b(aVar);
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.f64404a.a(i + i4, d2.d(i4));
        }
    }

    public byte[] b() {
        return this.f64404a.a();
    }
}
