package com.facebook.d;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes11.dex */
class c {
    public static int a(InputStream inputStream, int i, boolean z) throws IOException {
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int read = inputStream.read();
            if (read == -1) {
                throw new IOException("no more bytes");
            }
            if (z) {
                i2 = (read & 255) << (i4 * 8);
            } else {
                i3 <<= 8;
                i2 = read & 255;
            }
            i3 |= i2;
        }
        return i3;
    }
}
