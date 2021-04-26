package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.t.b.d.c;
import a.a.a.a.x.d;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class KSNativeAdVideoH5OpenView extends c {

    /* renamed from: a  reason: collision with root package name */
    public TextView f31525a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f31526b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f31527c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31528d;

    /* renamed from: e  reason: collision with root package name */
    public Button f31529e;

    public KSNativeAdVideoH5OpenView(Context context) {
        this(context, null);
    }

    public KSNativeAdVideoH5OpenView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdVideoH5OpenView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // a.a.a.a.t.b.d.c
    public void a(Activity activity, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        View videoView = ksNativeAd.getVideoView(activity, new KsAdVideoPlayConfig.Builder().videoSoundEnable(FunAdSdk.getFunAdConfig().isVideoSoundEnable).dataFlowAutoStart(FunAdSdk.getFunAdConfig().isVideoDataFlowAutoStart).build());
        d.b("KSNativeAd video videoView: " + videoView, new Object[0]);
        if (videoView != null && videoView.getParent() != null) {
            ((ViewGroup) videoView.getParent()).removeView(videoView);
        }
        if (videoView != null) {
            this.f31526b.removeAllViews();
            this.f31526b.addView(videoView);
        }
        this.f31527c.setImageBitmap(ksNativeAd.getSdkLogo());
        this.f31525a.setText(ksNativeAd.getAdDescription());
        this.f31528d.setText(ksNativeAd.getAdSource());
        this.f31529e.setText(ksNativeAd.getActionDescription());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f31525a = (TextView) findViewById(R.id.ad_description);
        this.f31526b = (FrameLayout) findViewById(R.id.ad_video);
        this.f31527c = (ImageView) findViewById(R.id.ad_logo);
        this.f31528d = (TextView) findViewById(R.id.ad_h5_description);
        this.f31529e = (Button) findViewById(R.id.ad_h5_open);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f31526b.getLayoutParams();
        int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i6;
        layoutParams.height = (int) (i6 / 1.78f);
        this.f31526b.setLayoutParams(layoutParams);
    }
}
