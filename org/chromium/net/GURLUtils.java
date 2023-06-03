package org.chromium.net;

import androidx.annotation.VisibleForTesting;
import org.chromium.base.annotations.JNINamespace;
@JNINamespace("net")
/* loaded from: classes2.dex */
public final class GURLUtils {

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public interface Natives {
        String getOrigin(String str);

        String getScheme(String str);
    }

    public static String getOrigin(String str) {
        return GURLUtilsJni.get().getOrigin(str);
    }

    public static String getScheme(String str) {
        return GURLUtilsJni.get().getScheme(str);
    }
}
