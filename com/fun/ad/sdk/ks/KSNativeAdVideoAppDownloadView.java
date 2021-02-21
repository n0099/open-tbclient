package com.fun.ad.sdk.ks;

import android.app.Activity;
import android.content.Context;
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
import com.fun.ad.ai;
import com.fun.ad.ap;
import com.fun.ad.d;
import com.fun.ad.m;
import com.fun.ad.o1;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class KSNativeAdVideoAppDownloadView extends o1 {

    /* renamed from: a  reason: collision with root package name */
    public TextView f7835a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f7836b;
    public ImageView c;
    public TextView d;
    public Button e;

    public KSNativeAdVideoAppDownloadView(Context context) {
        this(context, null);
    }

    public KSNativeAdVideoAppDownloadView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdVideoAppDownloadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.fun.ad.o1
    public void a(Activity activity, String str, String str2, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        arrayList.add(this.e);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        View videoView = ksNativeAd.getVideoView(activity, new KsAdVideoPlayConfig.Builder().videoSoundEnable(d.f7778b).dataFlowAutoStart(d.c).build());
        m.a("KSNativeAd video videoView: " + videoView);
        if (videoView != null && videoView.getParent() != null) {
            ((ViewGroup) videoView.getParent()).removeView(videoView);
        }
        if (videoView != null) {
            this.f7836b.removeAllViews();
            this.f7836b.addView(videoView);
        }
        this.f7835a.setText(ksNativeAd.getAdDescription());
        if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            ap.a.pPQ.a(getContext(), ksNativeAd.getAppIconUrl(), this.c);
        }
        this.d.setText(ksNativeAd.getAppName());
        this.e.setText(ksNativeAd.getActionDescription());
        ksNativeAd.setDownloadListener(new ai(ksNativeAd, this.e, str, FunAdType.KS_NATIVE, str2));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f7835a = (TextView) findViewById(R.id.ad_description);
        this.f7836b = (FrameLayout) findViewById(R.id.ad_video);
        ImageView imageView = (ImageView) findViewById(R.id.ad_logo);
        this.c = (ImageView) findViewById(R.id.ad_app_icon);
        this.d = (TextView) findViewById(R.id.ad_app_title);
        this.e = (Button) findViewById(R.id.ad_app_download);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7836b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / 1.78f);
        this.f7836b.setLayoutParams(layoutParams);
    }
}
