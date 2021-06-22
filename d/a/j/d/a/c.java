package d.a.j.d.a;

import java.security.SecureRandom;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final SecureRandom f43946b = new SecureRandom();

    /* renamed from: a  reason: collision with root package name */
    public e f43947a;

    public c() {
        this.f43947a = null;
        this.f43947a = new e(new b(), 16);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        c cVar = new c();
        cVar.a(1, bArr, bArr2);
        return cVar.b(bArr3);
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        c cVar = new c();
        cVar.a(2, bArr, bArr2);
        return cVar.b(bArr3);
    }

    public void a(int i2, byte[] bArr, byte[] bArr2) {
        this.f43947a.c(i2, bArr, bArr2, f43946b);
    }

    public final byte[] b(byte[] bArr) {
        if (bArr != null) {
            return this.f43947a.e(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
