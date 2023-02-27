package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.splashscreen.h;
/* loaded from: classes8.dex */
public final class c {
    public static void a(View view2, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (i2 >= 0) {
                marginLayoutParams.bottomMargin = com.kwad.sdk.b.kwai.a.a(view2.getContext(), i2);
            }
            if (i3 >= 0) {
                marginLayoutParams.leftMargin = com.kwad.sdk.b.kwai.a.a(view2.getContext(), i3);
            }
            if (i4 >= 0) {
                marginLayoutParams.rightMargin = com.kwad.sdk.b.kwai.a.a(view2.getContext(), i4);
            }
        }
    }

    public static boolean b(h hVar) {
        int i = hVar.xV;
        return i == 2 || i == 3;
    }

    public static int c(h hVar) {
        int i = hVar.xV;
        if (i == 0) {
            return 1;
        }
        if (i == 3 || i == 1) {
            return 2;
        }
        return i == 2 ? 3 : 1;
    }

    public static boolean d(Context context, int i, int i2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        int a = com.kwad.sdk.b.kwai.a.a(context, 10.0f);
        return Math.abs(i - i3) <= a && Math.abs(i2 - i4) <= a;
    }
}
