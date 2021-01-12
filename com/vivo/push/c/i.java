package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes3.dex */
final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f13611a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f13612b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ h e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, int i, List list, List list2, String str) {
        this.e = hVar;
        this.f13611a = i;
        this.f13612b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.f13602b;
        context = this.e.f13709a;
        pushMessageCallback.onDelTags(context, this.f13611a, this.f13612b, this.c, this.d);
    }
}
