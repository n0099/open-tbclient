package i.a.a.e.n;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f72168a = new h();

    @TargetApi(17)
    public final boolean a(Context context) {
        if (context != null && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing()) {
                return Build.VERSION.SDK_INT < 17 || !activity.isDestroyed();
            }
            RLog.warn("ViewUtils", "activity is finishing");
            return false;
        }
        RLog.warn("ViewUtils", "mContext is null or not activity");
        return false;
    }

    public final void b(Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.dismiss();
    }
}
