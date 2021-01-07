package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes15.dex */
public abstract class bd {

    /* renamed from: a  reason: collision with root package name */
    public au.a f8064a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8065b = false;
    public ba pJV;
    public ax pJW;
    public TTAdNative pJX;

    public bd(au.a aVar) {
        this.f8064a = aVar;
    }

    public void a() {
        m.a("CSJAdLoader destroy adId: " + this.f8064a.f8060a);
        this.pJV = null;
        this.pJW = null;
    }

    public abstract FunRippedAd eBP();

    public void a(Context context, FunAdSlot funAdSlot, ba baVar) {
        m.a("CSJAdLoader load adId: " + this.f8064a.f8060a);
        if (this.pJX == null) {
            this.pJX = TTAdSdk.getAdManager().createAdNative(context);
        }
        this.pJV = baVar;
    }

    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        m.a("CSJAdLoader show adId: " + this.f8064a.f8060a);
        this.pJW = axVar;
    }
}
