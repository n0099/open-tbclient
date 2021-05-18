package d.a.c.c.e.c.j;

import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.p.s;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f38707c;

    /* renamed from: a  reason: collision with root package name */
    public SecretKey f38708a = null;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f38709b = null;

    public static d a() {
        if (f38707c == null) {
            synchronized (d.class) {
                if (f38707c == null) {
                    f38707c = new d();
                }
            }
        }
        return f38707c;
    }

    public SecretKey b() {
        return this.f38708a;
    }

    public byte[] c() {
        return this.f38709b;
    }

    public void d(byte[] bArr) {
        try {
            PublicKey e2 = s.e(bArr);
            String g2 = s.g(32);
            byte[] bArr2 = new byte[g2.length()];
            for (int i2 = 0; i2 < g2.length(); i2++) {
                bArr2[i2] = (byte) g2.charAt(i2);
            }
            this.f38708a = s.f(g2);
            this.f38709b = s.d(e2, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.f38708a = null;
            this.f38709b = new byte[0];
        }
    }
}
