package d.o.a.e.b.o;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final double f66769a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66770b;

    /* renamed from: c  reason: collision with root package name */
    public double f66771c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    public int f66772d;

    public f(double d2) {
        this.f66769a = d2;
        this.f66770b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public double a() {
        return this.f66771c;
    }

    public void b(double d2) {
        double d3 = 1.0d - this.f66769a;
        int i2 = this.f66772d;
        if (i2 > this.f66770b) {
            this.f66771c = Math.exp((d3 * Math.log(this.f66771c)) + (this.f66769a * Math.log(d2)));
        } else if (i2 > 0) {
            double d4 = (d3 * i2) / (i2 + 1.0d);
            this.f66771c = Math.exp((d4 * Math.log(this.f66771c)) + ((1.0d - d4) * Math.log(d2)));
        } else {
            this.f66771c = d2;
        }
        this.f66772d++;
    }
}
