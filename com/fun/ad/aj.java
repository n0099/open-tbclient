package com.fun.ad;

import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdSlot;
/* loaded from: classes15.dex */
public class aj implements ba {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ au.a f8049b;
    public final /* synthetic */ FunAdSlot pHH;
    public final /* synthetic */ p pHI;

    public aj(p pVar, FunAdSlot funAdSlot, au.a aVar) {
        this.pHI = pVar;
        this.pHH = funAdSlot;
        this.f8049b = aVar;
    }

    public void a(String str) {
        m.a("FunAdLoader 穿山甲广告开始加载，广告ID：" + str);
        ((d.a) d.pHm).b(this.pHH.getSid(), this.f8049b.f8060b, str);
    }

    public void b(String str) {
        m.a("FunAdLoader 穿山甲广告加载成功，广告ID：" + str);
        p.a(this.pHI, this.pHH.getSid(), this.f8049b.f8060b, str);
    }

    public void a(String str, int i, String str2) {
        m.a("FunAdLoader 穿山甲广告加载失败，广告ID：" + str + "，code: " + i + ", message: " + str2);
        p.a(this.pHI, this.pHH.getSid(), this.f8049b.f8060b, str, i, str2);
    }
}
