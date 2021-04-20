package d.b.m.a;
/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f64734e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ long f64735f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f64736g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f64737h;
    public final /* synthetic */ h i;

    public i(h hVar, long j, long j2, long j3, long j4) {
        this.i = hVar;
        this.f64734e = j;
        this.f64735f = j2;
        this.f64736g = j3;
        this.f64737h = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        fVar = this.i.f64731c;
        fVar.a(this.f64734e, this.f64735f, this.f64736g, this.f64737h);
    }
}
