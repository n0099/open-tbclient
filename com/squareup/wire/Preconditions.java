package com.squareup.wire;
/* loaded from: classes18.dex */
final class Preconditions {
    private Preconditions() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(String.valueOf(str) + " == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
