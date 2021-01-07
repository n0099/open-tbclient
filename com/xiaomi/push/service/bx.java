package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bx extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14589a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f980a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f981a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f14590b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.f14589a = xMPushService;
        this.f14590b = i2;
        this.f981a = bArr;
        this.f980a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        ft ftVar;
        l.m608a((Context) this.f14589a);
        ap.a().m578a("5");
        com.xiaomi.push.ab.a(this.f14590b);
        ftVar = this.f14589a.f882a;
        ftVar.c(ft.a());
        this.f14589a.a(this.f981a, this.f980a);
    }
}
