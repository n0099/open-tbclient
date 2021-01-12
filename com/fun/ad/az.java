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
/* loaded from: classes14.dex */
public class az extends ac {
    public AdRipper.RippedKSAd pFe;
    public KsSplashScreenAd pFs;

    /* loaded from: classes14.dex */
    public class a implements KsLoadManager.SplashScreenAdListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int i, String str) {
            m.a("KSSplashAd onError code: " + i + ", message: " + str);
            az azVar = az.this;
            azVar.f7744b = false;
            z zVar = azVar.pFb;
            if (zVar != null) {
                ((ad) zVar).a(azVar.f7743a.f7760a, i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
            m.a("KSSplashAd onSplashScreenAdLoad");
            az azVar = az.this;
            azVar.f7744b = false;
            azVar.pFs = ksSplashScreenAd;
            z zVar = azVar.pFb;
            if (zVar != null) {
                ((ad) zVar).b(azVar.f7743a.f7760a);
            }
            AdRipper.ripKsSplash(ksSplashScreenAd);
        }
    }

    /* loaded from: classes14.dex */
    public class b implements KsSplashScreenAd.SplashScreenAdInteractionListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdClicked() {
            m.a("KSSplashAd onAdClicked");
            az azVar = az.this;
            w wVar = azVar.pFc;
            if (wVar != null) {
                ((ag) wVar).a(azVar.f7743a.f7760a);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowEnd() {
            m.a("KSSplashAd onAdShowEnd");
            az azVar = az.this;
            w wVar = azVar.pFc;
            if (wVar != null) {
                ((ag) wVar).b(azVar.f7743a.f7760a);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowError(int i, String str) {
            m.a("KSSplashAd onAdShowError code: " + i + ", message: " + str);
            az azVar = az.this;
            w wVar = azVar.pFc;
            if (wVar != null) {
                ((ag) wVar).a(azVar.f7743a.f7760a, i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowStart() {
            m.a("KSSplashAd onAdShowStart");
            az azVar = az.this;
            w wVar = azVar.pFc;
            if (wVar != null) {
                ((ag) wVar).c(azVar.f7743a.f7760a);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onSkippedAd() {
            m.a("KSSplashAd onSkippedAd");
            az azVar = az.this;
            w wVar = azVar.pFc;
            if (wVar != null) {
                String str = azVar.f7743a.f7760a;
                ag agVar = (ag) wVar;
                if (agVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 快手广告 onAdSkip，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = agVar.pEU;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClose(agVar.pEW.pEE.f7758a);
                }
                d.b bVar = d.pEt;
                ((d.a) bVar).a(agVar.f7747b, agVar.pEV.f7761b, str);
            }
        }
    }

    public az(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.ac
    public void a() {
        super.a();
        this.pFs = null;
        this.pFe = null;
    }

    @Override // com.fun.ad.ac
    public FunRippedAd exX() {
        KsSplashScreenAd ksSplashScreenAd = this.pFs;
        if (ksSplashScreenAd == null) {
            return null;
        }
        if (this.pFe == null) {
            this.pFe = AdRipper.getRippedKsSplashAd(ksSplashScreenAd, false);
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        AdRipper.RippedKSAd rippedKSAd = this.pFe;
        funRippedAd.description = rippedKSAd.adDescription;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedKSAd.deeplinkUrl);
        AdRipper.RippedKSAd rippedKSAd2 = this.pFe;
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
        if (!this.f7744b) {
            this.f7744b = true;
            KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(Long.parseLong(this.f7743a.f7760a)).build(), new a());
            z zVar2 = this.pFb;
            if (zVar2 != null) {
                ((ad) zVar2).a(this.f7743a.f7760a);
            }
        }
    }

    @Override // com.fun.ad.ac
    public void a(Activity activity, FunAdView funAdView, w wVar) {
        super.a(activity, funAdView, wVar);
        KsSplashScreenAd ksSplashScreenAd = this.pFs;
        if (ksSplashScreenAd != null) {
            Fragment fragment = ksSplashScreenAd.getFragment(new b());
            if (fragment == null) {
                w wVar2 = this.pFc;
                if (wVar2 != null) {
                    ((ag) wVar2).a(this.f7743a.f7760a, 0, "KsSplashScreenFragment is null");
                }
            } else if (activity instanceof FragmentActivity) {
                FrameLayout frameLayout = new FrameLayout(activity);
                frameLayout.setId(R.id.splash_ad_container);
                funAdView.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
                ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction().replace(R.id.splash_ad_container, fragment).commit();
            } else {
                w wVar3 = this.pFc;
                if (wVar3 != null) {
                    ((ag) wVar3).a(this.f7743a.f7760a, 0, "Activity is not instanceof FragmentActivity");
                }
            }
        }
    }
}
