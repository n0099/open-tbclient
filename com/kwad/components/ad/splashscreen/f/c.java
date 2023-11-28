package com.kwad.components.ad.splashscreen.f;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes10.dex */
public final class c {
    public static void a(View view2, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = com.kwad.sdk.d.a.a.a(view2.getContext(), 16.0f);
            marginLayoutParams.leftMargin = com.kwad.sdk.d.a.a.a(view2.getContext(), 16.0f);
        }
    }

    public static boolean a(Context context, int i, int i2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        int a = com.kwad.sdk.d.a.a.a(context, 10.0f);
        if (Math.abs(i - i3) <= a && Math.abs(i2 - i4) <= a) {
            return true;
        }
        return false;
    }

    public static boolean z(@NonNull AdInfo adInfo) {
        if (adInfo.adSplashInfo.skipButtonPosition == 0) {
            return true;
        }
        return false;
    }
}
