package d.a.c.c.e.c.j;

import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.p.s;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f42024c;

    /* renamed from: a  reason: collision with root package name */
    public SecretKey f42025a = null;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f42026b = null;

    public static d a() {
        if (f42024c == null) {
            synchronized (d.class) {
                if (f42024c == null) {
                    f42024c = new d();
                }
            }
        }
        return f42024c;
    }

    public SecretKey b() {
        return this.f42025a;
    }

    public byte[] c() {
        return this.f42026b;
    }

    public void d(byte[] bArr) {
        try {
            PublicKey e2 = s.e(bArr);
            String g2 = s.g(32);
            byte[] bArr2 = new byte[g2.length()];
            for (int i2 = 0; i2 < g2.length(); i2++) {
                bArr2[i2] = (byte) g2.charAt(i2);
            }
            this.f42025a = s.f(g2);
            this.f42026b = s.d(e2, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.f42025a = null;
            this.f42026b = new byte[0];
        }
    }
}
