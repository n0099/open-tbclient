package d.a.l0.a.v2.d1;
/* loaded from: classes3.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f45393e;

    public void a() {
        b bVar = this.f45393e;
        if (bVar != null) {
            bVar.a(this);
            this.f45393e = null;
        }
    }

    public a b(b bVar) {
        this.f45393e = bVar;
        return this;
    }
}
