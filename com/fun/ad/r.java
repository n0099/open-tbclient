package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes14.dex */
public class r implements f {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ au.a f7787b;
    public final /* synthetic */ FunAdSlot pEP;
    public final /* synthetic */ p pEQ;

    public r(p pVar, FunAdSlot funAdSlot, au.a aVar) {
        this.pEQ = pVar;
        this.pEP = funAdSlot;
        this.f7787b = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 巨赢互联广告开始加载，广告ID：" + str);
        ((d.a) d.pEu).b(this.pEP.getSid(), this.f7787b.f7761b, str);
    }

    public void b(String str) {
        m.a("FunAdLoader 巨赢互联广告加载成功，广告ID：" + str);
        p.a(this.pEQ, this.pEP.getSid(), this.f7787b.f7761b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 巨赢互联广告加载失败，广告ID：" + str + "，code" + i + ", message: " + str2);
        p.a(this.pEQ, this.pEP.getSid(), this.f7787b.f7761b, str, i, str2);
    }
}
