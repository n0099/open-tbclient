package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes11.dex */
final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4432a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ h e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, int i, List list, List list2, String str) {
        this.e = hVar;
        this.f4432a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.b;
        context = this.e.f4484a;
        pushMessageCallback.onDelAlias(context, this.f4432a, this.b, this.c, this.d);
    }
}
