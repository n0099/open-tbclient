package d.b.g0.g.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.bdtls.AES;
import com.baidu.swan.games.bdtls.model.Bdtls$Alert;
import d.b.g0.g.d.g.g;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f48032a;

    public static int a(byte[] bArr) {
        if (bArr != null) {
            int i = 0;
            for (byte b2 : bArr) {
                i = (i << 8) | (b2 & 255);
            }
            return i;
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: char */
    /* JADX WARN: Multi-variable type inference failed */
    public static String d(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(bArr[i] > 0 ? bArr[i] : bArr[i] & 255);
            sb.append(",");
        }
        return sb.toString();
    }

    public static d f() {
        if (f48032a == null) {
            synchronized (d.class) {
                if (f48032a == null) {
                    f48032a = new d();
                }
            }
        }
        return f48032a;
    }

    public static byte[] g(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public byte[] b(g gVar, String str) {
        if (gVar == null) {
            return null;
        }
        try {
            d.b.g0.g.d.g.e a2 = d.b.g0.g.d.g.e.i.a();
            a2.p((byte) 23);
            byte[] i = gVar.i();
            if (i != null && i.length > 0 && i.length <= 32767) {
                a2.o((short) i.length);
                a2.m(i);
            }
            if (!TextUtils.isEmpty(str)) {
                byte[] b2 = AES.b(str, gVar.c());
                a2.j(b2.length);
                a2.i(b2);
            }
            return d.b.g0.g.d.h.b.b(a2);
        } catch (Exception e2) {
            if (a.f48028a) {
                e2.printStackTrace();
                Log.d("BDTLS", "exception=" + e2.getMessage());
                return null;
            }
            return null;
        }
    }

    public d.b.g0.g.d.g.f c(g gVar, byte[] bArr) {
        d.b.g0.g.d.g.f fVar = new d.b.g0.g.d.g.f();
        try {
            d.b.g0.g.d.g.e a2 = d.b.g0.g.d.h.b.a(bArr);
            byte h2 = a2.h();
            if (h2 == 21) {
                Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(a2.e());
                if (parseFrom != null) {
                    String str = new String(parseFrom.getDescription().toByteArray());
                    if (a.f48028a) {
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
                    if (a.f48028a) {
                        if (parseFrom.getDescription() != null) {
                            if (a.f48028a) {
                                Log.d("BDTLS", "BdtlsPostRequest response alert message=" + str);
                            }
                        } else if (a.f48028a) {
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
            if (a.f48028a) {
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
            byte[] b2 = d.b.g0.g.d.h.a.b(gVar, new d.b.g0.g.d.g.d());
            if (b2 == null) {
                return null;
            }
            d.b.g0.g.d.g.e a2 = d.b.g0.g.d.g.e.i.a();
            a2.p((byte) 22);
            a2.o((short) b2.length);
            a2.m(b2);
            return d.b.g0.g.d.h.b.b(a2);
        } catch (Exception e2) {
            if (a.f48028a) {
                e2.printStackTrace();
                Log.d("BDTLS", "exception=" + e2.getMessage());
            }
            return null;
        }
    }
}
