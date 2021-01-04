package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14106a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ an f126a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String[] f127a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, String[] strArr, Context context) {
        this.f126a = anVar;
        this.f127a = strArr;
        this.f14106a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.f127a.length; i++) {
            try {
                if (!TextUtils.isEmpty(this.f127a[i])) {
                    if (i > 0) {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                    }
                    PackageInfo packageInfo = this.f14106a.getPackageManager().getPackageInfo(this.f127a[i], 4);
                    if (packageInfo != null) {
                        this.f126a.a(this.f14106a, packageInfo);
                    }
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return;
            }
        }
    }
}
