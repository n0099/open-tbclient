package d.a.a.y;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public float f41907a;

    /* renamed from: b  reason: collision with root package name */
    public float f41908b;

    public d(float f2, float f3) {
        this.f41907a = f2;
        this.f41908b = f3;
    }

    public boolean a(float f2, float f3) {
        return this.f41907a == f2 && this.f41908b == f3;
    }

    public float b() {
        return this.f41907a;
    }

    public float c() {
        return this.f41908b;
    }

    public void d(float f2, float f3) {
        this.f41907a = f2;
        this.f41908b = f3;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public d() {
        this(1.0f, 1.0f);
    }
}
