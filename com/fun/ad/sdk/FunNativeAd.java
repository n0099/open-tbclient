package com.fun.ad.sdk;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.ai;
import com.fun.ad.ap;
import com.fun.ad.bj;
import com.fun.ad.d;
import com.fun.ad.m;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.win.opensdk.PBMediaView;
import com.win.opensdk.PBNative;
import java.util.List;
/* loaded from: classes14.dex */
public class FunNativeAd {
    public String mAid;
    public KsNativeAd mKsNativeAd;
    public NativeUnifiedADData mNativeUnifiedADData;
    public PBNative mPBNative;
    public FunRippedAd mRippedAd;
    public String mSid;
    public TTFeedAd mTTFeedAd;

    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PBMediaView f7801a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInteractionListener f7802b;

        public a(PBMediaView pBMediaView, FunNativeAdInteractionListener funNativeAdInteractionListener) {
            this.f7801a = pBMediaView;
            this.f7802b = funNativeAdInteractionListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f7801a.performClick();
            FunNativeAdInteractionListener funNativeAdInteractionListener = this.f7802b;
            if (funNativeAdInteractionListener != null) {
                funNativeAdInteractionListener.onAdClick(FunNativeAd.this.mSid);
            }
            ((d.a) com.fun.ad.d.pEu).a(FunNativeAd.this.mSid, FunAdType.JY_NATIVE, FunNativeAd.this.mAid, (String) null, (String) null);
        }
    }

    /* loaded from: classes14.dex */
    public class b implements NativeADEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInteractionListener f7803a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Button f7804b;

        public b(FunNativeAdInteractionListener funNativeAdInteractionListener, Button button) {
            this.f7803a = funNativeAdInteractionListener;
            this.f7804b = button;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            m.a("GDTNativeUnifiedAd onADClicked");
            FunNativeAdInteractionListener funNativeAdInteractionListener = this.f7803a;
            if (funNativeAdInteractionListener != null) {
                funNativeAdInteractionListener.onAdClick(FunNativeAd.this.mSid);
            }
            if (FunNativeAd.this.mRippedAd != null) {
                ((d.a) com.fun.ad.d.pEu).a(FunNativeAd.this.mSid, FunAdType.GDT_NATIVE_UNIFIED, FunNativeAd.this.mAid, FunNativeAd.this.mRippedAd.appPackageName, FunNativeAd.this.mRippedAd.appLinkUrl);
                return;
            }
            ((d.a) com.fun.ad.d.pEu).a(FunNativeAd.this.mSid, FunAdType.GDT_NATIVE_UNIFIED, FunNativeAd.this.mAid, (String) null, (String) null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            m.a("GDTNativeUnifiedAd onADError");
            FunNativeAdInteractionListener funNativeAdInteractionListener = this.f7803a;
            if (funNativeAdInteractionListener != null) {
                funNativeAdInteractionListener.onAdError(FunNativeAd.this.mSid, adError.getErrorCode(), adError.getErrorMsg());
            }
            ((d.a) com.fun.ad.d.pEu).e(FunNativeAd.this.mSid, FunAdType.GDT_NATIVE_UNIFIED, FunNativeAd.this.mAid, adError.getErrorCode(), adError.getErrorMsg());
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            m.a("GDTNativeUnifiedAd onADExposed");
            FunNativeAdInteractionListener funNativeAdInteractionListener = this.f7803a;
            if (funNativeAdInteractionListener != null) {
                funNativeAdInteractionListener.onAdShow(FunNativeAd.this.mSid);
            }
            ((d.a) com.fun.ad.d.pEu).d(FunNativeAd.this.mSid, FunAdType.GDT_NATIVE_UNIFIED, FunNativeAd.this.mAid);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            m.a("GDTNativeUnifiedAd onADStatusChanged");
            if (this.f7804b == null || FunNativeAd.this.mNativeUnifiedADData == null || this.f7804b.getTag(R.id.download_button_listener) != this) {
                return;
            }
            FunNativeAd funNativeAd = FunNativeAd.this;
            funNativeAd.updateAdAction(this.f7804b, funNativeAd.mNativeUnifiedADData);
        }
    }

    /* loaded from: classes14.dex */
    public class c implements NativeADMediaListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInteractionListener f7805a;

        public c(FunNativeAdInteractionListener funNativeAdInteractionListener) {
            this.f7805a = funNativeAdInteractionListener;
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
            m.a("GDTNativeUnifiedAd video onVideoClicked");
            FunNativeAdInteractionListener funNativeAdInteractionListener = this.f7805a;
            if (funNativeAdInteractionListener != null) {
                funNativeAdInteractionListener.onAdClick(FunNativeAd.this.mSid);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
            m.a("GDTNativeUnifiedAd video onVideoCompleted");
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
            m.a("GDTNativeUnifiedAd video onVideoError");
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
            m.a("GDTNativeUnifiedAd video onVideoInit");
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i) {
            m.a("GDTNativeUnifiedAd video onVideoLoaded");
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
            m.a("GDTNativeUnifiedAd video onVideoLoading");
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
            m.a("GDTNativeUnifiedAd video onVideoPause");
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
            m.a("GDTNativeUnifiedAd video onVideoReady");
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
            m.a("GDTNativeUnifiedAd video onVideoResume");
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
            m.a("GDTNativeUnifiedAd video onVideoStart");
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
            m.a("GDTNativeUnifiedAd video onVideoStop");
        }
    }

    /* loaded from: classes14.dex */
    public class d implements TTNativeAd.AdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInteractionListener f7807a;

        public d(FunNativeAdInteractionListener funNativeAdInteractionListener) {
            this.f7807a = funNativeAdInteractionListener;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            FunNativeAdInteractionListener funNativeAdInteractionListener = this.f7807a;
            if (funNativeAdInteractionListener != null) {
                funNativeAdInteractionListener.onAdClick(FunNativeAd.this.mSid);
            }
            if (FunNativeAd.this.mRippedAd != null) {
                ((d.a) com.fun.ad.d.pEu).a(FunNativeAd.this.mSid, FunAdType.CSJ_NATIVE, FunNativeAd.this.mAid, FunNativeAd.this.mRippedAd.appPackageName, FunNativeAd.this.mRippedAd.appLinkUrl);
                return;
            }
            ((d.a) com.fun.ad.d.pEu).a(FunNativeAd.this.mSid, FunAdType.CSJ_NATIVE, FunNativeAd.this.mAid, (String) null, (String) null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            FunNativeAdInteractionListener funNativeAdInteractionListener = this.f7807a;
            if (funNativeAdInteractionListener != null) {
                funNativeAdInteractionListener.onAdClick(FunNativeAd.this.mSid);
            }
            if (FunNativeAd.this.mRippedAd != null) {
                ((d.a) com.fun.ad.d.pEu).a(FunNativeAd.this.mSid, FunAdType.CSJ_NATIVE, FunNativeAd.this.mAid, FunNativeAd.this.mRippedAd.appPackageName, FunNativeAd.this.mRippedAd.appLinkUrl);
                return;
            }
            ((d.a) com.fun.ad.d.pEu).a(FunNativeAd.this.mSid, FunAdType.CSJ_NATIVE, FunNativeAd.this.mAid, (String) null, (String) null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            FunNativeAdInteractionListener funNativeAdInteractionListener = this.f7807a;
            if (funNativeAdInteractionListener != null) {
                funNativeAdInteractionListener.onAdShow(FunNativeAd.this.mSid);
            }
            ((d.a) com.fun.ad.d.pEu).d(FunNativeAd.this.mSid, FunAdType.CSJ_NATIVE, FunNativeAd.this.mAid);
        }
    }

    /* loaded from: classes14.dex */
    public class e implements KsNativeAd.AdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunNativeAdInteractionListener f7809a;

        public e(FunNativeAdInteractionListener funNativeAdInteractionListener) {
            this.f7809a = funNativeAdInteractionListener;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            FunNativeAdInteractionListener funNativeAdInteractionListener = this.f7809a;
            if (funNativeAdInteractionListener != null) {
                funNativeAdInteractionListener.onAdClick(FunNativeAd.this.mSid);
            }
            if (FunNativeAd.this.mRippedAd != null) {
                ((d.a) com.fun.ad.d.pEu).a(FunNativeAd.this.mSid, FunAdType.KS_NATIVE, FunNativeAd.this.mAid, FunNativeAd.this.mRippedAd.appPackageName, FunNativeAd.this.mRippedAd.appLinkUrl);
                return;
            }
            ((d.a) com.fun.ad.d.pEu).a(FunNativeAd.this.mSid, FunAdType.KS_NATIVE, FunNativeAd.this.mAid, (String) null, (String) null);
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            FunNativeAdInteractionListener funNativeAdInteractionListener = this.f7809a;
            if (funNativeAdInteractionListener != null) {
                funNativeAdInteractionListener.onAdShow(FunNativeAd.this.mSid);
            }
            ((d.a) com.fun.ad.d.pEu).d(FunNativeAd.this.mSid, FunAdType.KS_NATIVE, FunNativeAd.this.mAid);
        }
    }

    public FunNativeAd() {
    }

    public FunNativeAd(String str, String str2, TTFeedAd tTFeedAd, FunRippedAd funRippedAd) {
        this.mSid = str;
        this.mAid = str2;
        this.mTTFeedAd = tTFeedAd;
        this.mRippedAd = funRippedAd;
    }

    public FunNativeAd(String str, String str2, KsNativeAd ksNativeAd, FunRippedAd funRippedAd) {
        this.mSid = str;
        this.mAid = str2;
        this.mKsNativeAd = ksNativeAd;
        this.mRippedAd = funRippedAd;
    }

    public FunNativeAd(String str, String str2, NativeUnifiedADData nativeUnifiedADData, FunRippedAd funRippedAd) {
        this.mSid = str;
        this.mAid = str2;
        this.mNativeUnifiedADData = nativeUnifiedADData;
        this.mRippedAd = funRippedAd;
    }

    public FunNativeAd(String str, String str2, PBNative pBNative, FunRippedAd funRippedAd) {
        this.mSid = str;
        this.mAid = str2;
        this.mPBNative = pBNative;
        this.mRippedAd = funRippedAd;
    }

    public void destroy() {
        if (this.mTTFeedAd != null) {
            this.mTTFeedAd = null;
        } else if (this.mKsNativeAd != null) {
            this.mKsNativeAd = null;
        } else {
            NativeUnifiedADData nativeUnifiedADData = this.mNativeUnifiedADData;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.destroy();
                this.mNativeUnifiedADData = null;
                return;
            }
            PBNative pBNative = this.mPBNative;
            if (pBNative != null) {
                pBNative.destroy();
                this.mPBNative = null;
            }
        }
    }

    public String getAdType() {
        if (this.mNativeUnifiedADData != null) {
            return FunAdType.GDT_NATIVE_UNIFIED;
        }
        if (this.mKsNativeAd != null) {
            return FunAdType.KS_NATIVE;
        }
        if (this.mTTFeedAd != null) {
            return FunAdType.CSJ_NATIVE;
        }
        if (this.mPBNative != null) {
            return FunAdType.JY_NATIVE;
        }
        return null;
    }

    public FunRippedAd getDeepLinkAd() {
        return this.mRippedAd;
    }

    public boolean isDownloadAd() {
        TTFeedAd tTFeedAd = this.mTTFeedAd;
        if (tTFeedAd != null) {
            return tTFeedAd.getAppSize() == 0;
        }
        KsNativeAd ksNativeAd = this.mKsNativeAd;
        if (ksNativeAd != null) {
            return !TextUtils.isEmpty(ksNativeAd.getAppIconUrl());
        }
        return false;
    }

    public void show(@NonNull ViewGroup viewGroup, @NonNull List<View> list, List<View> list2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, FrameLayout frameLayout, Button button, FunNativeAdInteractionListener funNativeAdInteractionListener, boolean z) {
        if (this.mTTFeedAd != null) {
            showCsjNative(viewGroup, list, list2, imageView, imageView2, textView, textView2, frameLayout, button, funNativeAdInteractionListener, z);
        } else if (this.mKsNativeAd != null) {
            showKsNative(viewGroup, list, list2, imageView, imageView2, textView, textView2, frameLayout, button, funNativeAdInteractionListener, z);
        } else if (this.mNativeUnifiedADData != null) {
            showGdtNativeUnified((NativeAdContainer) viewGroup, list, list2, imageView, imageView2, textView, textView2, (MediaView) frameLayout, button, funNativeAdInteractionListener, z);
        } else if (this.mPBNative != null) {
            showJyNative(viewGroup, list, list2, imageView, imageView2, textView, textView2, frameLayout, button, funNativeAdInteractionListener, z);
        }
    }

    public void showCsjNative(@NonNull ViewGroup viewGroup, @NonNull List<View> list, List<View> list2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, FrameLayout frameLayout, Button button, FunNativeAdInteractionListener funNativeAdInteractionListener, boolean z) {
        TTImage videoCoverImage;
        TTImage tTImage;
        TTImage icon;
        this.mTTFeedAd.registerViewForInteraction(viewGroup, list, list2, new d(funNativeAdInteractionListener));
        if (imageView != null && (icon = this.mTTFeedAd.getIcon()) != null && icon.isValid()) {
            ap.a.pFl.a(imageView, icon.getImageUrl(), imageView);
        }
        if (imageView2 != null) {
            imageView2.setImageResource(z ? R.drawable.csj_ad_logo_transparent : R.drawable.csj_ad_logo);
        }
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(this.mTTFeedAd.getSource()) ? this.mTTFeedAd.getTitle() : this.mTTFeedAd.getSource());
        }
        if (textView2 != null) {
            textView2.setText(this.mTTFeedAd.getDescription());
        }
        if (button != null) {
            switch (this.mTTFeedAd.getInteractionType()) {
                case 2:
                case 3:
                    button.setVisibility(0);
                    button.setText(R.string.ad_interaction_type_browser);
                    break;
                case 4:
                    button.setVisibility(0);
                    button.setText(R.string.ad_interaction_type_download);
                    break;
                case 5:
                    button.setVisibility(0);
                    button.setText(R.string.ad_interaction_type_dial);
                    break;
                default:
                    button.setVisibility(8);
                    break;
            }
            bj bjVar = new bj(button);
            button.setTag(R.id.download_button_listener, bjVar);
            this.mTTFeedAd.setDownloadListener(bjVar);
        }
        int imageMode = this.mTTFeedAd.getImageMode();
        if (imageMode != 15) {
            if (imageMode != 16) {
                switch (imageMode) {
                    case 2:
                    case 3:
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                        return;
                }
            }
            List<TTImage> imageList = this.mTTFeedAd.getImageList();
            if (imageList == null || imageList.isEmpty() || (tTImage = imageList.get(0)) == null || !tTImage.isValid()) {
                return;
            }
            if (frameLayout != null) {
                ImageView imageView3 = new ImageView(frameLayout.getContext());
                imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                frameLayout.addView(imageView3, new FrameLayout.LayoutParams(-1, -1));
                ap.a.pFl.a(frameLayout, tTImage.getImageUrl(), imageView3);
            }
            if (imageView != null) {
                TTImage icon2 = this.mTTFeedAd.getIcon();
                if (icon2 == null || !icon2.isValid()) {
                    ap.a.pFl.a(imageView, tTImage.getImageUrl(), imageView);
                    return;
                }
                return;
            }
            return;
        }
        if (frameLayout != null) {
            View adView = this.mTTFeedAd.getAdView();
            if (adView != null && adView.getParent() != null) {
                ((ViewGroup) adView.getParent()).removeView(adView);
            }
            if (adView != null) {
                frameLayout.addView(adView);
            }
        }
        if (imageView != null) {
            TTImage icon3 = this.mTTFeedAd.getIcon();
            if ((icon3 == null || !icon3.isValid()) && (videoCoverImage = this.mTTFeedAd.getVideoCoverImage()) != null && videoCoverImage.isValid()) {
                ap.a.pFl.a(imageView, videoCoverImage.getImageUrl(), imageView);
            }
        }
    }

    public void showGdtNativeUnified(@NonNull NativeAdContainer nativeAdContainer, @NonNull List<View> list, List<View> list2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, MediaView mediaView, Button button, FunNativeAdInteractionListener funNativeAdInteractionListener, boolean z) {
        this.mNativeUnifiedADData.bindAdToView(nativeAdContainer.getContext(), nativeAdContainer, null, list);
        b bVar = new b(funNativeAdInteractionListener, button);
        this.mNativeUnifiedADData.setNativeAdEventListener(bVar);
        if (imageView != null) {
            String iconUrl = this.mNativeUnifiedADData.getIconUrl();
            if (!TextUtils.isEmpty(iconUrl)) {
                ap.a.pFl.a(imageView, iconUrl, imageView);
            }
        }
        if (imageView2 != null) {
            imageView2.setImageResource(z ? R.drawable.gdt_ad_logo_transparent : R.drawable.gdt_ad_logo);
        }
        if (textView != null) {
            textView.setText(this.mNativeUnifiedADData.getTitle());
        }
        if (textView2 != null) {
            textView2.setText(this.mNativeUnifiedADData.getDesc());
        }
        if (button != null) {
            updateAdAction(button, this.mNativeUnifiedADData);
            button.setTag(R.id.download_button_listener, bVar);
        }
        switch (this.mNativeUnifiedADData.getAdPatternType()) {
            case 1:
            case 3:
            case 4:
                String imgUrl = this.mNativeUnifiedADData.getAdPatternType() == 3 ? this.mNativeUnifiedADData.getImgList().get(0) : this.mNativeUnifiedADData.getImgUrl();
                if (TextUtils.isEmpty(imgUrl)) {
                    return;
                }
                if (mediaView != null) {
                    ImageView imageView3 = new ImageView(mediaView.getContext());
                    imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    mediaView.addView(imageView3, new FrameLayout.LayoutParams(-1, -1));
                    ap.a.pFl.a(mediaView, imgUrl, imageView3);
                }
                if (imageView == null || !TextUtils.isEmpty(this.mNativeUnifiedADData.getIconUrl())) {
                    return;
                }
                ap.a.pFl.a(imageView, imgUrl, imageView);
                return;
            case 2:
                this.mNativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayPolicy(com.fun.ad.d.c ? 1 : 0).setAutoPlayMuted(!com.fun.ad.d.f7776b).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build(), new c(funNativeAdInteractionListener));
                if (imageView == null || !TextUtils.isEmpty(this.mNativeUnifiedADData.getIconUrl())) {
                    return;
                }
                String imgUrl2 = this.mNativeUnifiedADData.getImgUrl();
                if (!TextUtils.isEmpty(imgUrl2)) {
                    ap.a.pFl.a(imageView, imgUrl2, imageView);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void showJyNative(@NonNull ViewGroup viewGroup, @NonNull List<View> list, List<View> list2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, FrameLayout frameLayout, Button button, FunNativeAdInteractionListener funNativeAdInteractionListener, boolean z) {
        if (imageView != null) {
            String icon = this.mPBNative.getIcon();
            if (!TextUtils.isEmpty(icon)) {
                ap.a.pFl.a(imageView, icon, imageView);
            }
        }
        if (imageView2 != null) {
            imageView2.setImageResource(z ? R.drawable.ad_logo_transparent : R.drawable.ad_logo);
        }
        if (textView != null) {
            textView.setText(this.mPBNative.getHeadline());
        }
        if (textView2 != null) {
            textView2.setText(this.mPBNative.getBody());
        }
        if (frameLayout != null) {
            PBMediaView pBMediaView = new PBMediaView(frameLayout.getContext());
            frameLayout.addView(pBMediaView, new FrameLayout.LayoutParams(-1, -1));
            this.mPBNative.registerViewForInteraction(viewGroup, pBMediaView);
            frameLayout.setOnClickListener(new a(pBMediaView, funNativeAdInteractionListener));
        }
        if (button != null) {
            button.setText(this.mPBNative.getCallToAction());
        }
        if (funNativeAdInteractionListener != null) {
            funNativeAdInteractionListener.onAdShow(this.mSid);
        }
        ((d.a) com.fun.ad.d.pEu).d(this.mSid, FunAdType.JY_NATIVE, this.mAid);
    }

    public void showKsNative(ViewGroup viewGroup, List<View> list, List<View> list2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, FrameLayout frameLayout, Button button, FunNativeAdInteractionListener funNativeAdInteractionListener, boolean z) {
        KsImage videoCoverImage;
        List<KsImage> imageList;
        KsImage ksImage;
        this.mKsNativeAd.registerViewForInteraction(viewGroup, list, new e(funNativeAdInteractionListener));
        if (imageView != null && !TextUtils.isEmpty(this.mKsNativeAd.getAppIconUrl())) {
            ap.a.pFl.a(imageView, this.mKsNativeAd.getAppIconUrl(), imageView);
        }
        if (imageView2 != null) {
            imageView2.setImageResource(z ? R.drawable.ks_ad_logo_transparent : R.drawable.ks_ad_logo);
        }
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(this.mKsNativeAd.getAppIconUrl()) ? this.mKsNativeAd.getAdSource() : this.mKsNativeAd.getAppName());
        }
        if (textView2 != null) {
            textView2.setText(this.mKsNativeAd.getAdDescription());
        }
        if (button != null) {
            button.setText(this.mKsNativeAd.getActionDescription());
            ai aiVar = new ai(this.mKsNativeAd, button, this.mSid, FunAdType.KS_NATIVE, this.mAid);
            button.setTag(R.id.download_button_listener, aiVar);
            this.mKsNativeAd.setDownloadListener(aiVar);
        }
        int materialType = this.mKsNativeAd.getMaterialType();
        if (materialType == 1) {
            if (frameLayout != null) {
                View videoView = this.mKsNativeAd.getVideoView(frameLayout.getContext(), new KsAdVideoPlayConfig.Builder().videoSoundEnable(com.fun.ad.d.f7776b).dataFlowAutoStart(com.fun.ad.d.c).build());
                if (videoView != null && videoView.getParent() != null) {
                    ((ViewGroup) videoView.getParent()).removeView(videoView);
                }
                if (videoView != null) {
                    frameLayout.addView(videoView);
                }
            }
            if (imageView == null || !TextUtils.isEmpty(this.mKsNativeAd.getAppIconUrl()) || (videoCoverImage = this.mKsNativeAd.getVideoCoverImage()) == null || !videoCoverImage.isValid()) {
                return;
            }
            ap.a.pFl.a(imageView, videoCoverImage.getImageUrl(), imageView);
        } else if ((materialType != 2 && materialType != 3) || (imageList = this.mKsNativeAd.getImageList()) == null || imageList.isEmpty() || (ksImage = imageList.get(0)) == null || !ksImage.isValid()) {
        } else {
            if (frameLayout != null) {
                ImageView imageView3 = new ImageView(frameLayout.getContext());
                imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                frameLayout.addView(imageView3, new FrameLayout.LayoutParams(-1, -1));
                ap.a.pFl.a(frameLayout, ksImage.getImageUrl(), imageView3);
            }
            if (imageView != null && TextUtils.isEmpty(this.mKsNativeAd.getAppIconUrl())) {
                ap.a.pFl.a(imageView, ksImage.getImageUrl(), imageView);
            }
        }
    }

    public void updateAdAction(Button button, NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData.isAppAd()) {
            int appStatus = nativeUnifiedADData.getAppStatus();
            if (appStatus == 0) {
                button.setText(R.string.ad_interaction_type_download);
                return;
            } else if (appStatus == 1) {
                button.setText(R.string.ad_interaction_type_start);
                return;
            } else if (appStatus == 2) {
                button.setText(R.string.ad_interaction_type_update);
                return;
            } else if (appStatus == 4) {
                button.setText(String.format("%s/100", Integer.valueOf(nativeUnifiedADData.getProgress())));
                return;
            } else if (appStatus == 8) {
                button.setText(R.string.ad_interaction_type_install);
                return;
            } else if (appStatus == 16) {
                button.setText(R.string.ad_interaction_type_redownload);
                return;
            }
        }
        button.setText(R.string.ad_interaction_type_view);
    }
}
