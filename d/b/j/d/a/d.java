package d.b.j.d.a;

import java.security.InvalidKeyException;
/* loaded from: classes2.dex */
public class d extends f {

    /* renamed from: d  reason: collision with root package name */
    public byte[] f63700d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f63701e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f63702f;

    public d(b bVar) {
        super(bVar);
        this.f63702f = null;
        int i = this.f63712b;
        this.f63701e = new byte[i];
        this.f63700d = new byte[i];
    }

    @Override // d.b.j.d.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.f63712b) {
            throw new InvalidKeyException("Internal error");
        }
        this.f63713c = bArr2;
        c();
        this.f63711a.e(z, str, bArr);
    }

    @Override // d.b.j.d.a.f
    public void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + i;
        while (i < i4) {
            for (int i5 = 0; i5 < this.f63712b; i5++) {
                this.f63701e[i5] = (byte) (bArr[i5 + i] ^ this.f63700d[i5]);
            }
            this.f63711a.f(this.f63701e, 0, bArr2, i3);
            System.arraycopy(bArr2, i3, this.f63700d, 0, this.f63712b);
            int i6 = this.f63712b;
            i += i6;
            i3 += i6;
        }
    }

    @Override // d.b.j.d.a.f
    public void c() {
        System.arraycopy(this.f63713c, 0, this.f63700d, 0, this.f63712b);
    }

    @Override // d.b.j.d.a.f
    public void d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        int i5 = i2 + i;
        byte[] bArr3 = (bArr != bArr2 || i < i3 || i - i3 >= this.f63712b) ? null : (byte[]) bArr.clone();
        while (i < i5) {
            this.f63711a.j(bArr, i, this.f63701e, 0);
            int i6 = 0;
            while (true) {
                i4 = this.f63712b;
                if (i6 >= i4) {
                    break;
                }
                bArr2[i6 + i3] = (byte) (this.f63701e[i6] ^ this.f63700d[i6]);
                i6++;
            }
            byte[] bArr4 = this.f63700d;
            if (bArr3 == null) {
                System.arraycopy(bArr, i, bArr4, 0, i4);
            } else {
                System.arraycopy(bArr3, i, bArr4, 0, i4);
            }
            int i7 = this.f63712b;
            i += i7;
            i3 += i7;
        }
    }

    @Override // d.b.j.d.a.f
    public void e() {
        if (this.f63702f == null) {
            this.f63702f = new byte[this.f63712b];
        }
        System.arraycopy(this.f63700d, 0, this.f63702f, 0, this.f63712b);
    }

    @Override // d.b.j.d.a.f
    public void g() {
        System.arraycopy(this.f63702f, 0, this.f63700d, 0, this.f63712b);
    }
}
