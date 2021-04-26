package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes6.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f37417a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f37418b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f37419c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f37420d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f37421e;

    public j(h hVar, int i2, List list, List list2, String str) {
        this.f37421e = hVar;
        this.f37417a = i2;
        this.f37418b = list;
        this.f37419c = list2;
        this.f37420d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f37421e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f37396b;
        context = hVar.f37578a;
        pushMessageCallback.onDelAlias(context, this.f37417a, this.f37418b, this.f37419c, this.f37420d);
    }
}
