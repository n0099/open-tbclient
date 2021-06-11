package d.a.j.d.a;

import java.security.InvalidKeyException;
/* loaded from: classes2.dex */
public class d extends f {

    /* renamed from: d  reason: collision with root package name */
    public byte[] f43845d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f43846e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f43847f;

    public d(b bVar) {
        super(bVar);
        this.f43847f = null;
        int i2 = this.f43858b;
        this.f43846e = new byte[i2];
        this.f43845d = new byte[i2];
    }

    @Override // d.a.j.d.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.f43858b) {
            throw new InvalidKeyException("Internal error");
        }
        this.f43859c = bArr2;
        c();
        this.f43857a.e(z, str, bArr);
    }

    @Override // d.a.j.d.a.f
    public void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5 = i3 + i2;
        while (i2 < i5) {
            for (int i6 = 0; i6 < this.f43858b; i6++) {
                this.f43846e[i6] = (byte) (bArr[i6 + i2] ^ this.f43845d[i6]);
            }
            this.f43857a.f(this.f43846e, 0, bArr2, i4);
            System.arraycopy(bArr2, i4, this.f43845d, 0, this.f43858b);
            int i7 = this.f43858b;
            i2 += i7;
            i4 += i7;
        }
    }

    @Override // d.a.j.d.a.f
    public void c() {
        System.arraycopy(this.f43859c, 0, this.f43845d, 0, this.f43858b);
    }

    @Override // d.a.j.d.a.f
    public void d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5;
        int i6 = i3 + i2;
        byte[] bArr3 = (bArr != bArr2 || i2 < i4 || i2 - i4 >= this.f43858b) ? null : (byte[]) bArr.clone();
        while (i2 < i6) {
            this.f43857a.j(bArr, i2, this.f43846e, 0);
            int i7 = 0;
            while (true) {
                i5 = this.f43858b;
                if (i7 >= i5) {
                    break;
                }
                bArr2[i7 + i4] = (byte) (this.f43846e[i7] ^ this.f43845d[i7]);
                i7++;
            }
            byte[] bArr4 = this.f43845d;
            if (bArr3 == null) {
                System.arraycopy(bArr, i2, bArr4, 0, i5);
            } else {
                System.arraycopy(bArr3, i2, bArr4, 0, i5);
            }
            int i8 = this.f43858b;
            i2 += i8;
            i4 += i8;
        }
    }

    @Override // d.a.j.d.a.f
    public void e() {
        if (this.f43847f == null) {
            this.f43847f = new byte[this.f43858b];
        }
        System.arraycopy(this.f43845d, 0, this.f43847f, 0, this.f43858b);
    }

    @Override // d.a.j.d.a.f
    public void g() {
        System.arraycopy(this.f43847f, 0, this.f43845d, 0, this.f43858b);
    }
}
