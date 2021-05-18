package d.a.k0.q3;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f59838a;

    /* renamed from: b  reason: collision with root package name */
    public float f59839b;

    /* renamed from: c  reason: collision with root package name */
    public float f59840c;

    /* renamed from: d  reason: collision with root package name */
    public float f59841d;

    /* renamed from: e  reason: collision with root package name */
    public float f59842e;

    /* renamed from: f  reason: collision with root package name */
    public float f59843f;

    public static a a(int i2, float f2, float f3, float f4, float f5, float f6) {
        a aVar = new a();
        aVar.f59838a = i2;
        aVar.f59839b = f2;
        aVar.f59840c = f3;
        aVar.f59841d = f4;
        aVar.f59842e = f5;
        aVar.f59843f = f6;
        return aVar;
    }

    public static a b(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return null;
                            }
                            return a(i2, 0.47f, 3.0f, 2.14f, 1.41f, 1.03f);
                        }
                        return a(i2, 0.53f, 3.0f, 1.64f, 1.08f, 0.62f);
                    }
                    return a(i2, 0.59f, 3.0f, 1.11f, 0.71f, 0.67f);
                }
                return a(i2, 0.1f, 2.0f, 0.39f, 0.31f, 0.66f);
            }
            return a(i2, 0.1f, 1.0f, 0.0f, 0.0f, 0.09f);
        }
        return a(i2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }
}
