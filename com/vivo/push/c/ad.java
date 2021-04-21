package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f39794a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f39795b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f39796c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f39797d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f39798e;

    public ad(ac acVar, int i, List list, List list2, String str) {
        this.f39798e = acVar;
        this.f39794a = i;
        this.f39795b = list;
        this.f39796c = list2;
        this.f39797d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f39798e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f39793b;
        context = acVar.f39973a;
        pushMessageCallback.onSetTags(context, this.f39794a, this.f39795b, this.f39796c, this.f39797d);
    }
}
