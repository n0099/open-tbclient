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
    public au.a f8042a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8043b = false;
    public z pHU;
    public w pHV;

    public ac(au.a aVar) {
        this.f8042a = aVar;
    }

    public void a() {
        m.a("KSAdLoader destroy adId: " + this.f8042a.f8059a);
        this.pHU = null;
        this.pHV = null;
    }

    public abstract FunRippedAd eBl();

    public void a(Context context, FunAdSlot funAdSlot, z zVar) {
        m.a("KSAdLoader load adId: " + this.f8042a.f8059a);
        this.pHU = zVar;
    }

    public void a(Activity activity, FunAdView funAdView, w wVar) {
        m.a("KSAdLoader show adId: " + this.f8042a.f8059a);
        this.pHV = wVar;
    }
}
