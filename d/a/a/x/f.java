package d.a.a.x;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public float f41791a;

    /* renamed from: b  reason: collision with root package name */
    public int f41792b;

    public void a(float f2) {
        float f3 = this.f41791a + f2;
        this.f41791a = f3;
        int i = this.f41792b + 1;
        this.f41792b = i;
        if (i == Integer.MAX_VALUE) {
            this.f41791a = f3 / 2.0f;
            this.f41792b = i / 2;
        }
    }
}
