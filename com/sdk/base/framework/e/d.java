package com.sdk.base.framework.e;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
/* loaded from: classes6.dex */
public abstract class d {
    public final void a(InputStream inputStream, OutputStream outputStream) {
        int i;
        int i2;
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        while (true) {
            int i3 = 0;
            while (true) {
                i = i3 + 4;
                i2 = 4;
                if (i >= 72) {
                    break;
                }
                try {
                    a(pushbackInputStream, outputStream, 4);
                    i3 = i;
                } catch (c unused) {
                    return;
                }
            }
            if (i != 72) {
                i2 = 72 - i3;
            }
            a(pushbackInputStream, outputStream, i2);
        }
    }

    public void a(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i) {
        throw new c();
    }
}
