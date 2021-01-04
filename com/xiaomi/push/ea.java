package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes6.dex */
public class ea extends ed {

    /* renamed from: a  reason: collision with root package name */
    private String f14258a;

    public ea(Context context, int i, String str) {
        super(context, i);
        this.f14258a = str;
    }

    private String[] a() {
        if (!TextUtils.isEmpty(this.f14258a)) {
            String b2 = bc.b(this.f14258a);
            if (!TextUtils.isEmpty(b2)) {
                return b2.contains(",") ? b2.split(",") : new String[]{b2};
            }
        }
        return null;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo185a() {
        return 24;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo185a() {
        return ho.AppIsInstalled;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo185a() {
        String[] a2 = a();
        if (a2 == null || a2.length <= 0) {
            return null;
        }
        PackageManager packageManager = this.f310a.getPackageManager();
        StringBuilder sb = new StringBuilder();
        for (String str : a2) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 16384);
                if (packageInfo != null) {
                    if (sb.length() > 0) {
                        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    }
                    sb.append(packageInfo.applicationInfo.loadLabel(packageManager).toString()).append(",").append(packageInfo.packageName).append(",").append(packageInfo.versionName).append(",").append(packageInfo.versionCode).append(",").append(packageInfo.firstInstallTime);
                }
            } catch (Exception e) {
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}
