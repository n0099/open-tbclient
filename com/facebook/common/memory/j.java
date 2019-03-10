package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public class j {
    private final int jAm;
    private final a jAn;

    public j(a aVar) {
        this(aVar, 16384);
    }

    public j(a aVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.jAm = i;
        this.jAn = aVar;
    }

    public long g(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        byte[] bArr = this.jAn.get(this.jAm);
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.jAm);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            } finally {
                this.jAn.release(bArr);
            }
        }
    }
}
