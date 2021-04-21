package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.r.b.d.c;
import a.a.a.a.v.d;
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
    public TextView f30591a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f30592b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f30593c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f30594d;

    /* renamed from: e  reason: collision with root package name */
    public Button f30595e;

    public KSNativeAdVideoH5OpenView(Context context) {
        this(context, null);
    }

    public KSNativeAdVideoH5OpenView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdVideoH5OpenView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // a.a.a.a.r.b.d.c
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
            this.f30592b.removeAllViews();
            this.f30592b.addView(videoView);
        }
        this.f30593c.setImageBitmap(ksNativeAd.getSdkLogo());
        this.f30591a.setText(ksNativeAd.getAdDescription());
        this.f30594d.setText(ksNativeAd.getAdSource());
        this.f30595e.setText(ksNativeAd.getActionDescription());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30591a = (TextView) findViewById(R.id.ad_description);
        this.f30592b = (FrameLayout) findViewById(R.id.ad_video);
        this.f30593c = (ImageView) findViewById(R.id.ad_logo);
        this.f30594d = (TextView) findViewById(R.id.ad_h5_description);
        this.f30595e = (Button) findViewById(R.id.ad_h5_open);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30592b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / 1.78f);
        this.f30592b.setLayoutParams(layoutParams);
    }
}
