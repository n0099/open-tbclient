package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
/* loaded from: classes3.dex */
final class ah implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String[] f34a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(String[] strArr, Context context) {
        this.f34a = strArr;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        String[] strArr;
        PackageInfo packageInfo;
        try {
            for (String str : this.f34a) {
                if (!TextUtils.isEmpty(str) && (packageInfo = this.a.getPackageManager().getPackageInfo(str, 4)) != null) {
                    MiPushClient.awakePushServiceByPackageInfo(this.a, packageInfo);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }
}
