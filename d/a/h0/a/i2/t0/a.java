package d.a.h0.a.i2.t0;
/* loaded from: classes3.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f42826e;

    public void a() {
        b bVar = this.f42826e;
        if (bVar != null) {
            bVar.a(this);
            this.f42826e = null;
        }
    }

    public a b(b bVar) {
        this.f42826e = bVar;
        return this;
    }
}
