package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class ao implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ an f47a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String[] f48a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, String[] strArr, Context context) {
        this.f47a = anVar;
        this.f48a = strArr;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.f48a.length; i++) {
            try {
                if (!TextUtils.isEmpty(this.f48a[i])) {
                    if (i > 0) {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                    }
                    PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.f48a[i], 4);
                    if (packageInfo != null) {
                        this.f47a.a(this.a, packageInfo);
                    }
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return;
            }
        }
    }
}
