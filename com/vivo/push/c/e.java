package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f40262a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f40263b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f40264c;

    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.f40264c = dVar;
        this.f40262a = str;
        this.f40263b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f40262a)) {
            d dVar = this.f40264c;
            PushMessageCallback pushMessageCallback = ((ab) dVar).f40249b;
            context2 = dVar.f40431a;
            pushMessageCallback.onReceiveRegId(context2, this.f40262a);
        }
        d dVar2 = this.f40264c;
        PushMessageCallback pushMessageCallback2 = ((ab) dVar2).f40249b;
        context = dVar2.f40431a;
        pushMessageCallback2.onBind(context, this.f40263b.h(), this.f40263b.d());
    }
}
