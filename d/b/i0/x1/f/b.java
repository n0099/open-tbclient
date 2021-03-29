package d.b.i0.x1.f;
/* loaded from: classes3.dex */
public class b implements Comparable<b> {

    /* renamed from: e  reason: collision with root package name */
    public int f62373e;

    /* renamed from: f  reason: collision with root package name */
    public String f62374f;

    /* renamed from: g  reason: collision with root package name */
    public String f62375g;

    /* renamed from: h  reason: collision with root package name */
    public String f62376h;
    public int i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (this == bVar) {
            return 0;
        }
        return (bVar == null || this.f62373e <= bVar.f62373e) ? -1 : 1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }
}
