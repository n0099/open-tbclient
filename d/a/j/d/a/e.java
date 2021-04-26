package d.a.j.d.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f50282a;

    /* renamed from: b  reason: collision with root package name */
    public int f50283b;

    /* renamed from: c  reason: collision with root package name */
    public int f50284c;

    /* renamed from: e  reason: collision with root package name */
    public int f50286e;

    /* renamed from: f  reason: collision with root package name */
    public i f50287f;

    /* renamed from: g  reason: collision with root package name */
    public f f50288g;

    /* renamed from: d  reason: collision with root package name */
    public int f50285d = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f50289h = 1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50290i = false;

    public e(b bVar, int i2) {
        this.f50282a = null;
        this.f50283b = 0;
        this.f50284c = 0;
        this.f50286e = 0;
        this.f50287f = null;
        this.f50288g = null;
        this.f50283b = i2;
        this.f50284c = i2;
        this.f50286e = i2;
        this.f50282a = new byte[i2 * 2];
        this.f50288g = new d(bVar);
        this.f50287f = new h(this.f50283b);
    }

    public int a(int i2) {
        int i3 = this.f50285d + i2;
        i iVar = this.f50287f;
        if (iVar == null || this.f50290i) {
            return i3;
        }
        int i4 = this.f50284c;
        int i5 = this.f50283b;
        if (i4 != i5) {
            int i6 = this.f50286e;
            return i3 < i6 ? i6 : (i3 + i5) - ((i3 - i6) % i5);
        }
        return i3 + iVar.a(i3);
    }

    public final int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        if (bArr == null || i4 == 0) {
            return 0;
        }
        int i5 = this.f50289h;
        if (i5 == 2 || i5 == 3 || i4 % this.f50284c == 0 || i5 == 6) {
            if (this.f50290i) {
                this.f50288g.h(bArr, i2, i4, bArr2, i3);
            } else {
                this.f50288g.f(bArr, i2, i4, bArr2, i3);
            }
            return i4;
        } else if (this.f50287f != null) {
            throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f50284c + " bytes");
        } else {
            throw new IllegalBlockSizeException("Input length not multiple of " + this.f50284c + " bytes");
        }
    }

    public void c(int i2, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        boolean z = i2 == 2 || i2 == 4;
        this.f50290i = z;
        if (this.f50289h == 0) {
            if (bArr2 != null) {
                throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
            }
        } else if (bArr2 == null) {
            if (z) {
                throw new InvalidAlgorithmParameterException("Parameters missing");
            }
            if (secureRandom == null) {
                secureRandom = c.f50277b;
            }
            bArr2 = new byte[this.f50283b];
            secureRandom.nextBytes(bArr2);
        }
        this.f50285d = 0;
        this.f50286e = this.f50283b;
        this.f50288g.a(this.f50290i, "", bArr, bArr2);
    }

    public int d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int a2;
        byte[] bArr3;
        int i5;
        i iVar;
        int b2;
        int i6 = this.f50285d + i3;
        int i7 = this.f50284c;
        int i8 = this.f50283b;
        if (i7 != i8) {
            int i9 = this.f50286e;
            a2 = i6 < i9 ? i9 - i6 : i8 - ((i6 - i9) % i8);
        } else {
            i iVar2 = this.f50287f;
            a2 = iVar2 != null ? iVar2.a(i6) : 0;
        }
        if (a2 > 0 && a2 != this.f50283b && this.f50287f != null && this.f50290i) {
            throw new IllegalBlockSizeException("Input length must be multiple of " + this.f50283b + " when decrypting with padded cipher");
        }
        int i10 = (this.f50290i || this.f50287f == null) ? i6 : i6 + a2;
        if (bArr2 != null) {
            int length = bArr2.length - i4;
            if (((!this.f50290i || this.f50287f == null) && length < i10) || (this.f50290i && length < i10 - this.f50283b)) {
                throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i10 + " bytes needed");
            }
            if (this.f50285d == 0 && (this.f50290i || this.f50287f == null)) {
                bArr3 = bArr;
                i5 = i2;
            } else {
                byte[] bArr4 = new byte[i10];
                int i11 = this.f50285d;
                if (i11 != 0) {
                    System.arraycopy(this.f50282a, 0, bArr4, 0, i11);
                }
                if (i3 != 0) {
                    System.arraycopy(bArr, i2, bArr4, this.f50285d, i3);
                }
                if (!this.f50290i && (iVar = this.f50287f) != null) {
                    iVar.a(bArr4, i6, a2);
                }
                bArr3 = bArr4;
                i5 = 0;
            }
            if (this.f50290i) {
                if (length < i10) {
                    this.f50288g.e();
                }
                byte[] bArr5 = new byte[i6];
                b2 = b(bArr3, i5, bArr5, 0, i6);
                i iVar3 = this.f50287f;
                if (iVar3 != null && (b2 = iVar3.b(bArr5, 0, b2)) < 0) {
                    throw new BadPaddingException("Given final block not properly padded");
                }
                if (bArr2.length - i4 < b2) {
                    this.f50288g.g();
                    throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i4) + " bytes given, " + b2 + " bytes needed");
                }
                for (int i12 = 0; i12 < b2; i12++) {
                    bArr2[i4 + i12] = bArr5[i12];
                }
            } else {
                b2 = b(bArr3, i5, bArr2, i4, i10);
            }
            this.f50285d = 0;
            this.f50286e = this.f50283b;
            if (this.f50289h != 0) {
                this.f50288g.c();
            }
            return b2;
        }
        throw new ShortBufferException("Output buffer is null");
    }

    public byte[] e(byte[] bArr, int i2, int i3) {
        int a2;
        byte[] bArr2;
        int d2;
        byte[] bArr3 = null;
        try {
            a2 = a(i3);
            bArr2 = new byte[a2];
            d2 = d(bArr, i2, i3, bArr2, 0);
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
