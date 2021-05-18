package d.o.a.e.b.o;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final double f67455a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67456b;

    /* renamed from: c  reason: collision with root package name */
    public double f67457c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    public int f67458d;

    public f(double d2) {
        this.f67455a = d2;
        this.f67456b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public double a() {
        return this.f67457c;
    }

    public void b(double d2) {
        double d3 = 1.0d - this.f67455a;
        int i2 = this.f67458d;
        if (i2 > this.f67456b) {
            this.f67457c = Math.exp((d3 * Math.log(this.f67457c)) + (this.f67455a * Math.log(d2)));
        } else if (i2 > 0) {
            double d4 = (d3 * i2) / (i2 + 1.0d);
            this.f67457c = Math.exp((d4 * Math.log(this.f67457c)) + ((1.0d - d4) * Math.log(d2)));
        } else {
            this.f67457c = d2;
        }
        this.f67458d++;
    }
}
