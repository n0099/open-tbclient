package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39410a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39411b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39412c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39413d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f39414e;

    public ad(ac acVar, int i, List list, List list2, String str) {
        this.f39414e = acVar;
        this.f39410a = i;
        this.f39411b = list;
        this.f39412c = list2;
        this.f39413d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f39414e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f39409b;
        context = acVar.f39589a;
        pushMessageCallback.onSetTags(context, this.f39410a, this.f39411b, this.f39412c, this.f39413d);
    }
}
