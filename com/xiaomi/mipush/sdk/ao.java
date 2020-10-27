package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4750a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ an f45a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String[] f46a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, String[] strArr, Context context) {
        this.f45a = anVar;
        this.f46a = strArr;
        this.f4750a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.f46a.length; i++) {
            try {
                if (!TextUtils.isEmpty(this.f46a[i])) {
                    if (i > 0) {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                    }
                    PackageInfo packageInfo = this.f4750a.getPackageManager().getPackageInfo(this.f46a[i], 4);
                    if (packageInfo != null) {
                        this.f45a.a(this.f4750a, packageInfo);
                    }
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return;
            }
        }
    }
}
