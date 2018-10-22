package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public class j {
    private final int hXc;
    private final a hXd;

    public j(a aVar) {
        this(aVar, 16384);
    }

    public j(a aVar, int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.hXc = i;
        this.hXd = aVar;
    }

    public long f(InputStream inputStream, OutputStream outputStream) throws IOException {
        long j = 0;
        byte[] bArr = this.hXd.get(this.hXc);
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.hXc);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            } finally {
                this.hXd.release(bArr);
            }
        }
    }
}
