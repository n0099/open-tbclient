package d.a.c.h.k;
/* loaded from: classes.dex */
public class f implements Comparable<f> {

    /* renamed from: e  reason: collision with root package name */
    public int f39522e;

    /* renamed from: f  reason: collision with root package name */
    public int f39523f;

    /* renamed from: g  reason: collision with root package name */
    public int f39524g;

    /* renamed from: h  reason: collision with root package name */
    public int f39525h;

    /* renamed from: i  reason: collision with root package name */
    public int f39526i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        int i2 = this.f39522e;
        int i3 = fVar.f39522e;
        if (i2 - i3 > 0) {
            return 1;
        }
        if (i2 - i3 < 0) {
            return -1;
        }
        int i4 = this.f39523f;
        int i5 = fVar.f39523f;
        if (i4 - i5 > 0) {
            return 1;
        }
        if (i4 - i5 < 0) {
            return -1;
        }
        int i6 = this.f39524g;
        int i7 = fVar.f39524g;
        if (i6 - i7 > 0) {
            return 1;
        }
        if (i6 - i7 < 0) {
            return -1;
        }
        int i8 = this.f39525h;
        int i9 = fVar.f39525h;
        if (i8 - i9 > 0) {
            return 1;
        }
        if (i8 - i9 < 0) {
            return -1;
        }
        int i10 = this.f39526i;
        int i11 = fVar.f39526i;
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
        this.f39522e = i2;
        this.f39523f = i3;
        this.f39524g = i4;
        this.f39525h = i5;
        this.f39526i = i6;
        this.j = i7;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && compareTo((f) obj) == 0;
    }

    public String toString() {
        return this.f39522e + "-" + this.f39523f + "-" + this.f39524g + " " + this.f39525h + ":" + this.f39526i + ":" + this.j;
    }
}
