package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39429a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39430b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39431c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39432d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f39433e;

    public j(h hVar, int i, List list, List list2, String str) {
        this.f39433e = hVar;
        this.f39429a = i;
        this.f39430b = list;
        this.f39431c = list2;
        this.f39432d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f39433e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f39408b;
        context = hVar.f39588a;
        pushMessageCallback.onDelAlias(context, this.f39429a, this.f39430b, this.f39431c, this.f39432d);
    }
}
