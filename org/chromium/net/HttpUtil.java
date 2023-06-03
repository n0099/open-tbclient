package org.chromium.net;

import org.chromium.base.annotations.JNINamespace;
@JNINamespace("net")
/* loaded from: classes2.dex */
public final class HttpUtil {

    /* loaded from: classes2.dex */
    public interface Natives {
        boolean isAllowedHeader(String str, String str2);
    }

    public static boolean isAllowedHeader(String str, String str2) {
        return HttpUtilJni.get().isAllowedHeader(str, str2);
    }
}
