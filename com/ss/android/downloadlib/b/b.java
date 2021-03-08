package com.ss.android.downloadlib.b;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.ss.android.downloadlib.f.i;
/* loaded from: classes6.dex */
public class b {
    public static boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        return "market".equals(scheme) || "appmarket".equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || "samsungapps".equals(scheme);
    }

    public static String ai(@NonNull Uri uri) {
        return i.a(uri.getQueryParameter("id"), uri.getQueryParameter("packagename"), uri.getQueryParameter(Config.INPUT_DEF_PKG), uri.getQueryParameter("package_name"), uri.getQueryParameter("appId"));
    }
}
