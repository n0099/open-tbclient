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
/* loaded from: classes14.dex */
public class q extends i {
    public PBNative pEM;

    /* loaded from: classes14.dex */
    public class a implements PBNativeListener {
        public a() {
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            m.a("JYNativeAd onClicked");
            q qVar = q.this;
            c cVar = qVar.pEz;
            if (cVar != null) {
                ((u) cVar).a(qVar.f7781a.f7760a);
            }
        }

        @Override // com.win.opensdk.PBNativeListener
        public void onDisplayed() {
            m.a("JYNativeAd onDisplayed");
            q qVar = q.this;
            c cVar = qVar.pEz;
            if (cVar != null) {
                ((u) cVar).c(qVar.f7781a.f7760a);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            m.a("JYNativeAd onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg());
            q qVar = q.this;
            qVar.f7782b = false;
            f fVar = qVar.pEy;
            if (fVar != null) {
                ((r) fVar).a(qVar.f7781a.f7760a, pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            m.a("JYNativeAd onLoaded");
            q qVar = q.this;
            qVar.f7782b = false;
            f fVar = qVar.pEy;
            if (fVar != null) {
                ((r) fVar).b(qVar.f7781a.f7760a);
            }
        }
    }

    public q(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.i
    public void a() {
        super.a();
        PBNative pBNative = this.pEM;
        if (pBNative != null) {
            pBNative.destroy();
            this.pEM = null;
        }
    }

    @Override // com.fun.ad.i
    public FunRippedAd exX() {
        return null;
    }

    @Override // com.fun.ad.i
    public void a(Context context, FunAdSlot funAdSlot, f fVar) {
        super.a(context.getApplicationContext(), funAdSlot, fVar);
        if (!this.f7782b) {
            this.f7782b = true;
            PBNative pBNative = new PBNative(context.getApplicationContext(), this.f7781a.f7760a);
            this.pEM = pBNative;
            pBNative.setNativeListener(new a());
            this.pEM.load();
            f fVar2 = this.pEy;
            if (fVar2 != null) {
                ((r) fVar2).a(this.f7781a.f7760a);
            }
        }
    }

    @Override // com.fun.ad.i
    public void a(Activity activity, FunAdView funAdView, c cVar) {
        super.a(activity, funAdView, cVar);
        if (this.pEM != null) {
            JYNativeAdView jYNativeAdView = (JYNativeAdView) LayoutInflater.from(activity).inflate(R.layout.jy_ad_native_view, (ViewGroup) funAdView, false);
            funAdView.removeAllViews();
            funAdView.addView(jYNativeAdView);
            PBNative pBNative = this.pEM;
            jYNativeAdView.f7823a.setText(pBNative.getBody());
            jYNativeAdView.c.setText(pBNative.getHeadline());
            ap.a.pFk.a(jYNativeAdView.getContext(), pBNative.getIcon(), jYNativeAdView.d);
            jYNativeAdView.e.setText(pBNative.getCallToAction());
            jYNativeAdView.f = (pBNative.getMediaViewWidth() * 1.0f) / (pBNative.getMediaViewHeight() * 1.0f);
            pBNative.registerViewForInteraction(jYNativeAdView, jYNativeAdView.f7824b);
        }
    }
}
