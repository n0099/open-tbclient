package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes15.dex */
final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f13613a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f13614b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ h e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, int i, List list, List list2, String str) {
        this.e = hVar;
        this.f13613a = i;
        this.f13614b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.f13604b;
        context = this.e.f13711a;
        pushMessageCallback.onDelTags(context, this.f13613a, this.f13614b, this.c, this.d);
    }
}
