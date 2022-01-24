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
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
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
/* loaded from: classes3.dex */
public class a extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    @NonNull
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f56827b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56828c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsNativeAd.AdInteractionListener f56829d;

    /* renamed from: e  reason: collision with root package name */
    public b f56830e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f56831f;

    /* renamed from: g  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f56832g = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.sdk.f.a.6
        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayComplete() {
            if (a.this.f56831f != null) {
                a.this.f56831f.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayError(int i2, int i3) {
            if (a.this.f56831f != null) {
                a.this.f56831f.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayStart() {
            if (a.this.f56831f != null) {
                a.this.f56831f.onVideoPlayStart();
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC2131a f56833h = new InterfaceC2131a() { // from class: com.kwad.sdk.f.a.7
        @Override // com.kwad.sdk.f.a.InterfaceC2131a
        public void a() {
            if (a.this.f56829d != null) {
                try {
                    a.this.f56829d.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.sdk.f.a.InterfaceC2131a
        public void a(View view, KsNativeAd ksNativeAd) {
            if (a.this.f56829d != null) {
                a.this.f56829d.onAdClicked(view, a.this);
            }
        }

        @Override // com.kwad.sdk.f.a.InterfaceC2131a
        public void a(KsNativeAd ksNativeAd) {
            if (a.this.f56829d != null) {
                a.this.f56829d.onAdShow(a.this);
            }
        }

        @Override // com.kwad.sdk.f.a.InterfaceC2131a
        public boolean a(DialogInterface.OnClickListener onClickListener) {
            if (a.this.f56829d != null) {
                try {
                    return a.this.f56829d.handleDownloadDialog(onClickListener);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                    return false;
                }
            }
            return false;
        }

        @Override // com.kwad.sdk.f.a.InterfaceC2131a
        public void b() {
            if (a.this.f56829d != null) {
                try {
                    a.this.f56829d.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }
    };

    /* renamed from: com.kwad.sdk.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2131a {
        void a();

        void a(View view, KsNativeAd ksNativeAd);

        void a(KsNativeAd ksNativeAd);

        boolean a(DialogInterface.OnClickListener onClickListener);

        void b();
    }

    public a(@NonNull AdTemplate adTemplate) {
        this.a = adTemplate;
        AdInfo j2 = d.j(adTemplate);
        this.f56827b = j2;
        if (com.kwad.sdk.core.response.a.a.B(j2)) {
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(this.a);
            this.f56828c = bVar;
            bVar.a((DialogInterface.OnShowListener) this);
            this.f56828c.a((DialogInterface.OnDismissListener) this);
            this.f56828c.a(new b.a() { // from class: com.kwad.sdk.f.a.1
                @Override // com.kwad.sdk.core.download.a.b.a
                public boolean a(DialogInterface.OnClickListener onClickListener) {
                    return a.this.f56833h.a(onClickListener);
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.c(this.f56827b), this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@Nullable Activity activity, final View view, final z.a aVar) {
        Context context;
        if (activity == null) {
            context = view.getContext();
        }
        com.kwad.sdk.core.download.a.a.a(Wrapper.wrapContextIfNeed(context), this.a, new a.b() { // from class: com.kwad.sdk.f.a.4
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(a.this.a, aVar);
                a.this.f56833h.a(view, a.this);
            }
        }, this.f56828c, false);
    }

    private void a(@Nullable final Activity activity, @NonNull final ViewGroup viewGroup, @NonNull List<View> list) {
        for (View view : list) {
            final z.a aVar = new z.a();
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.f.a.2

                /* renamed from: d  reason: collision with root package name */
                public int[] f56836d = new int[2];

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        aVar.a(viewGroup.getWidth(), viewGroup.getHeight());
                        viewGroup.getLocationOnScreen(this.f56836d);
                        aVar.a(Math.abs(motionEvent.getRawX() - this.f56836d[0]), Math.abs(motionEvent.getRawY() - this.f56836d[1]));
                    } else if (action == 1) {
                        aVar.b(Math.abs(motionEvent.getRawX() - this.f56836d[0]), Math.abs(motionEvent.getRawY() - this.f56836d[1]));
                    }
                    return false;
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.f.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.a(activity, view2, aVar);
                }
            });
        }
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
        if (b2 == null) {
            b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b2);
        }
        b2.setViewCallback(new a.InterfaceC2115a() { // from class: com.kwad.sdk.f.a.5
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2115a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2115a
            public void a(View view) {
                if (!a.this.a.mPvReported) {
                    a.this.f56833h.a(a.this);
                }
                com.kwad.sdk.core.report.a.a(a.this.a, (JSONObject) null);
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2115a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2115a
            public void b() {
            }
        });
        b2.setNeedCheckingShow(true);
    }

    private com.kwad.sdk.core.page.widget.a b(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
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
        AdInfo.AdMaterialInfo.MaterialFeature J = com.kwad.sdk.core.response.a.a.J(this.f56827b);
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
        return com.kwad.sdk.core.response.a.a.A(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdDescription() {
        return com.kwad.sdk.core.response.a.a.s(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdSource() {
        return com.kwad.sdk.core.response.a.a.z(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdSourceLogoUrl(@AdSourceLogoType int i2) {
        AdInfo adInfo = this.f56827b;
        if (adInfo == null) {
            return null;
        }
        return i2 != 1 ? adInfo.adBaseInfo.adMarkIcon : adInfo.adBaseInfo.adGrayMarkIcon;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppDownloadCountDes() {
        return com.kwad.sdk.core.response.a.a.w(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppIconUrl() {
        return com.kwad.sdk.core.response.a.a.au(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getAppName() {
        return com.kwad.sdk.core.response.a.a.t(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPackageName() {
        return com.kwad.sdk.core.response.a.a.v(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public long getAppPackageSize() {
        return com.kwad.sdk.core.response.a.a.am(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPrivacyUrl() {
        return com.kwad.sdk.core.response.a.a.ak(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public float getAppScore() {
        return com.kwad.sdk.core.response.a.a.x(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppVersion() {
        return com.kwad.sdk.core.response.a.a.al(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getCorporationName() {
        return com.kwad.sdk.core.response.a.a.ah(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getECPM() {
        return com.kwad.sdk.core.response.a.a.F(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo j2 = d.j(this.a);
        int R = com.kwad.sdk.core.response.a.a.R(this.f56827b);
        if (R == 2 || R == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : j2.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new com.kwad.sdk.internal.api.b(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.E(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.R(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getPermissionInfo() {
        return com.kwad.sdk.core.response.a.a.ai(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getPermissionInfoUrl() {
        return com.kwad.sdk.core.response.a.a.aj(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getProductName() {
        return com.kwad.sdk.core.response.a.a.u(this.f56827b);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public Bitmap getSdkLogo() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.ksad_sdk_logo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoDuration() {
        return com.kwad.sdk.core.response.a.a.b(this.f56827b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoHeight() {
        return com.kwad.sdk.core.response.a.a.J(this.f56827b).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getVideoUrl() {
        return com.kwad.sdk.core.response.a.a.a(this.f56827b);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            com.kwad.sdk.core.d.a.d("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.f56830e == null) {
            b bVar = new b(context);
            this.f56830e = bVar;
            bVar.setInnerAdInteractionListener(this.f56833h);
            this.f56830e.setVideoPlayListener(this.f56832g);
            this.f56830e.a(this.a, this.f56828c, ksAdVideoPlayConfig);
        }
        return this.f56830e;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public View getVideoView2(Context context, boolean z) {
        return getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).dataFlowAutoStart(false).build());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoWidth() {
        return com.kwad.sdk.core.response.a.a.J(this.f56827b).videoWidth;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f56833h.b();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        this.f56833h.a();
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.f56829d = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, list);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        registerViewForInteraction(null, viewGroup, list, adInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.a, i2, adExposureFailedReason);
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
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.a;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.a.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.sdk.core.download.a.b bVar = this.f56828c;
        if (bVar == null || ksAppDownloadListener == null) {
            return;
        }
        bVar.a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f56831f = videoPlayListener;
    }
}
