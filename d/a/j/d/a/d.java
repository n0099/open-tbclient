package d.a.j.d.a;

import java.security.InvalidKeyException;
/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: d  reason: collision with root package name */
    public byte[] f48500d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f48501e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f48502f;

    public d(b bVar) {
        super(bVar);
        this.f48502f = null;
        int i2 = this.f48513b;
        this.f48501e = new byte[i2];
        this.f48500d = new byte[i2];
    }

    @Override // d.a.j.d.a.f
    public void a(boolean z, String str, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length != this.f48513b) {
            throw new InvalidKeyException("Internal error");
        }
        this.f48514c = bArr2;
        c();
        this.f48512a.e(z, str, bArr);
    }

    @Override // d.a.j.d.a.f
    public void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5 = i3 + i2;
        while (i2 < i5) {
            for (int i6 = 0; i6 < this.f48513b; i6++) {
                this.f48501e[i6] = (byte) (bArr[i6 + i2] ^ this.f48500d[i6]);
            }
            this.f48512a.f(this.f48501e, 0, bArr2, i4);
            System.arraycopy(bArr2, i4, this.f48500d, 0, this.f48513b);
            int i7 = this.f48513b;
            i2 += i7;
            i4 += i7;
        }
    }

    @Override // d.a.j.d.a.f
    public void c() {
        System.arraycopy(this.f48514c, 0, this.f48500d, 0, this.f48513b);
    }

    @Override // d.a.j.d.a.f
    public void d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5;
        int i6 = i3 + i2;
        byte[] bArr3 = (bArr != bArr2 || i2 < i4 || i2 - i4 >= this.f48513b) ? null : (byte[]) bArr.clone();
        while (i2 < i6) {
            this.f48512a.j(bArr, i2, this.f48501e, 0);
            int i7 = 0;
            while (true) {
                i5 = this.f48513b;
                if (i7 >= i5) {
                    break;
                }
                bArr2[i7 + i4] = (byte) (this.f48501e[i7] ^ this.f48500d[i7]);
                i7++;
            }
            byte[] bArr4 = this.f48500d;
            if (bArr3 == null) {
                System.arraycopy(bArr, i2, bArr4, 0, i5);
            } else {
                System.arraycopy(bArr3, i2, bArr4, 0, i5);
            }
            int i8 = this.f48513b;
            i2 += i8;
            i4 += i8;
        }
    }

    @Override // d.a.j.d.a.f
    public void e() {
        if (this.f48502f == null) {
            this.f48502f = new byte[this.f48513b];
        }
        System.arraycopy(this.f48500d, 0, this.f48502f, 0, this.f48513b);
    }

    @Override // d.a.j.d.a.f
    public void g() {
        System.arraycopy(this.f48502f, 0, this.f48500d, 0, this.f48513b);
    }
}
