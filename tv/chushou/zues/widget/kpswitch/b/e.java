package tv.chushou.zues.widget.kpswitch.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class e {
    public static int nYO = 0;

    public static boolean f(View view, int i) {
        if (view.isInEditMode()) {
            return false;
        }
        tv.chushou.zues.utils.e.d("ViewUtil", String.format("refresh Height %d %d", Integer.valueOf(view.getHeight()), Integer.valueOf(i)));
        if (view.getHeight() != i) {
            nYO = i;
            if (Math.abs(view.getHeight() - i) != tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext())) {
                int i2 = nYO;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    view.setLayoutParams(new ViewGroup.LayoutParams(-1, i2));
                } else {
                    layoutParams.height = i2;
                    view.requestLayout();
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean isFullScreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) != 0;
    }

    @TargetApi(19)
    public static boolean C(Activity activity) {
        return Build.VERSION.SDK_INT >= 19 && (activity.getWindow().getAttributes().flags & 67108864) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(16)
    public static boolean E(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            return ((ViewGroup) activity.findViewById(16908290)).getChildAt(0).getFitsSystemWindows();
        }
        return false;
    }
}
