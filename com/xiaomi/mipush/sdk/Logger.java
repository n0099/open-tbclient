package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.dl;
import com.xiaomi.push.dm;
import java.io.File;
/* loaded from: classes12.dex */
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

    public static File getLogFile(String str) {
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isFile() && !listFiles[i].getName().contains("lock") && listFiles[i].getName().contains(TbConfig.TMP_LOG_DIR_NAME)) {
                        return listFiles[i];
                    }
                }
                return null;
            }
            return null;
        } catch (NullPointerException e) {
            com.xiaomi.channel.commonutils.logger.b.d("null pointer exception while retrieve file.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static LoggerInterface getUserLogger() {
        return sUserLogger;
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

    public static void setPushLog(Context context) {
        boolean z = false;
        boolean z2 = sUserLogger != null;
        if (sDisablePushLog) {
            z2 = false;
        } else if (hasWritePermission(context)) {
            z = true;
        }
        com.xiaomi.channel.commonutils.logger.b.a(new dl(z2 ? sUserLogger : null, z ? new dm(context) : null));
    }

    public static void uploadLogFile(Context context, boolean z) {
        com.xiaomi.push.ai.a(context).a(new u(context, z));
    }
}
