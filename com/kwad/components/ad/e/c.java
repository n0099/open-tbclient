package com.kwad.components.ad.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.a.c;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.core.AbstractKsNativeAd;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.AdSourceLogoType;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.components.core.internal.api.a {
    @Nullable
    public KsNativeAd.VideoPlayListener jA;
    public KsNativeAd.VideoPlayListener jB = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.components.ad.e.c.7
        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            if (c.this.jA != null) {
                c.this.jA.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i, int i2) {
            if (c.this.jA != null) {
                c.this.jA.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
            if (c.this.jA != null) {
                try {
                    c.this.jA.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
            if (c.this.jA != null) {
                try {
                    c.this.jA.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
            if (c.this.jA != null) {
                try {
                    c.this.jA.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            if (c.this.jA != null) {
                c.this.jA.onVideoPlayStart();
            }
        }
    };
    public a jC = new a() { // from class: com.kwad.components.ad.e.c.8
        @Override // com.kwad.components.ad.e.c.a
        public final void en() {
            if (c.this.jy != null) {
                c.this.jy.onAdShow(c.this);
            }
        }

        @Override // com.kwad.components.ad.e.c.a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (c.this.jy != null) {
                try {
                    return c.this.jy.handleDownloadDialog(onClickListener);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                    return false;
                }
            }
            return false;
        }

        @Override // com.kwad.components.ad.e.c.a
        public final void i(View view2) {
            if (c.this.jy != null) {
                c.this.jy.onAdClicked(view2, c.this);
            }
        }

        @Override // com.kwad.components.ad.e.c.a
        public final void onDownloadTipsDialogDismiss() {
            if (c.this.jy != null) {
                try {
                    c.this.jy.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.components.ad.e.c.a
        public final void onDownloadTipsDialogShow() {
            if (c.this.jy != null) {
                try {
                    c.this.jy.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }
    };
    @Nullable
    public KsNativeAd.AdInteractionListener jy;
    public d jz;
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    /* loaded from: classes8.dex */
    public interface a {
        void en();

        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        void i(View view2);

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public c(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.mAdInfo = bQ;
        if (com.kwad.sdk.core.response.a.a.am(bQ)) {
            com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            this.mApkDownloadHelper.a(new c.a() { // from class: com.kwad.components.ad.e.c.1
                @Override // com.kwad.components.core.c.a.c.a
                public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return c.this.jC.handleDownloadDialog(onClickListener);
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.D(this.mAdInfo), this.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r2 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@Nullable Activity activity, final View view2, final aa.a aVar, int i, boolean z) {
        Context context;
        if (activity == null) {
            context = view2.getContext();
        }
        com.kwad.components.core.c.a.a.a(new a.C0593a(Wrapper.wrapContextIfNeed(context)).L(this.mAdTemplate).b(this.mApkDownloadHelper).af(i).aj(true).ap(z).a(new a.b() { // from class: com.kwad.components.ad.e.c.4
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(c.this.mAdTemplate, new f().b(aVar), (JSONObject) null);
                c.this.jC.i(view2);
            }
        }));
    }

    private void a(final Activity activity, @NonNull final ViewGroup viewGroup, final int i, View view2, final boolean z) {
        final aa.a aVar = new aa.a();
        view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.e.c.2
            public int[] jE = new int[2];

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    aVar.q(viewGroup.getWidth(), viewGroup.getHeight());
                    viewGroup.getLocationOnScreen(this.jE);
                    aVar.e(Math.abs(motionEvent.getRawX() - this.jE[0]), Math.abs(motionEvent.getRawY() - this.jE[1]));
                } else if (action == 1) {
                    aVar.f(Math.abs(motionEvent.getRawX() - this.jE[0]), Math.abs(motionEvent.getRawY() - this.jE[1]));
                }
                return false;
            }
        });
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.e.c.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                c.this.a(activity, view3, aVar, i, z);
            }
        });
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list) {
        for (View view2 : list) {
            a(activity, viewGroup, 0, view2, false);
        }
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map) {
        for (View view2 : map.keySet()) {
            a(activity, viewGroup, map.get(view2).intValue(), view2, true);
        }
    }

    private void a(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.d.sm() && com.kwad.sdk.core.config.d.sl() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0616a() { // from class: com.kwad.components.ad.e.c.5
                @Override // com.kwad.components.core.widget.a.InterfaceC0616a
                public final void em() {
                    if (!c.this.mAdTemplate.mPvReported) {
                        c.this.jC.en();
                    }
                    com.kwad.components.core.m.c.ox().a(c.this.mAdTemplate, null, null);
                }
            });
            aVar.pW();
            return;
        }
        com.kwad.components.core.widget.c b = b(viewGroup);
        if (b == null) {
            b = new com.kwad.components.core.widget.c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b);
        }
        b.setViewCallback(new c.a() { // from class: com.kwad.components.ad.e.c.6
            @Override // com.kwad.components.core.widget.c.a
            public final void em() {
                if (!c.this.mAdTemplate.mPvReported) {
                    c.this.jC.en();
                }
                com.kwad.components.core.m.c.ox().a(c.this.mAdTemplate, null, null);
            }
        });
        b.setNeedCheckingShow(true);
    }

    public static com.kwad.components.core.widget.c b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.c) {
                return (com.kwad.components.core.widget.c) childAt;
            }
        }
        return null;
    }

    public static void c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    /* renamed from: el */
    public com.kwad.components.core.internal.api.b getVideoCoverImage() {
        AdInfo.AdMaterialInfo.MaterialFeature au = com.kwad.sdk.core.response.a.a.au(this.mAdInfo);
        if (TextUtils.isEmpty(au.coverUrl)) {
            return null;
        }
        return new com.kwad.components.core.internal.api.b(au.width, au.height, au.coverUrl);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getActionDescription() {
        return com.kwad.sdk.core.response.a.a.al(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdDescription() {
        return com.kwad.sdk.core.response.a.a.ad(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSource() {
        return com.kwad.sdk.core.response.a.a.ak(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSourceLogoUrl(@AdSourceLogoType int i) {
        AdInfo adInfo = this.mAdInfo;
        if (adInfo == null) {
            return null;
        }
        return i != 1 ? adInfo.adBaseInfo.adMarkIcon : adInfo.adBaseInfo.adGrayMarkIcon;
    }

    @Override // com.kwad.components.core.internal.api.a
    @NonNull
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppDownloadCountDes() {
        return com.kwad.sdk.core.response.a.a.ah(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppIconUrl() {
        return com.kwad.sdk.core.response.a.a.bn(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppName() {
        return com.kwad.sdk.core.response.a.a.ae(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPackageName() {
        return com.kwad.sdk.core.response.a.a.ag(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final long getAppPackageSize() {
        return com.kwad.sdk.core.response.a.a.aX(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPrivacyUrl() {
        return com.kwad.sdk.core.response.a.a.aV(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final float getAppScore() {
        return com.kwad.sdk.core.response.a.a.ai(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppVersion() {
        return com.kwad.sdk.core.response.a.a.aW(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getCorporationName() {
        return com.kwad.sdk.core.response.a.a.aS(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aq(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
        int aD = com.kwad.sdk.core.response.a.a.aD(this.mAdInfo);
        if (aD == 2 || aD == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : bQ.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new com.kwad.components.core.internal.api.b(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.ap(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aD(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfo() {
        return com.kwad.sdk.core.response.a.a.aT(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfoUrl() {
        return com.kwad.sdk.core.response.a.a.aU(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getProductName() {
        return com.kwad.sdk.core.response.a.a.af(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final Bitmap getSdkLogo() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.obfuscated_res_0x7f080cf6);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoDuration() {
        return com.kwad.sdk.core.response.a.a.B(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoHeight() {
        return com.kwad.sdk.core.response.a.a.au(this.mAdInfo).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getVideoUrl() {
        return com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public final View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            com.kwad.sdk.core.e.b.w("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.jz == null) {
            d dVar = new d(context);
            this.jz = dVar;
            dVar.setInnerAdInteractionListener(this.jC);
            this.jz.setVideoPlayListener(this.jB);
            this.jz.a(this.mAdTemplate, this.mApkDownloadHelper, ksAdVideoPlayConfig);
        }
        return this.jz;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, boolean z) {
        return getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).build());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoWidth() {
        return com.kwad.sdk.core.response.a.a.au(this.mAdInfo).videoWidth;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.jC.onDownloadTipsDialogDismiss();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        a aVar = this.jC;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.jy = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, list);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.jy = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, map);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        registerViewForInteraction((Activity) null, viewGroup, list, adInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayEnd() {
        com.kwad.sdk.core.report.a.ax(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayStart() {
        com.kwad.sdk.core.report.a.aw(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(int i) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.a.aA(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar == null || ksAppDownloadListener == null) {
            return;
        }
        cVar.b(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.jA = videoPlayListener;
    }
}
