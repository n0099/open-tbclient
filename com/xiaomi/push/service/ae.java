package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.ai;
/* loaded from: classes7.dex */
public final class ae extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f40939a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Notification f878a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f879a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f880a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40940b;

    public ae(int i, String str, Context context, String str2, Notification notification) {
        this.f40939a = i;
        this.f880a = str;
        this.f879a = context;
        this.f40940b = str2;
        this.f878a = notification;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo165a() {
        String b2;
        b2 = ac.b(this.f40939a, this.f880a);
        return b2;
    }

    @Override // java.lang.Runnable
    @TargetApi(19)
    public void run() {
        ac.b(this.f879a, this.f40940b, this.f40939a, this.f880a, this.f878a);
    }
}
