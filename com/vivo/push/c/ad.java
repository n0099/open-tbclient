package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes4.dex */
final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f13903a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f13904b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ ac e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, int i, List list, List list2, String str) {
        this.e = acVar;
        this.f13903a = i;
        this.f13904b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.f13902b;
        context = this.e.f14009a;
        pushMessageCallback.onSetTags(context, this.f13903a, this.f13904b, this.c, this.d);
    }
}
