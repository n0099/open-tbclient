package d.b.h0.a;
/* loaded from: classes3.dex */
public class l extends h {

    /* renamed from: e  reason: collision with root package name */
    public volatile long f49990e;

    public l(b bVar) {
        super(bVar);
        this.f49990e = System.currentTimeMillis();
    }

    public synchronized long i() {
        this.f49990e = System.currentTimeMillis() + 60000;
        return this.f49990e;
    }

    public boolean j() {
        return System.currentTimeMillis() - this.f49990e >= 60000;
    }
}
