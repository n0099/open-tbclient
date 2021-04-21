package d.b.i0.w.w;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f52326b;

    /* renamed from: a  reason: collision with root package name */
    public int f52327a = 0;

    public static a a() {
        if (f52326b == null) {
            synchronized (a.class) {
                if (f52326b == null) {
                    f52326b = new a();
                }
            }
        }
        return f52326b;
    }

    public int b() {
        return this.f52327a;
    }

    public void c(int i) {
        this.f52327a = i;
    }
}
