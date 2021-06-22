package d.a.w.b.f;

import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f68569g;

    /* renamed from: i  reason: collision with root package name */
    public static final FloatBuffer f68571i;

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f68570h = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer j = d.a.w.b.h.a.b(f68570h);

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f68569g = fArr;
        f68571i = d.a.w.b.h.a.b(fArr);
    }

    public b() {
        this.f68563a = f68571i;
        this.f68564b = j;
        this.f68566d = 2;
        this.f68567e = 2 * 4;
        this.f68565c = f68569g.length / 2;
        this.f68568f = 8;
    }
}
