package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class as extends ContentObserver {
    final /* synthetic */ aq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(aq aqVar, Handler handler) {
        super(handler);
        this.a = aqVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        aq aqVar = this.a;
        context = this.a.f49a;
        aqVar.f53a = Integer.valueOf(com.xiaomi.push.service.aw.a(context).a());
        num = this.a.f53a;
        if (num.intValue() != 0) {
            context2 = this.a.f49a;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.a.f49a;
            if (az.b(context3)) {
                this.a.m89c();
            }
        }
    }
}
