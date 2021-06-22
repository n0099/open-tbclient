package d.g.d.a.a.a;

import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static final double f70220f = 1.0d / TimeUnit.NANOSECONDS.convert(1, TimeUnit.SECONDS);

    /* renamed from: a  reason: collision with root package name */
    public final double f70221a;

    /* renamed from: c  reason: collision with root package name */
    public long f70223c;

    /* renamed from: d  reason: collision with root package name */
    public int f70224d;

    /* renamed from: b  reason: collision with root package name */
    public final g f70222b = new g();

    /* renamed from: e  reason: collision with root package name */
    public final g f70225e = new g();

    public b(double d2) {
        this.f70221a = 1.0d / (d2 * 6.283185307179586d);
    }

    public int a() {
        return this.f70224d;
    }

    public void b(g gVar, long j) {
        c(gVar, j, 1.0d);
    }

    public void c(g gVar, long j, double d2) {
        int i2 = this.f70224d + 1;
        this.f70224d = i2;
        if (i2 == 1) {
            this.f70222b.f(gVar);
        } else {
            double d3 = d2 * (j - this.f70223c) * f70220f;
            double d4 = d3 / (this.f70221a + d3);
            this.f70222b.c(1.0d - d4);
            this.f70225e.f(gVar);
            this.f70225e.c(d4);
            g gVar2 = this.f70225e;
            g gVar3 = this.f70222b;
            g.g(gVar2, gVar3, gVar3);
        }
        this.f70223c = j;
    }

    public g d() {
        return this.f70222b;
    }
}
