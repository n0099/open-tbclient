package d.b.t.b.f;

import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f65397g;
    public static final FloatBuffer i;

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f65398h = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer j = d.b.t.b.h.a.b(f65398h);

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f65397g = fArr;
        i = d.b.t.b.h.a.b(fArr);
    }

    public b() {
        this.f65391a = i;
        this.f65392b = j;
        this.f65394d = 2;
        this.f65395e = 2 * 4;
        this.f65393c = f65397g.length / 2;
        this.f65396f = 8;
    }
}
