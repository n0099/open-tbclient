package d.a.u.b.f;

import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f64007g;

    /* renamed from: i  reason: collision with root package name */
    public static final FloatBuffer f64009i;

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f64008h = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer j = d.a.u.b.h.a.b(f64008h);

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f64007g = fArr;
        f64009i = d.a.u.b.h.a.b(fArr);
    }

    public b() {
        this.f64001a = f64009i;
        this.f64002b = j;
        this.f64004d = 2;
        this.f64005e = 2 * 4;
        this.f64003c = f64007g.length / 2;
        this.f64006f = 8;
    }
}
