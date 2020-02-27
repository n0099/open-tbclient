package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class aw implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ av f44a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String[] f45a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar, String[] strArr, Context context) {
        this.f44a = avVar;
        this.f45a = strArr;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.f45a.length; i++) {
            try {
                if (!TextUtils.isEmpty(this.f45a[i])) {
                    if (i > 0) {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                    }
                    PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.f45a[i], 4);
                    if (packageInfo != null) {
                        this.f44a.a(this.a, packageInfo);
                    }
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return;
            }
        }
    }
}
