package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f40373a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f40374b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f40375c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f40376d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f40377e;

    public j(h hVar, int i2, List list, List list2, String str) {
        this.f40377e = hVar;
        this.f40373a = i2;
        this.f40374b = list;
        this.f40375c = list2;
        this.f40376d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f40377e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f40352b;
        context = hVar.f40534a;
        pushMessageCallback.onDelAlias(context, this.f40373a, this.f40374b, this.f40375c, this.f40376d);
    }
}
