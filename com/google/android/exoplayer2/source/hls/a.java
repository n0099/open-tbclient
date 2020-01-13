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
    private final byte[] mdF;
    private final com.google.android.exoplayer2.upstream.e muM;
    private final byte[] muN;
    private CipherInputStream muO;

    public a(com.google.android.exoplayer2.upstream.e eVar, byte[] bArr, byte[] bArr2) {
        this.muM = eVar;
        this.mdF = bArr;
        this.muN = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public long a(com.google.android.exoplayer2.upstream.g gVar) throws IOException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.mdF, "AES"), new IvParameterSpec(this.muN));
                this.muO = new CipherInputStream(new com.google.android.exoplayer2.upstream.f(this.muM, gVar), cipher);
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
        this.muO = null;
        this.muM.close();
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public int read(byte[] bArr, int i, int i2) throws IOException {
        com.google.android.exoplayer2.util.a.checkState(this.muO != null);
        int read = this.muO.read(bArr, i, i2);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    @Override // com.google.android.exoplayer2.upstream.e
    public Uri getUri() {
        return this.muM.getUri();
    }
}
