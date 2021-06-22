package d.a.h.a.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.browser.core.util.BdLog;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f43709a = "b";

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return ContextCompat.checkPermissionGranted(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        } catch (Throwable th) {
            BdLog.c(f43709a, th);
            return !ApiUtil.shouldCheckPermission();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (com.baidu.permissionhelper.context.ContextCompat.checkPermissionGranted(r5, "android.permission.READ_EXTERNAL_STORAGE") != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            boolean checkPermissionGranted = ContextCompat.checkPermissionGranted(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (Build.VERSION.SDK_INT >= 16) {
                if (!checkPermissionGranted) {
                }
                z = true;
                return z;
            }
            return checkPermissionGranted;
        } catch (Throwable th) {
            BdLog.c(f43709a, th);
            return !ApiUtil.shouldCheckPermission();
        }
    }

    public static boolean c(Context context, int i2) {
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(f43709a, 0);
        if (sharedPreferences == null) {
            return true;
        }
        String str = "permission_request_code=" + String.valueOf(i2);
        boolean z = sharedPreferences.getBoolean(str, true);
        d(context, str);
        return z;
    }

    public static void d(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences(f43709a, 0)) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(str, false);
        edit.apply();
    }
}
