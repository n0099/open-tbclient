package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes6.dex */
public abstract class bd {

    /* renamed from: a  reason: collision with root package name */
    public au.a f7766a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7767b = false;
    public ba pPA;
    public ax pPB;
    public TTAdNative pPC;

    public bd(au.a aVar) {
        this.f7766a = aVar;
    }

    public void a() {
        m.a("CSJAdLoader destroy adId: " + this.f7766a.f7762a);
        this.pPA = null;
        this.pPB = null;
    }

    public abstract FunRippedAd eAp();

    public void a(Context context, FunAdSlot funAdSlot, ba baVar) {
        m.a("CSJAdLoader load adId: " + this.f7766a.f7762a);
        if (this.pPC == null) {
            this.pPC = TTAdSdk.getAdManager().createAdNative(context);
        }
        this.pPA = baVar;
    }

    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        m.a("CSJAdLoader show adId: " + this.f7766a.f7762a);
        this.pPB = axVar;
    }
}
