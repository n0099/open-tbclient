package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class v extends Handler {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(u uVar, Looper looper) {
        super(looper);
        this.a = uVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        String str = (String) message.obj;
        int i = message.arg1;
        synchronized (p.class) {
            context = this.a.c;
            if (p.a(context).e(str)) {
                context2 = this.a.c;
                if (p.a(context2).c(str) < 10) {
                    if (1 == i) {
                        context6 = this.a.c;
                        if ("disable_syncing".equals(p.a(context6).a())) {
                            this.a.a(str, true);
                            context5 = this.a.c;
                            p.a(context5).b(str);
                        }
                    }
                    if (i == 0) {
                        context4 = this.a.c;
                        if ("enable_syncing".equals(p.a(context4).a())) {
                            this.a.a(str, false);
                        }
                    }
                    context5 = this.a.c;
                    p.a(context5).b(str);
                } else {
                    context3 = this.a.c;
                    p.a(context3).d(str);
                }
            }
        }
    }
}
