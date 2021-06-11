package d.a.l0.a.v2.d1;
/* loaded from: classes3.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f49067e;

    public void a() {
        b bVar = this.f49067e;
        if (bVar != null) {
            bVar.a(this);
            this.f49067e = null;
        }
    }

    public a b(b bVar) {
        this.f49067e = bVar;
        return this;
    }
}
