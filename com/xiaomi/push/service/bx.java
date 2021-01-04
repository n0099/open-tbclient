package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bx extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14588a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f979a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f980a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f14589b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.f14588a = xMPushService;
        this.f14589b = i2;
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
        l.m597a((Context) this.f14588a);
        ap.a().m567a("5");
        com.xiaomi.push.ab.a(this.f14589b);
        ftVar = this.f14588a.f881a;
        ftVar.c(ft.a());
        this.f14588a.a(this.f980a, this.f979a);
    }
}
