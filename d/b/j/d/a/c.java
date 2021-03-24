package d.b.j.d.a;

import java.security.SecureRandom;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final SecureRandom f63698b = new SecureRandom();

    /* renamed from: a  reason: collision with root package name */
    public e f63699a;

    public c() {
        this.f63699a = null;
        this.f63699a = new e(new b(), 16);
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

    public void a(int i, byte[] bArr, byte[] bArr2) {
        this.f63699a.c(i, bArr, bArr2, f63698b);
    }

    public final byte[] b(byte[] bArr) {
        if (bArr != null) {
            return this.f63699a.e(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
