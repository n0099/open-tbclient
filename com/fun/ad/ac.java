package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes6.dex */
public abstract class ac {

    /* renamed from: a  reason: collision with root package name */
    public au.a f7745a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7746b = false;
    public z pPh;
    public w pPi;

    public ac(au.a aVar) {
        this.f7745a = aVar;
    }

    public void a() {
        m.a("KSAdLoader destroy adId: " + this.f7745a.f7762a);
        this.pPh = null;
        this.pPi = null;
    }

    public abstract FunRippedAd eAp();

    public void a(Context context, FunAdSlot funAdSlot, z zVar) {
        m.a("KSAdLoader load adId: " + this.f7745a.f7762a);
        this.pPh = zVar;
    }

    public void a(Activity activity, FunAdView funAdView, w wVar) {
        m.a("KSAdLoader show adId: " + this.f7745a.f7762a);
        this.pPi = wVar;
    }
}
