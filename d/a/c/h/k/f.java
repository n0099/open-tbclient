package d.a.c.h.k;
/* loaded from: classes.dex */
public class f implements Comparable<f> {

    /* renamed from: e  reason: collision with root package name */
    public int f40277e;

    /* renamed from: f  reason: collision with root package name */
    public int f40278f;

    /* renamed from: g  reason: collision with root package name */
    public int f40279g;

    /* renamed from: h  reason: collision with root package name */
    public int f40280h;

    /* renamed from: i  reason: collision with root package name */
    public int f40281i;
    public int j;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        int i2 = this.f40277e;
        int i3 = fVar.f40277e;
        if (i2 - i3 > 0) {
            return 1;
        }
        if (i2 - i3 < 0) {
            return -1;
        }
        int i4 = this.f40278f;
        int i5 = fVar.f40278f;
        if (i4 - i5 > 0) {
            return 1;
        }
        if (i4 - i5 < 0) {
            return -1;
        }
        int i6 = this.f40279g;
        int i7 = fVar.f40279g;
        if (i6 - i7 > 0) {
            return 1;
        }
        if (i6 - i7 < 0) {
            return -1;
        }
        int i8 = this.f40280h;
        int i9 = fVar.f40280h;
        if (i8 - i9 > 0) {
            return 1;
        }
        if (i8 - i9 < 0) {
            return -1;
        }
        int i10 = this.f40281i;
        int i11 = fVar.f40281i;
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
        this.f40277e = i2;
        this.f40278f = i3;
        this.f40279g = i4;
        this.f40280h = i5;
        this.f40281i = i6;
        this.j = i7;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && compareTo((f) obj) == 0;
    }

    public String toString() {
        return this.f40277e + "-" + this.f40278f + "-" + this.f40279g + " " + this.f40280h + ":" + this.f40281i + ":" + this.j;
    }
}
