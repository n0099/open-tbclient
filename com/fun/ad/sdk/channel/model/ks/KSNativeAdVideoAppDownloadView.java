package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.r.b.d.b;
import a.a.a.a.r.b.d.c;
import a.a.a.a.v.d;
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
    public TextView f30490a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f30491b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f30492c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f30493d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f30494e;

    /* renamed from: f  reason: collision with root package name */
    public Button f30495f;

    public KSNativeAdVideoAppDownloadView(Context context) {
        this(context, null);
    }

    public KSNativeAdVideoAppDownloadView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdVideoAppDownloadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // a.a.a.a.r.b.d.c
    public void a(Activity activity, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        arrayList.add(this.f30495f);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        View videoView = ksNativeAd.getVideoView(activity, new KsAdVideoPlayConfig.Builder().videoSoundEnable(FunAdSdk.getFunAdConfig().isVideoSoundEnable).dataFlowAutoStart(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart).build());
        d.b("KSNativeAd video videoView: " + videoView, new Object[0]);
        if (videoView != null && videoView.getParent() != null) {
            ((ViewGroup) videoView.getParent()).removeView(videoView);
        }
        if (videoView != null) {
            this.f30491b.removeAllViews();
            this.f30491b.addView(videoView);
        }
        this.f30492c.setImageBitmap(ksNativeAd.getSdkLogo());
        this.f30490a.setText(ksNativeAd.getAdDescription());
        if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
            this.f30493d.setVisibility(8);
        } else {
            this.f30493d.setVisibility(0);
            Context context = getContext();
            String appIconUrl = ksNativeAd.getAppIconUrl();
            ImageView imageView = this.f30493d;
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
        this.f30494e.setText(ksNativeAd.getAppName());
        this.f30495f.setText(ksNativeAd.getActionDescription());
        ksNativeAd.setDownloadListener(new b(ksNativeAd.getActionDescription(), this.f30495f));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30490a = (TextView) findViewById(R.id.ad_description);
        this.f30491b = (FrameLayout) findViewById(R.id.ad_video);
        this.f30492c = (ImageView) findViewById(R.id.ad_logo);
        this.f30493d = (ImageView) findViewById(R.id.ad_app_icon);
        this.f30494e = (TextView) findViewById(R.id.ad_app_title);
        this.f30495f = (Button) findViewById(R.id.ad_app_download);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30491b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / 1.78f);
        this.f30491b.setLayoutParams(layoutParams);
    }
}
