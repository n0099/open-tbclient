package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes15.dex */
public class x implements ak {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ au.a f8142b;
    public final /* synthetic */ FunAdSlot pJp;
    public final /* synthetic */ p pJq;

    public x(p pVar, FunAdSlot funAdSlot, au.a aVar) {
        this.pJq = pVar;
        this.pJp = funAdSlot;
        this.f8142b = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 优量汇广告开始加载，广告ID：" + str);
        ((d.a) d.pIU).b(this.pJp.getSid(), this.f8142b.f8061b, str);
    }

    public void b(String str) {
        m.a("FunAdLoader 优量汇广告加载成功，广告ID：" + str);
        p.a(this.pJq, this.pJp.getSid(), this.f8142b.f8061b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 优量汇广告加载失败，广告ID：" + str + "，code" + i + ", message: " + str2);
        p.a(this.pJq, this.pJp.getSid(), this.f8142b.f8061b, str, i, str2);
    }
}
