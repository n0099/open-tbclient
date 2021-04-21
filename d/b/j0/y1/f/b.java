package d.b.j0.y1.f;
/* loaded from: classes3.dex */
public class b implements Comparable<b> {

    /* renamed from: e  reason: collision with root package name */
    public int f64479e;

    /* renamed from: f  reason: collision with root package name */
    public String f64480f;

    /* renamed from: g  reason: collision with root package name */
    public String f64481g;

    /* renamed from: h  reason: collision with root package name */
    public String f64482h;
    public int i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (this == bVar) {
            return 0;
        }
        return (bVar == null || this.f64479e <= bVar.f64479e) ? -1 : 1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }
}
