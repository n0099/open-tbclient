package com.kwad.sdk.a;

import android.content.Context;
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
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends AbstractKsNativeAd {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private AdTemplate f8424a;

    /* renamed from: b  reason: collision with root package name */
    private AdInfo f8425b;
    @Nullable
    private com.kwad.sdk.core.download.b.b c;
    @Nullable
    private KsNativeAd.AdInteractionListener d;
    private b e;
    @Nullable
    private KsNativeAd.VideoPlayListener f;
    private KsNativeAd.VideoPlayListener g = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.sdk.a.a.5
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
    private KsNativeAd.AdInteractionListener h = new KsNativeAd.AdInteractionListener() { // from class: com.kwad.sdk.a.a.6
        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            if (a.this.d != null) {
                a.this.d.onAdClicked(view, a.this);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            if (a.this.d != null) {
                a.this.d.onAdShow(a.this);
            }
        }
    };

    public a(@NonNull AdTemplate adTemplate) {
        this.f8424a = adTemplate;
        this.f8425b = c.j(this.f8424a);
        if (com.kwad.sdk.core.response.b.a.y(this.f8425b)) {
            this.c = new com.kwad.sdk.core.download.b.b(this.f8424a);
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.c(this.f8425b), this.f8424a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final s.a aVar) {
        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f8424a, new a.InterfaceC1064a() { // from class: com.kwad.sdk.a.a.3
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1064a
            public void a() {
                com.kwad.sdk.core.report.b.a(a.this.f8424a, aVar);
                if (a.this.d != null) {
                    a.this.d.onAdClicked(view, a.this);
                }
            }
        }, this.c);
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
        if (b2 == null) {
            b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b2);
        }
        b2.setViewCallback(new a.InterfaceC1075a() { // from class: com.kwad.sdk.a.a.4
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC1075a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC1075a
            public void a(View view) {
                if (!a.this.f8424a.mPvReported && a.this.d != null) {
                    a.this.d.onAdShow(a.this);
                }
                com.kwad.sdk.core.report.b.a(a.this.f8424a, (JSONObject) null);
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC1075a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC1075a
            public void b() {
            }
        });
        b2.setNeedCheckingShow(true);
    }

    private void a(@NonNull final ViewGroup viewGroup, @NonNull List<View> list) {
        for (View view : list) {
            final s.a aVar = new s.a();
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.sdk.a.a.1
                private int[] d = new int[2];

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            aVar.a(viewGroup.getWidth(), viewGroup.getHeight());
                            viewGroup.getLocationOnScreen(this.d);
                            aVar.a(Math.abs(motionEvent.getRawX() - this.d[0]), Math.abs(motionEvent.getRawY() - this.d[1]));
                            break;
                        case 1:
                            aVar.b(Math.abs(motionEvent.getRawX() - this.d[0]), Math.abs(motionEvent.getRawY() - this.d[1]));
                            break;
                    }
                    return false;
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.a(view2, aVar);
                }
            });
        }
    }

    private com.kwad.sdk.core.page.widget.a b(ViewGroup viewGroup) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return null;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof com.kwad.sdk.core.page.widget.a) {
                return (com.kwad.sdk.core.page.widget.a) childAt;
            }
            i = i2 + 1;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    /* renamed from: a */
    public com.kwad.sdk.internal.api.a getVideoCoverImage() {
        AdInfo.AdMaterialInfo.MaterialFeature E = com.kwad.sdk.core.response.b.a.E(this.f8425b);
        if (TextUtils.isEmpty(E.coverUrl)) {
            return null;
        }
        return new com.kwad.sdk.internal.api.a(E.width, E.height, E.coverUrl);
    }

    @NonNull
    public AdTemplate b() {
        return this.f8424a;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getActionDescription() {
        return com.kwad.sdk.core.response.b.a.w(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdDescription() {
        return com.kwad.sdk.core.response.b.a.n(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAdSource() {
        return com.kwad.sdk.core.response.b.a.v(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppDownloadCountDes() {
        return com.kwad.sdk.core.response.b.a.t(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppIconUrl() {
        return com.kwad.sdk.core.response.b.a.o(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getAppName() {
        return com.kwad.sdk.core.response.b.a.q(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPackageName() {
        return com.kwad.sdk.core.response.b.a.s(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public long getAppPackageSize() {
        return com.kwad.sdk.core.response.b.a.ag(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppPrivacyUrl() {
        return com.kwad.sdk.core.response.b.a.ae(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public float getAppScore() {
        return com.kwad.sdk.core.response.b.a.u(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getAppVersion() {
        return com.kwad.sdk.core.response.b.a.af(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getCorporationName() {
        return com.kwad.sdk.core.response.b.a.ac(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo j = c.j(this.f8424a);
        int L = com.kwad.sdk.core.response.b.a.L(this.f8425b);
        if (L == 2 || L == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : j.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new com.kwad.sdk.internal.api.a(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.z(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.L(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public String getPermissionInfo() {
        return com.kwad.sdk.core.response.b.a.ad(this.f8425b);
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
        return com.kwad.sdk.core.response.b.a.b(this.f8425b);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoHeight() {
        return com.kwad.sdk.core.response.b.a.E(this.f8425b).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public String getVideoUrl() {
        return com.kwad.sdk.core.response.b.a.a(this.f8425b);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            com.kwad.sdk.core.d.a.c("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.e == null) {
            this.e = new b(context);
            this.e.setAdInteractionListener(this.h);
            this.e.setVideoPlayListener(this.g);
            this.e.a(this.f8424a, this.c, ksAdVideoPlayConfig);
        }
        return this.e;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public View getVideoView2(Context context, boolean z) {
        return getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).dataFlowAutoStart(false).build());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public int getVideoWidth() {
        return com.kwad.sdk.core.response.b.a.E(this.f8425b).videoWidth;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.d = adInteractionListener;
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
    public void setBidEcpm(int i) {
        this.f8424a.mBidEcpm = i;
        com.kwad.sdk.core.report.b.m(this.f8424a);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        if (this.c == null || ksAppDownloadListener == null) {
            return;
        }
        this.c.a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.f = videoPlayListener;
    }
}
