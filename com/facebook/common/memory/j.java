package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public class j {
    private final int jzT;
    private final a jzU;

    public j(a aVar) {
        this(aVar, 16384);
    }

    public j(a aVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.jzT = i;
        this.jzU = aVar;
    }

    public long g(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        byte[] bArr = this.jzU.get(this.jzT);
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.jzT);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            } finally {
                this.jzU.release(bArr);
            }
        }
    }
}
