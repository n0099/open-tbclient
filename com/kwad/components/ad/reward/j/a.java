package com.kwad.components.ad.reward.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/* loaded from: classes10.dex */
public final class a {
    public static int a(Activity activity) {
        TextView e;
        if (activity != null && !activity.isFinishing()) {
            View findViewById = activity.getWindow().getDecorView().findViewById(16908290);
            if ((findViewById instanceof ViewGroup) && (e = e((ViewGroup) findViewById)) != null) {
                return b(e);
            }
        }
        return -1;
    }

    @SuppressLint({"InternalInsetResource"})
    public static int b(TextView textView) {
        if (textView == null) {
            return -1;
        }
        int[] iArr = new int[2];
        textView.getLocationOnScreen(iArr);
        return iArr[1];
    }

    public static TextView e(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                TextView e = e((ViewGroup) childAt);
                if (e != null) {
                    return e;
                }
            } else if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (a(textView)) {
                    return textView;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    public static boolean a(TextView textView) {
        if (textView != null && "topBarCallLabel".equals(textView.getContentDescription())) {
            return true;
        }
        return false;
    }
}
