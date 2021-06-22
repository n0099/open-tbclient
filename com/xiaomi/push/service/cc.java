package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fm;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes7.dex */
public class cc extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41910a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f944a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ byte[] f945a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f41911b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cc(XMPushService xMPushService, int i2, int i3, byte[] bArr, String str) {
        super(i2);
        this.f41910a = xMPushService;
        this.f41911b = i3;
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
        m.m617a((Context) this.f41910a);
        av.a().m590a("5");
        com.xiaomi.push.ab.a(this.f41911b);
        fmVar = this.f41910a.f841a;
        fmVar.c(fm.a());
        this.f41910a.a(this.f945a, this.f944a);
    }
}
