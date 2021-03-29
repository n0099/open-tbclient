package d.b.n.a;
/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f64130e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ long f64131f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f64132g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f64133h;
    public final /* synthetic */ h i;

    public i(h hVar, long j, long j2, long j3, long j4) {
        this.i = hVar;
        this.f64130e = j;
        this.f64131f = j2;
        this.f64132g = j3;
        this.f64133h = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        fVar = this.i.f64127c;
        fVar.a(this.f64130e, this.f64131f, this.f64132g, this.f64133h);
    }
}
