package d.g.d.a.a.a;

import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static final double f66137f = 1.0d / TimeUnit.NANOSECONDS.convert(1, TimeUnit.SECONDS);

    /* renamed from: a  reason: collision with root package name */
    public final double f66138a;

    /* renamed from: c  reason: collision with root package name */
    public long f66140c;

    /* renamed from: d  reason: collision with root package name */
    public int f66141d;

    /* renamed from: b  reason: collision with root package name */
    public final g f66139b = new g();

    /* renamed from: e  reason: collision with root package name */
    public final g f66142e = new g();

    public b(double d2) {
        this.f66138a = 1.0d / (d2 * 6.283185307179586d);
    }

    public int a() {
        return this.f66141d;
    }

    public void b(g gVar, long j) {
        c(gVar, j, 1.0d);
    }

    public void c(g gVar, long j, double d2) {
        int i = this.f66141d + 1;
        this.f66141d = i;
        if (i == 1) {
            this.f66139b.f(gVar);
        } else {
            double d3 = d2 * (j - this.f66140c) * f66137f;
            double d4 = d3 / (this.f66138a + d3);
            this.f66139b.c(1.0d - d4);
            this.f66142e.f(gVar);
            this.f66142e.c(d4);
            g gVar2 = this.f66142e;
            g gVar3 = this.f66139b;
            g.g(gVar2, gVar3, gVar3);
        }
        this.f66140c = j;
    }

    public g d() {
        return this.f66139b;
    }
}
