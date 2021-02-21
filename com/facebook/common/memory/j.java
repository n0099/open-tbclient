package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes6.dex */
public class j {
    private final int pzD;
    private final a pzE;

    public j(a aVar) {
        this(aVar, 16384);
    }

    public j(a aVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.pzD = i;
        this.pzE = aVar;
    }

    public long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        byte[] bArr = this.pzE.get(this.pzD);
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.pzD);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            } finally {
                this.pzE.release(bArr);
            }
        }
    }
}
