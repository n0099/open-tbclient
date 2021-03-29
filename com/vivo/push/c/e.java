package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39422a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f39423b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f39424c;

    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.f39424c = dVar;
        this.f39422a = str;
        this.f39423b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f39422a)) {
            d dVar = this.f39424c;
            PushMessageCallback pushMessageCallback = ((ab) dVar).f39409b;
            context2 = dVar.f39589a;
            pushMessageCallback.onReceiveRegId(context2, this.f39422a);
        }
        d dVar2 = this.f39424c;
        PushMessageCallback pushMessageCallback2 = ((ab) dVar2).f39409b;
        context = dVar2.f39589a;
        pushMessageCallback2.onBind(context, this.f39423b.h(), this.f39423b.d());
    }
}
