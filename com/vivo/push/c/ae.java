package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39799a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39800b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39801c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39802d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f39803e;

    public ae(ac acVar, int i, List list, List list2, String str) {
        this.f39803e = acVar;
        this.f39799a = i;
        this.f39800b = list;
        this.f39801c = list2;
        this.f39802d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f39803e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f39793b;
        context = acVar.f39973a;
        pushMessageCallback.onSetAlias(context, this.f39799a, this.f39800b, this.f39801c, this.f39802d);
    }
}
