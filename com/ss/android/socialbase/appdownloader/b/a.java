package com.ss.android.socialbase.appdownloader.b;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13013a;

    static {
        boolean z = true;
        StringBuilder sb = new StringBuilder();
        boolean z2 = !TextUtils.isEmpty(Build.VERSION.RELEASE);
        boolean z3 = !TextUtils.isEmpty(Build.ID);
        if (!"REL".equals(Build.VERSION.CODENAME) || TextUtils.isEmpty(Build.MODEL)) {
            z = false;
        }
        sb.append("AppDownloader");
        if (z2) {
            sb.append("/").append(Build.VERSION.RELEASE);
        }
        sb.append(" (Linux; U; Android");
        if (z2) {
            sb.append(" ").append(Build.VERSION.RELEASE);
        }
        if (z || z3) {
            sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            if (z) {
                sb.append(" ").append(Build.MODEL);
            }
            if (z3) {
                sb.append(" Build/").append(Build.ID);
            }
        }
        sb.append(")");
        f13013a = sb.toString();
    }
}
