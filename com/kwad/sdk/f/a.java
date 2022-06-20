package com.kwad.sdk.f;

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
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.core.AbstractKsNativeAd;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.AdSourceLogoType;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    @NonNull
    public AdTemplate a;
    public AdInfo b;
    @Nullable
    public com.kwad.sdk.core.download.a.b c;
    @Nullable
    public KsNativeAd.AdInteractionListener d;
    public b e;
    @Nullable
    public KsNativeAd.VideoPlayListener f;
    public KsNativeAd.VideoPlayListener g = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.sdk.f.a.6
        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayComplete() {
            if (a.this.f != null) {
                a.this.f.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayError(int i, int i2) {
            if (a.this.f != null) {
                a.this.f.onVideoPlayError(i, i2);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayStart() {
            if (a.this.f != null) {
                a.this.f.onVideoPlayStart();
            }
        }
    };
    public InterfaceC0329a h = new InterfaceC0329a() { // from class: com.kwad.sdk.f.a.7
        @Override // com.kwad.sdk.f.a.InterfaceC0329a
        public void a() {
            if (a.this.d != null) {
                try {
                    a.this.d.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.sdk.f.a.InterfaceC0329a
        public void a(View view2, KsNativeAd ksNativeAd) {
            if (a.this.d != null) {
                a.this.d.onAdClicked(view2, a.this);
            }
        }

        @Override // com.kwad.sdk.f.a.InterfaceC0329a
        public void a(KsNativeAd ksNativeAd) {
            if (a.this.d != null) {
                a.this.d.onAdShow(a.this);
            }
        }

        @Override // com.kwad.sdk.f.a.InterfaceC0329a
        public boolean a(DialogInterface.OnClickListener onClickListener) {
            if (a.this.d != null) {
                try {
                    return a.this.d.handleDownloadDialog(onClickListener);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                    return false;
                }
            }
            return false;
        }

        @Override // com.kwad.sdk.f.a.InterfaceC0329a
        public void b() {
            if (a.this.d != null) {
                try {
                    a.this.d.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }
    };

    /* renamed from: com.kwad.sdk.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0329a {
        void a();

        void a(View view2, KsNativeAd ksNativeAd);

        void a(KsNativeAd ksNativeAd);

        boolean a(DialogInterface.OnClickListener onClickListener);

        void b();
    }

    public a(@NonNull AdTemplate adTemplate) {
        this.a = adTemplate;
        AdInfo j = d.j(adTemplate);
        this.b = j;
        if (com.kwad.sdk.core.response.a.a.B(j)) {
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.a);
            this.c = bVar;
            bVar.a((DialogInterface.OnShowListener) this);
            this.c.a((DialogInterface.OnDismissListener) this);
            this.c.a(new b.a() { // from class: com.kwad.sdk.f.a.1
                @Override // com.kwad.sdk.core.download.a.b.a
                public boolean a(DialogInterface.OnClickListener onClickListener) {
                    return a.this.h.a(onClickListener);
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.c(this.b), this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@Nullable Activity activity, final View view2, final z.a aVar) {
        Context context;
        if (activity == null) {
            context = view2.getContext();
        }
        com.kwad.sdk.core.download.a.a.a(Wrapper.wrapContextIfNeed(context), this.a, new a.b() { // from class: com.kwad.sdk.f.a.4
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(a.this.a, aVar);
                a.this.h.a(view2, a.this);
            }
        }, this.c, false);
    }

    private void a(@Nullable final Activity activity, @NonNull final ViewGroup viewGroup, @NonNull List<View> list) {
        for (View view2 : list) {
            final z.a aVar = new z.a();
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.f.a.2
                public int[] d = new int[2];

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        aVar.a(viewGroup.getWidth(), viewGroup.getHeight());
                        viewGroup.getLocationOnScreen(this.d);
                        aVar.a(Math.abs(motionEvent.getRawX() - this.d[0]), Math.abs(motionEvent.getRawY() - this.d[1]));
                    } else if (action == 1) {
                        aVar.b(Math.abs(motionEvent.getRawX() - this.d[0]), Math.abs(motionEvent.getRawY() - this.d[1]));
                    }
                    return false;
                }
            });
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.f.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    a.this.a(activity, view3, aVar);
                }
            });
        }
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b = b(viewGroup);
        if (b == null) {
            b = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b);
        }
        b.setViewCallback(new a.InterfaceC0313a() { // from class: com.kwad.sdk.f.a.5
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0313a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0313a
            public void a(View view2) {
                if (!a.this.a.mPvReported) {
                    a.this.h.a(a.this);
                }
                com.kwad.sdk.core.report.a.a(a.this.a, (JSONObject) null);
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0313a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0313a
            public void b() {
            }
        });
        b.setNeedCheckingShow(true);
    }

    private com.kwad.sdk.core.page.widget.a b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.sdk.core.page.widget.a) {
                return (com.kwad.sdk.core.page.widget.a) childAt;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    /* renamed from: a */
    public com.kwad.sdk.internal.api.b getVideoCoverImage() {
        AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.b);
        if (TextUtils.isEmpty(J.coverUrl)) {
            return null;
        }
        return new com.kwad.sdk.internal.api.b(J.width, J.height, J.coverUrl);
    }

    @NonNull
    public AdTemplate b() {
        return this.a;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getActionDescription() {
        return com.kwad.sdk.core.response.a.a.A(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdDescription() {
        return com.kwad.sdk.core.response.a.a.s(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdSource() {
        return com.kwad.sdk.core.response.a.a.z(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdSourceLogoUrl(@AdSourceLogoType int i) {
        AdInfo adInfo = this.b;
        if (adInfo == null) {
            return null;
        }
        return i != 1 ? adInfo.adBaseInfo.adMarkIcon : adInfo.adBaseInfo.adGrayMarkIcon;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppDownloadCountDes() {
        return com.kwad.sdk.core.response.a.a.w(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppIconUrl() {
        return com.kwad.sdk.core.response.a.a.au(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getAppName() {
        return com.kwad.sdk.core.response.a.a.t(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPackageName() {
        return com.kwad.sdk.core.response.a.a.v(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public long getAppPackageSize() {
        return com.kwad.sdk.core.response.a.a.am(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPrivacyUrl() {
        return com.kwad.sdk.core.response.a.a.ak(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public float getAppScore() {
        return com.kwad.sdk.core.response.a.a.x(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppVersion() {
        return com.kwad.sdk.core.response.a.a.al(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getCorporationName() {
        return com.kwad.sdk.core.response.a.a.ah(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getECPM() {
        return com.kwad.sdk.core.response.a.a.F(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo j = d.j(this.a);
        int R = com.kwad.sdk.core.response.a.a.R(this.b);
        if (R == 2 || R == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : j.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new com.kwad.sdk.internal.api.b(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.E(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.R(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getPermissionInfo() {
        return com.kwad.sdk.core.response.a.a.ai(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getPermissionInfoUrl() {
        return com.kwad.sdk.core.response.a.a.aj(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getProductName() {
        return com.kwad.sdk.core.response.a.a.u(this.b);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public Bitmap getSdkLogo() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.obfuscated_res_0x7f080cbb);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoDuration() {
        return com.kwad.sdk.core.response.a.a.b(this.b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoHeight() {
        return com.kwad.sdk.core.response.a.a.J(this.b).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getVideoUrl() {
        return com.kwad.sdk.core.response.a.a.a(this.b);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            com.kwad.sdk.core.d.a.d("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.e == null) {
            b bVar = new b(context);
            this.e = bVar;
            bVar.setInnerAdInteractionListener(this.h);
            this.e.setVideoPlayListener(this.g);
            this.e.a(this.a, this.c, ksAdVideoPlayConfig);
        }
        return this.e;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public View getVideoView2(Context context, boolean z) {
        return getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).dataFlowAutoStart(false).build());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoWidth() {
        return com.kwad.sdk.core.response.a.a.J(this.b).videoWidth;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.h.b();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        this.h.a();
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.d = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, list);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        registerViewForInteraction(null, viewGroup, list, adInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.a, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdVideoPlayEnd() {
        com.kwad.sdk.core.report.a.j(b());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdVideoPlayStart() {
        com.kwad.sdk.core.report.a.i(b());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.a;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.a.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.sdk.core.download.a.b bVar = this.c;
        if (bVar == null || ksAppDownloadListener == null) {
            return;
        }
        bVar.a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f = videoPlayListener;
    }
}
