package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bx extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14289a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f979a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f980a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f14290b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.f14289a = xMPushService;
        this.f14290b = i2;
        this.f980a = bArr;
        this.f979a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        ft ftVar;
        l.m604a((Context) this.f14289a);
        ap.a().m574a("5");
        com.xiaomi.push.ab.a(this.f14290b);
        ftVar = this.f14289a.f881a;
        ftVar.c(ft.a());
        this.f14289a.a(this.f980a, this.f979a);
    }
}
