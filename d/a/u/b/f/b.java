package d.a.u.b.f;

import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f64694g;

    /* renamed from: i  reason: collision with root package name */
    public static final FloatBuffer f64696i;

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f64695h = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer j = d.a.u.b.h.a.b(f64695h);

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f64694g = fArr;
        f64696i = d.a.u.b.h.a.b(fArr);
    }

    public b() {
        this.f64688a = f64696i;
        this.f64689b = j;
        this.f64691d = 2;
        this.f64692e = 2 * 4;
        this.f64690c = f64694g.length / 2;
        this.f64693f = 8;
    }
}
