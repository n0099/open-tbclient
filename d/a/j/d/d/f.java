package d.a.j.d.d;

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
public final class f {

    /* renamed from: h  reason: collision with root package name */
    public static final Map<String, byte[]> f43986h = Collections.synchronizedMap(new HashMap());

    /* renamed from: a  reason: collision with root package name */
    public final int f43987a;

    /* renamed from: b  reason: collision with root package name */
    public final int f43988b;

    /* renamed from: c  reason: collision with root package name */
    public SecureRandom f43989c;

    /* renamed from: d  reason: collision with root package name */
    public final int f43990d;

    /* renamed from: e  reason: collision with root package name */
    public MessageDigest f43991e;

    /* renamed from: f  reason: collision with root package name */
    public MessageDigest f43992f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f43993g;

    public f(int i2, int i3, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) {
        String str;
        this.f43987a = i2;
        this.f43988b = i3;
        this.f43989c = secureRandom;
        if (i3 < 64) {
            throw new InvalidKeyException("Padded size must be at least 64");
        }
        if (i2 == 1 || i2 == 2) {
            i3 -= 11;
        } else if (i2 != 3) {
            if (i2 != 4) {
                throw new InvalidKeyException("Invalid padding: " + i2);
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
            this.f43991e = MessageDigest.getInstance(str2);
            this.f43992f = MessageDigest.getInstance(str);
            byte[] e3 = e(this.f43991e, bArr);
            this.f43993g = e3;
            int length = (i3 - 2) - (e3.length * 2);
            this.f43990d = length;
            if (length > 0) {
                return;
            }
            throw new InvalidKeyException("Key is too short for encryption using OAEPPadding with " + str2 + " and MGF1" + str);
        }
        this.f43990d = i3;
    }

    public static f b(int i2, int i3, SecureRandom secureRandom) {
        return new f(i2, i3, secureRandom, null);
    }

    public static f c(int i2, int i3, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) {
        return new f(i2, i3, secureRandom, oAEPParameterSpec);
    }

    public static byte[] e(MessageDigest messageDigest, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            String algorithm = messageDigest.getAlgorithm();
            byte[] bArr2 = f43986h.get(algorithm);
            if (bArr2 == null) {
                byte[] digest = messageDigest.digest();
                f43986h.put(algorithm, digest);
                return digest;
            }
            return bArr2;
        }
        return messageDigest.digest(bArr);
    }

    public int a() {
        return this.f43990d;
    }

    public final void d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        int i6;
        byte[] bArr3 = new byte[4];
        byte[] bArr4 = new byte[20];
        while (i5 > 0) {
            this.f43992f.update(bArr, i2, i3);
            this.f43992f.update(bArr3);
            try {
                this.f43992f.digest(bArr4, 0, 20);
                for (int i7 = 0; i7 < 20 && i5 > 0; i7++) {
                    bArr2[i4] = (byte) (bArr4[i7] ^ bArr2[i4]);
                    i5--;
                    i4++;
                }
                if (i5 > 0) {
                    while (true) {
                        byte b2 = (byte) (bArr3[i6] + 1);
                        bArr3[i6] = b2;
                        i6 = (b2 == 0 && i6 > 0) ? i6 - 1 : 3;
                    }
                }
            } catch (DigestException e2) {
                throw new BadPaddingException(e2.toString());
            }
        }
    }

    public byte[] f(byte[] bArr) {
        if (bArr.length > this.f43990d) {
            throw new BadPaddingException("Data must be shorter than " + (this.f43990d + 1) + " bytes");
        }
        int i2 = this.f43987a;
        if (i2 == 1 || i2 == 2) {
            return i(bArr);
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return k(bArr);
            }
            throw new AssertionError();
        }
        return bArr;
    }

    public byte[] g(byte[] bArr, int i2, int i3) {
        return f(b.d(bArr, i2, i3));
    }

    public byte[] h(byte[] bArr) {
        if (bArr.length != this.f43988b) {
            throw new BadPaddingException("Padded length must be " + this.f43988b);
        }
        int i2 = this.f43987a;
        if (i2 == 1 || i2 == 2) {
            return j(bArr);
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return l(bArr);
            }
            throw new AssertionError();
        }
        return bArr;
    }

    public final byte[] i(byte[] bArr) {
        int i2;
        int i3;
        int i4 = this.f43988b;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, 0, bArr2, i4 - bArr.length, bArr.length);
        int length = (this.f43988b - 3) - bArr.length;
        bArr2[0] = 0;
        int i5 = this.f43987a;
        bArr2[1] = (byte) i5;
        int i6 = -1;
        int i7 = 2;
        if (i5 != 1) {
            if (this.f43989c == null) {
                this.f43989c = b.f43976a;
            }
            byte[] bArr3 = new byte[64];
            while (true) {
                int i8 = length - 1;
                if (length <= 0) {
                    break;
                }
                while (true) {
                    if (i6 < 0) {
                        this.f43989c.nextBytes(bArr3);
                        i6 = 63;
                    }
                    i2 = i6 - 1;
                    i3 = bArr3[i6] & 255;
                    if (i3 != 0) {
                        break;
                    }
                    i6 = i2;
                }
                bArr2[i7] = (byte) i3;
                i6 = i2;
                length = i8;
                i7++;
            }
        } else {
            while (true) {
                int i9 = length - 1;
                if (length <= 0) {
                    break;
                }
                bArr2[i7] = -1;
                i7++;
                length = i9;
            }
        }
        return bArr2;
    }

    public final byte[] j(byte[] bArr) {
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        int i2 = 2;
        if (bArr[1] != this.f43987a) {
            throw new BadPaddingException("Blocktype mismatch: " + ((int) bArr[1]));
        }
        while (true) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i4 == 0) {
                int length = bArr.length - i3;
                if (length <= this.f43990d) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                    return bArr2;
                }
                throw new BadPaddingException("Padding string too short");
            } else if (i3 == bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            } else {
                if (this.f43987a == 1 && i4 != 255) {
                    throw new BadPaddingException("Padding byte not 0xff: " + i4);
                }
                i2 = i3;
            }
        }
    }

    public final byte[] k(byte[] bArr) {
        if (this.f43989c == null) {
            this.f43989c = b.f43976a;
        }
        int length = this.f43993g.length;
        byte[] bArr2 = new byte[length];
        this.f43989c.nextBytes(bArr2);
        int i2 = this.f43988b;
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 1, length);
        int i3 = length + 1;
        int i4 = i2 - i3;
        int length2 = this.f43988b - bArr.length;
        System.arraycopy(this.f43993g, 0, bArr3, i3, length);
        bArr3[length2 - 1] = 1;
        System.arraycopy(bArr, 0, bArr3, length2, bArr.length);
        d(bArr3, 1, length, bArr3, i3, i4);
        d(bArr3, i3, i4, bArr3, 1, length);
        return bArr3;
    }

    public final byte[] l(byte[] bArr) {
        int length = this.f43993g.length;
        if (bArr[0] == 0) {
            int i2 = length + 1;
            int length2 = bArr.length - i2;
            d(bArr, i2, length2, bArr, 1, length);
            d(bArr, 1, length, bArr, i2, length2);
            for (int i3 = 0; i3 < length; i3++) {
                if (this.f43993g[i3] != bArr[i2 + i3]) {
                    throw new BadPaddingException("lHash mismatch");
                }
            }
            int i4 = i2 + length;
            while (bArr[i4] == 0) {
                i4++;
                if (i4 >= bArr.length) {
                    throw new BadPaddingException("Padding string not terminated");
                }
            }
            int i5 = i4 + 1;
            if (bArr[i4] == 1) {
                int length3 = bArr.length - i5;
                byte[] bArr2 = new byte[length3];
                System.arraycopy(bArr, i5, bArr2, 0, length3);
                return bArr2;
            }
            throw new BadPaddingException("Padding string not terminated by 0x01 byte");
        }
        throw new BadPaddingException("Data must start with zero");
    }
}
