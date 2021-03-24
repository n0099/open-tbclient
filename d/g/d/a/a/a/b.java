package d.g.d.a.a.a;

import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static final double f66136f;

    /* renamed from: a  reason: collision with root package name */
    public final double f66137a;

    /* renamed from: c  reason: collision with root package name */
    public long f66139c;

    /* renamed from: d  reason: collision with root package name */
    public int f66140d;

    /* renamed from: b  reason: collision with root package name */
    public final g f66138b = new g();

    /* renamed from: e  reason: collision with root package name */
    public final g f66141e = new g();

    static {
        double convert = TimeUnit.NANOSECONDS.convert(1L, TimeUnit.SECONDS);
        Double.isNaN(convert);
        f66136f = 1.0d / convert;
    }

    public b(double d2) {
        this.f66137a = 1.0d / (d2 * 6.283185307179586d);
    }

    public int a() {
        return this.f66140d;
    }

    public void b(g gVar, long j) {
        c(gVar, j, 1.0d);
    }

    public void c(g gVar, long j, double d2) {
        int i = this.f66140d + 1;
        this.f66140d = i;
        if (i == 1) {
            this.f66138b.f(gVar);
        } else {
            double d3 = j - this.f66139c;
            Double.isNaN(d3);
            double d4 = d2 * d3 * f66136f;
            double d5 = d4 / (this.f66137a + d4);
            this.f66138b.c(1.0d - d5);
            this.f66141e.f(gVar);
            this.f66141e.c(d5);
            g gVar2 = this.f66141e;
            g gVar3 = this.f66138b;
            g.g(gVar2, gVar3, gVar3);
        }
        this.f66139c = j;
    }

    public g d() {
        return this.f66138b;
    }
}
