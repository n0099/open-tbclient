package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
/* loaded from: classes11.dex */
public class PSSParameters extends AlgorithmParametersSpi {
    private PSSParameterSpec spec = PSSParameterSpec.DEFAULT;

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof PSSParameterSpec) {
            this.spec = (PSSParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("Only PSSParameterSpec is supported");
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(byte[] bArr) throws IOException {
        long j;
        long j2;
        long j3 = 0;
        try {
            long asn1_read_init = NativeCrypto.asn1_read_init(bArr);
            try {
                long asn1_read_sequence = NativeCrypto.asn1_read_sequence(asn1_read_init);
                int i = 20;
                try {
                    String readHash = OAEPParameters.readHash(asn1_read_sequence);
                    String readMgfHash = OAEPParameters.readMgfHash(asn1_read_sequence);
                    if (NativeCrypto.asn1_read_next_tag_is(asn1_read_sequence, 2)) {
                        try {
                            j2 = NativeCrypto.asn1_read_tagged(asn1_read_sequence);
                            try {
                                i = (int) NativeCrypto.asn1_read_uint64(j2);
                                NativeCrypto.asn1_read_free(j2);
                            } catch (Throwable th) {
                                th = th;
                                NativeCrypto.asn1_read_free(j2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            j2 = 0;
                        }
                    }
                    if (NativeCrypto.asn1_read_next_tag_is(asn1_read_sequence, 3)) {
                        long asn1_read_tagged = NativeCrypto.asn1_read_tagged(asn1_read_sequence);
                        long asn1_read_uint64 = (int) NativeCrypto.asn1_read_uint64(asn1_read_tagged);
                        NativeCrypto.asn1_read_free(asn1_read_tagged);
                        if (asn1_read_uint64 != 1) {
                            throw new IOException("Error reading ASN.1 encoding");
                        }
                    }
                    if (!NativeCrypto.asn1_read_is_empty(asn1_read_sequence) || !NativeCrypto.asn1_read_is_empty(asn1_read_init)) {
                        throw new IOException("Error reading ASN.1 encoding");
                    }
                    this.spec = new PSSParameterSpec(readHash, "MGF1", new MGF1ParameterSpec(readMgfHash), i, 1);
                    NativeCrypto.asn1_read_free(asn1_read_sequence);
                    NativeCrypto.asn1_read_free(asn1_read_init);
                } catch (Throwable th3) {
                    th = th3;
                    j3 = asn1_read_sequence;
                    j = asn1_read_init;
                    NativeCrypto.asn1_read_free(j3);
                    NativeCrypto.asn1_read_free(j);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                j = asn1_read_init;
            }
        } catch (Throwable th5) {
            th = th5;
            j = 0;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(byte[] bArr, String str) throws IOException {
        if (str == null || str.equals("ASN.1") || str.equals("X.509")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unsupported format: " + str);
    }

    @Override // java.security.AlgorithmParametersSpi
    protected <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (cls != null && cls == PSSParameterSpec.class) {
            return this.spec;
        }
        throw new InvalidParameterSpecException("Unsupported class: " + cls);
    }

    @Override // java.security.AlgorithmParametersSpi
    protected byte[] engineGetEncoded() throws IOException {
        long j;
        long j2;
        long j3;
        long j4 = 0;
        try {
            j2 = NativeCrypto.asn1_write_init();
            try {
                j = NativeCrypto.asn1_write_sequence(j2);
            } catch (IOException e) {
                e = e;
                j3 = j2;
            } catch (Throwable th) {
                th = th;
                j = 0;
            }
        } catch (IOException e2) {
            e = e2;
            j3 = 0;
        } catch (Throwable th2) {
            th = th2;
            j = 0;
            j2 = 0;
        }
        try {
            OAEPParameters.writeHashAndMgfHash(j, this.spec.getDigestAlgorithm(), (MGF1ParameterSpec) this.spec.getMGFParameters());
            if (this.spec.getSaltLength() != 20) {
                try {
                    j4 = NativeCrypto.asn1_write_tag(j, 2);
                    NativeCrypto.asn1_write_uint64(j4, this.spec.getSaltLength());
                } finally {
                    NativeCrypto.asn1_write_flush(j);
                    NativeCrypto.asn1_write_free(j4);
                }
            }
            byte[] asn1_write_finish = NativeCrypto.asn1_write_finish(j2);
            NativeCrypto.asn1_write_free(j);
            NativeCrypto.asn1_write_free(j2);
            return asn1_write_finish;
        } catch (IOException e3) {
            e = e3;
            j4 = j;
            j3 = j2;
            try {
                NativeCrypto.asn1_write_cleanup(j3);
                throw e;
            } catch (Throwable th3) {
                th = th3;
                j2 = j3;
                j = j4;
                NativeCrypto.asn1_write_free(j);
                NativeCrypto.asn1_write_free(j2);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            NativeCrypto.asn1_write_free(j);
            NativeCrypto.asn1_write_free(j2);
            throw th;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    protected byte[] engineGetEncoded(String str) throws IOException {
        if (str == null || str.equals("ASN.1") || str.equals("X.509")) {
            return engineGetEncoded();
        }
        throw new IOException("Unsupported format: " + str);
    }

    @Override // java.security.AlgorithmParametersSpi
    protected String engineToString() {
        return "Conscrypt PSS AlgorithmParameters";
    }
}
