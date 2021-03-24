package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39424a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39425b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39426c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39427d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f39428e;

    public i(h hVar, int i, List list, List list2, String str) {
        this.f39428e = hVar;
        this.f39424a = i;
        this.f39425b = list;
        this.f39426c = list2;
        this.f39427d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f39428e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f39408b;
        context = hVar.f39588a;
        pushMessageCallback.onDelTags(context, this.f39424a, this.f39425b, this.f39426c, this.f39427d);
    }
}
