package d.a.j0.a;
/* loaded from: classes3.dex */
public class m extends i {

    /* renamed from: e  reason: collision with root package name */
    public volatile long f48717e;

    public m(b bVar) {
        super(bVar);
        this.f48717e = System.currentTimeMillis();
    }

    public synchronized long i() {
        this.f48717e = System.currentTimeMillis() + 60000;
        return this.f48717e;
    }

    public boolean j() {
        return System.currentTimeMillis() - this.f48717e >= 60000;
    }
}
