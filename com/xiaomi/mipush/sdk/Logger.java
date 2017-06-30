package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
/* loaded from: classes2.dex */
public class Logger {
    private static boolean sDisablePushLog = false;
    private static LoggerInterface sUserLogger = null;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    private static boolean hasWritePermission(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    private static void setPushLog(Context context) {
        boolean z = sUserLogger != null;
        com.xiaomi.push.log.f fVar = new com.xiaomi.push.log.f(context);
        if (!sDisablePushLog && hasWritePermission(context) && z) {
            com.xiaomi.channel.commonutils.logger.b.a(new com.xiaomi.push.log.e(sUserLogger, fVar));
        } else if (!sDisablePushLog && hasWritePermission(context)) {
            com.xiaomi.channel.commonutils.logger.b.a(fVar);
        } else if (z) {
            com.xiaomi.channel.commonutils.logger.b.a(sUserLogger);
        } else {
            com.xiaomi.channel.commonutils.logger.b.a(new com.xiaomi.push.log.e(null, null));
        }
    }
}
