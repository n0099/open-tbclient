package d.b.b.c.e.c.j;

import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.p.s;
import java.security.PublicKey;
import javax.crypto.SecretKey;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static d f41535c;

    /* renamed from: a  reason: collision with root package name */
    public SecretKey f41536a = null;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f41537b = null;

    public static d a() {
        if (f41535c == null) {
            synchronized (d.class) {
                if (f41535c == null) {
                    f41535c = new d();
                }
            }
        }
        return f41535c;
    }

    public SecretKey b() {
        return this.f41536a;
    }

    public byte[] c() {
        return this.f41537b;
    }

    public void d(byte[] bArr) {
        try {
            PublicKey e2 = s.e(bArr);
            String g2 = s.g(32);
            byte[] bArr2 = new byte[g2.length()];
            for (int i = 0; i < g2.length(); i++) {
                bArr2[i] = (byte) g2.charAt(i);
            }
            this.f41536a = s.f(g2);
            this.f41537b = s.d(e2, bArr2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            this.f41536a = null;
            this.f41537b = new byte[0];
        }
    }
}
