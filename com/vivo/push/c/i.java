package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f40368a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f40369b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f40370c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f40371d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f40372e;

    public i(h hVar, int i2, List list, List list2, String str) {
        this.f40372e = hVar;
        this.f40368a = i2;
        this.f40369b = list;
        this.f40370c = list2;
        this.f40371d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f40372e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f40352b;
        context = hVar.f40534a;
        pushMessageCallback.onDelTags(context, this.f40368a, this.f40369b, this.f40370c, this.f40371d);
    }
}
