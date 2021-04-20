package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39714a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39715b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39716c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39717d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f39718e;

    public i(h hVar, int i, List list, List list2, String str) {
        this.f39718e = hVar;
        this.f39714a = i;
        this.f39715b = list;
        this.f39716c = list2;
        this.f39717d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f39718e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f39698b;
        context = hVar.f39878a;
        pushMessageCallback.onDelTags(context, this.f39714a, this.f39715b, this.f39716c, this.f39717d);
    }
}
