package d.a.h0.g.r.b;

import android.util.Base64;
/* loaded from: classes3.dex */
public class d implements d.a.h0.g.r.c.d {
    @Override // d.a.h0.g.r.c.d
    public byte[] a(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return bArr;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 76158) {
            if (hashCode == 1952093519 && str.equals("BASE64")) {
                c2 = 1;
            }
        } else if (str.equals("MD5")) {
            c2 = 0;
        }
        if (c2 != 0) {
            return c2 != 1 ? bArr : Base64.encode(bArr, 2);
        }
        return d.a.h0.p.e.d(bArr, false).getBytes();
    }
}
