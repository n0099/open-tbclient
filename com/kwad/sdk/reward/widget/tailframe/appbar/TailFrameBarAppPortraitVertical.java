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
public class TailFrameBarAppPortraitVertical extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f33960a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f33961b;

    /* renamed from: c  reason: collision with root package name */
    public AppScoreView f33962c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33963d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33964e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f33965f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f33966g;

    public TailFrameBarAppPortraitVertical(Context context) {
        this(context, null);
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private void b() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_bar_app_portrait_vertical, this);
        this.f33960a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f33962c = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f33963d = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f33961b = (TextView) findViewById(R.id.ksad_app_name);
        this.f33964e = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.f33965f = textProgressBar;
        textProgressBar.setTextDimen(an.a(getContext(), 16.0f));
        this.f33965f.setTextColor(-1);
    }

    private void c() {
        ValueAnimator valueAnimator = this.f33966g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.f33966g = ofFloat;
            ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.f33966g.setRepeatCount(-1);
            this.f33966g.setRepeatMode(1);
            this.f33966g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    TailFrameBarAppPortraitVertical.this.f33965f.setScaleY(floatValue);
                    TailFrameBarAppPortraitVertical.this.f33965f.setScaleX(floatValue);
                }
            });
            this.f33966g.start();
        }
    }

    public void a() {
        ValueAnimator valueAnimator = this.f33966g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f33966g.cancel();
        this.f33966g.end();
    }

    public void a(@NonNull AdInfo adInfo) {
        int i2 = adInfo.status;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            a();
        } else {
            c();
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        AdInfo g2 = c.g(adTemplate);
        KSImageLoader.loadAppIcon(this.f33960a, a.n(g2), adTemplate, 12);
        this.f33961b.setText(a.o(g2));
        float s = a.s(g2);
        if (s >= 3.0f) {
            this.f33962c.setScore(s);
            this.f33962c.setVisibility(0);
        } else {
            this.f33962c.setVisibility(8);
        }
        String r = a.r(g2);
        if (TextUtils.isEmpty(r)) {
            this.f33963d.setVisibility(8);
        } else {
            this.f33963d.setText(r);
            this.f33963d.setVisibility(0);
        }
        this.f33964e.setText(a.m(g2));
        this.f33965f.a(a.u(g2), 0);
        a(g2);
    }

    public TextProgressBar getTextProgressBar() {
        return this.f33965f;
    }
}
