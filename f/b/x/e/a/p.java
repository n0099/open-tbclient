package f.b.x.e.a;
/* loaded from: classes7.dex */
public final class p implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final o f68496e;

    /* renamed from: f  reason: collision with root package name */
    public final long f68497f;

    public p(long j, o oVar) {
        this.f68497f = j;
        this.f68496e = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f68496e.onTimeout(this.f68497f);
    }
}
