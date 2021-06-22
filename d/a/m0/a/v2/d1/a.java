package d.a.m0.a.v2.d1;
/* loaded from: classes3.dex */
public abstract class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public b f49175e;

    public void a() {
        b bVar = this.f49175e;
        if (bVar != null) {
            bVar.a(this);
            this.f49175e = null;
        }
    }

    public a b(b bVar) {
        this.f49175e = bVar;
        return this;
    }
}
