package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f40270a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f40271b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f40272c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f40273d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f40274e;

    public j(h hVar, int i2, List list, List list2, String str) {
        this.f40274e = hVar;
        this.f40270a = i2;
        this.f40271b = list;
        this.f40272c = list2;
        this.f40273d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f40274e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f40249b;
        context = hVar.f40431a;
        pushMessageCallback.onDelAlias(context, this.f40270a, this.f40271b, this.f40272c, this.f40273d);
    }
}
