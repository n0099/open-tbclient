package d.a.n0.z1.f;
/* loaded from: classes4.dex */
public class b implements Comparable<b> {

    /* renamed from: e  reason: collision with root package name */
    public int f67360e;

    /* renamed from: f  reason: collision with root package name */
    public String f67361f;

    /* renamed from: g  reason: collision with root package name */
    public String f67362g;

    /* renamed from: h  reason: collision with root package name */
    public String f67363h;

    /* renamed from: i  reason: collision with root package name */
    public int f67364i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (this == bVar) {
            return 0;
        }
        return (bVar == null || this.f67360e <= bVar.f67360e) ? -1 : 1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }
}
