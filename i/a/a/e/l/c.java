package i.a.a.e.l;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes7.dex */
public class c {
    public static void a(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void b(Activity activity, View view) {
        if (view == null && (view = activity.getCurrentFocus()) == null) {
            return;
        }
        ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(view, 1);
    }
}
