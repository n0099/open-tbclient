package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.bg;
import com.xiaomi.push.service.bc;
/* loaded from: classes7.dex */
public class aq extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ an f37243a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(an anVar, Handler handler) {
        super(handler);
        this.f37243a = anVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        an anVar = this.f37243a;
        context = anVar.f64a;
        anVar.f68a = Integer.valueOf(bc.a(context).a());
        num = this.f37243a.f68a;
        if (num.intValue() != 0) {
            context2 = this.f37243a.f64a;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.f37243a.f64a;
            if (bg.b(context3)) {
                this.f37243a.m95c();
            }
        }
    }
}
