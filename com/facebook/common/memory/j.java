package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes12.dex */
public class j {
    private final int lHV;
    private final a lHW;

    public j(a aVar) {
        this(aVar, 16384);
    }

    public j(a aVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.lHV = i;
        this.lHW = aVar;
    }

    public long e(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        byte[] bArr = this.lHW.get(this.lHV);
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.lHV);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            } finally {
                this.lHW.release(bArr);
            }
        }
    }
}
