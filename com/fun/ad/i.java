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
    public au.a f8080a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8081b = false;
    public f pHr;
    public c pHs;

    public i(au.a aVar) {
        this.f8080a = aVar;
    }

    public void a() {
        m.a("JYAdLoader destroy adId: " + this.f8080a.f8059a);
        this.pHr = null;
        this.pHs = null;
    }

    public abstract FunRippedAd eBl();

    public void a(Context context, FunAdSlot funAdSlot, f fVar) {
        m.a("JYAdLoader load adId: " + this.f8080a.f8059a);
        this.pHr = fVar;
    }

    public void a(Activity activity, FunAdView funAdView, c cVar) {
        m.a("JYAdLoader show adId: " + this.f8080a.f8059a);
        this.pHs = cVar;
    }
}
