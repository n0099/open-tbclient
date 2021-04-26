package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
/* loaded from: classes6.dex */
public class MemoryChunkUtil {
    public static int adjustByteCount(int i2, int i3, int i4) {
        return Math.min(Math.max(0, i4 - i2), i3);
    }

    public static void checkBounds(int i2, int i3, int i4, int i5, int i6) {
        Preconditions.checkArgument(i5 >= 0);
        Preconditions.checkArgument(i2 >= 0);
        Preconditions.checkArgument(i4 >= 0);
        Preconditions.checkArgument(i2 + i5 <= i6);
        Preconditions.checkArgument(i4 + i5 <= i3);
    }
}
