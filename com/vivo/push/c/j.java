package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39719a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39720b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39721c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39722d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f39723e;

    public j(h hVar, int i, List list, List list2, String str) {
        this.f39723e = hVar;
        this.f39719a = i;
        this.f39720b = list;
        this.f39721c = list2;
        this.f39722d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f39723e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f39698b;
        context = hVar.f39878a;
        pushMessageCallback.onDelAlias(context, this.f39719a, this.f39720b, this.f39721c, this.f39722d);
    }
}
