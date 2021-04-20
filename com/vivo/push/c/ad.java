package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39699a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39700b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39701c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39702d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f39703e;

    public ad(ac acVar, int i, List list, List list2, String str) {
        this.f39703e = acVar;
        this.f39699a = i;
        this.f39700b = list;
        this.f39701c = list2;
        this.f39702d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f39703e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f39698b;
        context = acVar.f39878a;
        pushMessageCallback.onSetTags(context, this.f39699a, this.f39700b, this.f39701c, this.f39702d);
    }
}
