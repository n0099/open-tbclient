package d.h.e.a.a.a;

import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static final double f67277f = 1.0d / TimeUnit.NANOSECONDS.convert(1, TimeUnit.SECONDS);

    /* renamed from: a  reason: collision with root package name */
    public final double f67278a;

    /* renamed from: c  reason: collision with root package name */
    public long f67280c;

    /* renamed from: d  reason: collision with root package name */
    public int f67281d;

    /* renamed from: b  reason: collision with root package name */
    public final g f67279b = new g();

    /* renamed from: e  reason: collision with root package name */
    public final g f67282e = new g();

    public b(double d2) {
        this.f67278a = 1.0d / (d2 * 6.283185307179586d);
    }

    public int a() {
        return this.f67281d;
    }

    public void b(g gVar, long j) {
        c(gVar, j, 1.0d);
    }

    public void c(g gVar, long j, double d2) {
        int i = this.f67281d + 1;
        this.f67281d = i;
        if (i == 1) {
            this.f67279b.f(gVar);
        } else {
            double d3 = d2 * (j - this.f67280c) * f67277f;
            double d4 = d3 / (this.f67278a + d3);
            this.f67279b.c(1.0d - d4);
            this.f67282e.f(gVar);
            this.f67282e.c(d4);
            g gVar2 = this.f67282e;
            g gVar3 = this.f67279b;
            g.g(gVar2, gVar3, gVar3);
        }
        this.f67280c = j;
    }

    public g d() {
        return this.f67279b;
    }
}
