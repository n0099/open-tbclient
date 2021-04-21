package d.p.a.e.b.o;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final double f68392a;

    /* renamed from: b  reason: collision with root package name */
    public final int f68393b;

    /* renamed from: c  reason: collision with root package name */
    public double f68394c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    public int f68395d;

    public f(double d2) {
        this.f68392a = d2;
        this.f68393b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public double a() {
        return this.f68394c;
    }

    public void b(double d2) {
        double d3 = 1.0d - this.f68392a;
        int i = this.f68395d;
        if (i > this.f68393b) {
            this.f68394c = Math.exp((d3 * Math.log(this.f68394c)) + (this.f68392a * Math.log(d2)));
        } else if (i > 0) {
            double d4 = (d3 * i) / (i + 1.0d);
            this.f68394c = Math.exp((d4 * Math.log(this.f68394c)) + ((1.0d - d4) * Math.log(d2)));
        } else {
            this.f68394c = d2;
        }
        this.f68395d++;
    }
}
