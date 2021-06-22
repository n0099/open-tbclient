package d.a.n0.g0.e;
/* loaded from: classes3.dex */
public abstract class a<T> extends b<T> {

    /* renamed from: f  reason: collision with root package name */
    public String f53184f;

    /* renamed from: g  reason: collision with root package name */
    public Class<T> f53185g;

    public a(int i2, String str, Class<T> cls) {
        super(i2);
        this.f53184f = str;
        this.f53185g = cls;
    }

    public T a() {
        try {
            return this.f53185g.newInstance();
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
