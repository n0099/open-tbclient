package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.item.TipsConfigItem;
/* loaded from: classes7.dex */
public final class q {
    public static String a(Context context) {
        String a2 = com.kwad.sdk.core.config.c.a(TipsConfigItem.TipConfigData.BOTTOM);
        return (!TextUtils.isEmpty(a2) || context == null) ? a2 : context.getString(R.string.ksad_default_no_more_tip_or_toast_txt);
    }

    public static String b(Context context) {
        String a2 = com.kwad.sdk.core.config.c.a("toast");
        return (!TextUtils.isEmpty(a2) || context == null) ? a2 : context.getString(R.string.ksad_default_no_more_tip_or_toast_txt);
    }

    public static String c(Context context) {
        return context.getString(R.string.ksad_network_error_toast);
    }

    public static String d(Context context) {
        return context.getString(R.string.ksad_page_loading_network_error_title);
    }

    public static String e(Context context) {
        return context.getString(R.string.ksad_page_loading_network_error_sub_title);
    }

    public static String f(Context context) {
        return context.getString(R.string.ksad_data_error_toast);
    }

    public static String g(Context context) {
        return context.getString(R.string.ksad_page_loading_data_error_title);
    }

    public static String h(Context context) {
        return context.getString(R.string.ksad_page_loading_data_error_sub_title);
    }

    public static String i(Context context) {
        return context.getString(R.string.ksad_page_loading_error_retry);
    }

    public static String j(Context context) {
        return context.getString(R.string.ksad_half_page_loading_error_tip);
    }
}
