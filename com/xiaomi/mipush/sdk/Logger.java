package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.de;
import com.xiaomi.push.df;
import java.io.File;
/* loaded from: classes7.dex */
public class Logger {
    public static boolean sDisablePushLog = false;
    public static LoggerInterface sUserLogger;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    @Deprecated
    public static File getLogFile(String str) {
        return null;
    }

    public static LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    public static boolean hasWritePermission(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if (StorageUtils.EXTERNAL_STORAGE_PERMISSION.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (hasWritePermission(r4) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setPushLog(Context context) {
        boolean z = true;
        boolean z2 = false;
        boolean z3 = sUserLogger != null;
        if (!sDisablePushLog) {
            z2 = z3;
        }
        z = false;
        com.xiaomi.channel.commonutils.logger.b.a(new de(z2 ? sUserLogger : null, z ? new df(context) : null));
    }

    @Deprecated
    public static void uploadLogFile(Context context, boolean z) {
    }
}
