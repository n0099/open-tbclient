package com.facebook.common.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public final class a {
    public static long f(InputStream inputStream, OutputStream outputStream) throws IOException {
        g.checkNotNull(inputStream);
        g.checkNotNull(outputStream);
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += read;
            } else {
                return j;
            }
        }
    }

    public static int a(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        g.checkNotNull(inputStream);
        g.checkNotNull(bArr);
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        return i3;
    }
}
