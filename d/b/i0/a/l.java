package d.b.i0.a;
/* loaded from: classes3.dex */
public class l extends h {

    /* renamed from: e  reason: collision with root package name */
    public volatile long f50326e;

    public l(b bVar) {
        super(bVar);
        this.f50326e = System.currentTimeMillis();
    }

    public synchronized long i() {
        this.f50326e = System.currentTimeMillis() + 60000;
        return this.f50326e;
    }

    public boolean j() {
        return System.currentTimeMillis() - this.f50326e >= 60000;
    }
}
