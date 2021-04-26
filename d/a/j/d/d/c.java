package d.a.j.d.d;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Locale;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f50308a;

    /* renamed from: c  reason: collision with root package name */
    public f f50310c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f50311d;

    /* renamed from: e  reason: collision with root package name */
    public int f50312e;

    /* renamed from: f  reason: collision with root package name */
    public d f50313f;

    /* renamed from: g  reason: collision with root package name */
    public String f50314g = "SHA-1";

    /* renamed from: b  reason: collision with root package name */
    public String f50309b = "PKCS1Padding";

    public void a(int i2, d dVar, SecureRandom secureRandom) {
        try {
            b(i2, dVar, secureRandom, null);
        } catch (InvalidAlgorithmParameterException e2) {
            InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
            invalidKeyException.initCause(e2);
            throw invalidKeyException;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(int i2, d dVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) {
        boolean z;
        OAEPParameterSpec oAEPParameterSpec;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        throw new InvalidKeyException("Unknown mode: " + i2);
                    }
                }
            }
            z = false;
            if (dVar instanceof d) {
                throw new InvalidKeyException("only support helios key");
            }
            this.f50308a = z ? 1 : 4;
            this.f50313f = dVar;
            int a2 = b.a(dVar.a());
            this.f50312e = 0;
            String str = this.f50309b;
            if (str == "NoPadding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                this.f50310c = f.b(3, a2, secureRandom);
                this.f50311d = new byte[a2];
                return;
            } else if (str == "PKCS1Padding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                f b2 = f.b(this.f50308a > 2 ? 1 : 2, a2, secureRandom);
                this.f50310c = b2;
                if (z) {
                    this.f50311d = new byte[b2.a()];
                    return;
                } else {
                    this.f50311d = new byte[a2];
                    return;
                }
            } else {
                int i3 = this.f50308a;
                if (i3 == 3 || i3 == 4) {
                    throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
                }
                if (algorithmParameterSpec == null) {
                    oAEPParameterSpec = new OAEPParameterSpec(this.f50314g, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
                } else if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
                } else {
                    oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
                }
                f c2 = f.c(4, a2, secureRandom, oAEPParameterSpec);
                this.f50310c = c2;
                if (z) {
                    this.f50311d = new byte[c2.a()];
                    return;
                } else {
                    this.f50311d = new byte[a2];
                    return;
                }
            }
        }
        z = true;
        if (dVar instanceof d) {
        }
    }

    public final byte[] c() {
        int i2 = this.f50312e;
        byte[] bArr = this.f50311d;
        if (i2 > bArr.length) {
            throw new IllegalBlockSizeException("Data must not be longer than " + this.f50311d.length + " bytes");
        }
        try {
            int i3 = this.f50308a;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            return this.f50310c.h(b.e(b.d(bArr, 0, i2), this.f50313f));
                        }
                        throw new AssertionError("Internal error");
                    }
                    throw new UnsupportedOperationException("only verify supported");
                }
                throw new UnsupportedOperationException("only verify supported");
            }
            return b.e(this.f50310c.g(bArr, 0, i2), this.f50313f);
        } finally {
            this.f50312e = 0;
        }
    }

    public byte[] d(byte[] bArr, int i2, int i3) {
        f(bArr, i2, i3);
        return c();
    }

    public void e(String str) {
        String str2 = "NoPadding";
        if (!str.equalsIgnoreCase("NoPadding")) {
            str2 = "PKCS1Padding";
            if (!str.equalsIgnoreCase("PKCS1Padding")) {
                String lowerCase = str.toLowerCase(Locale.ENGLISH);
                if (lowerCase.equals("oaeppadding")) {
                    this.f50309b = "OAEP";
                    return;
                } else if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                    throw new NoSuchPaddingException("Padding " + str + " not supported");
                } else {
                    this.f50309b = "OAEP";
                    this.f50314g = str.substring(8, str.length() - 14);
                    throw new NoSuchPaddingException("MessageDigest not available for " + str);
                }
            }
        }
        this.f50309b = str2;
    }

    public final void f(byte[] bArr, int i2, int i3) {
        int i4;
        if (i3 == 0 || bArr == null) {
            return;
        }
        int i5 = this.f50312e;
        int i6 = i5 + i3;
        byte[] bArr2 = this.f50311d;
        if (i6 > bArr2.length) {
            i4 = bArr2.length + 1;
        } else {
            System.arraycopy(bArr, i2, bArr2, i5, i3);
            i4 = this.f50312e + i3;
        }
        this.f50312e = i4;
    }
}
