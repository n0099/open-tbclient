package d.a.h0.g.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.bdtls.AES;
import com.baidu.swan.games.bdtls.model.Bdtls$Alert;
import d.a.h0.g.d.g.g;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f46220a;

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

    public static d f() {
        if (f46220a == null) {
            synchronized (d.class) {
                if (f46220a == null) {
                    f46220a = new d();
                }
            }
        }
        return f46220a;
    }

    public static byte[] g(int i2) {
        return new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
    }

    public byte[] b(g gVar, String str) {
        if (gVar == null) {
            return null;
        }
        try {
            d.a.h0.g.d.g.e a2 = d.a.h0.g.d.g.e.f46234i.a();
            a2.p((byte) 23);
            byte[] i2 = gVar.i();
            if (i2 != null && i2.length > 0 && i2.length <= 32767) {
                a2.o((short) i2.length);
                a2.m(i2);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] b2 = AES.b(str, gVar.c());
                a2.j(b2.length);
                a2.i(b2);
            }
            return d.a.h0.g.d.h.b.b(a2);
        } catch (Exception e2) {
            if (a.f46216a) {
                e2.printStackTrace();
                Log.d("BDTLS", "exception=" + e2.getMessage());
                return null;
            }
            return null;
        }
    }

    public d.a.h0.g.d.g.f c(g gVar, byte[] bArr) {
        d.a.h0.g.d.g.f fVar = new d.a.h0.g.d.g.f();
        try {
            d.a.h0.g.d.g.e a2 = d.a.h0.g.d.h.b.a(bArr);
            byte h2 = a2.h();
            if (h2 == 21) {
                Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(a2.e());
                if (parseFrom != null) {
                    String str = new String(parseFrom.getDescription().toByteArray());
                    if (a.f46216a) {
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
                    if (a.f46216a) {
                        if (parseFrom.getDescription() != null) {
                            if (a.f46216a) {
                                Log.d("BDTLS", "BdtlsPostRequest response alert message=" + str);
                            }
                        } else if (a.f46216a) {
                            Log.d("BDTLS", "BdtlsPostRequest response alert messag=null");
                        }
                    }
                } else {
                    fVar.d(-1);
                }
            } else if (h2 == 23) {
                fVar.c(new String(AES.a(a2.a(), gVar.c())));
                fVar.d(1);
            }
        } catch (Exception e2) {
            if (a.f46216a) {
                e2.printStackTrace();
                Log.d("BDTLS", "exception=" + e2.getMessage());
            }
            fVar.d(-1);
        }
        return fVar;
    }

    public byte[] e(g gVar) {
        if (gVar == null) {
            return null;
        }
        try {
            byte[] b2 = d.a.h0.g.d.h.a.b(gVar, new d.a.h0.g.d.g.d());
            if (b2 == null) {
                return null;
            }
            d.a.h0.g.d.g.e a2 = d.a.h0.g.d.g.e.f46234i.a();
            a2.p((byte) 22);
            a2.o((short) b2.length);
            a2.m(b2);
            return d.a.h0.g.d.h.b.b(a2);
        } catch (Exception e2) {
            if (a.f46216a) {
                e2.printStackTrace();
                Log.d("BDTLS", "exception=" + e2.getMessage());
            }
            return null;
        }
    }
}
