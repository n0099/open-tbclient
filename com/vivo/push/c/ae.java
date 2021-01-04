package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes3.dex */
final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f13904a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f13905b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ ac e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar, int i, List list, List list2, String str) {
        this.e = acVar;
        this.f13904a = i;
        this.f13905b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.f13901b;
        context = this.e.f14008a;
        pushMessageCallback.onSetAlias(context, this.f13904a, this.f13905b, this.c, this.d);
    }
}
