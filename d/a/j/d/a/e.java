package d.a.j.d.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f40167a;

    /* renamed from: b  reason: collision with root package name */
    public int f40168b;

    /* renamed from: c  reason: collision with root package name */
    public int f40169c;

    /* renamed from: e  reason: collision with root package name */
    public int f40171e;

    /* renamed from: f  reason: collision with root package name */
    public i f40172f;

    /* renamed from: g  reason: collision with root package name */
    public f f40173g;

    /* renamed from: d  reason: collision with root package name */
    public int f40170d = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f40174h = 1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40175i = false;

    public e(b bVar, int i2) {
        this.f40167a = null;
        this.f40168b = 0;
        this.f40169c = 0;
        this.f40171e = 0;
        this.f40172f = null;
        this.f40173g = null;
        this.f40168b = i2;
        this.f40169c = i2;
        this.f40171e = i2;
        this.f40167a = new byte[i2 * 2];
        this.f40173g = new d(bVar);
        this.f40172f = new h(this.f40168b);
    }

    public int a(int i2) {
        int i3 = this.f40170d + i2;
        i iVar = this.f40172f;
        if (iVar == null || this.f40175i) {
            return i3;
        }
        int i4 = this.f40169c;
        int i5 = this.f40168b;
        if (i4 != i5) {
            int i6 = this.f40171e;
            return i3 < i6 ? i6 : (i3 + i5) - ((i3 - i6) % i5);
        }
        return i3 + iVar.a(i3);
    }

    public final int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        if (bArr == null || i4 == 0) {
            return 0;
        }
        int i5 = this.f40174h;
        if (i5 == 2 || i5 == 3 || i4 % this.f40169c == 0 || i5 == 6) {
            if (this.f40175i) {
                this.f40173g.h(bArr, i2, i4, bArr2, i3);
            } else {
                this.f40173g.f(bArr, i2, i4, bArr2, i3);
            }
            return i4;
        } else if (this.f40172f != null) {
            throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.f40169c + " bytes");
        } else {
            throw new IllegalBlockSizeException("Input length not multiple of " + this.f40169c + " bytes");
        }
    }

    public void c(int i2, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        boolean z = i2 == 2 || i2 == 4;
        this.f40175i = z;
        if (this.f40174h == 0) {
            if (bArr2 != null) {
                throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
            }
        } else if (bArr2 == null) {
            if (z) {
                throw new InvalidAlgorithmParameterException("Parameters missing");
            }
            if (secureRandom == null) {
                secureRandom = c.f40162b;
            }
            bArr2 = new byte[this.f40168b];
            secureRandom.nextBytes(bArr2);
        }
        this.f40170d = 0;
        this.f40171e = this.f40168b;
        this.f40173g.a(this.f40175i, "", bArr, bArr2);
    }

    public int d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int a2;
        byte[] bArr3;
        int i5;
        i iVar;
        int b2;
        int i6 = this.f40170d + i3;
        int i7 = this.f40169c;
        int i8 = this.f40168b;
        if (i7 != i8) {
            int i9 = this.f40171e;
            a2 = i6 < i9 ? i9 - i6 : i8 - ((i6 - i9) % i8);
        } else {
            i iVar2 = this.f40172f;
            a2 = iVar2 != null ? iVar2.a(i6) : 0;
        }
        if (a2 > 0 && a2 != this.f40168b && this.f40172f != null && this.f40175i) {
            throw new IllegalBlockSizeException("Input length must be multiple of " + this.f40168b + " when decrypting with padded cipher");
        }
        int i10 = (this.f40175i || this.f40172f == null) ? i6 : i6 + a2;
        if (bArr2 != null) {
            int length = bArr2.length - i4;
            if (((!this.f40175i || this.f40172f == null) && length < i10) || (this.f40175i && length < i10 - this.f40168b)) {
                throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i10 + " bytes needed");
            }
            if (this.f40170d == 0 && (this.f40175i || this.f40172f == null)) {
                bArr3 = bArr;
                i5 = i2;
            } else {
                byte[] bArr4 = new byte[i10];
                int i11 = this.f40170d;
                if (i11 != 0) {
                    System.arraycopy(this.f40167a, 0, bArr4, 0, i11);
                }
                if (i3 != 0) {
                    System.arraycopy(bArr, i2, bArr4, this.f40170d, i3);
                }
                if (!this.f40175i && (iVar = this.f40172f) != null) {
                    iVar.a(bArr4, i6, a2);
                }
                bArr3 = bArr4;
                i5 = 0;
            }
            if (this.f40175i) {
                if (length < i10) {
                    this.f40173g.e();
                }
                byte[] bArr5 = new byte[i6];
                b2 = b(bArr3, i5, bArr5, 0, i6);
                i iVar3 = this.f40172f;
                if (iVar3 != null && (b2 = iVar3.b(bArr5, 0, b2)) < 0) {
                    throw new BadPaddingException("Given final block not properly padded");
                }
                if (bArr2.length - i4 < b2) {
                    this.f40173g.g();
                    throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i4) + " bytes given, " + b2 + " bytes needed");
                }
                for (int i12 = 0; i12 < b2; i12++) {
                    bArr2[i4 + i12] = bArr5[i12];
                }
            } else {
                b2 = b(bArr3, i5, bArr2, i4, i10);
            }
            this.f40170d = 0;
            this.f40171e = this.f40168b;
            if (this.f40174h != 0) {
                this.f40173g.c();
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
