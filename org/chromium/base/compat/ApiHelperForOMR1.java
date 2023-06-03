package org.chromium.base.compat;

import android.annotation.TargetApi;
import android.view.Window;
import org.chromium.base.annotations.VerifiesOnOMR1;
@TargetApi(27)
@VerifiesOnOMR1
/* loaded from: classes2.dex */
public final class ApiHelperForOMR1 {
    public static boolean isWideColorGamut(Window window) {
        return window.isWideColorGamut();
    }
}
