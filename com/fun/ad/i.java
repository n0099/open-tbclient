package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
/* loaded from: classes6.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public au.a f7783a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7784b = false;
    public f pOE;
    public c pOF;

    public i(au.a aVar) {
        this.f7783a = aVar;
    }

    public void a() {
        m.a("JYAdLoader destroy adId: " + this.f7783a.f7762a);
        this.pOE = null;
        this.pOF = null;
    }

    public abstract FunRippedAd eAp();

    public void a(Context context, FunAdSlot funAdSlot, f fVar) {
        m.a("JYAdLoader load adId: " + this.f7783a.f7762a);
        this.pOE = fVar;
    }

    public void a(Activity activity, FunAdView funAdView, c cVar) {
        m.a("JYAdLoader show adId: " + this.f7783a.f7762a);
        this.pOF = cVar;
    }
}
