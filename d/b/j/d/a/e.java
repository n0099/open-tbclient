package d.b.j.d.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f63703a;

    /* renamed from: b  reason: collision with root package name */
    public int f63704b;

    /* renamed from: c  reason: collision with root package name */
    public int f63705c;

    /* renamed from: e  reason: collision with root package name */
    public int f63707e;

    /* renamed from: f  reason: collision with root package name */
    public i f63708f;

    /* renamed from: g  reason: collision with root package name */
    public f f63709g;

    /* renamed from: d  reason: collision with root package name */
    public int f63706d = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f63710h = 1;
    public boolean i = false;

    public e(b bVar, int i) {
        this.f63703a = null;
        this.f63704b = 0;
        this.f63705c = 0;
        this.f63707e = 0;
        this.f63708f = null;
        this.f63709g = null;
        this.f63704b = i;
        this.f63705c = i;
        this.f63707e = i;
        this.f63703a = new byte[i * 2];
        this.f63709g = new d(bVar);
        this.f63708f = new h(this.f63704b);
    }

    public int a(int i) {
        int i2 = this.f63706d + i;
        i iVar = this.f63708f;
        if (iVar == null || this.i) {
            return i2;
        }
        int i3 = this.f63705c;
        int i4 = this.f63704b;
        if (i3 != i4) {
            int i5 = this.f63707e;
            return i2 < i5 ? i5 : (i2 + i4) - ((i2 - i5) % i4);
        }
        return i2 + iVar.a(i2);
    }

    public final int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null || i3 == 0) {
            return 0;
        }
        int i4 = this.f63710h;
        if (i4 == 2 || i4 == 3 || i3 % this.f63705c == 0 || i4 == 6) {
            if (this.i) {
                this.f63709g.h(bArr, i, i3, bArr2, i2);
            } else {
                this.f63709g.f(bArr, i, i3, bArr2, i2);
            }
            return i3;
        } else if (this.f63708f != null) {
            throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f63705c + " bytes");
        } else {
            throw new IllegalBlockSizeException("Input length not multiple of " + this.f63705c + " bytes");
        }
    }

    public void c(int i, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        boolean z = i == 2 || i == 4;
        this.i = z;
        if (this.f63710h == 0) {
            if (bArr2 != null) {
                throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
            }
        } else if (bArr2 == null) {
            if (z) {
                throw new InvalidAlgorithmParameterException("Parameters missing");
            }
            if (secureRandom == null) {
                secureRandom = c.f63698b;
            }
            bArr2 = new byte[this.f63704b];
            secureRandom.nextBytes(bArr2);
        }
        this.f63706d = 0;
        this.f63707e = this.f63704b;
        this.f63709g.a(this.i, "", bArr, bArr2);
    }

    public int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int a2;
        byte[] bArr3;
        int i4;
        i iVar;
        int b2;
        int i5 = this.f63706d + i2;
        int i6 = this.f63705c;
        int i7 = this.f63704b;
        if (i6 != i7) {
            int i8 = this.f63707e;
            a2 = i5 < i8 ? i8 - i5 : i7 - ((i5 - i8) % i7);
        } else {
            i iVar2 = this.f63708f;
            a2 = iVar2 != null ? iVar2.a(i5) : 0;
        }
        if (a2 > 0 && a2 != this.f63704b && this.f63708f != null && this.i) {
            throw new IllegalBlockSizeException("Input length must be multiple of " + this.f63704b + " when decrypting with padded cipher");
        }
        int i9 = (this.i || this.f63708f == null) ? i5 : i5 + a2;
        if (bArr2 != null) {
            int length = bArr2.length - i3;
            if (((!this.i || this.f63708f == null) && length < i9) || (this.i && length < i9 - this.f63704b)) {
                throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i9 + " bytes needed");
            }
            if (this.f63706d == 0 && (this.i || this.f63708f == null)) {
                bArr3 = bArr;
                i4 = i;
            } else {
                byte[] bArr4 = new byte[i9];
                int i10 = this.f63706d;
                if (i10 != 0) {
                    System.arraycopy(this.f63703a, 0, bArr4, 0, i10);
                }
                if (i2 != 0) {
                    System.arraycopy(bArr, i, bArr4, this.f63706d, i2);
                }
                if (!this.i && (iVar = this.f63708f) != null) {
                    iVar.a(bArr4, i5, a2);
                }
                bArr3 = bArr4;
                i4 = 0;
            }
            if (this.i) {
                if (length < i9) {
                    this.f63709g.e();
                }
                byte[] bArr5 = new byte[i5];
                b2 = b(bArr3, i4, bArr5, 0, i5);
                i iVar3 = this.f63708f;
                if (iVar3 != null && (b2 = iVar3.b(bArr5, 0, b2)) < 0) {
                    throw new BadPaddingException("Given final block not properly padded");
                }
                if (bArr2.length - i3 < b2) {
                    this.f63709g.g();
                    throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i3) + " bytes given, " + b2 + " bytes needed");
                }
                for (int i11 = 0; i11 < b2; i11++) {
                    bArr2[i3 + i11] = bArr5[i11];
                }
            } else {
                b2 = b(bArr3, i4, bArr2, i3, i9);
            }
            this.f63706d = 0;
            this.f63707e = this.f63704b;
            if (this.f63710h != 0) {
                this.f63709g.c();
            }
            return b2;
        }
        throw new ShortBufferException("Output buffer is null");
    }

    public byte[] e(byte[] bArr, int i, int i2) {
        int a2;
        byte[] bArr2;
        int d2;
        byte[] bArr3 = null;
        try {
            a2 = a(i2);
            bArr2 = new byte[a2];
            d2 = d(bArr, i, i2, bArr2, 0);
        } catch (ShortBufferException unused) {
        }
        if (d2 < a2) {
            bArr3 = new byte[d2];
            if (d2 != 0) {
                System.arraycopy(bArr2, 0, bArr3, 0, d2);
            }
            return bArr3;
        }
        return bArr2;
    }
}
