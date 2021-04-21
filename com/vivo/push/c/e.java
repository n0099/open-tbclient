package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39806a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f39807b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f39808c;

    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.f39808c = dVar;
        this.f39806a = str;
        this.f39807b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f39806a)) {
            d dVar = this.f39808c;
            PushMessageCallback pushMessageCallback = ((ab) dVar).f39793b;
            context2 = dVar.f39973a;
            pushMessageCallback.onReceiveRegId(context2, this.f39806a);
        }
        d dVar2 = this.f39808c;
        PushMessageCallback pushMessageCallback2 = ((ab) dVar2).f39793b;
        context = dVar2.f39973a;
        pushMessageCallback2.onBind(context, this.f39807b.h(), this.f39807b.d());
    }
}
