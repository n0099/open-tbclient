package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f36571a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f36572b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f36573c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f36574d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f36575e;

    public ad(ac acVar, int i2, List list, List list2, String str) {
        this.f36575e = acVar;
        this.f36571a = i2;
        this.f36572b = list;
        this.f36573c = list2;
        this.f36574d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f36575e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f36570b;
        context = acVar.f36752a;
        pushMessageCallback.onSetTags(context, this.f36571a, this.f36572b, this.f36573c, this.f36574d);
    }
}
