package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;
/* loaded from: classes7.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f36586a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f36587b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f36588c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f36589d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f36590e;

    public i(h hVar, int i2, List list, List list2, String str) {
        this.f36590e = hVar;
        this.f36586a = i2;
        this.f36587b = list;
        this.f36588c = list2;
        this.f36589d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f36590e;
        PushMessageCallback pushMessageCallback = ((ab) hVar).f36570b;
        context = hVar.f36752a;
        pushMessageCallback.onDelTags(context, this.f36586a, this.f36587b, this.f36588c, this.f36589d);
    }
}
