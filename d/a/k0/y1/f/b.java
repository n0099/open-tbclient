package d.a.k0.y1.f;
/* loaded from: classes4.dex */
public class b implements Comparable<b> {

    /* renamed from: e  reason: collision with root package name */
    public int f63478e;

    /* renamed from: f  reason: collision with root package name */
    public String f63479f;

    /* renamed from: g  reason: collision with root package name */
    public String f63480g;

    /* renamed from: h  reason: collision with root package name */
    public String f63481h;

    /* renamed from: i  reason: collision with root package name */
    public int f63482i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (this == bVar) {
            return 0;
        }
        return (bVar == null || this.f63478e <= bVar.f63478e) ? -1 : 1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }
}
