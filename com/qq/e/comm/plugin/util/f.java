package com.qq.e.comm.plugin.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class f {
    @Nullable
    public static Activity a(Context context) {
        if (context instanceof ContextWrapper) {
            return context instanceof Activity ? (Activity) context : a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean a(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (activity.isFinishing() || activity.isDestroyed()) {
                return false;
            }
        } else if (activity.isFinishing()) {
            return false;
        }
        return true;
    }
}
