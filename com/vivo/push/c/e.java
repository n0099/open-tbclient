package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes9.dex */
final class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ com.vivo.push.b.k b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.c = dVar;
        this.a = str;
        this.b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.a)) {
            PushMessageCallback pushMessageCallback = this.c.b;
            context2 = this.c.a;
            pushMessageCallback.onReceiveRegId(context2, this.a);
        }
        PushMessageCallback pushMessageCallback2 = this.c.b;
        context = this.c.a;
        pushMessageCallback2.onBind(context, this.b.h(), this.b.d());
    }
}
