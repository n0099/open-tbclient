package d.b.i0.q3;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f60542a;

    /* renamed from: b  reason: collision with root package name */
    public float f60543b;

    /* renamed from: c  reason: collision with root package name */
    public float f60544c;

    /* renamed from: d  reason: collision with root package name */
    public float f60545d;

    /* renamed from: e  reason: collision with root package name */
    public float f60546e;

    /* renamed from: f  reason: collision with root package name */
    public float f60547f;

    public static a a(int i, float f2, float f3, float f4, float f5, float f6) {
        a aVar = new a();
        aVar.f60542a = i;
        aVar.f60543b = f2;
        aVar.f60544c = f3;
        aVar.f60545d = f4;
        aVar.f60546e = f5;
        aVar.f60547f = f6;
        return aVar;
    }

    public static a b(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return a(i, 0.47f, 3.0f, 2.14f, 1.41f, 1.03f);
                        }
                        return a(i, 0.53f, 3.0f, 1.64f, 1.08f, 0.62f);
                    }
                    return a(i, 0.59f, 3.0f, 1.11f, 0.71f, 0.67f);
                }
                return a(i, 0.1f, 2.0f, 0.39f, 0.31f, 0.66f);
            }
            return a(i, 0.1f, 1.0f, 0.0f, 0.0f, 0.09f);
        }
        return a(i, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }
}
