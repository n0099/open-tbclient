package org.chromium.base;

import org.chromium.base.annotations.JNINamespace;
@JNINamespace("base::android")
/* loaded from: classes2.dex */
public class ImportantFileWriterAndroid {

    /* loaded from: classes2.dex */
    public interface Natives {
        boolean writeFileAtomically(String str, byte[] bArr);
    }

    public static boolean writeFileAtomically(String str, byte[] bArr) {
        return ImportantFileWriterAndroidJni.get().writeFileAtomically(str, bArr);
    }
}
