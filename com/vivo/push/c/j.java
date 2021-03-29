package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39430a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39431b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39432c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39433d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f39434e;

    public j(h hVar, int i, List list, List list2, String str) {
        this.f39434e = hVar;
        this.f39430a = i;
        this.f39431b = list;
        this.f39432c = list2;
        this.f39433d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f39434e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f39409b;
        context = hVar.f39589a;
        pushMessageCallback.onDelAlias(context, this.f39430a, this.f39431b, this.f39432c, this.f39433d);
    }
}
