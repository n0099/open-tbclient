package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39414a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39415b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39416c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39417d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f39418e;

    public ae(ac acVar, int i, List list, List list2, String str) {
        this.f39418e = acVar;
        this.f39414a = i;
        this.f39415b = list;
        this.f39416c = list2;
        this.f39417d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f39418e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f39408b;
        context = acVar.f39588a;
        pushMessageCallback.onSetAlias(context, this.f39414a, this.f39415b, this.f39416c, this.f39417d);
    }
}
