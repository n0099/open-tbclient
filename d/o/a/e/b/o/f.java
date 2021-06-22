package d.o.a.e.b.o;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final double f71388a;

    /* renamed from: b  reason: collision with root package name */
    public final int f71389b;

    /* renamed from: c  reason: collision with root package name */
    public double f71390c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    public int f71391d;

    public f(double d2) {
        this.f71388a = d2;
        this.f71389b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public double a() {
        return this.f71390c;
    }

    public void b(double d2) {
        double d3 = 1.0d - this.f71388a;
        int i2 = this.f71391d;
        if (i2 > this.f71389b) {
            this.f71390c = Math.exp((d3 * Math.log(this.f71390c)) + (this.f71388a * Math.log(d2)));
        } else if (i2 > 0) {
            double d4 = (d3 * i2) / (i2 + 1.0d);
            this.f71390c = Math.exp((d4 * Math.log(this.f71390c)) + ((1.0d - d4) * Math.log(d2)));
        } else {
            this.f71390c = d2;
        }
        this.f71391d++;
    }
}
