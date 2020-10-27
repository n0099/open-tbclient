package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes12.dex */
public class ea extends ed {

    /* renamed from: a  reason: collision with root package name */
    private String f4868a;

    public ea(Context context, int i, String str) {
        super(context, i);
        this.f4868a = str;
    }

    private String[] a() {
        if (!TextUtils.isEmpty(this.f4868a)) {
            String b = bc.b(this.f4868a);
            if (!TextUtils.isEmpty(b)) {
                return b.contains(Constants.ACCEPT_TIME_SEPARATOR_SP) ? b.split(Constants.ACCEPT_TIME_SEPARATOR_SP) : new String[]{b};
            }
        }
        return null;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo166a() {
        return 24;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo166a() {
        return ho.AppIsInstalled;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo166a() {
        String[] a2 = a();
        if (a2 == null || a2.length <= 0) {
            return null;
        }
        PackageManager packageManager = this.f229a.getPackageManager();
        StringBuilder sb = new StringBuilder();
        for (String str : a2) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 16384);
                if (packageInfo != null) {
                    if (sb.length() > 0) {
                        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    }
                    sb.append(packageInfo.applicationInfo.loadLabel(packageManager).toString()).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(packageInfo.packageName).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(packageInfo.versionName).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(packageInfo.versionCode).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(packageInfo.firstInstallTime);
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
