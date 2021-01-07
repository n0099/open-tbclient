package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes15.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public au.a f8081a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8082b = false;
    public f pIZ;
    public c pJa;

    public i(au.a aVar) {
        this.f8081a = aVar;
    }

    public void a() {
        m.a("JYAdLoader destroy adId: " + this.f8081a.f8060a);
        this.pIZ = null;
        this.pJa = null;
    }

    public abstract FunRippedAd eBP();

    public void a(Context context, FunAdSlot funAdSlot, f fVar) {
        m.a("JYAdLoader load adId: " + this.f8081a.f8060a);
        this.pIZ = fVar;
    }

    public void a(Activity activity, FunAdView funAdView, c cVar) {
        m.a("JYAdLoader show adId: " + this.f8081a.f8060a);
        this.pJa = cVar;
    }
}
