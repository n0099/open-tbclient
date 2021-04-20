package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39711a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f39712b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f39713c;

    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.f39713c = dVar;
        this.f39711a = str;
        this.f39712b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f39711a)) {
            d dVar = this.f39713c;
            PushMessageCallback pushMessageCallback = ((ab) dVar).f39698b;
            context2 = dVar.f39878a;
            pushMessageCallback.onReceiveRegId(context2, this.f39711a);
        }
        d dVar2 = this.f39713c;
        PushMessageCallback pushMessageCallback2 = ((ab) dVar2).f39698b;
        context = dVar2.f39878a;
        pushMessageCallback2.onBind(context, this.f39712b.h(), this.f39712b.d());
    }
}
