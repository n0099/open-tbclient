package f.b.x.i;
/* loaded from: classes7.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f68536a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f68537b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f68538c;

    /* renamed from: d  reason: collision with root package name */
    public int f68539d;

    /* renamed from: f.b.x.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1893a<T> extends f.b.w.i<T> {
        @Override // f.b.w.i
        boolean test(T t);
    }

    public a(int i) {
        this.f68536a = i;
        Object[] objArr = new Object[i + 1];
        this.f68537b = objArr;
        this.f68538c = objArr;
    }

    public void a(T t) {
        int i = this.f68536a;
        int i2 = this.f68539d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.f68538c[i] = objArr;
            this.f68538c = objArr;
            i2 = 0;
        }
        this.f68538c[i2] = t;
        this.f68539d = i2 + 1;
    }

    public void b(InterfaceC1893a<? super T> interfaceC1893a) {
        int i;
        int i2 = this.f68536a;
        for (Object[] objArr = this.f68537b; objArr != null; objArr = objArr[i2]) {
            while (i < i2) {
                Object obj = objArr[i];
                i = (obj == null || interfaceC1893a.test(obj)) ? 0 : i + 1;
            }
        }
    }
}
