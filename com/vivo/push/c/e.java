package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f13908a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.k f13909b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.c = dVar;
        this.f13908a = str;
        this.f13909b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f13908a)) {
            PushMessageCallback pushMessageCallback = this.c.f13901b;
            context2 = this.c.f14008a;
            pushMessageCallback.onReceiveRegId(context2, this.f13908a);
        }
        PushMessageCallback pushMessageCallback2 = this.c.f13901b;
        context = this.c.f14008a;
        pushMessageCallback2.onBind(context, this.f13909b.h(), this.f13909b.d());
    }
}
