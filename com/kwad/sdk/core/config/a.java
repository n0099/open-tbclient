package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;
/* loaded from: classes5.dex */
public final class a {
    public static final String[] Tn = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean ae(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (bq(host)) {
                return true;
            }
            return br(host);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean bq(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : Tn) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean br(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : d.rI()) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
