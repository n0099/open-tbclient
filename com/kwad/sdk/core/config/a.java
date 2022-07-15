package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;
/* loaded from: classes5.dex */
public final class a {
    public static final String[] a = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (b(host)) {
                return true;
            }
            return c(host);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : a) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : d.g()) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
