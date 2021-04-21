package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39809a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39810b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39811c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39812d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f39813e;

    public i(h hVar, int i, List list, List list2, String str) {
        this.f39813e = hVar;
        this.f39809a = i;
        this.f39810b = list;
        this.f39811c = list2;
        this.f39812d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f39813e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f39793b;
        context = hVar.f39973a;
        pushMessageCallback.onDelTags(context, this.f39809a, this.f39810b, this.f39811c, this.f39812d);
    }
}
