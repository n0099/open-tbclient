package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39425a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39426b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39427c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39428d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f39429e;

    public i(h hVar, int i, List list, List list2, String str) {
        this.f39429e = hVar;
        this.f39425a = i;
        this.f39426b = list;
        this.f39427c = list2;
        this.f39428d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f39429e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f39409b;
        context = hVar.f39589a;
        pushMessageCallback.onDelTags(context, this.f39425a, this.f39426b, this.f39427c, this.f39428d);
    }
}
