package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public class j {
    private final int kas;
    private final a kat;

    public j(a aVar) {
        this(aVar, 16384);
    }

    public j(a aVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.kas = i;
        this.kat = aVar;
    }

    public long e(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        byte[] bArr = this.kat.get(this.kas);
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.kas);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            } finally {
                this.kat.release(bArr);
            }
        }
    }
}
