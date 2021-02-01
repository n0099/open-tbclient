package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes15.dex */
final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f13607a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f13608b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ ac e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar, int i, List list, List list2, String str) {
        this.e = acVar;
        this.f13607a = i;
        this.f13608b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.f13604b;
        context = this.e.f13711a;
        pushMessageCallback.onSetAlias(context, this.f13607a, this.f13608b, this.c, this.d);
    }
}
