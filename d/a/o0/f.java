package d.a.o0;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public a f58069a;

    /* renamed from: b  reason: collision with root package name */
    public int f58070b = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i2, int i3);
    }

    public int a() {
        return this.f58070b;
    }

    public void b(a aVar) {
        this.f58069a = aVar;
    }

    public void c(int i2) {
        int i3 = this.f58070b;
        if (i3 != i2) {
            a aVar = this.f58069a;
            if (aVar != null) {
                aVar.a(i3, i2);
            }
            this.f58070b = i2;
        }
    }

    public void d(int i2) {
        this.f58070b = i2;
    }
}
