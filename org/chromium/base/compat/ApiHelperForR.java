package org.chromium.base.compat;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.Display;
import org.chromium.base.annotations.VerifiesOnR;
@VerifiesOnR
@TargetApi(30)
/* loaded from: classes2.dex */
public final class ApiHelperForR {
    public static Display getDisplay(Context context) throws UnsupportedOperationException {
        return context.getDisplay();
    }
}
