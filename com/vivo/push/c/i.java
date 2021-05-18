package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f36657a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f36658b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f36659c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f36660d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f36661e;

    public i(h hVar, int i2, List list, List list2, String str) {
        this.f36661e = hVar;
        this.f36657a = i2;
        this.f36658b = list;
        this.f36659c = list2;
        this.f36660d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f36661e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f36641b;
        context = hVar.f36823a;
        pushMessageCallback.onDelTags(context, this.f36657a, this.f36658b, this.f36659c, this.f36660d);
    }
}
