package d.b.u.b.f;

import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f64702g;
    public static final FloatBuffer i;

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f64703h = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer j = d.b.u.b.h.a.b(f64703h);

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f64702g = fArr;
        i = d.b.u.b.h.a.b(fArr);
    }

    public b() {
        this.f64696a = i;
        this.f64697b = j;
        this.f64699d = 2;
        this.f64700e = 2 * 4;
        this.f64698c = f64702g.length / 2;
        this.f64701f = 8;
    }
}
