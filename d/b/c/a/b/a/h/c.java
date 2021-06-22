package d.b.c.a.b.a.h;

import java.io.IOException;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f69174a = com.bytedance.sdk.a.a.f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f69175b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f69176c = new String[64];

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f69177d = new String[256];

    static {
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            String[] strArr = f69177d;
            if (i4 >= strArr.length) {
                break;
            }
            strArr[i4] = d.b.c.a.b.a.e.j("%8s", Integer.toBinaryString(i4)).replace(' ', '0');
            i4++;
        }
        String[] strArr2 = f69176c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i5 = 0; i5 < 1; i5++) {
            f69176c[iArr[i5] | 8] = f69176c[i2] + "|PADDED";
        }
        String[] strArr3 = f69176c;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = iArr2[i6];
            for (int i8 = 0; i8 < 1; i8++) {
                int i9 = iArr[i8];
                int i10 = i9 | i7;
                f69176c[i10] = f69176c[i9] + '|' + f69176c[i7];
                f69176c[i10 | 8] = f69176c[i9] + '|' + f69176c[i7] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = f69176c;
            if (i3 >= strArr4.length) {
                return;
            }
            if (strArr4[i3] == null) {
                strArr4[i3] = f69177d[i3];
            }
            i3++;
        }
    }

    public static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(d.b.c.a.b.a.e.j(str, objArr));
    }

    public static String b(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : f69177d[b3];
            } else if (b2 != 7 && b2 != 8) {
                String[] strArr = f69176c;
                String str = b3 < strArr.length ? strArr[b3] : f69177d[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f69177d[b3];
    }

    public static String c(boolean z, int i2, int i3, byte b2, byte b3) {
        String[] strArr = f69175b;
        String j = b2 < strArr.length ? strArr[b2] : d.b.c.a.b.a.e.j("0x%02x", Byte.valueOf(b2));
        String b4 = b(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = j;
        objArr[4] = b4;
        return d.b.c.a.b.a.e.j("%s 0x%08x %5d %-13s %s", objArr);
    }

    public static IOException d(String str, Object... objArr) throws IOException {
        throw new IOException(d.b.c.a.b.a.e.j(str, objArr));
    }
}
