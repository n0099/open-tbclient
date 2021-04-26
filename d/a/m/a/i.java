package d.a.m.a;
/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f63307e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ long f63308f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f63309g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f63310h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ h f63311i;

    public i(h hVar, long j, long j2, long j3, long j4) {
        this.f63311i = hVar;
        this.f63307e = j;
        this.f63308f = j2;
        this.f63309g = j3;
        this.f63310h = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        fVar = this.f63311i.f63304c;
        fVar.a(this.f63307e, this.f63308f, this.f63309g, this.f63310h);
    }
}
