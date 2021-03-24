package io.flutter.util;
/* loaded from: classes7.dex */
public final class Preconditions {
    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }
}
