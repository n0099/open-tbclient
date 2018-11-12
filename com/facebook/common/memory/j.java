package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public class j {
    private final int hYM;
    private final a hYN;

    public j(a aVar) {
        this(aVar, 16384);
    }

    public j(a aVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.hYM = i;
        this.hYN = aVar;
    }

    public long f(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        byte[] bArr = this.hYN.get(this.hYM);
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.hYM);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            } finally {
                this.hYN.release(bArr);
            }
        }
    }
}
