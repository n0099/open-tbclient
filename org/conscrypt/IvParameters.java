package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
/* loaded from: classes11.dex */
public class IvParameters extends AlgorithmParametersSpi {
    private byte[] iv;

    /* loaded from: classes11.dex */
    public static class AES extends IvParameters {
    }

    /* loaded from: classes11.dex */
    public static class ChaCha20 extends IvParameters {
    }

    /* loaded from: classes11.dex */
    public static class DESEDE extends IvParameters {
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (!(algorithmParameterSpec instanceof IvParameterSpec)) {
            throw new InvalidParameterSpecException("Only IvParameterSpec is supported");
        }
        this.iv = (byte[]) ((IvParameterSpec) algorithmParameterSpec).getIV().clone();
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(byte[] bArr) throws IOException {
        try {
            long asn1_read_init = NativeCrypto.asn1_read_init(bArr);
            byte[] asn1_read_octetstring = NativeCrypto.asn1_read_octetstring(asn1_read_init);
            if (!NativeCrypto.asn1_read_is_empty(asn1_read_init)) {
                throw new IOException("Error reading ASN.1 encoding");
            }
            this.iv = asn1_read_octetstring;
            NativeCrypto.asn1_read_free(asn1_read_init);
        } catch (Throwable th) {
            NativeCrypto.asn1_read_free(0L);
            throw th;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(byte[] bArr, String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            engineInit(bArr);
        } else if (str.equals("RAW")) {
            this.iv = (byte[]) bArr.clone();
        } else {
            throw new IOException("Unsupported format: " + str);
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    protected <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls != IvParameterSpec.class) {
            throw new InvalidParameterSpecException("Incompatible AlgorithmParametersSpec class: " + cls);
        }
        return new IvParameterSpec(this.iv);
    }

    @Override // java.security.AlgorithmParametersSpi
    protected byte[] engineGetEncoded() throws IOException {
        long j = 0;
        try {
            try {
                j = NativeCrypto.asn1_write_init();
                NativeCrypto.asn1_write_octetstring(j, this.iv);
                return NativeCrypto.asn1_write_finish(j);
            } catch (IOException e) {
                NativeCrypto.asn1_write_cleanup(j);
                throw e;
            }
        } finally {
            NativeCrypto.asn1_write_free(j);
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    protected byte[] engineGetEncoded(String str) throws IOException {
        if (str == null || str.equals("ASN.1")) {
            return engineGetEncoded();
        }
        if (str.equals("RAW")) {
            return (byte[]) this.iv.clone();
        }
        throw new IOException("Unsupported format: " + str);
    }

    @Override // java.security.AlgorithmParametersSpi
    protected String engineToString() {
        return "Conscrypt IV AlgorithmParameters";
    }
}
