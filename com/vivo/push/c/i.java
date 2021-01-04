package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes3.dex */
final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f13910a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f13911b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ h e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, int i, List list, List list2, String str) {
        this.e = hVar;
        this.f13910a = i;
        this.f13911b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.f13901b;
        context = this.e.f14008a;
        pushMessageCallback.onDelTags(context, this.f13910a, this.f13911b, this.c, this.d);
    }
}
