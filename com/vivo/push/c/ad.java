package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes6.dex */
public final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f37397a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f37398b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f37399c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f37400d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ac f37401e;

    public ad(ac acVar, int i2, List list, List list2, String str) {
        this.f37401e = acVar;
        this.f37397a = i2;
        this.f37398b = list;
        this.f37399c = list2;
        this.f37400d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.f37401e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).f37396b;
        context = acVar.f37578a;
        pushMessageCallback.onSetTags(context, this.f37397a, this.f37398b, this.f37399c, this.f37400d);
    }
}
