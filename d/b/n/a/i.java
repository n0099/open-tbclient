package d.b.n.a;
/* loaded from: classes2.dex */
public final class i implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f64129e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ long f64130f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f64131g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f64132h;
    public final /* synthetic */ h i;

    public i(h hVar, long j, long j2, long j3, long j4) {
        this.i = hVar;
        this.f64129e = j;
        this.f64130f = j2;
        this.f64131g = j3;
        this.f64132h = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        fVar = this.i.f64126c;
        fVar.a(this.f64129e, this.f64130f, this.f64131g, this.f64132h);
    }
}
