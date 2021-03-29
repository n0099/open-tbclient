package f.a.x.i;
/* loaded from: classes7.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f67530a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f67531b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f67532c;

    /* renamed from: d  reason: collision with root package name */
    public int f67533d;

    /* renamed from: f.a.x.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1858a<T> extends f.a.w.i<T> {
        @Override // f.a.w.i
        boolean test(T t);
    }

    public a(int i) {
        this.f67530a = i;
        Object[] objArr = new Object[i + 1];
        this.f67531b = objArr;
        this.f67532c = objArr;
    }

    public void a(T t) {
        int i = this.f67530a;
        int i2 = this.f67533d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.f67532c[i] = objArr;
            this.f67532c = objArr;
            i2 = 0;
        }
        this.f67532c[i2] = t;
        this.f67533d = i2 + 1;
    }

    public void b(InterfaceC1858a<? super T> interfaceC1858a) {
        int i;
        int i2 = this.f67530a;
        for (Object[] objArr = this.f67531b; objArr != null; objArr = objArr[i2]) {
            while (i < i2) {
                Object obj = objArr[i];
                i = (obj == null || interfaceC1858a.test(obj)) ? 0 : i + 1;
            }
        }
    }
}
