package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39704a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39705b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39706c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39707d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f39708e;

    public ae(ac acVar, int i, List list, List list2, String str) {
        this.f39708e = acVar;
        this.f39704a = i;
        this.f39705b = list;
        this.f39706c = list2;
        this.f39707d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f39708e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f39698b;
        context = acVar.f39878a;
        pushMessageCallback.onSetAlias(context, this.f39704a, this.f39705b, this.f39706c, this.f39707d);
    }
}
