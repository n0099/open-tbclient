package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;
/* loaded from: classes3.dex */
public class b {
    public static final void a(d dVar, int i2) throws IOException {
        int b2 = dVar.b();
        if (b2 == i2) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i2) + ", read 0x" + Integer.toHexString(b2) + ".");
    }
}
