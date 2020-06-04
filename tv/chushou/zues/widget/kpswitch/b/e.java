package tv.chushou.zues.widget.kpswitch.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
/* loaded from: classes5.dex */
public class e {
    public static int nRK = 0;

    public static boolean D(View view, int i) {
        if (view.isInEditMode()) {
            return false;
        }
        tv.chushou.zues.utils.e.d("ViewUtil", String.format("refresh Height %d %d", Integer.valueOf(view.getHeight()), Integer.valueOf(i)));
        if (view.getHeight() != i) {
            nRK = i;
            Context context = view.getContext();
            int i2 = nRK;
            if (gK(context)) {
                i2 += tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(context);
            }
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

    public static boolean isFullScreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) != 0;
    }

    @TargetApi(19)
    public static boolean A(Activity activity) {
        return Build.VERSION.SDK_INT >= 19 && (activity.getWindow().getAttributes().flags & 67108864) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(16)
    public static boolean aD(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            return ((ViewGroup) activity.findViewById(16908290)).getChildAt(0).getFitsSystemWindows();
        }
        return false;
    }

    private static boolean gK(Context context) {
        Window window;
        View decorView;
        Activity activity = getActivity(context);
        return (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null || (decorView.getSystemUiVisibility() & 4) == 0) ? false : true;
    }

    private static Activity getActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return getActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }
}
