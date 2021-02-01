package com.kwad.sdk.glide.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
/* loaded from: classes3.dex */
public final class j {
    @NonNull
    public static <T> T a(@Nullable T t) {
        return (T) a(t, "Argument must not be null");
    }

    @NonNull
    public static <T> T a(@Nullable T t, @NonNull String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
        return t;
    }

    @NonNull
    public static String a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T a(@NonNull T t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t;
    }

    public static void a(boolean z, @NonNull String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
