package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes14.dex */
public class j {
    private final int poT;
    private final a poU;

    public j(a aVar) {
        this(aVar, 16384);
    }

    public j(a aVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.poT = i;
        this.poU = aVar;
    }

    public long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        byte[] bArr = this.poU.get(this.poT);
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.poT);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            } finally {
                this.poU.release(bArr);
            }
        }
    }
}
