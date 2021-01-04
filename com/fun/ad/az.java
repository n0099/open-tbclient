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
/* loaded from: classes15.dex */
public class az extends ac {
    public AdRipper.RippedKSAd pHX;
    public KsSplashScreenAd pIl;

    /* loaded from: classes15.dex */
    public class a implements KsLoadManager.SplashScreenAdListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int i, String str) {
            m.a("KSSplashAd onError code: " + i + ", message: " + str);
            az azVar = az.this;
            azVar.f8043b = false;
            z zVar = azVar.pHU;
            if (zVar != null) {
                ((ad) zVar).a(azVar.f8042a.f8059a, i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
            m.a("KSSplashAd onSplashScreenAdLoad");
            az azVar = az.this;
            azVar.f8043b = false;
            azVar.pIl = ksSplashScreenAd;
            z zVar = azVar.pHU;
            if (zVar != null) {
                ((ad) zVar).b(azVar.f8042a.f8059a);
            }
            AdRipper.ripKsSplash(ksSplashScreenAd);
        }
    }

    /* loaded from: classes15.dex */
    public class b implements KsSplashScreenAd.SplashScreenAdInteractionListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdClicked() {
            m.a("KSSplashAd onAdClicked");
            az azVar = az.this;
            w wVar = azVar.pHV;
            if (wVar != null) {
                ((ag) wVar).a(azVar.f8042a.f8059a);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowEnd() {
            m.a("KSSplashAd onAdShowEnd");
            az azVar = az.this;
            w wVar = azVar.pHV;
            if (wVar != null) {
                ((ag) wVar).b(azVar.f8042a.f8059a);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowError(int i, String str) {
            m.a("KSSplashAd onAdShowError code: " + i + ", message: " + str);
            az azVar = az.this;
            w wVar = azVar.pHV;
            if (wVar != null) {
                ((ag) wVar).a(azVar.f8042a.f8059a, i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowStart() {
            m.a("KSSplashAd onAdShowStart");
            az azVar = az.this;
            w wVar = azVar.pHV;
            if (wVar != null) {
                ((ag) wVar).c(azVar.f8042a.f8059a);
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onSkippedAd() {
            m.a("KSSplashAd onSkippedAd");
            az azVar = az.this;
            w wVar = azVar.pHV;
            if (wVar != null) {
                String str = azVar.f8042a.f8059a;
                ag agVar = (ag) wVar;
                if (agVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 快手广告 onAdSkip，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = agVar.pHN;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onAdClose(agVar.pHP.pHx.f8057a);
                }
                d.b bVar = d.pHm;
                ((d.a) bVar).a(agVar.f8046b, agVar.pHO.f8060b, str);
            }
        }
    }

    public az(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.ac
    public void a() {
        super.a();
        this.pIl = null;
        this.pHX = null;
    }

    @Override // com.fun.ad.ac
    public FunRippedAd eBl() {
        KsSplashScreenAd ksSplashScreenAd = this.pIl;
        if (ksSplashScreenAd == null) {
            return null;
        }
        if (this.pHX == null) {
            this.pHX = AdRipper.getRippedKsSplashAd(ksSplashScreenAd, false);
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        AdRipper.RippedKSAd rippedKSAd = this.pHX;
        funRippedAd.description = rippedKSAd.adDescription;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedKSAd.deeplinkUrl);
        AdRipper.RippedKSAd rippedKSAd2 = this.pHX;
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
        if (!this.f8043b) {
            this.f8043b = true;
            KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(Long.parseLong(this.f8042a.f8059a)).build(), new a());
            z zVar2 = this.pHU;
            if (zVar2 != null) {
                ((ad) zVar2).a(this.f8042a.f8059a);
            }
        }
    }

    @Override // com.fun.ad.ac
    public void a(Activity activity, FunAdView funAdView, w wVar) {
        super.a(activity, funAdView, wVar);
        KsSplashScreenAd ksSplashScreenAd = this.pIl;
        if (ksSplashScreenAd != null) {
            Fragment fragment = ksSplashScreenAd.getFragment(new b());
            if (fragment == null) {
                w wVar2 = this.pHV;
                if (wVar2 != null) {
                    ((ag) wVar2).a(this.f8042a.f8059a, 0, "KsSplashScreenFragment is null");
                }
            } else if (activity instanceof FragmentActivity) {
                FrameLayout frameLayout = new FrameLayout(activity);
                frameLayout.setId(R.id.splash_ad_container);
                funAdView.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
                ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction().replace(R.id.splash_ad_container, fragment).commit();
            } else {
                w wVar3 = this.pHV;
                if (wVar3 != null) {
                    ((ag) wVar3).a(this.f8042a.f8059a, 0, "Activity is not instanceof FragmentActivity");
                }
            }
        }
    }
}
