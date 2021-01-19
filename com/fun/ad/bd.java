package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes14.dex */
public abstract class bd {

    /* renamed from: a  reason: collision with root package name */
    public au.a f7764a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7765b = false;
    public ba pFv;
    public ax pFw;
    public TTAdNative pFx;

    public bd(au.a aVar) {
        this.f7764a = aVar;
    }

    public void a() {
        m.a("CSJAdLoader destroy adId: " + this.f7764a.f7760a);
        this.pFv = null;
        this.pFw = null;
    }

    public abstract FunRippedAd exX();

    public void a(Context context, FunAdSlot funAdSlot, ba baVar) {
        m.a("CSJAdLoader load adId: " + this.f7764a.f7760a);
        if (this.pFx == null) {
            this.pFx = TTAdSdk.getAdManager().createAdNative(context);
        }
        this.pFv = baVar;
    }

    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        m.a("CSJAdLoader show adId: " + this.f7764a.f7760a);
        this.pFw = axVar;
    }
}
