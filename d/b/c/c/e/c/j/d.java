package d.b.c.c.e.c.j;

import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.p.s;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f42273c;

    /* renamed from: a  reason: collision with root package name */
    public SecretKey f42274a = null;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f42275b = null;

    public static d a() {
        if (f42273c == null) {
            synchronized (d.class) {
                if (f42273c == null) {
                    f42273c = new d();
                }
            }
        }
        return f42273c;
    }

    public SecretKey b() {
        return this.f42274a;
    }

    public byte[] c() {
        return this.f42275b;
    }

    public void d(byte[] bArr) {
        try {
            PublicKey e2 = s.e(bArr);
            String g2 = s.g(32);
            byte[] bArr2 = new byte[g2.length()];
            for (int i = 0; i < g2.length(); i++) {
                bArr2[i] = (byte) g2.charAt(i);
            }
            this.f42274a = s.f(g2);
            this.f42275b = s.d(e2, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.f42274a = null;
            this.f42275b = new byte[0];
        }
    }
}
