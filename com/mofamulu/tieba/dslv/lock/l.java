package com.mofamulu.tieba.dslv.lock;

import android.content.Context;
import android.util.TypedValue;
import android.view.Window;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class l {
    public static void a(Window window) {
        if (window.isFloating() && window.getContext().getResources().getBoolean(R.bool.alp_is_large_screen)) {
            window.setLayout(window.getContext().getResources().getDimensionPixelSize(R.dimen.alp_dialog_width_large), window.getContext().getResources().getDimensionPixelSize(R.dimen.alp_dialog_height_large));
        }
    }

    public static int a(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue.resourceId;
        }
        return 0;
    }
}
