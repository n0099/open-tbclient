package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes14.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public au.a f7781a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7782b = false;
    public f pEy;
    public c pEz;

    public i(au.a aVar) {
        this.f7781a = aVar;
    }

    public void a() {
        m.a("JYAdLoader destroy adId: " + this.f7781a.f7760a);
        this.pEy = null;
        this.pEz = null;
    }

    public abstract FunRippedAd exX();

    public void a(Context context, FunAdSlot funAdSlot, f fVar) {
        m.a("JYAdLoader load adId: " + this.f7781a.f7760a);
        this.pEy = fVar;
    }

    public void a(Activity activity, FunAdView funAdView, c cVar) {
        m.a("JYAdLoader show adId: " + this.f7781a.f7760a);
        this.pEz = cVar;
    }
}
