package org.conscrypt;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class OpenSSLBIOInputStream extends FilterInputStream {
    private long ctx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLBIOInputStream(InputStream inputStream, boolean z) {
        super(inputStream);
        this.ctx = NativeCrypto.create_BIO_InputStream(this, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getBioContext() {
        return this.ctx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        NativeCrypto.BIO_free_all(this.ctx);
    }

    int gets(byte[] bArr) throws IOException {
        int read;
        int i = 0;
        if (bArr != null && bArr.length != 0) {
            while (i < bArr.length && (read = read()) != -1) {
                if (read == 10) {
                    if (i != 0) {
                        break;
                    }
                } else {
                    bArr[i] = (byte) read;
                    i++;
                }
            }
        }
        return i;
    }
}
