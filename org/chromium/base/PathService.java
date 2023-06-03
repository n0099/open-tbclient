package org.chromium.base;

import org.chromium.base.annotations.JNINamespace;
@JNINamespace("base::android")
/* loaded from: classes2.dex */
public abstract class PathService {
    public static final int DIR_MODULE = 3;

    /* loaded from: classes2.dex */
    public interface Natives {
        void override(int i, String str);
    }

    public static void override(int i, String str) {
        PathServiceJni.get().override(i, str);
    }
}
