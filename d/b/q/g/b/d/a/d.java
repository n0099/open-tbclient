package d.b.q.g.b.d.a;

import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.MGF1ParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: h  reason: collision with root package name */
    public static final Map<String, byte[]> f64429h = Collections.synchronizedMap(new HashMap());

    /* renamed from: a  reason: collision with root package name */
    public final int f64430a;

    /* renamed from: b  reason: collision with root package name */
    public final int f64431b;

    /* renamed from: c  reason: collision with root package name */
    public SecureRandom f64432c;

    /* renamed from: d  reason: collision with root package name */
    public final int f64433d;

    /* renamed from: e  reason: collision with root package name */
    public MessageDigest f64434e;

    /* renamed from: f  reason: collision with root package name */
    public MessageDigest f64435f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f64436g;

    public d(int i, int i2, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) {
        String str;
        this.f64430a = i;
        this.f64431b = i2;
        this.f64432c = secureRandom;
        if (i2 < 64) {
            throw new InvalidKeyException("Padded size must be at least 64");
        }
        if (i == 1 || i == 2) {
            i2 -= 11;
        } else if (i != 3) {
            if (i != 4) {
                throw new InvalidKeyException("Invalid padding: " + i);
            }
            byte[] bArr = null;
            String str2 = "SHA-1";
            if (oAEPParameterSpec != null) {
                try {
                    str2 = oAEPParameterSpec.getDigestAlgorithm();
                    String mGFAlgorithm = oAEPParameterSpec.getMGFAlgorithm();
                    if (!mGFAlgorithm.equalsIgnoreCase("MGF1")) {
                        throw new InvalidAlgorithmParameterException("Unsupported MGF algo: " + mGFAlgorithm);
                    }
                    String digestAlgorithm = ((MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters()).getDigestAlgorithm();
                    PSource pSource = oAEPParameterSpec.getPSource();
                    String algorithm = pSource.getAlgorithm();
                    if (!algorithm.equalsIgnoreCase("PSpecified")) {
                        throw new InvalidAlgorithmParameterException("Unsupported pSource algo: " + algorithm);
                    }
                    byte[] value = ((PSource.PSpecified) pSource).getValue();
                    str = digestAlgorithm;
                    bArr = value;
                } catch (NoSuchAlgorithmException e2) {
                    throw new InvalidKeyException("Digest SHA-1 not available", e2);
                }
            } else {
                str = "SHA-1";
            }
            this.f64434e = MessageDigest.getInstance(str2);
            this.f64435f = MessageDigest.getInstance(str);
            byte[] e3 = e(this.f64434e, bArr);
            this.f64436g = e3;
            int length = (i2 - 2) - (e3.length * 2);
            this.f64433d = length;
            if (length > 0) {
                return;
            }
            throw new InvalidKeyException("Key is too short for encryption using OAEPPadding with " + str2 + " and MGF1" + str);
        }
        this.f64433d = i2;
    }

    public static d b(int i, int i2, SecureRandom secureRandom) {
        return new d(i, i2, secureRandom, null);
    }

    public static d c(int i, int i2, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) {
        return new d(i, i2, secureRandom, oAEPParameterSpec);
    }

    public static byte[] e(MessageDigest messageDigest, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            String algorithm = messageDigest.getAlgorithm();
            byte[] bArr2 = f64429h.get(algorithm);
            if (bArr2 == null) {
                byte[] digest = messageDigest.digest();
                f64429h.put(algorithm, digest);
                return digest;
            }
            return bArr2;
        }
        return messageDigest.digest(bArr);
    }

    public int a() {
        return this.f64433d;
    }

    public final void d(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        byte[] bArr3 = new byte[4];
        byte[] bArr4 = new byte[20];
        while (i4 > 0) {
            this.f64435f.update(bArr, i, i2);
            this.f64435f.update(bArr3);
            try {
                this.f64435f.digest(bArr4, 0, 20);
                for (int i6 = 0; i6 < 20 && i4 > 0; i6++) {
                    bArr2[i3] = (byte) (bArr4[i6] ^ bArr2[i3]);
                    i4--;
                    i3++;
                }
                if (i4 > 0) {
                    while (true) {
                        byte b2 = (byte) (bArr3[i5] + 1);
                        bArr3[i5] = b2;
                        i5 = (b2 == 0 && i5 > 0) ? i5 - 1 : 3;
                    }
                }
            } catch (DigestException e2) {
                throw new BadPaddingException(e2.toString());
            }
        }
    }

    public byte[] f(byte[] bArr) {
        if (bArr.length > this.f64433d) {
            throw new BadPaddingException("Data must be shorter than " + (this.f64433d + 1) + " bytes");
        }
        int i = this.f64430a;
        if (i == 1 || i == 2) {
            return i(bArr);
        }
        if (i != 3) {
            if (i == 4) {
                return k(bArr);
            }
            throw new AssertionError();
        }
        return bArr;
    }

    public byte[] g(byte[] bArr, int i, int i2) {
        return f(a.d(bArr, i, i2));
    }

    public byte[] h(byte[] bArr) {
        if (bArr.length != this.f64431b) {
            throw new BadPaddingException("Padded length must be " + this.f64431b);
        }
        int i = this.f64430a;
        if (i == 1 || i == 2) {
            return j(bArr);
        }
        if (i != 3) {
            if (i == 4) {
                return l(bArr);
            }
            throw new AssertionError();
        }
        return bArr;
    }

    public final byte[] i(byte[] bArr) {
        int i;
        int i2;
        int i3 = this.f64431b;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, i3 - bArr.length, bArr.length);
        int length = (this.f64431b - 3) - bArr.length;
        bArr2[0] = 0;
        int i4 = this.f64430a;
        bArr2[1] = (byte) i4;
        int i5 = -1;
        int i6 = 2;
        if (i4 != 1) {
            if (this.f64432c == null) {
                this.f64432c = a.f64419a;
            }
            byte[] bArr3 = new byte[64];
            while (true) {
                int i7 = length - 1;
                if (length <= 0) {
                    break;
                }
                while (true) {
                    if (i5 < 0) {
                        this.f64432c.nextBytes(bArr3);
                        i5 = 63;
                    }
                    i = i5 - 1;
                    i2 = bArr3[i5] & 255;
                    if (i2 != 0) {
                        break;
                    }
                    i5 = i;
                }
                bArr2[i6] = (byte) i2;
                i5 = i;
                length = i7;
                i6++;
            }
        } else {
            while (true) {
                int i8 = length - 1;
                if (length <= 0) {
                    break;
                }
                bArr2[i6] = -1;
                i6++;
                length = i8;
            }
        }
        return bArr2;
    }

    public final byte[] j(byte[] bArr) {
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        int i = 2;
        if (bArr[1] != this.f64430a) {
            throw new BadPaddingException("Blocktype mismatch: " + ((int) bArr[1]));
        }
        while (true) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i3 == 0) {
                int length = bArr.length - i2;
                if (length <= this.f64433d) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                    return bArr2;
                }
                throw new BadPaddingException("Padding string too short");
            } else if (i2 == bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            } else {
                if (this.f64430a == 1 && i3 != 255) {
                    throw new BadPaddingException("Padding byte not 0xff: " + i3);
                }
                i = i2;
            }
        }
    }

    public final byte[] k(byte[] bArr) {
        if (this.f64432c == null) {
            this.f64432c = a.f64419a;
        }
        int length = this.f64436g.length;
        byte[] bArr2 = new byte[length];
        this.f64432c.nextBytes(bArr2);
        int i = this.f64431b;
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 1, length);
        int i2 = length + 1;
        int i3 = i - i2;
        int length2 = this.f64431b - bArr.length;
        System.arraycopy(this.f64436g, 0, bArr3, i2, length);
        bArr3[length2 - 1] = 1;
        System.arraycopy(bArr, 0, bArr3, length2, bArr.length);
        d(bArr3, 1, length, bArr3, i2, i3);
        d(bArr3, i2, i3, bArr3, 1, length);
        return bArr3;
    }

    public final byte[] l(byte[] bArr) {
        int length = this.f64436g.length;
        if (bArr[0] == 0) {
            int i = length + 1;
            int length2 = bArr.length - i;
            d(bArr, i, length2, bArr, 1, length);
            d(bArr, 1, length, bArr, i, length2);
            for (int i2 = 0; i2 < length; i2++) {
                if (this.f64436g[i2] != bArr[i + i2]) {
                    throw new BadPaddingException("lHash mismatch");
                }
            }
            int i3 = i + length;
            while (bArr[i3] == 0) {
                i3++;
                if (i3 >= bArr.length) {
                    throw new BadPaddingException("Padding string not terminated");
                }
            }
            int i4 = i3 + 1;
            if (bArr[i3] == 1) {
                int length3 = bArr.length - i4;
                byte[] bArr2 = new byte[length3];
                System.arraycopy(bArr, i4, bArr2, 0, length3);
                return bArr2;
            }
            throw new BadPaddingException("Padding string not terminated by 0x01 byte");
        }
        throw new BadPaddingException("Data must start with zero");
    }
}
