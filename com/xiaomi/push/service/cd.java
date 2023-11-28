package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.aj;
/* loaded from: classes10.dex */
public final class cd extends aj.a {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Notification f963a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f964a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f965a;
    public final /* synthetic */ String b;

    public cd(int i, String str, Context context, String str2, Notification notification) {
        this.a = i;
        this.f965a = str;
        this.f964a = context;
        this.b = str2;
        this.f963a = notification;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo310a() {
        String b;
        b = cc.b(this.a, this.f965a);
        return b;
    }

    @Override // java.lang.Runnable
    @TargetApi(19)
    public void run() {
        cc.c(this.f964a, this.b, this.a, this.f965a, this.f963a);
    }
}
