package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4522a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ an f48a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String[] f49a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, String[] strArr, Context context) {
        this.f48a = anVar;
        this.f49a = strArr;
        this.f4522a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.f49a.length; i++) {
            try {
                if (!TextUtils.isEmpty(this.f49a[i])) {
                    if (i > 0) {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                    }
                    PackageInfo packageInfo = this.f4522a.getPackageManager().getPackageInfo(this.f49a[i], 4);
                    if (packageInfo != null) {
                        this.f48a.a(this.f4522a, packageInfo);
                    }
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return;
            }
        }
    }
}
