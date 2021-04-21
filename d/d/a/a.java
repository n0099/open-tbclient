package d.d.a;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f66851a;

    /* renamed from: b  reason: collision with root package name */
    public long f66852b;

    public a(boolean z, long j, int i) {
        this.f66852b = j;
        this.f66851a = i;
    }

    public static a b(String str, int i, int i2) {
        long j;
        int i3;
        if (i >= i2) {
            return null;
        }
        long j2 = 0;
        int i4 = i;
        while (i4 < i2) {
            char charAt = str.charAt(i4);
            if (charAt < '0' || charAt > '9') {
                if (charAt >= 'A' && charAt <= 'F') {
                    j = j2 * 16;
                    i3 = charAt - 'A';
                } else if (charAt < 'a' || charAt > 'f') {
                    break;
                } else {
                    j = j2 * 16;
                    i3 = charAt - 'a';
                }
                j2 = j + i3 + 10;
            } else {
                j2 = (j2 * 16) + (charAt - '0');
            }
            if (j2 > 4294967295L) {
                return null;
            }
            i4++;
        }
        if (i4 == i) {
            return null;
        }
        return new a(false, j2, i4);
    }

    public int a() {
        return this.f66851a;
    }

    public int c() {
        return (int) this.f66852b;
    }
}
