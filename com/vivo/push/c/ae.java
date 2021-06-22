package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f40358a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f40359b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f40360c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f40361d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f40362e;

    public ae(ac acVar, int i2, List list, List list2, String str) {
        this.f40362e = acVar;
        this.f40358a = i2;
        this.f40359b = list;
        this.f40360c = list2;
        this.f40361d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f40362e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f40352b;
        context = acVar.f40534a;
        pushMessageCallback.onSetAlias(context, this.f40358a, this.f40359b, this.f40360c, this.f40361d);
    }
}
