package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes11.dex */
public class j {
    private final int lEs;
    private final a lEt;

    public j(a aVar) {
        this(aVar, 16384);
    }

    public j(a aVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.lEs = i;
        this.lEt = aVar;
    }

    public long e(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        byte[] bArr = this.lEt.get(this.lEs);
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.lEs);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            } finally {
                this.lEt.release(bArr);
            }
        }
    }
}
