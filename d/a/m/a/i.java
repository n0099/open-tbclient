package d.a.m.a;
/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f63846e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ long f63847f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f63848g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f63849h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ h f63850i;

    public i(h hVar, long j, long j2, long j3, long j4) {
        this.f63850i = hVar;
        this.f63846e = j;
        this.f63847f = j2;
        this.f63848g = j3;
        this.f63849h = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        fVar = this.f63850i.f63843c;
        fVar.a(this.f63846e, this.f63847f, this.f63848g, this.f63849h);
    }
}
