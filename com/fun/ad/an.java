package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes14.dex */
public abstract class an {

    /* renamed from: a  reason: collision with root package name */
    public au.a f7752a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7753b = false;
    public ak pFg;
    public ah pFh;

    public an(au.a aVar) {
        this.f7752a = aVar;
    }

    public void a() {
        m.a("GDTAdLoader destroy adId: " + this.f7752a.f7760a);
        this.pFg = null;
        this.pFh = null;
    }

    public abstract FunRippedAd exX();

    public void a(Context context, FunAdSlot funAdSlot, ak akVar) {
        m.a("GDTAdLoader load adId: " + this.f7752a.f7760a);
        this.pFg = akVar;
    }

    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        m.a("GDTAdLoader show adId: " + this.f7752a.f7760a);
        this.pFh = ahVar;
    }
}
