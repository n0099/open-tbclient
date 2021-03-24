package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39409a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39410b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39411c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39412d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f39413e;

    public ad(ac acVar, int i, List list, List list2, String str) {
        this.f39413e = acVar;
        this.f39409a = i;
        this.f39410b = list;
        this.f39411c = list2;
        this.f39412d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f39413e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f39408b;
        context = acVar.f39588a;
        pushMessageCallback.onSetTags(context, this.f39409a, this.f39410b, this.f39411c, this.f39412d);
    }
}
