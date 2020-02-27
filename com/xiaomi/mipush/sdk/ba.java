package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ba extends ContentObserver {
    final /* synthetic */ ay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(ay ayVar, Handler handler) {
        super(handler);
        this.a = ayVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        ay ayVar = this.a;
        context = this.a.f47a;
        ayVar.f51a = Integer.valueOf(com.xiaomi.push.service.as.a(context).a());
        num = this.a.f51a;
        if (num.intValue() != 0) {
            context2 = this.a.f47a;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.a.f47a;
            if (com.xiaomi.push.as.b(context3)) {
                this.a.m80c();
            }
        }
    }
}
