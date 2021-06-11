package d.a.m0.a;
/* loaded from: classes3.dex */
public class n extends j {

    /* renamed from: e  reason: collision with root package name */
    public volatile long f52415e;

    public n(c cVar) {
        super(cVar);
        this.f52415e = System.currentTimeMillis();
    }

    public synchronized long i() {
        this.f52415e = System.currentTimeMillis() + 60000;
        return this.f52415e;
    }

    public boolean j() {
        return System.currentTimeMillis() - this.f52415e >= 60000;
    }
}
