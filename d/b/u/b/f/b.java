package d.b.u.b.f;

import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f65661g;
    public static final FloatBuffer i;

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f65662h = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer j = d.b.u.b.h.a.b(f65662h);

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f65661g = fArr;
        i = d.b.u.b.h.a.b(fArr);
    }

    public b() {
        this.f65655a = i;
        this.f65656b = j;
        this.f65658d = 2;
        this.f65659e = 2 * 4;
        this.f65657c = f65661g.length / 2;
        this.f65660f = 8;
    }
}
