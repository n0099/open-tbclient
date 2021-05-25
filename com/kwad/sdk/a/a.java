package com.kwad.sdk.a;

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
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.q;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends AbstractKsNativeAd {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f31609a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f31610b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f31611c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsNativeAd.AdInteractionListener f31612d;

    /* renamed from: e  reason: collision with root package name */
    public b f31613e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f31614f;

    /* renamed from: g  reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f31615g = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.sdk.a.a.6
        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayComplete() {
            if (a.this.f31614f != null) {
                a.this.f31614f.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayError(int i2, int i3) {
            if (a.this.f31614f != null) {
                a.this.f31614f.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public void onVideoPlayStart() {
            if (a.this.f31614f != null) {
                a.this.f31614f.onVideoPlayStart();
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public C0350a f31616h = new C0350a() { // from class: com.kwad.sdk.a.a.7
        @Override // com.kwad.sdk.a.a.C0350a, com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (a.this.f31612d != null) {
                try {
                    return a.this.f31612d.handleDownloadDialog(onClickListener);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.b(th);
                    return false;
                }
            }
            return false;
        }

        @Override // com.kwad.sdk.a.a.C0350a, com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            if (a.this.f31612d != null) {
                a.this.f31612d.onAdClicked(view, a.this);
            }
        }

        @Override // com.kwad.sdk.a.a.C0350a, com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            if (a.this.f31612d != null) {
                a.this.f31612d.onAdShow(a.this);
            }
        }
    };

    /* renamed from: com.kwad.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0350a implements KsNativeAd.AdInteractionListener {
        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
        }
    }

    public a(@NonNull AdTemplate adTemplate) {
        this.f31609a = adTemplate;
        AdInfo g2 = c.g(adTemplate);
        this.f31610b = g2;
        if (com.kwad.sdk.core.response.b.a.v(g2)) {
            com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.f31609a);
            this.f31611c = bVar;
            bVar.a(new b.a() { // from class: com.kwad.sdk.a.a.1
                @Override // com.kwad.sdk.core.download.b.b.a
                public boolean a(DialogInterface.OnClickListener onClickListener) {
                    return a.this.f31616h.handleDownloadDialog(onClickListener);
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.c(this.f31610b), this.f31609a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final q.a aVar) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f31609a, new a.InterfaceC0364a() { // from class: com.kwad.sdk.a.a.4
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
            public void a() {
                com.kwad.sdk.core.report.b.a(a.this.f31609a, aVar);
                if (a.this.f31612d != null) {
                    a.this.f31612d.onAdClicked(view, a.this);
                }
            }
        }, this.f31611c, false);
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
        if (b2 == null) {
            b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b2);
        }
        b2.setViewCallback(new a.InterfaceC0369a() { // from class: com.kwad.sdk.a.a.5
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0369a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0369a
            public void a(View view) {
                if (!a.this.f31609a.mPvReported && a.this.f31612d != null) {
                    a.this.f31612d.onAdShow(a.this);
                }
                com.kwad.sdk.core.report.b.a(a.this.f31609a, (JSONObject) null);
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0369a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0369a
            public void b() {
            }
        });
        b2.setNeedCheckingShow(true);
    }

    private void a(@NonNull final ViewGroup viewGroup, @NonNull List<View> list) {
        for (View view : list) {
            final q.a aVar = new q.a();
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.a.a.2

                /* renamed from: d  reason: collision with root package name */
                public int[] f31621d = new int[2];

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        aVar.a(viewGroup.getWidth(), viewGroup.getHeight());
                        viewGroup.getLocationOnScreen(this.f31621d);
                        aVar.a(Math.abs(motionEvent.getRawX() - this.f31621d[0]), Math.abs(motionEvent.getRawY() - this.f31621d[1]));
                    } else if (action == 1) {
                        aVar.b(Math.abs(motionEvent.getRawX() - this.f31621d[0]), Math.abs(motionEvent.getRawY() - this.f31621d[1]));
                    }
                    return false;
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.a(view2, aVar);
                }
            });
        }
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
    public com.kwad.sdk.internal.api.a getVideoCoverImage() {
        AdInfo.AdMaterialInfo.MaterialFeature C = com.kwad.sdk.core.response.b.a.C(this.f31610b);
        if (TextUtils.isEmpty(C.coverUrl)) {
            return null;
        }
        return new com.kwad.sdk.internal.api.a(C.width, C.height, C.coverUrl);
    }

    @NonNull
    public AdTemplate b() {
        return this.f31609a;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getActionDescription() {
        return com.kwad.sdk.core.response.b.a.u(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdDescription() {
        return com.kwad.sdk.core.response.b.a.m(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdSource() {
        return com.kwad.sdk.core.response.b.a.t(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppDownloadCountDes() {
        return com.kwad.sdk.core.response.b.a.r(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppIconUrl() {
        return com.kwad.sdk.core.response.b.a.n(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getAppName() {
        return com.kwad.sdk.core.response.b.a.o(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPackageName() {
        return com.kwad.sdk.core.response.b.a.q(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public long getAppPackageSize() {
        return com.kwad.sdk.core.response.b.a.Z(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPrivacyUrl() {
        return com.kwad.sdk.core.response.b.a.X(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public float getAppScore() {
        return com.kwad.sdk.core.response.b.a.s(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppVersion() {
        return com.kwad.sdk.core.response.b.a.Y(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getCorporationName() {
        return com.kwad.sdk.core.response.b.a.V(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.x(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo g2 = c.g(this.f31609a);
        int H = com.kwad.sdk.core.response.b.a.H(this.f31610b);
        if (H == 2 || H == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : g2.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new com.kwad.sdk.internal.api.a(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.w(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.H(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getPermissionInfo() {
        return com.kwad.sdk.core.response.b.a.W(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getProductName() {
        return com.kwad.sdk.core.response.b.a.p(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @NonNull
    public Bitmap getSdkLogo() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.ksad_sdk_logo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoDuration() {
        return com.kwad.sdk.core.response.b.a.b(this.f31610b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoHeight() {
        return com.kwad.sdk.core.response.b.a.C(this.f31610b).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getVideoUrl() {
        return com.kwad.sdk.core.response.b.a.a(this.f31610b);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            com.kwad.sdk.core.d.a.d("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.f31613e == null) {
            b bVar = new b(context);
            this.f31613e = bVar;
            bVar.setAdInteractionListener(this.f31616h);
            this.f31613e.setVideoPlayListener(this.f31615g);
            this.f31613e.a(this.f31609a, this.f31611c, ksAdVideoPlayConfig);
        }
        return this.f31613e;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public View getVideoView2(Context context, boolean z) {
        return getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).dataFlowAutoStart(false).build());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoWidth() {
        return com.kwad.sdk.core.response.b.a.C(this.f31610b).videoWidth;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.f31612d = adInteractionListener;
        a(viewGroup);
        a(viewGroup, list);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdVideoPlayEnd() {
        com.kwad.sdk.core.report.b.i(b());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void reportAdVideoPlayStart() {
        com.kwad.sdk.core.report.b.h(b());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f31609a;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.b.l(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.sdk.core.download.b.b bVar = this.f31611c;
        if (bVar == null || ksAppDownloadListener == null) {
            return;
        }
        bVar.a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f31614f = videoPlayListener;
    }
}
