package d.a.j0.b1.i.c;
/* loaded from: classes3.dex */
public class b implements d.a.c.e.k.c<d.a.j0.b1.i.a.a> {

    /* renamed from: a  reason: collision with root package name */
    public int f49040a;

    public b(int i2) {
        this.f49040a = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // d.a.c.e.k.c
    public /* bridge */ /* synthetic */ d.a.j0.b1.i.a.a a(d.a.j0.b1.i.a.a aVar) {
        d.a.j0.b1.i.a.a aVar2 = aVar;
        e(aVar2);
        return aVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // d.a.c.e.k.c
    public /* bridge */ /* synthetic */ d.a.j0.b1.i.a.a c(d.a.j0.b1.i.a.a aVar) {
        d.a.j0.b1.i.a.a aVar2 = aVar;
        i(aVar2);
        return aVar2;
    }

    public d.a.j0.b1.i.a.a e(d.a.j0.b1.i.a.a aVar) {
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.e.k.c
    /* renamed from: f */
    public void b(d.a.j0.b1.i.a.a aVar) {
        if (aVar == null || aVar.b() == null) {
            return;
        }
        aVar.b().recycle();
    }

    public int g() {
        return this.f49040a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.e.k.c
    /* renamed from: h */
    public d.a.j0.b1.i.a.a d() {
        return new d.a.j0.b1.i.a.a(this.f49040a);
    }

    public d.a.j0.b1.i.a.a i(d.a.j0.b1.i.a.a aVar) {
        return aVar;
    }

    public void j(int i2) {
        this.f49040a = i2;
    }
}
