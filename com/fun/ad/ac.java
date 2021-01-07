package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes15.dex */
public abstract class ac {

    /* renamed from: a  reason: collision with root package name */
    public au.a f8043a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8044b = false;
    public z pJC;
    public w pJD;

    public ac(au.a aVar) {
        this.f8043a = aVar;
    }

    public void a() {
        m.a("KSAdLoader destroy adId: " + this.f8043a.f8060a);
        this.pJC = null;
        this.pJD = null;
    }

    public abstract FunRippedAd eBP();

    public void a(Context context, FunAdSlot funAdSlot, z zVar) {
        m.a("KSAdLoader load adId: " + this.f8043a.f8060a);
        this.pJC = zVar;
    }

    public void a(Activity activity, FunAdView funAdView, w wVar) {
        m.a("KSAdLoader show adId: " + this.f8043a.f8060a);
        this.pJD = wVar;
    }
}
