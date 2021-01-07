package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes15.dex */
public abstract class an {

    /* renamed from: a  reason: collision with root package name */
    public au.a f8052a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8053b = false;
    public ak pJH;
    public ah pJI;

    public an(au.a aVar) {
        this.f8052a = aVar;
    }

    public void a() {
        m.a("GDTAdLoader destroy adId: " + this.f8052a.f8060a);
        this.pJH = null;
        this.pJI = null;
    }

    public abstract FunRippedAd eBP();

    public void a(Context context, FunAdSlot funAdSlot, ak akVar) {
        m.a("GDTAdLoader load adId: " + this.f8052a.f8060a);
        this.pJH = akVar;
    }

    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        m.a("GDTAdLoader show adId: " + this.f8052a.f8060a);
        this.pJI = ahVar;
    }
}
