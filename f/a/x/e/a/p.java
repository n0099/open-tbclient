package f.a.x.e.a;
/* loaded from: classes7.dex */
public final class p implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final o f67485e;

    /* renamed from: f  reason: collision with root package name */
    public final long f67486f;

    public p(long j, o oVar) {
        this.f67486f = j;
        this.f67485e = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f67485e.onTimeout(this.f67486f);
    }
}
