package com.yxcorp.kuaishou.addfp.a.b.h.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Context f14374a;
    private /* synthetic */ b qlU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Looper looper, Context context) {
        super(looper);
        this.qlU = bVar;
        this.f14374a = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        Object obj2;
        String b2;
        if (message.what == 666) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    b2 = b.b(this.f14374a, data.getInt("type"), data.getString("appid"));
                    String unused = b.j = b2;
                }
                obj = b.g;
                synchronized (obj) {
                    obj2 = b.g;
                    obj2.notify();
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
    }
}
