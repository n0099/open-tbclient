package d.b.j.d.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f64404a;

    /* renamed from: b  reason: collision with root package name */
    public int f64405b;

    /* renamed from: c  reason: collision with root package name */
    public int f64406c;

    /* renamed from: e  reason: collision with root package name */
    public int f64408e;

    /* renamed from: f  reason: collision with root package name */
    public i f64409f;

    /* renamed from: g  reason: collision with root package name */
    public f f64410g;

    /* renamed from: d  reason: collision with root package name */
    public int f64407d = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f64411h = 1;
    public boolean i = false;

    public e(b bVar, int i) {
        this.f64404a = null;
        this.f64405b = 0;
        this.f64406c = 0;
        this.f64408e = 0;
        this.f64409f = null;
        this.f64410g = null;
        this.f64405b = i;
        this.f64406c = i;
        this.f64408e = i;
        this.f64404a = new byte[i * 2];
        this.f64410g = new d(bVar);
        this.f64409f = new h(this.f64405b);
    }

    public int a(int i) {
        int i2 = this.f64407d + i;
        i iVar = this.f64409f;
        if (iVar == null || this.i) {
            return i2;
        }
        int i3 = this.f64406c;
        int i4 = this.f64405b;
        if (i3 != i4) {
            int i5 = this.f64408e;
            return i2 < i5 ? i5 : (i2 + i4) - ((i2 - i5) % i4);
        }
        return i2 + iVar.a(i2);
    }

    public final int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null || i3 == 0) {
            return 0;
        }
        int i4 = this.f64411h;
        if (i4 == 2 || i4 == 3 || i3 % this.f64406c == 0 || i4 == 6) {
            if (this.i) {
                this.f64410g.h(bArr, i, i3, bArr2, i2);
            } else {
                this.f64410g.f(bArr, i, i3, bArr2, i2);
            }
            return i3;
        } else if (this.f64409f != null) {
            throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f64406c + " bytes");
        } else {
            throw new IllegalBlockSizeException("Input length not multiple of " + this.f64406c + " bytes");
        }
    }

    public void c(int i, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        boolean z = i == 2 || i == 4;
        this.i = z;
        if (this.f64411h == 0) {
            if (bArr2 != null) {
                throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
            }
        } else if (bArr2 == null) {
            if (z) {
                throw new InvalidAlgorithmParameterException("Parameters missing");
            }
            if (secureRandom == null) {
                secureRandom = c.f64399b;
            }
            bArr2 = new byte[this.f64405b];
            secureRandom.nextBytes(bArr2);
        }
        this.f64407d = 0;
        this.f64408e = this.f64405b;
        this.f64410g.a(this.i, "", bArr, bArr2);
    }

    public int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int a2;
        byte[] bArr3;
        int i4;
        i iVar;
        int b2;
        int i5 = this.f64407d + i2;
        int i6 = this.f64406c;
        int i7 = this.f64405b;
        if (i6 != i7) {
            int i8 = this.f64408e;
            a2 = i5 < i8 ? i8 - i5 : i7 - ((i5 - i8) % i7);
        } else {
            i iVar2 = this.f64409f;
            a2 = iVar2 != null ? iVar2.a(i5) : 0;
        }
        if (a2 > 0 && a2 != this.f64405b && this.f64409f != null && this.i) {
            throw new IllegalBlockSizeException("Input length must be multiple of " + this.f64405b + " when decrypting with padded cipher");
        }
        int i9 = (this.i || this.f64409f == null) ? i5 : i5 + a2;
        if (bArr2 != null) {
            int length = bArr2.length - i3;
            if (((!this.i || this.f64409f == null) && length < i9) || (this.i && length < i9 - this.f64405b)) {
                throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i9 + " bytes needed");
            }
            if (this.f64407d == 0 && (this.i || this.f64409f == null)) {
                bArr3 = bArr;
                i4 = i;
            } else {
                byte[] bArr4 = new byte[i9];
                int i10 = this.f64407d;
                if (i10 != 0) {
                    System.arraycopy(this.f64404a, 0, bArr4, 0, i10);
                }
                if (i2 != 0) {
                    System.arraycopy(bArr, i, bArr4, this.f64407d, i2);
                }
                if (!this.i && (iVar = this.f64409f) != null) {
                    iVar.a(bArr4, i5, a2);
                }
                bArr3 = bArr4;
                i4 = 0;
            }
            if (this.i) {
                if (length < i9) {
                    this.f64410g.e();
                }
                byte[] bArr5 = new byte[i5];
                b2 = b(bArr3, i4, bArr5, 0, i5);
                i iVar3 = this.f64409f;
                if (iVar3 != null && (b2 = iVar3.b(bArr5, 0, b2)) < 0) {
                    throw new BadPaddingException("Given final block not properly padded");
                }
                if (bArr2.length - i3 < b2) {
                    this.f64410g.g();
                    throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i3) + " bytes given, " + b2 + " bytes needed");
                }
                for (int i11 = 0; i11 < b2; i11++) {
                    bArr2[i3 + i11] = bArr5[i11];
                }
            } else {
                b2 = b(bArr3, i4, bArr2, i3, i9);
            }
            this.f64407d = 0;
            this.f64408e = this.f64405b;
            if (this.f64411h != 0) {
                this.f64410g.c();
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
