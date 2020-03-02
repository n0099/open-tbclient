package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes13.dex */
public class j {
    private final int lIE;
    private final a lIF;

    public j(a aVar) {
        this(aVar, 16384);
    }

    public j(a aVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.lIE = i;
        this.lIF = aVar;
    }

    public long e(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        byte[] bArr = this.lIF.get(this.lIE);
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.lIE);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            } finally {
                this.lIF.release(bArr);
            }
        }
    }
}
