package d.a.c.h.k;
/* loaded from: classes.dex */
public class f implements Comparable<f> {

    /* renamed from: e  reason: collision with root package name */
    public int f42942e;

    /* renamed from: f  reason: collision with root package name */
    public int f42943f;

    /* renamed from: g  reason: collision with root package name */
    public int f42944g;

    /* renamed from: h  reason: collision with root package name */
    public int f42945h;

    /* renamed from: i  reason: collision with root package name */
    public int f42946i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        int i2 = this.f42942e;
        int i3 = fVar.f42942e;
        if (i2 - i3 > 0) {
            return 1;
        }
        if (i2 - i3 < 0) {
            return -1;
        }
        int i4 = this.f42943f;
        int i5 = fVar.f42943f;
        if (i4 - i5 > 0) {
            return 1;
        }
        if (i4 - i5 < 0) {
            return -1;
        }
        int i6 = this.f42944g;
        int i7 = fVar.f42944g;
        if (i6 - i7 > 0) {
            return 1;
        }
        if (i6 - i7 < 0) {
            return -1;
        }
        int i8 = this.f42945h;
        int i9 = fVar.f42945h;
        if (i8 - i9 > 0) {
            return 1;
        }
        if (i8 - i9 < 0) {
            return -1;
        }
        int i10 = this.f42946i;
        int i11 = fVar.f42946i;
        if (i10 - i11 > 0) {
            return 1;
        }
        if (i10 - i11 < 0) {
            return -1;
        }
        int i12 = this.j;
        int i13 = fVar.j;
        if (i12 - i13 > 0) {
            return 1;
        }
        return i12 - i13 < 0 ? -1 : 0;
    }

    public final void b(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f42942e = i2;
        this.f42943f = i3;
        this.f42944g = i4;
        this.f42945h = i5;
        this.f42946i = i6;
        this.j = i7;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && compareTo((f) obj) == 0;
    }

    public String toString() {
        return this.f42942e + "-" + this.f42943f + "-" + this.f42944g + " " + this.f42945h + ":" + this.f42946i + ":" + this.j;
    }
}
