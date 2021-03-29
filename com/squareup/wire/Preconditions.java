package com.squareup.wire;
/* loaded from: classes7.dex */
public final class Preconditions {
    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new NullPointerException(String.valueOf(str) + " == null");
    }
}
