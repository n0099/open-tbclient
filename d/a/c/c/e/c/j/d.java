package d.a.c.c.e.c.j;

import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.p.s;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f38371c;

    /* renamed from: a  reason: collision with root package name */
    public SecretKey f38372a = null;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f38373b = null;

    public static d a() {
        if (f38371c == null) {
            synchronized (d.class) {
                if (f38371c == null) {
                    f38371c = new d();
                }
            }
        }
        return f38371c;
    }

    public SecretKey b() {
        return this.f38372a;
    }

    public byte[] c() {
        return this.f38373b;
    }

    public void d(byte[] bArr) {
        try {
            PublicKey e2 = s.e(bArr);
            String g2 = s.g(32);
            byte[] bArr2 = new byte[g2.length()];
            for (int i2 = 0; i2 < g2.length(); i2++) {
                bArr2[i2] = (byte) g2.charAt(i2);
            }
            this.f38372a = s.f(g2);
            this.f38373b = s.d(e2, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.f38372a = null;
            this.f38373b = new byte[0];
        }
    }
}
