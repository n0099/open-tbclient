package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ag implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean checkPermission;
        checkPermission = MiPushClient.checkPermission(this.a);
        if (checkPermission) {
            MiPushClient.initialize(this.a, this.b, this.c, null);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.d("Because of lack of necessary information, mi push can't be initialized");
        ArrayList arrayList = new ArrayList();
        if (!com.xiaomi.channel.commonutils.android.g.a(this.a, "android.permission.READ_PHONE_STATE")) {
            arrayList.add("android.permission.READ_PHONE_STATE");
        }
        if (!com.xiaomi.channel.commonutils.android.g.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (arrayList.isEmpty()) {
            return;
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.mipush.ERROR");
        intent.setPackage(this.a.getPackageName());
        intent.putExtra(PushMessageHelper.MESSAGE_TYPE, 5);
        intent.putExtra(PushMessageHelper.ERROR_TYPE, PushMessageHelper.ERROR_TYPE_NEED_PERMISSION);
        intent.putExtra("error_message", strArr);
        this.a.sendBroadcast(intent);
    }
}
