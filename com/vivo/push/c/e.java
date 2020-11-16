package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes11.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4660a;
    final /* synthetic */ com.vivo.push.b.k b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.c = dVar;
        this.f4660a = str;
        this.b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f4660a)) {
            PushMessageCallback pushMessageCallback = this.c.b;
            context2 = this.c.f4714a;
            pushMessageCallback.onReceiveRegId(context2, this.f4660a);
        }
        PushMessageCallback pushMessageCallback2 = this.c.b;
        context = this.c.f4714a;
        pushMessageCallback2.onBind(context, this.b.h(), this.b.d());
    }
}
