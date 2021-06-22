package d.a.c.c.e.c.j;

import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.p.s;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f42127c;

    /* renamed from: a  reason: collision with root package name */
    public SecretKey f42128a = null;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f42129b = null;

    public static d a() {
        if (f42127c == null) {
            synchronized (d.class) {
                if (f42127c == null) {
                    f42127c = new d();
                }
            }
        }
        return f42127c;
    }

    public SecretKey b() {
        return this.f42128a;
    }

    public byte[] c() {
        return this.f42129b;
    }

    public void d(byte[] bArr) {
        try {
            PublicKey e2 = s.e(bArr);
            String g2 = s.g(32);
            byte[] bArr2 = new byte[g2.length()];
            for (int i2 = 0; i2 < g2.length(); i2++) {
                bArr2[i2] = (byte) g2.charAt(i2);
            }
            this.f42128a = s.f(g2);
            this.f42129b = s.d(e2, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.f42128a = null;
            this.f42129b = new byte[0];
        }
    }
}
