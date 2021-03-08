package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class bx extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f8560a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f900a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f901a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.f8560a = xMPushService;
        this.b = i2;
        this.f901a = bArr;
        this.f900a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        ft ftVar;
        l.m582a((Context) this.f8560a);
        ap.a().m552a("5");
        com.xiaomi.push.ab.a(this.b);
        ftVar = this.f8560a.f802a;
        ftVar.c(ft.a());
        this.f8560a.a(this.f901a, this.f900a);
    }
}
