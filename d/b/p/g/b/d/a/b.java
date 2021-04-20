package d.b.p.g.b.d.a;

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
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f65114a;

    /* renamed from: c  reason: collision with root package name */
    public d f65116c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f65117d;

    /* renamed from: e  reason: collision with root package name */
    public int f65118e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.p.g.b.e.a f65119f;

    /* renamed from: g  reason: collision with root package name */
    public String f65120g = "SHA-1";

    /* renamed from: b  reason: collision with root package name */
    public String f65115b = "PKCS1Padding";

    public void a(int i, d.b.p.g.b.e.a aVar, SecureRandom secureRandom) {
        try {
            b(i, aVar, secureRandom, null);
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
    public final void b(int i, d.b.p.g.b.e.a aVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) {
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
            if (aVar instanceof d.b.p.g.b.e.a) {
                throw new InvalidKeyException("only support helios key");
            }
            this.f65114a = z ? 1 : 4;
            this.f65119f = aVar;
            int a2 = a.a(aVar.b());
            this.f65118e = 0;
            String str = this.f65115b;
            if (str == "NoPadding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                this.f65116c = d.b(3, a2, secureRandom);
                this.f65117d = new byte[a2];
                return;
            } else if (str == "PKCS1Padding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                d b2 = d.b(this.f65114a > 2 ? 1 : 2, a2, secureRandom);
                this.f65116c = b2;
                if (z) {
                    this.f65117d = new byte[b2.a()];
                    return;
                } else {
                    this.f65117d = new byte[a2];
                    return;
                }
            } else {
                int i2 = this.f65114a;
                if (i2 == 3 || i2 == 4) {
                    throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
                }
                if (algorithmParameterSpec == null) {
                    oAEPParameterSpec = new OAEPParameterSpec(this.f65120g, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
                } else if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
                } else {
                    oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
                }
                d c2 = d.c(4, a2, secureRandom, oAEPParameterSpec);
                this.f65116c = c2;
                if (z) {
                    this.f65117d = new byte[c2.a()];
                    return;
                } else {
                    this.f65117d = new byte[a2];
                    return;
                }
            }
        }
        z = true;
        if (aVar instanceof d.b.p.g.b.e.a) {
        }
    }

    public final byte[] c() {
        int i = this.f65118e;
        byte[] bArr = this.f65117d;
        if (i > bArr.length) {
            throw new IllegalBlockSizeException("Data must not be longer than " + this.f65117d.length + " bytes");
        }
        try {
            int i2 = this.f65114a;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return this.f65116c.h(a.e(a.d(bArr, 0, i), this.f65119f));
                        }
                        throw new AssertionError("Internal error");
                    }
                    throw new UnsupportedOperationException("only verify supported");
                }
                throw new UnsupportedOperationException("only verify supported");
            }
            return a.e(this.f65116c.g(bArr, 0, i), this.f65119f);
        } finally {
            this.f65118e = 0;
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
                    this.f65115b = "OAEP";
                    return;
                } else if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                    throw new NoSuchPaddingException("Padding " + str + " not supported");
                } else {
                    this.f65115b = "OAEP";
                    this.f65120g = str.substring(8, str.length() - 14);
                    throw new NoSuchPaddingException("MessageDigest not available for " + str);
                }
            }
        }
        this.f65115b = str2;
    }

    public final void f(byte[] bArr, int i, int i2) {
        int i3;
        if (i2 == 0 || bArr == null) {
            return;
        }
        int i4 = this.f65118e;
        int i5 = i4 + i2;
        byte[] bArr2 = this.f65117d;
        if (i5 > bArr2.length) {
            i3 = bArr2.length + 1;
        } else {
            System.arraycopy(bArr, i, bArr2, i4, i2);
            i3 = this.f65118e + i2;
        }
        this.f65118e = i3;
    }
}
