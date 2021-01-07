package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14107a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ an f127a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String[] f128a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, String[] strArr, Context context) {
        this.f127a = anVar;
        this.f128a = strArr;
        this.f14107a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.f128a.length; i++) {
            try {
                if (!TextUtils.isEmpty(this.f128a[i])) {
                    if (i > 0) {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                    }
                    PackageInfo packageInfo = this.f14107a.getPackageManager().getPackageInfo(this.f128a[i], 4);
                    if (packageInfo != null) {
                        this.f127a.a(this.f14107a, packageInfo);
                    }
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return;
            }
        }
    }
}
