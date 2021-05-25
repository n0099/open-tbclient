package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f32007a = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (!b(host)) {
                if (!c(host)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : f32007a) {
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
        for (String str2 : c.j()) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
