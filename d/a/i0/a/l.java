package d.a.i0.a;
/* loaded from: classes3.dex */
public class l extends h {

    /* renamed from: e  reason: collision with root package name */
    public volatile long f47878e;

    public l(b bVar) {
        super(bVar);
        this.f47878e = System.currentTimeMillis();
    }

    public synchronized long i() {
        this.f47878e = System.currentTimeMillis() + 60000;
        return this.f47878e;
    }

    public boolean j() {
        return System.currentTimeMillis() - this.f47878e >= 60000;
    }
}
