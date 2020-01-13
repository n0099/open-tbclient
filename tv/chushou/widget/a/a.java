package tv.chushou.widget.a;

import android.app.Activity;
import android.content.Context;
import tv.chushou.widget.a.b;
/* loaded from: classes4.dex */
public class a {
    public static void q(Context context, boolean z) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (z) {
                activity.overridePendingTransition(b.a.commonres_activity_enter_right, b.a.commonres_activity_exit_left);
            } else {
                activity.overridePendingTransition(b.a.commonres_activity_enter_left, b.a.commonres_activity_exit_right);
            }
        }
    }
}
