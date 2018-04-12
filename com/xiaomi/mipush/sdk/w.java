package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.ao;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class w extends ContentObserver {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(u uVar, Handler handler) {
        super(handler);
        this.a = uVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        u uVar = this.a;
        context = this.a.c;
        uVar.h = Integer.valueOf(ao.a(context).b());
        num = this.a.h;
        if (num.intValue() != 0) {
            context2 = this.a.c;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.a.c;
            if (com.xiaomi.channel.commonutils.network.d.d(context3)) {
                this.a.d();
            }
        }
    }
}
