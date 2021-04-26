package d.a.j0.y1.f;
/* loaded from: classes3.dex */
public class b implements Comparable<b> {

    /* renamed from: e  reason: collision with root package name */
    public int f62754e;

    /* renamed from: f  reason: collision with root package name */
    public String f62755f;

    /* renamed from: g  reason: collision with root package name */
    public String f62756g;

    /* renamed from: h  reason: collision with root package name */
    public String f62757h;

    /* renamed from: i  reason: collision with root package name */
    public int f62758i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (this == bVar) {
            return 0;
        }
        return (bVar == null || this.f62754e <= bVar.f62754e) ? -1 : 1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }
}
