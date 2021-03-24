package d.b.g0.a.i2.t0;
/* loaded from: classes3.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f44784e;

    public void a() {
        b bVar = this.f44784e;
        if (bVar != null) {
            bVar.a(this);
            this.f44784e = null;
        }
    }

    public a b(b bVar) {
        this.f44784e = bVar;
        return this;
    }
}
