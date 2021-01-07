package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes4.dex */
final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f13911a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f13912b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ h e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, int i, List list, List list2, String str) {
        this.e = hVar;
        this.f13911a = i;
        this.f13912b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.f13902b;
        context = this.e.f14009a;
        pushMessageCallback.onDelTags(context, this.f13911a, this.f13912b, this.c, this.d);
    }
}
