package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39421a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f39422b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f39423c;

    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.f39423c = dVar;
        this.f39421a = str;
        this.f39422b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f39421a)) {
            d dVar = this.f39423c;
            PushMessageCallback pushMessageCallback = ((ab) dVar).f39408b;
            context2 = dVar.f39588a;
            pushMessageCallback.onReceiveRegId(context2, this.f39421a);
        }
        d dVar2 = this.f39423c;
        PushMessageCallback pushMessageCallback2 = ((ab) dVar2).f39408b;
        context = dVar2.f39588a;
        pushMessageCallback2.onBind(context, this.f39422b.h(), this.f39422b.d());
    }
}
