package com.kwad.sdk.reward.widget.tailframe.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.an;
/* loaded from: classes6.dex */
public class TailFrameBarAppLandscape extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f33873a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f33874b;

    /* renamed from: c  reason: collision with root package name */
    public AppScoreView f33875c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33876d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33877e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f33878f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f33879g;

    public TailFrameBarAppLandscape(Context context) {
        this(context, null);
    }

    public TailFrameBarAppLandscape(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private void b() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_bar_app_landscape, this);
        this.f33873a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f33874b = (TextView) findViewById(R.id.ksad_app_name);
        this.f33875c = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f33876d = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f33877e = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.f33878f = textProgressBar;
        textProgressBar.setTextDimen(an.a(getContext(), 16.0f));
        this.f33878f.setTextColor(-1);
    }

    private void c() {
        ValueAnimator valueAnimator = this.f33879g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.f33879g = ofFloat;
            ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.f33879g.setRepeatCount(-1);
            this.f33879g.setRepeatMode(1);
            this.f33879g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    TailFrameBarAppLandscape.this.f33878f.setScaleY(floatValue);
                    TailFrameBarAppLandscape.this.f33878f.setScaleX(floatValue);
                }
            });
            this.f33879g.start();
        }
    }

    public void a() {
        ValueAnimator valueAnimator = this.f33879g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f33879g.cancel();
        this.f33879g.end();
    }

    public void a(@NonNull AdInfo adInfo) {
        int i2 = adInfo.status;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            a();
        } else {
            c();
        }
    }

    public TextProgressBar getTextProgressBar() {
        return this.f33878f;
    }

    public void setModel(@NonNull AdTemplate adTemplate) {
        AdInfo g2 = c.g(adTemplate);
        KSImageLoader.loadAppIcon(this.f33873a, a.n(g2), adTemplate, 16);
        this.f33874b.setText(a.o(g2));
        float s = a.s(g2);
        if (s >= 3.0f) {
            this.f33875c.setScore(s);
            this.f33875c.setVisibility(0);
        } else {
            this.f33875c.setVisibility(8);
        }
        String r = a.r(g2);
        if (TextUtils.isEmpty(r)) {
            this.f33876d.setVisibility(8);
        } else {
            this.f33876d.setText(r);
            this.f33876d.setVisibility(0);
        }
        this.f33877e.setText(a.m(g2));
        this.f33878f.a(a.u(g2), 0);
        a(c.g(adTemplate));
    }
}
