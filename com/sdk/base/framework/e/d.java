package com.sdk.base.framework.e;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
/* loaded from: classes16.dex */
public abstract class d {
    public final void a(InputStream inputStream, OutputStream outputStream) {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        while (true) {
            int i = 0;
            while (i + 4 < 72) {
                try {
                    a(pushbackInputStream, outputStream, 4);
                    i += 4;
                } catch (c e) {
                    return;
                }
            }
            if (i + 4 == 72) {
                a(pushbackInputStream, outputStream, 4);
            } else {
                a(pushbackInputStream, outputStream, 72 - i);
            }
        }
    }

    protected void a(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i) {
        throw new c();
    }
}
