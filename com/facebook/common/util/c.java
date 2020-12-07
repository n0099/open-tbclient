package com.facebook.common.util;

import com.facebook.common.internal.g;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes19.dex */
public class c {
    public static long a(InputStream inputStream, long j) throws IOException {
        g.checkNotNull(inputStream);
        g.checkArgument(j >= 0);
        long j2 = j;
        while (j2 > 0) {
            long skip = inputStream.skip(j2);
            if (skip > 0) {
                j2 -= skip;
            } else if (inputStream.read() != -1) {
                j2--;
            } else {
                return j - j2;
            }
        }
        return j;
    }
}
