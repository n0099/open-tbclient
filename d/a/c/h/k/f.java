package d.a.c.h.k;
/* loaded from: classes.dex */
public class f implements Comparable<f> {

    /* renamed from: e  reason: collision with root package name */
    public int f42839e;

    /* renamed from: f  reason: collision with root package name */
    public int f42840f;

    /* renamed from: g  reason: collision with root package name */
    public int f42841g;

    /* renamed from: h  reason: collision with root package name */
    public int f42842h;

    /* renamed from: i  reason: collision with root package name */
    public int f42843i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        int i2 = this.f42839e;
        int i3 = fVar.f42839e;
        if (i2 - i3 > 0) {
            return 1;
        }
        if (i2 - i3 < 0) {
            return -1;
        }
        int i4 = this.f42840f;
        int i5 = fVar.f42840f;
        if (i4 - i5 > 0) {
            return 1;
        }
        if (i4 - i5 < 0) {
            return -1;
        }
        int i6 = this.f42841g;
        int i7 = fVar.f42841g;
        if (i6 - i7 > 0) {
            return 1;
        }
        if (i6 - i7 < 0) {
            return -1;
        }
        int i8 = this.f42842h;
        int i9 = fVar.f42842h;
        if (i8 - i9 > 0) {
            return 1;
        }
        if (i8 - i9 < 0) {
            return -1;
        }
        int i10 = this.f42843i;
        int i11 = fVar.f42843i;
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
        this.f42839e = i2;
        this.f42840f = i3;
        this.f42841g = i4;
        this.f42842h = i5;
        this.f42843i = i6;
        this.j = i7;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && compareTo((f) obj) == 0;
    }

    public String toString() {
        return this.f42839e + "-" + this.f42840f + "-" + this.f42841g + " " + this.f42842h + ":" + this.f42843i + ":" + this.j;
    }
}
