package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes18.dex */
public class ea extends ed {

    /* renamed from: a  reason: collision with root package name */
    private String f4640a;

    public ea(Context context, int i, String str) {
        super(context, i);
        this.f4640a = str;
    }

    private String[] a() {
        if (!TextUtils.isEmpty(this.f4640a)) {
            String b = bc.b(this.f4640a);
            if (!TextUtils.isEmpty(b)) {
                return b.contains(",") ? b.split(",") : new String[]{b};
            }
        }
        return null;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo159a() {
        return 24;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo159a() {
        return ho.AppIsInstalled;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo159a() {
        String[] a2 = a();
        if (a2 == null || a2.length <= 0) {
            return null;
        }
        PackageManager packageManager = this.f232a.getPackageManager();
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
