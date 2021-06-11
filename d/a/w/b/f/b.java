package d.a.w.b.f;

import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f68465g;

    /* renamed from: i  reason: collision with root package name */
    public static final FloatBuffer f68467i;

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f68466h = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer j = d.a.w.b.h.a.b(f68466h);

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f68465g = fArr;
        f68467i = d.a.w.b.h.a.b(fArr);
    }

    public b() {
        this.f68459a = f68467i;
        this.f68460b = j;
        this.f68462d = 2;
        this.f68463e = 2 * 4;
        this.f68461c = f68465g.length / 2;
        this.f68464f = 8;
    }
}
