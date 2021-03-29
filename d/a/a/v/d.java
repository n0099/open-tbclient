package d.a.a.v;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public float f41442a;

    /* renamed from: b  reason: collision with root package name */
    public int f41443b;

    public void a(float f2) {
        float f3 = this.f41442a + f2;
        this.f41442a = f3;
        int i = this.f41443b + 1;
        this.f41443b = i;
        if (i == Integer.MAX_VALUE) {
            this.f41442a = f3 / 2.0f;
            this.f41443b = i / 2;
        }
    }
}
