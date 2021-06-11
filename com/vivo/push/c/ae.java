package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f40255a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f40256b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f40257c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f40258d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f40259e;

    public ae(ac acVar, int i2, List list, List list2, String str) {
        this.f40259e = acVar;
        this.f40255a = i2;
        this.f40256b = list;
        this.f40257c = list2;
        this.f40258d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f40259e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f40249b;
        context = acVar.f40431a;
        pushMessageCallback.onSetAlias(context, this.f40255a, this.f40256b, this.f40257c, this.f40258d);
    }
}
