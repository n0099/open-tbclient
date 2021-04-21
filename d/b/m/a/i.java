package d.b.m.a;
/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f64998e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ long f64999f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f65000g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f65001h;
    public final /* synthetic */ h i;

    public i(h hVar, long j, long j2, long j3, long j4) {
        this.i = hVar;
        this.f64998e = j;
        this.f64999f = j2;
        this.f65000g = j3;
        this.f65001h = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        fVar = this.i.f64995c;
        fVar.a(this.f64998e, this.f64999f, this.f65000g, this.f65001h);
    }
}
