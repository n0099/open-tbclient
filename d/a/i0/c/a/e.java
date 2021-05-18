package d.a.i0.c.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.bdtls.AES;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f46280a;

    public static int a(byte[] bArr) {
        if (bArr != null) {
            int i2 = 0;
            for (byte b2 : bArr) {
                i2 = (i2 << 8) | (b2 & 255);
            }
            return i2;
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: char */
    /* JADX WARN: Multi-variable type inference failed */
    public static String d(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(bArr[i2] > 0 ? bArr[i2] : bArr[i2] & 255);
            sb.append(",");
        }
        return sb.toString();
    }

    public static e f() {
        if (f46280a == null) {
            synchronized (e.class) {
                if (f46280a == null) {
                    f46280a = new e();
                }
            }
        }
        return f46280a;
    }

    public static byte[] g(int i2) {
        return new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
    }

    public byte[] b(d.a.i0.c.a.i.g gVar, String str) {
        if (gVar == null) {
            return null;
        }
        try {
            d.a.i0.c.a.i.e a2 = d.a.i0.c.a.i.e.j.a();
            a2.r((byte) 23);
            byte[] i2 = gVar.i();
            if (i2 != null && i2.length > 0 && i2.length <= 32767) {
                a2.q((short) i2.length);
                a2.o(i2);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] aesEncrypt = AES.aesEncrypt(str, gVar.c());
                a2.k(aesEncrypt.length);
                a2.j(aesEncrypt);
            }
            a2.l(d.a.i0.n.j.j.b.c().b().longValue());
            return d.a.i0.c.a.j.b.b(a2);
        } catch (Exception e2) {
            if (a.f46273a) {
                e2.printStackTrace();
                Log.d("BDTLS", "exception=" + e2.getMessage());
                return null;
            }
            return null;
        }
    }

    public d.a.i0.c.a.i.f c(d.a.i0.c.a.i.g gVar, byte[] bArr) {
        d.a.i0.c.a.i.f fVar = new d.a.i0.c.a.i.f();
        try {
            d.a.i0.c.a.i.e a2 = d.a.i0.c.a.j.b.a(bArr);
            byte i2 = a2.i();
            if (i2 == 21) {
                Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(a2.f());
                if (parseFrom != null) {
                    String str = new String(parseFrom.getDescription().toByteArray());
                    if (a.f46273a) {
                        Log.d("BDTLS", "bdtls ubc application alert : " + str);
                    }
                    f.b(gVar, parseFrom);
                    if (1 == parseFrom.getLevel()) {
                        fVar.d(-2);
                    } else if (TextUtils.equals(str, "down grade")) {
                        fVar.d(2);
                    } else {
                        fVar.d(-1);
                    }
                    if (a.f46273a) {
                        if (parseFrom.getDescription() != null) {
                            if (a.f46273a) {
                                Log.d("BDTLS", "BdtlsPostRequest response alert message=" + str);
                            }
                        } else if (a.f46273a) {
                            Log.d("BDTLS", "BdtlsPostRequest response alert messag=null");
                        }
                    }
                } else {
                    fVar.d(-1);
                }
            } else if (i2 == 23) {
                fVar.c(new String(AES.aesDecrypt(a2.a(), gVar.c())));
                fVar.d(1);
            }
        } catch (Exception e2) {
            if (a.f46273a) {
                e2.printStackTrace();
                Log.d("BDTLS", "exception=" + e2.getMessage());
            }
            fVar.d(-1);
        }
        return fVar;
    }

    public byte[] e(d.a.i0.c.a.i.g gVar) {
        if (gVar == null) {
            return null;
        }
        try {
            byte[] b2 = d.a.i0.c.a.j.a.b(gVar, new d.a.i0.c.a.i.d());
            if (b2 == null) {
                return null;
            }
            d.a.i0.c.a.i.e a2 = d.a.i0.c.a.i.e.j.a();
            a2.r((byte) 22);
            a2.q((short) b2.length);
            a2.l(d.a.i0.n.j.j.b.c().b().longValue());
            a2.o(b2);
            return d.a.i0.c.a.j.b.b(a2);
        } catch (Exception e2) {
            if (a.f46273a) {
                e2.printStackTrace();
                Log.d("BDTLS", "exception=" + e2.getMessage());
            }
            return null;
        }
    }
}
