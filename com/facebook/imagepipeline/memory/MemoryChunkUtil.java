package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
/* loaded from: classes5.dex */
public class MemoryChunkUtil {
    public static int adjustByteCount(int i, int i2, int i3) {
        return Math.min(Math.max(0, i3 - i), i2);
    }

    public static void checkBounds(int i, int i2, int i3, int i4, int i5) {
        Preconditions.checkArgument(i4 >= 0);
        Preconditions.checkArgument(i >= 0);
        Preconditions.checkArgument(i3 >= 0);
        Preconditions.checkArgument(i + i4 <= i5);
        Preconditions.checkArgument(i3 + i4 <= i2);
    }
}
