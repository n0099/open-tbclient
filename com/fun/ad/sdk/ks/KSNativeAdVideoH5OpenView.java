package com.fun.ad.sdk.ks;

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
import com.fun.ad.ai;
import com.fun.ad.d;
import com.fun.ad.m;
import com.fun.ad.o1;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class KSNativeAdVideoH5OpenView extends o1 {

    /* renamed from: a  reason: collision with root package name */
    public TextView f8135a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f8136b;
    public ImageView c;
    public TextView d;
    public Button e;

    public KSNativeAdVideoH5OpenView(Context context) {
        this(context, null);
    }

    public KSNativeAdVideoH5OpenView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdVideoH5OpenView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.fun.ad.o1
    public void a(Activity activity, String str, String str2, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        View videoView = ksNativeAd.getVideoView(activity, new KsAdVideoPlayConfig.Builder().videoSoundEnable(d.f8076b).dataFlowAutoStart(d.c).build());
        m.a("KSNativeAd video videoView: " + videoView);
        if (videoView != null && videoView.getParent() != null) {
            ((ViewGroup) videoView.getParent()).removeView(videoView);
        }
        if (videoView != null) {
            this.f8136b.removeAllViews();
            this.f8136b.addView(videoView);
        }
        this.c.setImageBitmap(ksNativeAd.getSdkLogo());
        this.f8135a.setText(ksNativeAd.getAdDescription());
        this.d.setText(ksNativeAd.getAdSource());
        this.e.setText(ksNativeAd.getActionDescription());
        ksNativeAd.setDownloadListener(new ai(ksNativeAd, this.e, str, FunAdType.KS_NATIVE, str2));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f8135a = (TextView) findViewById(R.id.ad_description);
        this.f8136b = (FrameLayout) findViewById(R.id.ad_video);
        this.c = (ImageView) findViewById(R.id.ad_logo);
        this.d = (TextView) findViewById(R.id.ad_h5_description);
        this.e = (Button) findViewById(R.id.ad_h5_open);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f8136b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / 1.78f);
        this.f8136b.setLayoutParams(layoutParams);
    }
}
