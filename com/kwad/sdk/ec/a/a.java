package com.kwad.sdk.ec.a;

import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes3.dex */
public class a {
    public static String a(String str, int i2, String str2) {
        return TextUtils.isEmpty(str2) ? str : (i2 == 0 || i2 == 3) ? a(str, str2) : str;
    }

    public static String a(String str, String str2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("returnBack", "liveunion_" + KsAdSDKImpl.get().getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return appendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }
}
