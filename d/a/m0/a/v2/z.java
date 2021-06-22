package d.a.m0.a.v2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
/* loaded from: classes3.dex */
public class z {
    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean a(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        }
        return true;
    }
}
