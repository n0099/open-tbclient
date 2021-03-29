package d.b.u.b.f;

import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f64703g;
    public static final FloatBuffer i;

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f64704h = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer j = d.b.u.b.h.a.b(f64704h);

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f64703g = fArr;
        i = d.b.u.b.h.a.b(fArr);
    }

    public b() {
        this.f64697a = i;
        this.f64698b = j;
        this.f64700d = 2;
        this.f64701e = 2 * 4;
        this.f64699c = f64703g.length / 2;
        this.f64702f = 8;
    }
}
