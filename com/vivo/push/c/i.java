package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f40265a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f40266b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f40267c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f40268d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f40269e;

    public i(h hVar, int i2, List list, List list2, String str) {
        this.f40269e = hVar;
        this.f40265a = i2;
        this.f40266b = list;
        this.f40267c = list2;
        this.f40268d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f40269e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f40249b;
        context = hVar.f40431a;
        pushMessageCallback.onDelTags(context, this.f40265a, this.f40266b, this.f40267c, this.f40268d);
    }
}
