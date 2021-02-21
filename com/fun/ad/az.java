package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
/* loaded from: classes6.dex */
public class az extends ac {
    public AdRipper.RippedKSAd pPK;
    public KsSplashScreenAd pPY;

    /* loaded from: classes6.dex */
    public class a implements KsLoadManager.SplashScreenAdListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int i, String str) {
            m.a("KSSplashAd onError code: " + i + ", message: " + str);
            az azVar = az.this;
            azVar.f7746b = false;
            z zVar = azVar.pPH;
            if (zVar != null) {
                ((ad) zVar).a(azVar.f7745a.f7762a, i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
            m.a("KSSplashAd onSplashScreenAdLoad");
            az azVar = az.this;
            azVar.f7746b = false;
            azVar.pPY = ksSplashScreenAd;
            z zVar = azVar.pPH;
            if (zVar != null) {
                ((ad) zVar).b(azVar.f7745a.f7762a);
            }
            AdRipper.ripKsSplash(ksSplashScreenAd);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements KsSplashScreenAd.SplashScreenAdInteractionListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdClicked() {
            m.a("KSSplashAd onAdClicked");
            az azVar = az.this;
            w wVar = azVar.pPI;
            if (wVar != null) {
                ((ag) wVar).a(azVar.f7745a.f7762a);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowEnd() {
            m.a("KSSplashAd onAdShowEnd");
            az azVar = az.this;
            w wVar = azVar.pPI;
            if (wVar != null) {
                ((ag) wVar).b(azVar.f7745a.f7762a);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowError(int i, String str) {
            m.a("KSSplashAd onAdShowError code: " + i + ", message: " + str);
            az azVar = az.this;
            w wVar = azVar.pPI;
            if (wVar != null) {
                ((ag) wVar).a(azVar.f7745a.f7762a, i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowStart() {
            m.a("KSSplashAd onAdShowStart");
            az azVar = az.this;
            w wVar = azVar.pPI;
            if (wVar != null) {
                ((ag) wVar).c(azVar.f7745a.f7762a);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onSkippedAd() {
            m.a("KSSplashAd onSkippedAd");
            az azVar = az.this;
            w wVar = azVar.pPI;
            if (wVar != null) {
                String str = azVar.f7745a.f7762a;
                ag agVar = (ag) wVar;
                if (agVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 快手广告 onAdSkip，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = agVar.pPA;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClose(agVar.pPC.pPk.f7760a);
                }
                d.b bVar = d.pOZ;
                ((d.a) bVar).a(agVar.f7749b, agVar.pPB.f7763b, str);
            }
        }
    }

    public az(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.ac
    public void a() {
        super.a();
        this.pPY = null;
        this.pPK = null;
    }

    @Override // com.fun.ad.ac
    public FunRippedAd eAx() {
        KsSplashScreenAd ksSplashScreenAd = this.pPY;
        if (ksSplashScreenAd == null) {
            return null;
        }
        if (this.pPK == null) {
            this.pPK = AdRipper.getRippedKsSplashAd(ksSplashScreenAd, false);
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        AdRipper.RippedKSAd rippedKSAd = this.pPK;
        funRippedAd.description = rippedKSAd.adDescription;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedKSAd.deeplinkUrl);
        AdRipper.RippedKSAd rippedKSAd2 = this.pPK;
        funRippedAd.uniqueId = rippedKSAd2.adDescription;
        funRippedAd.appName = rippedKSAd2.appName;
        funRippedAd.appPackageName = rippedKSAd2.appPackageName;
        funRippedAd.appLinkUrl = rippedKSAd2.appDownloadUrl;
        funRippedAd.appMarketUrl = rippedKSAd2.marketUrl;
        return funRippedAd;
    }

    @Override // com.fun.ad.ac
    public void a(Context context, FunAdSlot funAdSlot, z zVar) {
        super.a(context.getApplicationContext(), funAdSlot, zVar);
        if (!this.f7746b) {
            this.f7746b = true;
            KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(Long.parseLong(this.f7745a.f7762a)).build(), new a());
            z zVar2 = this.pPH;
            if (zVar2 != null) {
                ((ad) zVar2).a(this.f7745a.f7762a);
            }
        }
    }

    @Override // com.fun.ad.ac
    public void a(Activity activity, FunAdView funAdView, w wVar) {
        super.a(activity, funAdView, wVar);
        KsSplashScreenAd ksSplashScreenAd = this.pPY;
        if (ksSplashScreenAd != null) {
            Fragment fragment = ksSplashScreenAd.getFragment(new b());
            if (fragment == null) {
                w wVar2 = this.pPI;
                if (wVar2 != null) {
                    ((ag) wVar2).a(this.f7745a.f7762a, 0, "KsSplashScreenFragment is null");
                }
            } else if (activity instanceof FragmentActivity) {
                FrameLayout frameLayout = new FrameLayout(activity);
                frameLayout.setId(R.id.splash_ad_container);
                funAdView.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
                ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction().replace(R.id.splash_ad_container, fragment).commit();
            } else {
                w wVar3 = this.pPI;
                if (wVar3 != null) {
                    ((ag) wVar3).a(this.f7745a.f7762a, 0, "Activity is not instanceof FragmentActivity");
                }
            }
        }
    }
}
