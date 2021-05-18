package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f36642a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f36643b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f36644c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f36645d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f36646e;

    public ad(ac acVar, int i2, List list, List list2, String str) {
        this.f36646e = acVar;
        this.f36642a = i2;
        this.f36643b = list;
        this.f36644c = list2;
        this.f36645d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f36646e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f36641b;
        context = acVar.f36823a;
        pushMessageCallback.onSetTags(context, this.f36642a, this.f36643b, this.f36644c, this.f36645d);
    }
}
