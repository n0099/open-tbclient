package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.bg;
import com.xiaomi.push.service.bc;
/* loaded from: classes7.dex */
public class aq extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ an f41025a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(an anVar, Handler handler) {
        super(handler);
        this.f41025a = anVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        an anVar = this.f41025a;
        context = anVar.f64a;
        anVar.f68a = Integer.valueOf(bc.a(context).a());
        num = this.f41025a.f68a;
        if (num.intValue() != 0) {
            context2 = this.f41025a.f64a;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.f41025a.f64a;
            if (bg.b(context3)) {
                this.f41025a.m94c();
            }
        }
    }
}
