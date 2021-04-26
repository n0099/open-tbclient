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
    public ImageView f34715a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34716b;

    /* renamed from: c  reason: collision with root package name */
    public AppScoreView f34717c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34718d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34719e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f34720f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f34721g;

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
        this.f34715a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f34717c = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f34718d = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f34716b = (TextView) findViewById(R.id.ksad_app_name);
        this.f34719e = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.f34720f = textProgressBar;
        textProgressBar.setTextDimen(an.a(getContext(), 16.0f));
        this.f34720f.setTextColor(-1);
    }

    private void c() {
        ValueAnimator valueAnimator = this.f34721g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.f34721g = ofFloat;
            ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.f34721g.setRepeatCount(-1);
            this.f34721g.setRepeatMode(1);
            this.f34721g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    TailFrameBarAppPortraitVertical.this.f34720f.setScaleY(floatValue);
                    TailFrameBarAppPortraitVertical.this.f34720f.setScaleX(floatValue);
                }
            });
            this.f34721g.start();
        }
    }

    public void a() {
        ValueAnimator valueAnimator = this.f34721g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f34721g.cancel();
        this.f34721g.end();
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
        KSImageLoader.loadAppIcon(this.f34715a, a.n(g2), adTemplate, 12);
        this.f34716b.setText(a.o(g2));
        float s = a.s(g2);
        if (s >= 3.0f) {
            this.f34717c.setScore(s);
            this.f34717c.setVisibility(0);
        } else {
            this.f34717c.setVisibility(8);
        }
        String r = a.r(g2);
        if (TextUtils.isEmpty(r)) {
            this.f34718d.setVisibility(8);
        } else {
            this.f34718d.setText(r);
            this.f34718d.setVisibility(0);
        }
        this.f34719e.setText(a.m(g2));
        this.f34720f.a(a.u(g2), 0);
        a(g2);
    }

    public TextProgressBar getTextProgressBar() {
        return this.f34720f;
    }
}
