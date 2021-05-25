package d.a.w.b.f;

import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f64747g;

    /* renamed from: i  reason: collision with root package name */
    public static final FloatBuffer f64749i;

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f64748h = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer j = d.a.w.b.h.a.b(f64748h);

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f64747g = fArr;
        f64749i = d.a.w.b.h.a.b(fArr);
    }

    public b() {
        this.f64741a = f64749i;
        this.f64742b = j;
        this.f64744d = 2;
        this.f64745e = 2 * 4;
        this.f64743c = f64747g.length / 2;
        this.f64746f = 8;
    }
}
