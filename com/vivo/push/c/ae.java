package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f36576a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f36577b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f36578c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f36579d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f36580e;

    public ae(ac acVar, int i2, List list, List list2, String str) {
        this.f36580e = acVar;
        this.f36576a = i2;
        this.f36577b = list;
        this.f36578c = list2;
        this.f36579d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f36580e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f36570b;
        context = acVar.f36752a;
        pushMessageCallback.onSetAlias(context, this.f36576a, this.f36577b, this.f36578c, this.f36579d);
    }
}
