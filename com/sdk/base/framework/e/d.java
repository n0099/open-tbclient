package com.sdk.base.framework.e;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
/* loaded from: classes6.dex */
public abstract class d {
    public final void a(InputStream inputStream, OutputStream outputStream) {
        int i2;
        int i3;
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        while (true) {
            int i4 = 0;
            while (true) {
                i2 = i4 + 4;
                i3 = 4;
                if (i2 >= 72) {
                    break;
                }
                try {
                    a(pushbackInputStream, outputStream, 4);
                    i4 = i2;
                } catch (c unused) {
                    return;
                }
            }
            if (i2 != 72) {
                i3 = 72 - i4;
            }
            a(pushbackInputStream, outputStream, i3);
        }
    }

    public void a(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i2) {
        throw new c();
    }
}
