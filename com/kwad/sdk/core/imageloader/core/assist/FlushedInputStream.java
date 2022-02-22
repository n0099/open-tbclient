package com.kwad.sdk.core.imageloader.core.assist;

import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class FlushedInputStream extends FilterInputStream {
    public FlushedInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) {
        long j3 = 0;
        while (j3 < j2) {
            long skip = ((FilterInputStream) this).in.skip(j2 - j3);
            if (skip == 0) {
                if (read() < 0) {
                    break;
                }
                skip = 1;
            }
            j3 += skip;
        }
        return j3;
    }
}
