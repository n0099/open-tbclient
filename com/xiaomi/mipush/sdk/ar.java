package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.bi;
import com.xiaomi.push.service.bn;
/* loaded from: classes8.dex */
public class ar extends ContentObserver {
    public final /* synthetic */ ao a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(ao aoVar, Handler handler) {
        super(handler);
        this.a = aoVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        ao aoVar = this.a;
        context = aoVar.f58a;
        aoVar.f62a = Integer.valueOf(bn.a(context).a());
        num = this.a.f62a;
        if (num.intValue() != 0) {
            context2 = this.a.f58a;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.a.f58a;
            if (bi.b(context3)) {
                this.a.m138c();
            }
        }
    }
}
