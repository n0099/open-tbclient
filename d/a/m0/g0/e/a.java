package d.a.m0.g0.e;
/* loaded from: classes3.dex */
public abstract class a<T> extends b<T> {

    /* renamed from: f  reason: collision with root package name */
    public String f53077f;

    /* renamed from: g  reason: collision with root package name */
    public Class<T> f53078g;

    public a(int i2, String str, Class<T> cls) {
        super(i2);
        this.f53077f = str;
        this.f53078g = cls;
    }

    public T a() {
        try {
            return this.f53078g.newInstance();
        } catch (ExceptionInInitializerError e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
