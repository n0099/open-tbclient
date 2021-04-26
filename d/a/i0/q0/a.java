package d.a.i0.q0;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
/* loaded from: classes3.dex */
public class a {
    public static boolean a(Context context) {
        try {
            return NotificationManagerCompat.from(context.getApplicationContext()).areNotificationsEnabled();
        } catch (Exception unused) {
            return false;
        }
    }
}
