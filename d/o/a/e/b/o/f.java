package d.o.a.e.b.o;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final double f67498a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67499b;

    /* renamed from: c  reason: collision with root package name */
    public double f67500c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    public int f67501d;

    public f(double d2) {
        this.f67498a = d2;
        this.f67499b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public double a() {
        return this.f67500c;
    }

    public void b(double d2) {
        double d3 = 1.0d - this.f67498a;
        int i2 = this.f67501d;
        if (i2 > this.f67499b) {
            this.f67500c = Math.exp((d3 * Math.log(this.f67500c)) + (this.f67498a * Math.log(d2)));
        } else if (i2 > 0) {
            double d4 = (d3 * i2) / (i2 + 1.0d);
            this.f67500c = Math.exp((d4 * Math.log(this.f67500c)) + ((1.0d - d4) * Math.log(d2)));
        } else {
            this.f67500c = d2;
        }
        this.f67501d++;
    }
}
