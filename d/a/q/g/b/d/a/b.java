package d.a.q.g.b.d.a;

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
    public int f63697a;

    /* renamed from: c  reason: collision with root package name */
    public d f63699c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f63700d;

    /* renamed from: e  reason: collision with root package name */
    public int f63701e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q.g.b.e.a f63702f;

    /* renamed from: g  reason: collision with root package name */
    public String f63703g = "SHA-1";

    /* renamed from: b  reason: collision with root package name */
    public String f63698b = "PKCS1Padding";

    public void a(int i2, d.a.q.g.b.e.a aVar, SecureRandom secureRandom) {
        try {
            b(i2, aVar, secureRandom, null);
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
    public final void b(int i2, d.a.q.g.b.e.a aVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) {
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
            if (aVar instanceof d.a.q.g.b.e.a) {
                throw new InvalidKeyException("only support helios key");
            }
            this.f63697a = z ? 1 : 4;
            this.f63702f = aVar;
            int a2 = a.a(aVar.b());
            this.f63701e = 0;
            String str = this.f63698b;
            if (str == "NoPadding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                this.f63699c = d.b(3, a2, secureRandom);
                this.f63700d = new byte[a2];
                return;
            } else if (str == "PKCS1Padding") {
                if (algorithmParameterSpec != null) {
                    throw new InvalidAlgorithmParameterException("Parameters not supported");
                }
                d b2 = d.b(this.f63697a > 2 ? 1 : 2, a2, secureRandom);
                this.f63699c = b2;
                if (z) {
                    this.f63700d = new byte[b2.a()];
                    return;
                } else {
                    this.f63700d = new byte[a2];
                    return;
                }
            } else {
                int i3 = this.f63697a;
                if (i3 == 3 || i3 == 4) {
                    throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
                }
                if (algorithmParameterSpec == null) {
                    oAEPParameterSpec = new OAEPParameterSpec(this.f63703g, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
                } else if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
                } else {
                    oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
                }
                d c2 = d.c(4, a2, secureRandom, oAEPParameterSpec);
                this.f63699c = c2;
                if (z) {
                    this.f63700d = new byte[c2.a()];
                    return;
                } else {
                    this.f63700d = new byte[a2];
                    return;
                }
            }
        }
        z = true;
        if (aVar instanceof d.a.q.g.b.e.a) {
        }
    }

    public final byte[] c() {
        int i2 = this.f63701e;
        byte[] bArr = this.f63700d;
        if (i2 > bArr.length) {
            throw new IllegalBlockSizeException("Data must not be longer than " + this.f63700d.length + " bytes");
        }
        try {
            int i3 = this.f63697a;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            return this.f63699c.h(a.e(a.d(bArr, 0, i2), this.f63702f));
                        }
                        throw new AssertionError("Internal error");
                    }
                    throw new UnsupportedOperationException("only verify supported");
                }
                throw new UnsupportedOperationException("only verify supported");
            }
            return a.e(this.f63699c.g(bArr, 0, i2), this.f63702f);
        } finally {
            this.f63701e = 0;
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
                    this.f63698b = "OAEP";
                    return;
                } else if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                    throw new NoSuchPaddingException("Padding " + str + " not supported");
                } else {
                    this.f63698b = "OAEP";
                    this.f63703g = str.substring(8, str.length() - 14);
                    throw new NoSuchPaddingException("MessageDigest not available for " + str);
                }
            }
        }
        this.f63698b = str2;
    }

    public final void f(byte[] bArr, int i2, int i3) {
        int i4;
        if (i3 == 0 || bArr == null) {
            return;
        }
        int i5 = this.f63701e;
        int i6 = i5 + i3;
        byte[] bArr2 = this.f63700d;
        if (i6 > bArr2.length) {
            i4 = bArr2.length + 1;
        } else {
            System.arraycopy(bArr, i2, bArr2, i5, i3);
            i4 = this.f63701e + i3;
        }
        this.f63701e = i4;
    }
}
