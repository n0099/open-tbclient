package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class bb extends ContentObserver {
    final /* synthetic */ az a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(az azVar, Handler handler) {
        super(handler);
        this.a = azVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        az azVar = this.a;
        context = this.a.c;
        azVar.l = Integer.valueOf(com.xiaomi.push.service.az.a(context).b());
        num = this.a.l;
        if (num.intValue() != 0) {
            context2 = this.a.c;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.a.c;
            if (com.xiaomi.channel.commonutils.network.d.c(context3)) {
                this.a.d();
            }
        }
    }
}
