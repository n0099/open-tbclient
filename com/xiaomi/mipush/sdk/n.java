package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n implements Runnable {
    final /* synthetic */ String[] a;
    final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(String[] strArr, Context context) {
        this.a = strArr;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        String[] strArr;
        PackageInfo packageInfo;
        try {
            for (String str : this.a) {
                if (!TextUtils.isEmpty(str) && (packageInfo = this.b.getPackageManager().getPackageInfo(str, 4)) != null) {
                    MiPushClient.awakePushServiceByPackageInfo(this.b, packageInfo);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }
}
