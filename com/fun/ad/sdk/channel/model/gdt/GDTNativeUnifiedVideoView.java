package com.fun.ad.sdk.channel.model.gdt;

import a.a.a.a.t.b.b.b;
import a.a.a.a.x.d;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.R;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class GDTNativeUnifiedVideoView extends b {

    /* renamed from: d  reason: collision with root package name */
    public MediaView f30652d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f30653e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f30654f;

    /* renamed from: g  reason: collision with root package name */
    public float f30655g;

    /* loaded from: classes6.dex */
    public class a implements NativeADMediaListener {
        public a() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
            d.b("GDTNativeUnifiedAd video onVideoClicked", new Object[0]);
            GDTNativeUnifiedVideoView gDTNativeUnifiedVideoView = GDTNativeUnifiedVideoView.this;
            View.OnClickListener onClickListener = gDTNativeUnifiedVideoView.f30654f;
            if (onClickListener != null) {
                onClickListener.onClick(gDTNativeUnifiedVideoView.f30652d);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
            d.b("GDTNativeUnifiedAd video onVideoCompleted", new Object[0]);
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
            d.b("GDTNativeUnifiedAd video onVideoError", new Object[0]);
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
            d.b("GDTNativeUnifiedAd video onVideoInit", new Object[0]);
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i2) {
            d.b("GDTNativeUnifiedAd video onVideoLoaded", new Object[0]);
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
            d.b("GDTNativeUnifiedAd video onVideoLoading", new Object[0]);
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
            d.b("GDTNativeUnifiedAd video onVideoPause", new Object[0]);
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
            d.b("GDTNativeUnifiedAd video onVideoReady", new Object[0]);
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
            d.b("GDTNativeUnifiedAd video onVideoResume", new Object[0]);
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
            d.b("GDTNativeUnifiedAd video onVideoStart", new Object[0]);
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
            d.b("GDTNativeUnifiedAd video onVideoStop", new Object[0]);
        }
    }

    public GDTNativeUnifiedVideoView(Context context) {
        this(context, null);
    }

    public GDTNativeUnifiedVideoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GDTNativeUnifiedVideoView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30655g = 1.78f;
    }

    @Override // a.a.a.a.t.b.b.b
    public List<View> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f1296c);
        arrayList.add(((b) this).f1295b);
        arrayList.add(((b) this).f1294a);
        arrayList.add(this.f30653e);
        return arrayList;
    }

    @Override // a.a.a.a.t.b.b.b
    public void a(Activity activity, NativeUnifiedADData nativeUnifiedADData) {
        super.a(activity, nativeUnifiedADData);
        Context context = getContext();
        String iconUrl = nativeUnifiedADData.getIconUrl();
        ImageView imageView = this.f30653e;
        if (context == null) {
            d.b("GlideHelper: context is null when load: " + iconUrl, new Object[0]);
        } else if (context instanceof Activity) {
            Activity activity2 = (Activity) context;
            if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                d.b("GlideHelper: activity is destroyed when load: " + iconUrl, new Object[0]);
            } else {
                Glide.with(activity2).load(iconUrl).into(imageView);
            }
        } else {
            Glide.with(context).load(iconUrl).into(imageView);
        }
        d.b("GDTNativeUnifiedAd image width: " + nativeUnifiedADData.getPictureWidth() + ", height: " + nativeUnifiedADData.getPictureHeight(), new Object[0]);
        this.f30655g = (((float) nativeUnifiedADData.getPictureWidth()) * 1.0f) / (((float) nativeUnifiedADData.getPictureHeight()) * 1.0f);
        nativeUnifiedADData.bindMediaView(this.f30652d, new VideoOption.Builder().setAutoPlayPolicy(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart ? 1 : 0).setAutoPlayMuted(FunAdSdk.getFunAdConfig().isVideoSoundEnable ^ true).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build(), new a());
    }

    @Override // a.a.a.a.t.b.b.b, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30652d = (MediaView) findViewById(R.id.ad_video);
        this.f30653e = (ImageView) findViewById(R.id.ad_icon);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30652d.getLayoutParams();
        int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i6;
        layoutParams.height = (int) (i6 / this.f30655g);
        this.f30652d.setLayoutParams(layoutParams);
    }

    public void setVideoOnClickListener(View.OnClickListener onClickListener) {
        this.f30654f = onClickListener;
    }
}
