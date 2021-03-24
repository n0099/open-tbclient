package d.a.a.v;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public float f41441a;

    /* renamed from: b  reason: collision with root package name */
    public int f41442b;

    public void a(float f2) {
        float f3 = this.f41441a + f2;
        this.f41441a = f3;
        int i = this.f41442b + 1;
        this.f41442b = i;
        if (i == Integer.MAX_VALUE) {
            this.f41441a = f3 / 2.0f;
            this.f41442b = i / 2;
        }
    }
}
