package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.aj;
/* loaded from: classes10.dex */
public final class cd extends aj.a {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Notification f968a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f969a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f970a;
    public final /* synthetic */ String b;

    public cd(int i, String str, Context context, String str2, Notification notification) {
        this.a = i;
        this.f970a = str;
        this.f969a = context;
        this.b = str2;
        this.f968a = notification;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo300a() {
        String b;
        b = cc.b(this.a, this.f970a);
        return b;
    }

    @Override // java.lang.Runnable
    @TargetApi(19)
    public void run() {
        cc.c(this.f969a, this.b, this.a, this.f970a, this.f968a);
    }
}
