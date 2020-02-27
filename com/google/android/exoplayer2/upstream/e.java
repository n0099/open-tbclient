package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;
/* loaded from: classes6.dex */
public interface e {

    /* loaded from: classes6.dex */
    public interface a {
        e dyT();
    }

    long a(g gVar) throws IOException;

    void close() throws IOException;

    Uri getUri();

    int read(byte[] bArr, int i, int i2) throws IOException;
}
