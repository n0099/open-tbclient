package org.chromium.base.compat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipDescription;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.autofill.AutofillManager;
import org.chromium.base.StrictModeContext;
import org.chromium.base.annotations.VerifiesOnO;
@VerifiesOnO
@TargetApi(26)
/* loaded from: classes2.dex */
public final class ApiHelperForO {
    public static void cancelAutofillSession(Activity activity) {
        AutofillManager autofillManager = (AutofillManager) activity.getSystemService(AutofillManager.class);
        if (autofillManager != null) {
            autofillManager.cancel();
        }
    }

    public static String[] getSplitNames(ApplicationInfo applicationInfo) {
        return applicationInfo.splitNames;
    }

    public static long getTimestamp(ClipDescription clipDescription) {
        return clipDescription.getTimestamp();
    }

    public static boolean isInstantApp(PackageManager packageManager) {
        return packageManager.isInstantApp();
    }

    public static boolean isScreenWideColorGamut(Configuration configuration) {
        return configuration.isScreenWideColorGamut();
    }

    public static boolean isWideColorGamut(Display display) {
        return display.isWideColorGamut();
    }

    public static void notifyValueChangedForAutofill(View view2) {
        AutofillManager autofillManager = (AutofillManager) view2.getContext().getSystemService(AutofillManager.class);
        if (autofillManager != null) {
            autofillManager.notifyValueChanged(view2);
        }
    }

    public static Context createContextForSplit(Context context, String str) throws PackageManager.NameNotFoundException {
        StrictModeContext allowDiskReads = StrictModeContext.allowDiskReads();
        try {
            Context createContextForSplit = context.createContextForSplit(str);
            if (allowDiskReads != null) {
                allowDiskReads.close();
            }
            return createContextForSplit;
        } catch (Throwable th) {
            if (allowDiskReads != null) {
                try {
                    allowDiskReads.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void setColorMode(Window window, int i) {
        window.setColorMode(i);
    }

    public static void setDefaultFocusHighlightEnabled(View view2, boolean z) {
        view2.setDefaultFocusHighlightEnabled(z);
    }
}
