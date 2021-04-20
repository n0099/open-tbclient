package d.b.i0.y1.f;
/* loaded from: classes3.dex */
public class b implements Comparable<b> {

    /* renamed from: e  reason: collision with root package name */
    public int f64058e;

    /* renamed from: f  reason: collision with root package name */
    public String f64059f;

    /* renamed from: g  reason: collision with root package name */
    public String f64060g;

    /* renamed from: h  reason: collision with root package name */
    public String f64061h;
    public int i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (this == bVar) {
            return 0;
        }
        return (bVar == null || this.f64058e <= bVar.f64058e) ? -1 : 1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }
}
