package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bx extends XMPushService.i {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f899a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f900a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.a = xMPushService;
        this.b = i2;
        this.f900a = bArr;
        this.f899a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        ft ftVar;
        l.m575a((Context) this.a);
        ap.a().m545a("5");
        com.xiaomi.push.ab.a(this.b);
        ftVar = this.a.f801a;
        ftVar.c(ft.a());
        this.a.a(this.f900a, this.f899a);
    }
}
