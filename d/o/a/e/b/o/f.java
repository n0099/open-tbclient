package d.o.a.e.b.o;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final double f67247a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67248b;

    /* renamed from: c  reason: collision with root package name */
    public double f67249c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    public int f67250d;

    public f(double d2) {
        this.f67247a = d2;
        this.f67248b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public double a() {
        return this.f67249c;
    }

    public void b(double d2) {
        double d3 = 1.0d - this.f67247a;
        int i = this.f67250d;
        if (i > this.f67248b) {
            this.f67249c = Math.exp((d3 * Math.log(this.f67249c)) + (this.f67247a * Math.log(d2)));
        } else if (i > 0) {
            double d4 = i;
            Double.isNaN(d4);
            double d5 = i;
            Double.isNaN(d5);
            double d6 = (d3 * d4) / (d5 + 1.0d);
            this.f67249c = Math.exp((d6 * Math.log(this.f67249c)) + ((1.0d - d6) * Math.log(d2)));
        } else {
            this.f67249c = d2;
        }
        this.f67250d++;
    }
}
