package org.conscrypt;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
/* loaded from: classes12.dex */
public class OpenSSLSignatureRawECDSA extends SignatureSpi {
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private OpenSSLKey key;

    @Override // java.security.SignatureSpi
    protected void engineUpdate(byte b) {
        this.buffer.write(b);
    }

    @Override // java.security.SignatureSpi
    protected void engineUpdate(byte[] bArr, int i, int i2) {
        this.buffer.write(bArr, i, i2);
    }

    @Override // java.security.SignatureSpi
    protected Object engineGetParameter(String str) throws InvalidParameterException {
        return null;
    }

    private static OpenSSLKey verifyKey(OpenSSLKey openSSLKey) throws InvalidKeyException {
        if (NativeCrypto.EVP_PKEY_type(openSSLKey.getNativeRef()) != 408) {
            throw new InvalidKeyException("Non-EC key used to initialize EC signature.");
        }
        return openSSLKey;
    }

    @Override // java.security.SignatureSpi
    protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        this.key = verifyKey(OpenSSLKey.fromPrivateKey(privateKey));
    }

    @Override // java.security.SignatureSpi
    protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        this.key = verifyKey(OpenSSLKey.fromPublicKey(publicKey));
    }

    @Override // java.security.SignatureSpi
    protected void engineSetParameter(String str, Object obj) throws InvalidParameterException {
    }

    @Override // java.security.SignatureSpi
    protected byte[] engineSign() throws SignatureException {
        byte[] bArr;
        if (this.key == null) {
            throw new SignatureException("No key provided");
        }
        int ECDSA_size = NativeCrypto.ECDSA_size(this.key.getNativeRef());
        byte[] bArr2 = new byte[ECDSA_size];
        try {
            try {
                int ECDSA_sign = NativeCrypto.ECDSA_sign(this.buffer.toByteArray(), bArr2, this.key.getNativeRef());
                if (ECDSA_sign < 0) {
                    throw new SignatureException("Could not compute signature.");
                }
                if (ECDSA_sign != ECDSA_size) {
                    bArr = new byte[ECDSA_sign];
                    System.arraycopy(bArr2, 0, bArr, 0, ECDSA_sign);
                } else {
                    bArr = bArr2;
                }
                return bArr;
            } catch (Exception e) {
                throw new SignatureException(e);
            }
        } finally {
            this.buffer.reset();
        }
    }

    @Override // java.security.SignatureSpi
    protected boolean engineVerify(byte[] bArr) throws SignatureException {
        try {
            if (this.key == null) {
                throw new SignatureException("No key provided");
            }
            try {
                int ECDSA_verify = NativeCrypto.ECDSA_verify(this.buffer.toByteArray(), bArr, this.key.getNativeRef());
                if (ECDSA_verify == -1) {
                    throw new SignatureException("Could not verify signature.");
                }
                return ECDSA_verify == 1;
            } catch (Exception e) {
                throw new SignatureException(e);
            }
        } finally {
            this.buffer.reset();
        }
    }
}
