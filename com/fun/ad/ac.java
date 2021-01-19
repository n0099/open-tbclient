package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes14.dex */
public abstract class ac {

    /* renamed from: a  reason: collision with root package name */
    public au.a f7743a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7744b = false;
    public z pFc;
    public w pFd;

    public ac(au.a aVar) {
        this.f7743a = aVar;
    }

    public void a() {
        m.a("KSAdLoader destroy adId: " + this.f7743a.f7760a);
        this.pFc = null;
        this.pFd = null;
    }

    public abstract FunRippedAd exX();

    public void a(Context context, FunAdSlot funAdSlot, z zVar) {
        m.a("KSAdLoader load adId: " + this.f7743a.f7760a);
        this.pFc = zVar;
    }

    public void a(Activity activity, FunAdView funAdView, w wVar) {
        m.a("KSAdLoader show adId: " + this.f7743a.f7760a);
        this.pFd = wVar;
    }
}
