package d.b.j.d.d;

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
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f63728a;

    /* renamed from: c  reason: collision with root package name */
    public f f63730c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f63731d;

    /* renamed from: e  reason: collision with root package name */
    public int f63732e;

    /* renamed from: f  reason: collision with root package name */
    public d f63733f;

    /* renamed from: g  reason: collision with root package name */
    public String f63734g = "SHA-1";

    /* renamed from: b  reason: collision with root package name */
    public String f63729b = "PKCS1Padding";

    public void a(int i, d dVar, SecureRandom secureRandom) {
        try {
            b(i, dVar, secureRandom, null);
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
    public final void b(int i, d dVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) {
        boolean z;
        OAEPParameterSpec oAEPParameterSpec;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new InvalidKeyException("Unknown mode: " + i);
                    }
                }
            }
            z = false;
            if (dVar instanceof d) {
                throw new InvalidKeyException("only support helios key");
            }
            this.f63728a = z ? 1 : 4;
            this.f63733f = dVar;
            int a2 = b.a(dVar.a());
            this.f63732e = 0;
            String str = this.f63729b;
            if (str == "NoPadding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                this.f63730c = f.b(3, a2, secureRandom);
                this.f63731d = new byte[a2];
                return;
            } else if (str == "PKCS1Padding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                f b2 = f.b(this.f63728a > 2 ? 1 : 2, a2, secureRandom);
                this.f63730c = b2;
                if (z) {
                    this.f63731d = new byte[b2.a()];
                    return;
                } else {
                    this.f63731d = new byte[a2];
                    return;
                }
            } else {
                int i2 = this.f63728a;
                if (i2 == 3 || i2 == 4) {
                    throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
                }
                if (algorithmParameterSpec == null) {
                    oAEPParameterSpec = new OAEPParameterSpec(this.f63734g, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
                } else if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
                } else {
                    oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
                }
                f c2 = f.c(4, a2, secureRandom, oAEPParameterSpec);
                this.f63730c = c2;
                if (z) {
                    this.f63731d = new byte[c2.a()];
                    return;
                } else {
                    this.f63731d = new byte[a2];
                    return;
                }
            }
        }
        z = true;
        if (dVar instanceof d) {
        }
    }

    public final byte[] c() {
        int i = this.f63732e;
        byte[] bArr = this.f63731d;
        if (i > bArr.length) {
            throw new IllegalBlockSizeException("Data must not be longer than " + this.f63731d.length + " bytes");
        }
        try {
            int i2 = this.f63728a;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return this.f63730c.h(b.e(b.d(bArr, 0, i), this.f63733f));
                        }
                        throw new AssertionError("Internal error");
                    }
                    throw new UnsupportedOperationException("only verify supported");
                }
                throw new UnsupportedOperationException("only verify supported");
            }
            return b.e(this.f63730c.g(bArr, 0, i), this.f63733f);
        } finally {
            this.f63732e = 0;
        }
    }

    public byte[] d(byte[] bArr, int i, int i2) {
        f(bArr, i, i2);
        return c();
    }

    public void e(String str) {
        String str2 = "NoPadding";
        if (!str.equalsIgnoreCase("NoPadding")) {
            str2 = "PKCS1Padding";
            if (!str.equalsIgnoreCase("PKCS1Padding")) {
                String lowerCase = str.toLowerCase(Locale.ENGLISH);
                if (lowerCase.equals("oaeppadding")) {
                    this.f63729b = "OAEP";
                    return;
                } else if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                    throw new NoSuchPaddingException("Padding " + str + " not supported");
                } else {
                    this.f63729b = "OAEP";
                    this.f63734g = str.substring(8, str.length() - 14);
                    throw new NoSuchPaddingException("MessageDigest not available for " + str);
                }
            }
        }
        this.f63729b = str2;
    }

    public final void f(byte[] bArr, int i, int i2) {
        int i3;
        if (i2 == 0 || bArr == null) {
            return;
        }
        int i4 = this.f63732e;
        int i5 = i4 + i2;
        byte[] bArr2 = this.f63731d;
        if (i5 > bArr2.length) {
            i3 = bArr2.length + 1;
        } else {
            System.arraycopy(bArr, i, bArr2, i4, i2);
            i3 = this.f63732e + i2;
        }
        this.f63732e = i3;
    }
}
