package com.facebook.d;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
class c {
    public static int a(InputStream inputStream, int i, boolean z) throws IOException {
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int read = inputStream.read();
            if (read == -1) {
                throw new IOException("no more bytes");
            }
            if (z) {
                i2 = (read & 255) << (i3 * 8);
            } else {
                i4 <<= 8;
                i2 = read & 255;
            }
            i3++;
            i4 = i2 | i4;
        }
        return i4;
    }
}
