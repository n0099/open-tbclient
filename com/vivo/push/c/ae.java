package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes6.dex */
public final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f37402a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f37403b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f37404c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f37405d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f37406e;

    public ae(ac acVar, int i2, List list, List list2, String str) {
        this.f37406e = acVar;
        this.f37402a = i2;
        this.f37403b = list;
        this.f37404c = list2;
        this.f37405d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f37406e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f37396b;
        context = acVar.f37578a;
        pushMessageCallback.onSetAlias(context, this.f37402a, this.f37403b, this.f37404c, this.f37405d);
    }
}
