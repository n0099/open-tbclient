package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes6.dex */
public class j {
    private final int pzd;
    private final a pze;

    public j(a aVar) {
        this(aVar, 16384);
    }

    public j(a aVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.pzd = i;
        this.pze = aVar;
    }

    public long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        byte[] bArr = this.pze.get(this.pzd);
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.pzd);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            } finally {
                this.pze.release(bArr);
            }
        }
    }
}
