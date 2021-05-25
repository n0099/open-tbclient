package d.a.m0.a;
/* loaded from: classes3.dex */
public class m extends i {

    /* renamed from: e  reason: collision with root package name */
    public volatile long f48739e;

    public m(b bVar) {
        super(bVar);
        this.f48739e = System.currentTimeMillis();
    }

    public synchronized long i() {
        this.f48739e = System.currentTimeMillis() + 60000;
        return this.f48739e;
    }

    public boolean j() {
        return System.currentTimeMillis() - this.f48739e >= 60000;
    }
}
