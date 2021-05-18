package com.sina.weibo.sdk.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;
/* loaded from: classes7.dex */
public class UIUtils {
    public static int dip2px(int i2, Context context) {
        return (int) ((i2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void showAlert(Context context, String str, String str2) {
        if (context != null) {
            new AlertDialog.Builder(context).setTitle(str).setMessage(str2).create().show();
        }
    }

    public static void showToast(Context context, int i2, int i3) {
        if (context != null) {
            Toast.makeText(context, i2, i3).show();
        }
    }

    public static void showToastInCenter(Context context, int i2, int i3) {
        if (context != null) {
            Toast makeText = Toast.makeText(context, i2, i3);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
    }

    public static void showToast(Context context, CharSequence charSequence, int i2) {
        if (context != null) {
            Toast.makeText(context, charSequence, i2).show();
        }
    }

    public static void showAlert(Context context, int i2, int i3) {
        if (context != null) {
            showAlert(context, context.getString(i2), context.getString(i3));
        }
    }
}
