package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.aj;
/* loaded from: classes8.dex */
public final class cd extends aj.a {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Notification f967a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f968a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f969a;
    public final /* synthetic */ String b;

    public cd(int i, String str, Context context, String str2, Notification notification) {
        this.a = i;
        this.f969a = str;
        this.f968a = context;
        this.b = str2;
        this.f967a = notification;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo219a() {
        String b;
        b = cc.b(this.a, this.f969a);
        return b;
    }

    @Override // java.lang.Runnable
    @TargetApi(19)
    public void run() {
        cc.c(this.f968a, this.b, this.a, this.f969a, this.f967a);
    }
}
