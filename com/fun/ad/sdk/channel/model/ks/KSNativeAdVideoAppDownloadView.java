package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.t.b.d.b;
import a.a.a.a.t.b.d.c;
import a.a.a.a.x.d;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class KSNativeAdVideoAppDownloadView extends c {

    /* renamed from: a  reason: collision with root package name */
    public TextView f31519a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f31520b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f31521c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f31522d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31523e;

    /* renamed from: f  reason: collision with root package name */
    public Button f31524f;

    public KSNativeAdVideoAppDownloadView(Context context) {
        this(context, null);
    }

    public KSNativeAdVideoAppDownloadView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdVideoAppDownloadView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // a.a.a.a.t.b.d.c
    public void a(Activity activity, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        arrayList.add(this.f31524f);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        View videoView = ksNativeAd.getVideoView(activity, new KsAdVideoPlayConfig.Builder().videoSoundEnable(FunAdSdk.getFunAdConfig().isVideoSoundEnable).dataFlowAutoStart(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart).build());
        d.b("KSNativeAd video videoView: " + videoView, new Object[0]);
        if (videoView != null && videoView.getParent() != null) {
            ((ViewGroup) videoView.getParent()).removeView(videoView);
        }
        if (videoView != null) {
            this.f31520b.removeAllViews();
            this.f31520b.addView(videoView);
        }
        this.f31521c.setImageBitmap(ksNativeAd.getSdkLogo());
        this.f31519a.setText(ksNativeAd.getAdDescription());
        if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
            this.f31522d.setVisibility(8);
        } else {
            this.f31522d.setVisibility(0);
            Context context = getContext();
            String appIconUrl = ksNativeAd.getAppIconUrl();
            ImageView imageView = this.f31522d;
            if (context == null) {
                d.b("GlideHelper: context is null when load: " + appIconUrl, new Object[0]);
            } else if (context instanceof Activity) {
                Activity activity2 = (Activity) context;
                if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                    d.b("GlideHelper: activity is destroyed when load: " + appIconUrl, new Object[0]);
                } else {
                    Glide.with(activity2).load(appIconUrl).into(imageView);
                }
            } else {
                Glide.with(context).load(appIconUrl).into(imageView);
            }
        }
        this.f31523e.setText(ksNativeAd.getAppName());
        this.f31524f.setText(ksNativeAd.getActionDescription());
        ksNativeAd.setDownloadListener(new b(ksNativeAd.getActionDescription(), this.f31524f));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f31519a = (TextView) findViewById(R.id.ad_description);
        this.f31520b = (FrameLayout) findViewById(R.id.ad_video);
        this.f31521c = (ImageView) findViewById(R.id.ad_logo);
        this.f31522d = (ImageView) findViewById(R.id.ad_app_icon);
        this.f31523e = (TextView) findViewById(R.id.ad_app_title);
        this.f31524f = (Button) findViewById(R.id.ad_app_download);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f31520b.getLayoutParams();
        int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i6;
        layoutParams.height = (int) (i6 / 1.78f);
        this.f31520b.setLayoutParams(layoutParams);
    }
}
