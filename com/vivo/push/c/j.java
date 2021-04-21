package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39814a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39815b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39816c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39817d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f39818e;

    public j(h hVar, int i, List list, List list2, String str) {
        this.f39818e = hVar;
        this.f39814a = i;
        this.f39815b = list;
        this.f39816c = list2;
        this.f39817d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f39818e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f39793b;
        context = hVar.f39973a;
        pushMessageCallback.onDelAlias(context, this.f39814a, this.f39815b, this.f39816c, this.f39817d);
    }
}
