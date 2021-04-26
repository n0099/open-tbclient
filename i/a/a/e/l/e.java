package i.a.a.e.l;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f68162a = new e();

    @TargetApi(17)
    public final boolean a(Context context) {
        if (context != null && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing()) {
                return Build.VERSION.SDK_INT < 17 || !activity.isDestroyed();
            }
            d.r.b.a.a.f.d.d.h("ViewUtils", "activity is finishing");
            return false;
        }
        d.r.b.a.a.f.d.d.h("ViewUtils", "mContext is null or not activity");
        return false;
    }

    public final void b(Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.dismiss();
    }
}
