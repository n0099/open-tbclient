package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fm;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class cc extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41023a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f944a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ byte[] f945a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f41024b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cc(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.f41023a = xMPushService;
        this.f41024b = i2;
        this.f945a = bArr;
        this.f944a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        fm fmVar;
        m.m612a((Context) this.f41023a);
        av.a().m585a("5");
        com.xiaomi.push.ab.a(this.f41024b);
        fmVar = this.f41023a.f841a;
        fmVar.c(fm.a());
        this.f41023a.a(this.f945a, this.f944a);
    }
}
