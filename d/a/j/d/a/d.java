package d.a.j.d.a;

import java.security.InvalidKeyException;
/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: d  reason: collision with root package name */
    public byte[] f50279d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f50280e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f50281f;

    public d(b bVar) {
        super(bVar);
        this.f50281f = null;
        int i2 = this.f50292b;
        this.f50280e = new byte[i2];
        this.f50279d = new byte[i2];
    }

    @Override // d.a.j.d.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.f50292b) {
            throw new InvalidKeyException("Internal error");
        }
        this.f50293c = bArr2;
        c();
        this.f50291a.e(z, str, bArr);
    }

    @Override // d.a.j.d.a.f
    public void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5 = i3 + i2;
        while (i2 < i5) {
            for (int i6 = 0; i6 < this.f50292b; i6++) {
                this.f50280e[i6] = (byte) (bArr[i6 + i2] ^ this.f50279d[i6]);
            }
            this.f50291a.f(this.f50280e, 0, bArr2, i4);
            System.arraycopy(bArr2, i4, this.f50279d, 0, this.f50292b);
            int i7 = this.f50292b;
            i2 += i7;
            i4 += i7;
        }
    }

    @Override // d.a.j.d.a.f
    public void c() {
        System.arraycopy(this.f50293c, 0, this.f50279d, 0, this.f50292b);
    }

    @Override // d.a.j.d.a.f
    public void d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5;
        int i6 = i3 + i2;
        byte[] bArr3 = (bArr != bArr2 || i2 < i4 || i2 - i4 >= this.f50292b) ? null : (byte[]) bArr.clone();
        while (i2 < i6) {
            this.f50291a.j(bArr, i2, this.f50280e, 0);
            int i7 = 0;
            while (true) {
                i5 = this.f50292b;
                if (i7 >= i5) {
                    break;
                }
                bArr2[i7 + i4] = (byte) (this.f50280e[i7] ^ this.f50279d[i7]);
                i7++;
            }
            byte[] bArr4 = this.f50279d;
            if (bArr3 == null) {
                System.arraycopy(bArr, i2, bArr4, 0, i5);
            } else {
                System.arraycopy(bArr3, i2, bArr4, 0, i5);
            }
            int i8 = this.f50292b;
            i2 += i8;
            i4 += i8;
        }
    }

    @Override // d.a.j.d.a.f
    public void e() {
        if (this.f50281f == null) {
            this.f50281f = new byte[this.f50292b];
        }
        System.arraycopy(this.f50279d, 0, this.f50281f, 0, this.f50292b);
    }

    @Override // d.a.j.d.a.f
    public void g() {
        System.arraycopy(this.f50281f, 0, this.f50279d, 0, this.f50292b);
    }
}
