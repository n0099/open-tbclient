package d.b.j.d.a;

import java.security.InvalidKeyException;
/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: d  reason: collision with root package name */
    public byte[] f63701d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f63702e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f63703f;

    public d(b bVar) {
        super(bVar);
        this.f63703f = null;
        int i = this.f63713b;
        this.f63702e = new byte[i];
        this.f63701d = new byte[i];
    }

    @Override // d.b.j.d.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.f63713b) {
            throw new InvalidKeyException("Internal error");
        }
        this.f63714c = bArr2;
        c();
        this.f63712a.e(z, str, bArr);
    }

    @Override // d.b.j.d.a.f
    public void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + i;
        while (i < i4) {
            for (int i5 = 0; i5 < this.f63713b; i5++) {
                this.f63702e[i5] = (byte) (bArr[i5 + i] ^ this.f63701d[i5]);
            }
            this.f63712a.f(this.f63702e, 0, bArr2, i3);
            System.arraycopy(bArr2, i3, this.f63701d, 0, this.f63713b);
            int i6 = this.f63713b;
            i += i6;
            i3 += i6;
        }
    }

    @Override // d.b.j.d.a.f
    public void c() {
        System.arraycopy(this.f63714c, 0, this.f63701d, 0, this.f63713b);
    }

    @Override // d.b.j.d.a.f
    public void d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        int i5 = i2 + i;
        byte[] bArr3 = (bArr != bArr2 || i < i3 || i - i3 >= this.f63713b) ? null : (byte[]) bArr.clone();
        while (i < i5) {
            this.f63712a.j(bArr, i, this.f63702e, 0);
            int i6 = 0;
            while (true) {
                i4 = this.f63713b;
                if (i6 >= i4) {
                    break;
                }
                bArr2[i6 + i3] = (byte) (this.f63702e[i6] ^ this.f63701d[i6]);
                i6++;
            }
            byte[] bArr4 = this.f63701d;
            if (bArr3 == null) {
                System.arraycopy(bArr, i, bArr4, 0, i4);
            } else {
                System.arraycopy(bArr3, i, bArr4, 0, i4);
            }
            int i7 = this.f63713b;
            i += i7;
            i3 += i7;
        }
    }

    @Override // d.b.j.d.a.f
    public void e() {
        if (this.f63703f == null) {
            this.f63703f = new byte[this.f63713b];
        }
        System.arraycopy(this.f63701d, 0, this.f63703f, 0, this.f63713b);
    }

    @Override // d.b.j.d.a.f
    public void g() {
        System.arraycopy(this.f63703f, 0, this.f63701d, 0, this.f63713b);
    }
}
