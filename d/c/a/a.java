package d.c.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f65258a;

    /* renamed from: b  reason: collision with root package name */
    public long f65259b;

    public a(boolean z, long j, int i2) {
        this.f65259b = j;
        this.f65258a = i2;
    }

    public static a b(String str, int i2, int i3) {
        long j;
        int i4;
        if (i2 >= i3) {
            return null;
        }
        long j2 = 0;
        int i5 = i2;
        while (i5 < i3) {
            char charAt = str.charAt(i5);
            if (charAt < '0' || charAt > '9') {
                if (charAt >= 'A' && charAt <= 'F') {
                    j = j2 * 16;
                    i4 = charAt - 'A';
                } else if (charAt < 'a' || charAt > 'f') {
                    break;
                } else {
                    j = j2 * 16;
                    i4 = charAt - 'a';
                }
                j2 = j + i4 + 10;
            } else {
                j2 = (j2 * 16) + (charAt - '0');
            }
            if (j2 > 4294967295L) {
                return null;
            }
            i5++;
        }
        if (i5 == i2) {
            return null;
        }
        return new a(false, j2, i5);
    }

    public int a() {
        return this.f65258a;
    }

    public int c() {
        return (int) this.f65259b;
    }
}
