package d.a.l0.v;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes3.dex */
public class g {
    public static boolean a(Activity activity, View view) {
        ViewGroup viewGroup;
        if (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null) {
            return false;
        }
        b(view);
        viewGroup.removeView(view);
        viewGroup.addView(view);
        return true;
    }

    public static boolean b(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup.indexOfChild(view) != -1) {
            try {
                viewGroup.removeView(view);
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
        return false;
    }
}
