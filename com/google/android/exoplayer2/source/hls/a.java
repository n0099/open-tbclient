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
/* loaded from: classes6.dex */
final class a implements com.google.android.exoplayer2.upstream.e {
    private final byte[] meD;
    private final com.google.android.exoplayer2.upstream.e mvK;
    private final byte[] mvL;
    private CipherInputStream mvM;

    public a(com.google.android.exoplayer2.upstream.e eVar, byte[] bArr, byte[] bArr2) {
        this.mvK = eVar;
        this.meD = bArr;
        this.mvL = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(com.google.android.exoplayer2.upstream.g gVar) throws IOException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.meD, "AES"), new IvParameterSpec(this.mvL));
                this.mvM = new CipherInputStream(new com.google.android.exoplayer2.upstream.f(this.mvK, gVar), cipher);
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
        this.mvM = null;
        this.mvK.close();
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(this.mvM != null);
        int read = this.mvM.read(bArr, i, i2);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.mvK.getUri();
    }
}
