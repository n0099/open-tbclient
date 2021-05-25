package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f36583a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f36584b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f36585c;

    public e(d dVar, String str, com.vivo.push.b.k kVar) {
        this.f36585c = dVar;
        this.f36583a = str;
        this.f36584b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f36583a)) {
            d dVar = this.f36585c;
            PushMessageCallback pushMessageCallback = ((ab) dVar).f36570b;
            context2 = dVar.f36752a;
            pushMessageCallback.onReceiveRegId(context2, this.f36583a);
        }
        d dVar2 = this.f36585c;
        PushMessageCallback pushMessageCallback2 = ((ab) dVar2).f36570b;
        context = dVar2.f36752a;
        pushMessageCallback2.onBind(context, this.f36584b.h(), this.f36584b.d());
    }
}
