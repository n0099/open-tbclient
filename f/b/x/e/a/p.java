package f.b.x.e.a;
/* loaded from: classes7.dex */
public final class p implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final o f68643e;

    /* renamed from: f  reason: collision with root package name */
    public final long f68644f;

    public p(long j, o oVar) {
        this.f68644f = j;
        this.f68643e = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f68643e.onTimeout(this.f68644f);
    }
}
