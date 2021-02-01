package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.fun.ad.ap;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.fun.ad.sdk.R;
import com.fun.ad.sdk.jy.JYNativeAdView;
import com.win.opensdk.PBError;
import com.win.opensdk.PBNative;
import com.win.opensdk.PBNativeListener;
/* loaded from: classes6.dex */
public class q extends i {
    public PBNative pOS;

    /* loaded from: classes6.dex */
    public class a implements PBNativeListener {
        public a() {
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            m.a("JYNativeAd onClicked");
            q qVar = q.this;
            c cVar = qVar.pOF;
            if (cVar != null) {
                ((u) cVar).a(qVar.f7783a.f7762a);
            }
        }

        @Override // com.win.opensdk.PBNativeListener
        public void onDisplayed() {
            m.a("JYNativeAd onDisplayed");
            q qVar = q.this;
            c cVar = qVar.pOF;
            if (cVar != null) {
                ((u) cVar).c(qVar.f7783a.f7762a);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            m.a("JYNativeAd onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg());
            q qVar = q.this;
            qVar.f7784b = false;
            f fVar = qVar.pOE;
            if (fVar != null) {
                ((r) fVar).a(qVar.f7783a.f7762a, pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            m.a("JYNativeAd onLoaded");
            q qVar = q.this;
            qVar.f7784b = false;
            f fVar = qVar.pOE;
            if (fVar != null) {
                ((r) fVar).b(qVar.f7783a.f7762a);
            }
        }
    }

    public q(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.i
    public void a() {
        super.a();
        PBNative pBNative = this.pOS;
        if (pBNative != null) {
            pBNative.destroy();
            this.pOS = null;
        }
    }

    @Override // com.fun.ad.i
    public FunRippedAd eAp() {
        return null;
    }

    @Override // com.fun.ad.i
    public void a(Context context, FunAdSlot funAdSlot, f fVar) {
        super.a(context.getApplicationContext(), funAdSlot, fVar);
        if (!this.f7784b) {
            this.f7784b = true;
            PBNative pBNative = new PBNative(context.getApplicationContext(), this.f7783a.f7762a);
            this.pOS = pBNative;
            pBNative.setNativeListener(new a());
            this.pOS.load();
            f fVar2 = this.pOE;
            if (fVar2 != null) {
                ((r) fVar2).a(this.f7783a.f7762a);
            }
        }
    }

    @Override // com.fun.ad.i
    public void a(Activity activity, FunAdView funAdView, c cVar) {
        super.a(activity, funAdView, cVar);
        if (this.pOS != null) {
            JYNativeAdView jYNativeAdView = (JYNativeAdView) LayoutInflater.from(activity).inflate(R.layout.jy_ad_native_view, (ViewGroup) funAdView, false);
            funAdView.removeAllViews();
            funAdView.addView(jYNativeAdView);
            PBNative pBNative = this.pOS;
            jYNativeAdView.f7825a.setText(pBNative.getBody());
            jYNativeAdView.c.setText(pBNative.getHeadline());
            ap.a.pPq.a(jYNativeAdView.getContext(), pBNative.getIcon(), jYNativeAdView.d);
            jYNativeAdView.e.setText(pBNative.getCallToAction());
            jYNativeAdView.f = (pBNative.getMediaViewWidth() * 1.0f) / (pBNative.getMediaViewHeight() * 1.0f);
            pBNative.registerViewForInteraction(jYNativeAdView, jYNativeAdView.f7826b);
        }
    }
}
