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
    public au.a f8063a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8064b = false;
    public ba pIn;
    public ax pIo;
    public TTAdNative pIp;

    public bd(au.a aVar) {
        this.f8063a = aVar;
    }

    public void a() {
        m.a("CSJAdLoader destroy adId: " + this.f8063a.f8059a);
        this.pIn = null;
        this.pIo = null;
    }

    public abstract FunRippedAd eBl();

    public void a(Context context, FunAdSlot funAdSlot, ba baVar) {
        m.a("CSJAdLoader load adId: " + this.f8063a.f8059a);
        if (this.pIp == null) {
            this.pIp = TTAdSdk.getAdManager().createAdNative(context);
        }
        this.pIn = baVar;
    }

    public void a(Activity activity, FunAdView funAdView, ax axVar) {
        m.a("CSJAdLoader show adId: " + this.f8063a.f8059a);
        this.pIo = axVar;
    }
}
