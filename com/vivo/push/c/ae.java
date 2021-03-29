package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39415a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39416b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39417c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39418d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f39419e;

    public ae(ac acVar, int i, List list, List list2, String str) {
        this.f39419e = acVar;
        this.f39415a = i;
        this.f39416b = list;
        this.f39417c = list2;
        this.f39418d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f39419e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f39409b;
        context = acVar.f39589a;
        pushMessageCallback.onSetAlias(context, this.f39415a, this.f39416b, this.f39417c, this.f39418d);
    }
}
