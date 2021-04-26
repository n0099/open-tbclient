package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes6.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f37412a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f37413b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f37414c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f37415d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f37416e;

    public i(h hVar, int i2, List list, List list2, String str) {
        this.f37416e = hVar;
        this.f37412a = i2;
        this.f37413b = list;
        this.f37414c = list2;
        this.f37415d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f37416e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f37396b;
        context = hVar.f37578a;
        pushMessageCallback.onDelTags(context, this.f37412a, this.f37413b, this.f37414c, this.f37415d);
    }
}
