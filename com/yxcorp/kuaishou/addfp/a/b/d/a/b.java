package com.yxcorp.kuaishou.addfp.a.b.d.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Context f14354a;
    private /* synthetic */ a qbE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Looper looper, Context context) {
        super(looper);
        this.qbE = aVar;
        this.f14354a = context;
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
                    b2 = a.b(this.f14354a, data.getString("appid"));
                    String unused = a.g = b2;
                }
                obj = a.d;
                synchronized (obj) {
                    obj2 = a.d;
                    obj2.notify();
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
    }
}
