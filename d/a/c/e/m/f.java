package d.a.c.e.m;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class f {
    public static boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        try {
            context.bindService(intent, serviceConnection, i2);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public static boolean b(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public static boolean c(Context context, Intent intent) {
        try {
            context.startService(intent);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public static boolean d(Context context, Intent intent) {
        try {
            context.stopService(intent);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public static boolean e(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }
}
