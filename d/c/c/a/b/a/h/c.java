package d.c.c.a.b.a.h;

import java.io.IOException;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f66141a = com.bytedance.sdk.a.a.f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f66142b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f66143c = new String[64];

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f66144d = new String[256];

    static {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = f66144d;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = d.c.c.a.b.a.e.j("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr2 = f66143c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i4 = 0; i4 < 1; i4++) {
            f66143c[iArr[i4] | 8] = f66143c[i] + "|PADDED";
        }
        String[] strArr3 = f66143c;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                int i9 = i8 | i6;
                f66143c[i9] = f66143c[i8] + '|' + f66143c[i6];
                f66143c[i9 | 8] = f66143c[i8] + '|' + f66143c[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = f66143c;
            if (i2 >= strArr4.length) {
                return;
            }
            if (strArr4[i2] == null) {
                strArr4[i2] = f66144d[i2];
            }
            i2++;
        }
    }

    public static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(d.c.c.a.b.a.e.j(str, objArr));
    }

    public static String b(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : f66144d[b3];
            } else if (b2 != 7 && b2 != 8) {
                String[] strArr = f66143c;
                String str = b3 < strArr.length ? strArr[b3] : f66144d[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f66144d[b3];
    }

    public static String c(boolean z, int i, int i2, byte b2, byte b3) {
        String[] strArr = f66142b;
        String j = b2 < strArr.length ? strArr[b2] : d.c.c.a.b.a.e.j("0x%02x", Byte.valueOf(b2));
        String b4 = b(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = j;
        objArr[4] = b4;
        return d.c.c.a.b.a.e.j("%s 0x%08x %5d %-13s %s", objArr);
    }

    public static IOException d(String str, Object... objArr) throws IOException {
        throw new IOException(d.c.c.a.b.a.e.j(str, objArr));
    }
}
