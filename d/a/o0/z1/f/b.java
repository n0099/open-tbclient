package d.a.o0.z1.f;
/* loaded from: classes5.dex */
public class b implements Comparable<b> {

    /* renamed from: e  reason: collision with root package name */
    public int f67485e;

    /* renamed from: f  reason: collision with root package name */
    public String f67486f;

    /* renamed from: g  reason: collision with root package name */
    public String f67487g;

    /* renamed from: h  reason: collision with root package name */
    public String f67488h;

    /* renamed from: i  reason: collision with root package name */
    public int f67489i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (this == bVar) {
            return 0;
        }
        return (bVar == null || this.f67485e <= bVar.f67485e) ? -1 : 1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }
}
