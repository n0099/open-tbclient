package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class as extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aq f13815a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(aq aqVar, Handler handler) {
        super(handler);
        this.f13815a = aqVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        aq aqVar = this.f13815a;
        context = this.f13815a.f129a;
        aqVar.f133a = Integer.valueOf(com.xiaomi.push.service.aw.a(context).a());
        num = this.f13815a.f133a;
        if (num.intValue() != 0) {
            context2 = this.f13815a.f129a;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.f13815a.f129a;
            if (az.b(context3)) {
                this.f13815a.m117c();
            }
        }
    }
}
