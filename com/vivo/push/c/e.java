package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes6.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37409a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f37410b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f37411c;

    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.f37411c = dVar;
        this.f37409a = str;
        this.f37410b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f37409a)) {
            d dVar = this.f37411c;
            PushMessageCallback pushMessageCallback = ((ab) dVar).f37396b;
            context2 = dVar.f37578a;
            pushMessageCallback.onReceiveRegId(context2, this.f37409a);
        }
        d dVar2 = this.f37411c;
        PushMessageCallback pushMessageCallback2 = ((ab) dVar2).f37396b;
        context = dVar2.f37578a;
        pushMessageCallback2.onBind(context, this.f37410b.h(), this.f37410b.d());
    }
}
