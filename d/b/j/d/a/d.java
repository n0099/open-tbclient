package d.b.j.d.a;

import java.security.InvalidKeyException;
/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: d  reason: collision with root package name */
    public byte[] f52596d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f52597e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f52598f;

    public d(b bVar) {
        super(bVar);
        this.f52598f = null;
        int i = this.f52608b;
        this.f52597e = new byte[i];
        this.f52596d = new byte[i];
    }

    @Override // d.b.j.d.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.f52608b) {
            throw new InvalidKeyException("Internal error");
        }
        this.f52609c = bArr2;
        c();
        this.f52607a.e(z, str, bArr);
    }

    @Override // d.b.j.d.a.f
    public void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + i;
        while (i < i4) {
            for (int i5 = 0; i5 < this.f52608b; i5++) {
                this.f52597e[i5] = (byte) (bArr[i5 + i] ^ this.f52596d[i5]);
            }
            this.f52607a.f(this.f52597e, 0, bArr2, i3);
            System.arraycopy(bArr2, i3, this.f52596d, 0, this.f52608b);
            int i6 = this.f52608b;
            i += i6;
            i3 += i6;
        }
    }

    @Override // d.b.j.d.a.f
    public void c() {
        System.arraycopy(this.f52609c, 0, this.f52596d, 0, this.f52608b);
    }

    @Override // d.b.j.d.a.f
    public void d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        int i5 = i2 + i;
        byte[] bArr3 = (bArr != bArr2 || i < i3 || i - i3 >= this.f52608b) ? null : (byte[]) bArr.clone();
        while (i < i5) {
            this.f52607a.j(bArr, i, this.f52597e, 0);
            int i6 = 0;
            while (true) {
                i4 = this.f52608b;
                if (i6 >= i4) {
                    break;
                }
                bArr2[i6 + i3] = (byte) (this.f52597e[i6] ^ this.f52596d[i6]);
                i6++;
            }
            byte[] bArr4 = this.f52596d;
            if (bArr3 == null) {
                System.arraycopy(bArr, i, bArr4, 0, i4);
            } else {
                System.arraycopy(bArr3, i, bArr4, 0, i4);
            }
            int i7 = this.f52608b;
            i += i7;
            i3 += i7;
        }
    }

    @Override // d.b.j.d.a.f
    public void e() {
        if (this.f52598f == null) {
            this.f52598f = new byte[this.f52608b];
        }
        System.arraycopy(this.f52596d, 0, this.f52598f, 0, this.f52608b);
    }

    @Override // d.b.j.d.a.f
    public void g() {
        System.arraycopy(this.f52598f, 0, this.f52596d, 0, this.f52608b);
    }
}
