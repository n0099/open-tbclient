package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class bx extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f5097a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f903a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f904a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.f5097a = xMPushService;
        this.b = i2;
        this.f904a = bArr;
        this.f903a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        ft ftVar;
        l.m581a((Context) this.f5097a);
        ap.a().m551a("5");
        com.xiaomi.push.ab.a(this.b);
        ftVar = this.f5097a.f805a;
        ftVar.c(ft.a());
        this.f5097a.a(this.f904a, this.f903a);
    }
}
