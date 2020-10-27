package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class as extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aq f4755a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(aq aqVar, Handler handler) {
        super(handler);
        this.f4755a = aqVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        aq aqVar = this.f4755a;
        context = this.f4755a.f48a;
        aqVar.f52a = Integer.valueOf(com.xiaomi.push.service.aw.a(context).a());
        num = this.f4755a.f52a;
        if (num.intValue() != 0) {
            context2 = this.f4755a.f48a;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.f4755a.f48a;
            if (az.b(context3)) {
                this.f4755a.m91c();
            }
        }
    }
}
