package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;
/* loaded from: classes10.dex */
public final class a {
    public static final String[] aor = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean bP(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (!cJ(host)) {
                if (!cK(host)) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean cJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : aor) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : d.Ax()) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
