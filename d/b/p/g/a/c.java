package d.b.p.g.a;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static int f65096b = 5;

    /* renamed from: c  reason: collision with root package name */
    public static int f65097c = 40;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.helios.common.cc.a f65098a;

    public c() {
        com.baidu.helios.common.cc.a aVar = new com.baidu.helios.common.cc.a(f65097c);
        this.f65098a = aVar;
        aVar.a(0, f65097c, true);
    }

    public void a(com.baidu.helios.common.cc.a aVar, int i, int i2, int i3) {
        com.baidu.helios.common.cc.a d2 = this.f65098a.d(i, i + i2);
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
            this.f65098a.a(i + i4, d2.d(i4));
        }
    }

    public byte[] b() {
        return this.f65098a.a();
    }
}
