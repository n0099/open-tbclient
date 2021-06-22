package d.a.j.d.a;

import java.security.InvalidKeyException;
/* loaded from: classes2.dex */
public class d extends f {

    /* renamed from: d  reason: collision with root package name */
    public byte[] f43948d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f43949e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f43950f;

    public d(b bVar) {
        super(bVar);
        this.f43950f = null;
        int i2 = this.f43961b;
        this.f43949e = new byte[i2];
        this.f43948d = new byte[i2];
    }

    @Override // d.a.j.d.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.f43961b) {
            throw new InvalidKeyException("Internal error");
        }
        this.f43962c = bArr2;
        c();
        this.f43960a.e(z, str, bArr);
    }

    @Override // d.a.j.d.a.f
    public void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5 = i3 + i2;
        while (i2 < i5) {
            for (int i6 = 0; i6 < this.f43961b; i6++) {
                this.f43949e[i6] = (byte) (bArr[i6 + i2] ^ this.f43948d[i6]);
            }
            this.f43960a.f(this.f43949e, 0, bArr2, i4);
            System.arraycopy(bArr2, i4, this.f43948d, 0, this.f43961b);
            int i7 = this.f43961b;
            i2 += i7;
            i4 += i7;
        }
    }

    @Override // d.a.j.d.a.f
    public void c() {
        System.arraycopy(this.f43962c, 0, this.f43948d, 0, this.f43961b);
    }

    @Override // d.a.j.d.a.f
    public void d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5;
        int i6 = i3 + i2;
        byte[] bArr3 = (bArr != bArr2 || i2 < i4 || i2 - i4 >= this.f43961b) ? null : (byte[]) bArr.clone();
        while (i2 < i6) {
            this.f43960a.j(bArr, i2, this.f43949e, 0);
            int i7 = 0;
            while (true) {
                i5 = this.f43961b;
                if (i7 >= i5) {
                    break;
                }
                bArr2[i7 + i4] = (byte) (this.f43949e[i7] ^ this.f43948d[i7]);
                i7++;
            }
            byte[] bArr4 = this.f43948d;
            if (bArr3 == null) {
                System.arraycopy(bArr, i2, bArr4, 0, i5);
            } else {
                System.arraycopy(bArr3, i2, bArr4, 0, i5);
            }
            int i8 = this.f43961b;
            i2 += i8;
            i4 += i8;
        }
    }

    @Override // d.a.j.d.a.f
    public void e() {
        if (this.f43950f == null) {
            this.f43950f = new byte[this.f43961b];
        }
        System.arraycopy(this.f43948d, 0, this.f43950f, 0, this.f43961b);
    }

    @Override // d.a.j.d.a.f
    public void g() {
        System.arraycopy(this.f43950f, 0, this.f43948d, 0, this.f43961b);
    }
}
