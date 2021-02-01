package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes15.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f13611a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.k f13612b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.c = dVar;
        this.f13611a = str;
        this.f13612b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f13611a)) {
            PushMessageCallback pushMessageCallback = this.c.f13604b;
            context2 = this.c.f13711a;
            pushMessageCallback.onReceiveRegId(context2, this.f13611a);
        }
        PushMessageCallback pushMessageCallback2 = this.c.f13604b;
        context = this.c.f13711a;
        pushMessageCallback2.onBind(context, this.f13612b.h(), this.f13612b.d());
    }
}
