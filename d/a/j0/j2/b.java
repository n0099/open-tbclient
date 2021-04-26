package d.a.j0.j2;
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public boolean f55927e;

    /* renamed from: f  reason: collision with root package name */
    public int f55928f;

    /* renamed from: g  reason: collision with root package name */
    public int f55929g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55930h = false;

    /* renamed from: i  reason: collision with root package name */
    public i f55931i;

    public b(i iVar) {
        this.f55931i = iVar;
    }

    public void a(int i2) {
        this.f55928f = i2;
    }

    public void b(boolean z) {
        this.f55927e = z;
    }

    public void c(int i2) {
        this.f55929g = i2;
    }

    public void d(boolean z) {
        this.f55930h = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar = this.f55931i;
        if (iVar == null) {
            return;
        }
        if (!this.f55930h) {
            iVar.m(this.f55928f, this.f55929g, this.f55927e, 2);
        } else {
            iVar.m(this.f55928f, this.f55929g, this.f55927e, 1);
        }
    }
}
