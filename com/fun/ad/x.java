package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes6.dex */
public class x implements ak {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ au.a f7844b;
    public final /* synthetic */ FunAdSlot pOU;
    public final /* synthetic */ p pOV;

    public x(p pVar, FunAdSlot funAdSlot, au.a aVar) {
        this.pOV = pVar;
        this.pOU = funAdSlot;
        this.f7844b = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 优量汇广告开始加载，广告ID：" + str);
        ((d.a) d.pOz).b(this.pOU.getSid(), this.f7844b.f7763b, str);
    }

    public void b(String str) {
        m.a("FunAdLoader 优量汇广告加载成功，广告ID：" + str);
        p.a(this.pOV, this.pOU.getSid(), this.f7844b.f7763b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 优量汇广告加载失败，广告ID：" + str + "，code" + i + ", message: " + str2);
        p.a(this.pOV, this.pOU.getSid(), this.f7844b.f7763b, str, i, str2);
    }
}
