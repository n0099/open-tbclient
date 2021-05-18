package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f36647a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f36648b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f36649c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f36650d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f36651e;

    public ae(ac acVar, int i2, List list, List list2, String str) {
        this.f36651e = acVar;
        this.f36647a = i2;
        this.f36648b = list;
        this.f36649c = list2;
        this.f36650d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f36651e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f36641b;
        context = acVar.f36823a;
        pushMessageCallback.onSetAlias(context, this.f36647a, this.f36648b, this.f36649c, this.f36650d);
    }
}
