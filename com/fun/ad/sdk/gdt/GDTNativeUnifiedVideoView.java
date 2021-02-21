package com.fun.ad.sdk.gdt;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.fun.ad.aa;
import com.fun.ad.ah;
import com.fun.ad.ap;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.m;
import com.fun.ad.sdk.R;
import com.fun.ad.v0;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
/* loaded from: classes6.dex */
public class GDTNativeUnifiedVideoView extends v0 {
    public MediaView d;
    public ImageView e;
    public float f;

    /* loaded from: classes6.dex */
    public class a implements NativeADMediaListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ah f7823a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ au.a f7824b;

        public a(GDTNativeUnifiedVideoView gDTNativeUnifiedVideoView, ah ahVar, au.a aVar) {
            this.f7823a = ahVar;
            this.f7824b = aVar;
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
            m.a("GDTNativeUnifiedAd video onVideoClicked");
            ah ahVar = this.f7823a;
            if (ahVar != null) {
                ((aa) ahVar).c(this.f7824b.f7762a);
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

    public GDTNativeUnifiedVideoView(Context context) {
        this(context, null);
    }

    public GDTNativeUnifiedVideoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GDTNativeUnifiedVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 1.78f;
    }

    @Override // com.fun.ad.v0
    public void a(Activity activity, au.a aVar, NativeUnifiedADData nativeUnifiedADData, ah ahVar) {
        super.a(activity, aVar, nativeUnifiedADData, ahVar);
        ap.a.pPQ.a(getContext(), nativeUnifiedADData.getIconUrl(), this.e);
        m.a("GDTNativeUnifiedAd image width: " + nativeUnifiedADData.getPictureWidth() + ", height: " + nativeUnifiedADData.getPictureHeight());
        this.f = (nativeUnifiedADData.getPictureWidth() * 1.0f) / (nativeUnifiedADData.getPictureHeight() * 1.0f);
        nativeUnifiedADData.bindMediaView(this.d, new VideoOption.Builder().setAutoPlayPolicy(d.c ? 1 : 0).setAutoPlayMuted(!d.f7778b).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build(), new a(this, ahVar, aVar));
    }

    @Override // com.fun.ad.v0, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.d = (MediaView) findViewById(R.id.ad_video);
        this.e = (ImageView) findViewById(R.id.ad_icon);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.f);
        this.d.setLayoutParams(layoutParams);
    }
}
