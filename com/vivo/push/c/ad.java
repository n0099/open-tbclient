package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f40250a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f40251b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f40252c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f40253d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f40254e;

    public ad(ac acVar, int i2, List list, List list2, String str) {
        this.f40254e = acVar;
        this.f40250a = i2;
        this.f40251b = list;
        this.f40252c = list2;
        this.f40253d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f40254e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f40249b;
        context = acVar.f40431a;
        pushMessageCallback.onSetTags(context, this.f40250a, this.f40251b, this.f40252c, this.f40253d);
    }
}
