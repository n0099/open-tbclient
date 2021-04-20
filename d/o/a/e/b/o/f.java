package d.o.a.e.b.o;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final double f68245a;

    /* renamed from: b  reason: collision with root package name */
    public final int f68246b;

    /* renamed from: c  reason: collision with root package name */
    public double f68247c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    public int f68248d;

    public f(double d2) {
        this.f68245a = d2;
        this.f68246b = d2 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d2);
    }

    public double a() {
        return this.f68247c;
    }

    public void b(double d2) {
        double d3 = 1.0d - this.f68245a;
        int i = this.f68248d;
        if (i > this.f68246b) {
            this.f68247c = Math.exp((d3 * Math.log(this.f68247c)) + (this.f68245a * Math.log(d2)));
        } else if (i > 0) {
            double d4 = (d3 * i) / (i + 1.0d);
            this.f68247c = Math.exp((d4 * Math.log(this.f68247c)) + ((1.0d - d4) * Math.log(d2)));
        } else {
            this.f68247c = d2;
        }
        this.f68248d++;
    }
}
