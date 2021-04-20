package d.b.f0.l;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static long f43405a = 60000;

    /* renamed from: b  reason: collision with root package name */
    public static long f43406b = f43405a * 60;

    public static void a(Context context, long j) {
        if (j <= 0) {
            return;
        }
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("sso_action_t_m");
            intent.setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, intent, 134217728);
            alarmManager.cancel(broadcast);
            long currentTimeMillis = System.currentTimeMillis() + j;
            if (Build.VERSION.SDK_INT >= 23) {
                alarmManager.setExactAndAllowWhileIdle(0, currentTimeMillis, broadcast);
            } else if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, currentTimeMillis, broadcast);
            } else {
                alarmManager.set(0, currentTimeMillis, broadcast);
            }
        } catch (Throwable th) {
            c.d(th);
        }
    }
}
