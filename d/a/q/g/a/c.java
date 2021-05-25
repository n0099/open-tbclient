package d.a.q.g.a;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static int f64192b = 5;

    /* renamed from: c  reason: collision with root package name */
    public static int f64193c = 40;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.helios.common.cc.a f64194a;

    public c() {
        com.baidu.helios.common.cc.a aVar = new com.baidu.helios.common.cc.a(f64193c);
        this.f64194a = aVar;
        aVar.a(0, f64193c, true);
    }

    public void a(com.baidu.helios.common.cc.a aVar, int i2, int i3, int i4) {
        com.baidu.helios.common.cc.a d2 = this.f64194a.d(i2, i2 + i3);
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    d2.e(aVar);
                } else if (i4 == 3) {
                    d2.c(aVar);
                }
            }
            d2.d(aVar);
        } else {
            d2.b(aVar);
        }
        for (int i5 = 0; i5 < i3; i5++) {
            this.f64194a.a(i2 + i5, d2.d(i5));
        }
    }

    public byte[] b() {
        return this.f64194a.a();
    }
}
