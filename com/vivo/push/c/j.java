package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f36591a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f36592b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f36593c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f36594d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f36595e;

    public j(h hVar, int i2, List list, List list2, String str) {
        this.f36595e = hVar;
        this.f36591a = i2;
        this.f36592b = list;
        this.f36593c = list2;
        this.f36594d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f36595e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f36570b;
        context = hVar.f36752a;
        pushMessageCallback.onDelAlias(context, this.f36591a, this.f36592b, this.f36593c, this.f36594d);
    }
}
