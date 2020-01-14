package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fn;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class br extends XMPushService.i {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f903a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f904a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.a = xMPushService;
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
        fn fnVar;
        l.m540a((Context) this.a);
        al.a().m510a("5");
        com.xiaomi.push.ab.a(this.b);
        fnVar = this.a.f818a;
        fnVar.c(fn.a());
        this.a.a(this.f904a, this.f903a);
    }
}
