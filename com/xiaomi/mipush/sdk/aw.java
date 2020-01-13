package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class aw implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ av f46a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String[] f47a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar, String[] strArr, Context context) {
        this.f46a = avVar;
        this.f47a = strArr;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.f47a.length; i++) {
            try {
                if (!TextUtils.isEmpty(this.f47a[i])) {
                    if (i > 0) {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                    }
                    PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.f47a[i], 4);
                    if (packageInfo != null) {
                        this.f46a.a(this.a, packageInfo);
                    }
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return;
            }
        }
    }
}
