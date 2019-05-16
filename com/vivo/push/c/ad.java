package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes3.dex */
final class ad implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ ab e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar, int i, List list, List list2, String str) {
        this.e = abVar;
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.c;
        context = this.e.a;
        pushMessageCallback.onSetAlias(context, this.a, this.b, this.c, this.d);
    }
}
