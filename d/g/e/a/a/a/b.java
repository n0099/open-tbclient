package d.g.e.a.a.a;

import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static final double f67130f = 1.0d / TimeUnit.NANOSECONDS.convert(1, TimeUnit.SECONDS);

    /* renamed from: a  reason: collision with root package name */
    public final double f67131a;

    /* renamed from: c  reason: collision with root package name */
    public long f67133c;

    /* renamed from: d  reason: collision with root package name */
    public int f67134d;

    /* renamed from: b  reason: collision with root package name */
    public final g f67132b = new g();

    /* renamed from: e  reason: collision with root package name */
    public final g f67135e = new g();

    public b(double d2) {
        this.f67131a = 1.0d / (d2 * 6.283185307179586d);
    }

    public int a() {
        return this.f67134d;
    }

    public void b(g gVar, long j) {
        c(gVar, j, 1.0d);
    }

    public void c(g gVar, long j, double d2) {
        int i = this.f67134d + 1;
        this.f67134d = i;
        if (i == 1) {
            this.f67132b.f(gVar);
        } else {
            double d3 = d2 * (j - this.f67133c) * f67130f;
            double d4 = d3 / (this.f67131a + d3);
            this.f67132b.c(1.0d - d4);
            this.f67135e.f(gVar);
            this.f67135e.c(d4);
            g gVar2 = this.f67135e;
            g gVar3 = this.f67132b;
            g.g(gVar2, gVar3, gVar3);
        }
        this.f67133c = j;
    }

    public g d() {
        return this.f67132b;
    }
}
