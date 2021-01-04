package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes3.dex */
final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f13912a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f13913b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ h e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, int i, List list, List list2, String str) {
        this.e = hVar;
        this.f13912a = i;
        this.f13913b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.f13901b;
        context = this.e.f14008a;
        pushMessageCallback.onDelAlias(context, this.f13912a, this.f13913b, this.c, this.d);
    }
}
