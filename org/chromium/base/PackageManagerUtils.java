package org.chromium.base;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.TransactionTooLargeException;
import com.baidu.searchbox.IntentConstants;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class PackageManagerUtils {
    public static final String SAMPLE_URL = "http://";
    public static final String TAG = "PackageManagerUtils";

    public static Intent getQueryInstalledBrowsersIntent() {
        return new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse("http://")).addCategory("android.intent.category.BROWSABLE");
    }

    public static Intent getQueryInstalledHomeLaunchersIntent() {
        return new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
    }

    public static List<ResolveInfo> queryAllLaunchersInfo() {
        return queryIntentActivities(getQueryInstalledHomeLaunchersIntent(), 131072);
    }

    public static List<ResolveInfo> queryAllWebBrowsersInfo() {
        return queryIntentActivities(getQueryInstalledBrowsersIntent(), 131072);
    }

    public static ResolveInfo resolveDefaultWebBrowserActivity() {
        return resolveActivity(getQueryInstalledBrowsersIntent(), 0);
    }

    public static void handleExpectedExceptionsOrRethrow(RuntimeException runtimeException, Intent intent) {
        if (!(runtimeException instanceof NullPointerException) && !(runtimeException.getCause() instanceof TransactionTooLargeException)) {
            throw runtimeException;
        }
        Log.e(TAG, "Could not resolve Activity for intent " + intent.toString(), runtimeException);
    }

    public static List<ResolveInfo> queryIntentActivities(Intent intent, int i) {
        try {
            StrictModeContext allowDiskReads = StrictModeContext.allowDiskReads();
            List<ResolveInfo> queryIntentActivities = ContextUtils.getApplicationContext().getPackageManager().queryIntentActivities(intent, i);
            if (allowDiskReads != null) {
                allowDiskReads.close();
            }
            return queryIntentActivities;
        } catch (RuntimeException e) {
            handleExpectedExceptionsOrRethrow(e, intent);
            return Collections.emptyList();
        }
    }

    public static ResolveInfo resolveActivity(Intent intent, int i) {
        try {
            StrictModeContext allowDiskWrites = StrictModeContext.allowDiskWrites();
            ResolveInfo resolveActivity = ContextUtils.getApplicationContext().getPackageManager().resolveActivity(intent, i);
            if (allowDiskWrites != null) {
                allowDiskWrites.close();
            }
            return resolveActivity;
        } catch (RuntimeException e) {
            handleExpectedExceptionsOrRethrow(e, intent);
            return null;
        }
    }
}
