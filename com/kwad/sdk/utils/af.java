package com.kwad.sdk.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes6.dex */
public class af {
    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window.addFlags(Integer.MIN_VALUE);
            window.getDecorView().setSystemUiVisibility(1024);
            window.setStatusBarColor(0);
        }
    }

    public static void a(View view, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(0, i, 0, 0);
        view.setLayoutParams(marginLayoutParams);
    }
}
