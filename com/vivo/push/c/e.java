package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes14.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f8035a;
    final /* synthetic */ com.vivo.push.b.k b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.c = dVar;
        this.f8035a = str;
        this.b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f8035a)) {
            PushMessageCallback pushMessageCallback = this.c.b;
            context2 = this.c.f8089a;
            pushMessageCallback.onReceiveRegId(context2, this.f8035a);
        }
        PushMessageCallback pushMessageCallback2 = this.c.b;
        context = this.c.f8089a;
        pushMessageCallback2.onBind(context, this.b.h(), this.b.d());
    }
}
