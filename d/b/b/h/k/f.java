package d.b.b.h.k;
/* loaded from: classes.dex */
public class f implements Comparable<f> {

    /* renamed from: e  reason: collision with root package name */
    public int f42319e;

    /* renamed from: f  reason: collision with root package name */
    public int f42320f;

    /* renamed from: g  reason: collision with root package name */
    public int f42321g;

    /* renamed from: h  reason: collision with root package name */
    public int f42322h;
    public int i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        int i = this.f42319e;
        int i2 = fVar.f42319e;
        if (i - i2 > 0) {
            return 1;
        }
        if (i - i2 < 0) {
            return -1;
        }
        int i3 = this.f42320f;
        int i4 = fVar.f42320f;
        if (i3 - i4 > 0) {
            return 1;
        }
        if (i3 - i4 < 0) {
            return -1;
        }
        int i5 = this.f42321g;
        int i6 = fVar.f42321g;
        if (i5 - i6 > 0) {
            return 1;
        }
        if (i5 - i6 < 0) {
            return -1;
        }
        int i7 = this.f42322h;
        int i8 = fVar.f42322h;
        if (i7 - i8 > 0) {
            return 1;
        }
        if (i7 - i8 < 0) {
            return -1;
        }
        int i9 = this.i;
        int i10 = fVar.i;
        if (i9 - i10 > 0) {
            return 1;
        }
        if (i9 - i10 < 0) {
            return -1;
        }
        int i11 = this.j;
        int i12 = fVar.j;
        if (i11 - i12 > 0) {
            return 1;
        }
        return i11 - i12 < 0 ? -1 : 0;
    }

    public final void b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f42319e = i;
        this.f42320f = i2;
        this.f42321g = i3;
        this.f42322h = i4;
        this.i = i5;
        this.j = i6;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && compareTo((f) obj) == 0;
    }

    public String toString() {
        return this.f42319e + "-" + this.f42320f + "-" + this.f42321g + " " + this.f42322h + ":" + this.i + ":" + this.j;
    }
}
