package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f40353a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f40354b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f40355c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f40356d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f40357e;

    public ad(ac acVar, int i2, List list, List list2, String str) {
        this.f40357e = acVar;
        this.f40353a = i2;
        this.f40354b = list;
        this.f40355c = list2;
        this.f40356d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f40357e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f40352b;
        context = acVar.f40534a;
        pushMessageCallback.onSetTags(context, this.f40353a, this.f40354b, this.f40355c, this.f40356d);
    }
}
