package d.b.i0.b1.i.c;
/* loaded from: classes3.dex */
public class b implements d.b.c.e.k.c<d.b.i0.b1.i.a.a> {

    /* renamed from: a  reason: collision with root package name */
    public int f50649a;

    public b(int i) {
        this.f50649a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // d.b.c.e.k.c
    public /* bridge */ /* synthetic */ d.b.i0.b1.i.a.a a(d.b.i0.b1.i.a.a aVar) {
        d.b.i0.b1.i.a.a aVar2 = aVar;
        e(aVar2);
        return aVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // d.b.c.e.k.c
    public /* bridge */ /* synthetic */ d.b.i0.b1.i.a.a c(d.b.i0.b1.i.a.a aVar) {
        d.b.i0.b1.i.a.a aVar2 = aVar;
        i(aVar2);
        return aVar2;
    }

    public d.b.i0.b1.i.a.a e(d.b.i0.b1.i.a.a aVar) {
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.e.k.c
    /* renamed from: f */
    public void b(d.b.i0.b1.i.a.a aVar) {
        if (aVar == null || aVar.b() == null) {
            return;
        }
        aVar.b().recycle();
    }

    public int g() {
        return this.f50649a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.e.k.c
    /* renamed from: h */
    public d.b.i0.b1.i.a.a d() {
        return new d.b.i0.b1.i.a.a(this.f50649a);
    }

    public d.b.i0.b1.i.a.a i(d.b.i0.b1.i.a.a aVar) {
        return aVar;
    }

    public void j(int i) {
        this.f50649a = i;
    }
}
