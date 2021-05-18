package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f36654a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f36655b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f36656c;

    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.f36656c = dVar;
        this.f36654a = str;
        this.f36655b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f36654a)) {
            d dVar = this.f36656c;
            PushMessageCallback pushMessageCallback = ((ab) dVar).f36641b;
            context2 = dVar.f36823a;
            pushMessageCallback.onReceiveRegId(context2, this.f36654a);
        }
        d dVar2 = this.f36656c;
        PushMessageCallback pushMessageCallback2 = ((ab) dVar2).f36641b;
        context = dVar2.f36823a;
        pushMessageCallback2.onBind(context, this.f36655b.h(), this.f36655b.d());
    }
}
