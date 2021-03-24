package f.a.x.i;
/* loaded from: classes7.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f67525a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f67526b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f67527c;

    /* renamed from: d  reason: collision with root package name */
    public int f67528d;

    /* renamed from: f.a.x.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1857a<T> extends f.a.w.i<T> {
        @Override // f.a.w.i
        boolean test(T t);
    }

    public a(int i) {
        this.f67525a = i;
        Object[] objArr = new Object[i + 1];
        this.f67526b = objArr;
        this.f67527c = objArr;
    }

    public void a(T t) {
        int i = this.f67525a;
        int i2 = this.f67528d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.f67527c[i] = objArr;
            this.f67527c = objArr;
            i2 = 0;
        }
        this.f67527c[i2] = t;
        this.f67528d = i2 + 1;
    }

    public void b(InterfaceC1857a<? super T> interfaceC1857a) {
        int i;
        int i2 = this.f67525a;
        for (Object[] objArr = this.f67526b; objArr != null; objArr = objArr[i2]) {
            while (i < i2) {
                Object obj = objArr[i];
                i = (obj == null || interfaceC1857a.test(obj)) ? 0 : i + 1;
            }
        }
    }
}
