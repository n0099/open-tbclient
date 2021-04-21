package f.b.x.i;
/* loaded from: classes7.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f68683a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f68684b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f68685c;

    /* renamed from: d  reason: collision with root package name */
    public int f68686d;

    /* renamed from: f.b.x.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1897a<T> extends f.b.w.i<T> {
        @Override // f.b.w.i
        boolean test(T t);
    }

    public a(int i) {
        this.f68683a = i;
        Object[] objArr = new Object[i + 1];
        this.f68684b = objArr;
        this.f68685c = objArr;
    }

    public void a(T t) {
        int i = this.f68683a;
        int i2 = this.f68686d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.f68685c[i] = objArr;
            this.f68685c = objArr;
            i2 = 0;
        }
        this.f68685c[i2] = t;
        this.f68686d = i2 + 1;
    }

    public void b(InterfaceC1897a<? super T> interfaceC1897a) {
        int i;
        int i2 = this.f68683a;
        for (Object[] objArr = this.f68684b; objArr != null; objArr = objArr[i2]) {
            while (i < i2) {
                Object obj = objArr[i];
                i = (obj == null || interfaceC1897a.test(obj)) ? 0 : i + 1;
            }
        }
    }
}
