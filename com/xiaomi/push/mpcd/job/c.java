package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class c extends g {
    public c(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 4;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public String b() {
        StringBuilder sb = new StringBuilder();
        try {
            PackageManager packageManager = this.d.getPackageManager();
            int i = 0;
            for (PackageInfo packageInfo : packageManager.getInstalledPackages(128)) {
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    if (sb.length() > 0) {
                        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    }
                    sb.append(packageInfo.applicationInfo.loadLabel(packageManager).toString()).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(packageInfo.packageName).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(packageInfo.versionName).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(packageInfo.versionCode).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(com.xiaomi.channel.commonutils.android.a.f(this.d, packageInfo.packageName));
                    int i2 = i + 1;
                    if (i2 >= 200) {
                        break;
                    }
                    i = i2;
                }
            }
        } catch (Throwable th) {
        }
        return sb.toString();
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.AppInstallList;
    }
}
