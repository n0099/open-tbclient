package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f40365a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f40366b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f40367c;

    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.f40367c = dVar;
        this.f40365a = str;
        this.f40366b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f40365a)) {
            d dVar = this.f40367c;
            PushMessageCallback pushMessageCallback = ((ab) dVar).f40352b;
            context2 = dVar.f40534a;
            pushMessageCallback.onReceiveRegId(context2, this.f40365a);
        }
        d dVar2 = this.f40367c;
        PushMessageCallback pushMessageCallback2 = ((ab) dVar2).f40352b;
        context = dVar2.f40534a;
        pushMessageCallback2.onBind(context, this.f40366b.h(), this.f40366b.d());
    }
}
