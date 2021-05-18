package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f36662a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f36663b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f36664c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f36665d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f36666e;

    public j(h hVar, int i2, List list, List list2, String str) {
        this.f36666e = hVar;
        this.f36662a = i2;
        this.f36663b = list;
        this.f36664c = list2;
        this.f36665d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f36666e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f36641b;
        context = hVar.f36823a;
        pushMessageCallback.onDelAlias(context, this.f36662a, this.f36663b, this.f36664c, this.f36665d);
    }
}
