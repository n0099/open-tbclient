package d.b.i0.g0.e;
/* loaded from: classes3.dex */
public abstract class a<T> extends b<T> {

    /* renamed from: f  reason: collision with root package name */
    public String f50952f;

    /* renamed from: g  reason: collision with root package name */
    public Class<T> f50953g;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.f50952f = str;
        this.f50953g = cls;
    }

    public T a() {
        try {
            return this.f50953g.newInstance();
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
