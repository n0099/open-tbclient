package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes5.dex */
final class a implements com.google.android.exoplayer2.upstream.e {
    private final byte[] mdK;
    private final com.google.android.exoplayer2.upstream.e muR;
    private final byte[] muS;
    private CipherInputStream muT;

    public a(com.google.android.exoplayer2.upstream.e eVar, byte[] bArr, byte[] bArr2) {
        this.muR = eVar;
        this.mdK = bArr;
        this.muS = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(com.google.android.exoplayer2.upstream.g gVar) throws IOException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.mdK, "AES"), new IvParameterSpec(this.muS));
                this.muT = new CipherInputStream(new com.google.android.exoplayer2.upstream.f(this.muR, gVar), cipher);
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public void close() throws IOException {
        this.muT = null;
        this.muR.close();
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(this.muT != null);
        int read = this.muT.read(bArr, i, i2);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.muR.getUri();
    }
}
