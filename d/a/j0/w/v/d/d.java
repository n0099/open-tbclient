package d.a.j0.w.v.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes3.dex */
public class d {
    @TargetApi(16)
    public static boolean a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            return ((ViewGroup) activity.findViewById(16908290)).getChildAt(0).getFitsSystemWindows();
        }
        return false;
    }

    public static boolean b(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) != 0;
    }

    @TargetApi(19)
    public static boolean c(Activity activity) {
        return Build.VERSION.SDK_INT >= 19 && (activity.getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0;
    }

    public static boolean d(View view, int i2) {
        if (view.isInEditMode() || view.getHeight() == i2 || Math.abs(view.getHeight() - i2) == c.a(view.getContext())) {
            return false;
        }
        int h2 = b.h(view.getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, h2));
            return true;
        }
        layoutParams.height = h2;
        view.requestLayout();
        return true;
    }
}
