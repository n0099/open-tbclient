package com.yxcorp.kuaishou.addfp.a.b.d.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Context f8605a;
    private /* synthetic */ a qmL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Looper looper, Context context) {
        super(looper);
        this.qmL = aVar;
        this.f8605a = context;
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
                    b = a.b(this.f8605a, data.getString("appid"));
                    String unused = a.g = b;
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
