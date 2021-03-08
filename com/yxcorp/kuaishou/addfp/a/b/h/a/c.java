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
    private /* synthetic */ Context f8615a;
    private /* synthetic */ b qmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Looper looper, Context context) {
        super(looper);
        this.qmW = bVar;
        this.f8615a = context;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        Object obj2;
        String b;
        if (message.what == 666) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    b = b.b(this.f8615a, data.getInt("type"), data.getString("appid"));
                    String unused = b.j = b;
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
