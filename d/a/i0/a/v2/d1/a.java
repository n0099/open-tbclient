package d.a.i0.a.v2.d1;
/* loaded from: classes3.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f45217e;

    public void a() {
        b bVar = this.f45217e;
        if (bVar != null) {
            bVar.a(this);
            this.f45217e = null;
        }
    }

    public a b(b bVar) {
        this.f45217e = bVar;
        return this;
    }
}
