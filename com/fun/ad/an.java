package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes6.dex */
public abstract class an {

    /* renamed from: a  reason: collision with root package name */
    public au.a f7754a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7755b = false;
    public ak pPm;
    public ah pPn;

    public an(au.a aVar) {
        this.f7754a = aVar;
    }

    public void a() {
        m.a("GDTAdLoader destroy adId: " + this.f7754a.f7762a);
        this.pPm = null;
        this.pPn = null;
    }

    public abstract FunRippedAd eAp();

    public void a(Context context, FunAdSlot funAdSlot, ak akVar) {
        m.a("GDTAdLoader load adId: " + this.f7754a.f7762a);
        this.pPm = akVar;
    }

    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        m.a("GDTAdLoader show adId: " + this.f7754a.f7762a);
        this.pPn = ahVar;
    }
}
