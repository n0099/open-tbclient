package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes3.dex */
final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f13603a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f13604b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ ac e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, int i, List list, List list2, String str) {
        this.e = acVar;
        this.f13603a = i;
        this.f13604b = list;
        this.c = list2;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.e.f13602b;
        context = this.e.f13709a;
        pushMessageCallback.onSetTags(context, this.f13603a, this.f13604b, this.c, this.d);
    }
}
