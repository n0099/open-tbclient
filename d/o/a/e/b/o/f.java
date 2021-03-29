package d.o.a.e.b.o;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final double f67252a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67253b;

    /* renamed from: c  reason: collision with root package name */
    public double f67254c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    public int f67255d;

    public f(double d2) {
        this.f67252a = d2;
        this.f67253b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public double a() {
        return this.f67254c;
    }

    public void b(double d2) {
        double d3 = 1.0d - this.f67252a;
        int i = this.f67255d;
        if (i > this.f67253b) {
            this.f67254c = Math.exp((d3 * Math.log(this.f67254c)) + (this.f67252a * Math.log(d2)));
        } else if (i > 0) {
            double d4 = (d3 * i) / (i + 1.0d);
            this.f67254c = Math.exp((d4 * Math.log(this.f67254c)) + ((1.0d - d4) * Math.log(d2)));
        } else {
            this.f67254c = d2;
        }
        this.f67255d++;
    }
}
