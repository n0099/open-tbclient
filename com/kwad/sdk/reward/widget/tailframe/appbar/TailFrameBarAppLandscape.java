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
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.ao;
/* loaded from: classes5.dex */
public class TailFrameBarAppLandscape extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f10992a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f10993b;
    private AppScoreView c;
    private TextView d;
    private TextView e;
    private TextProgressBar f;
    private ValueAnimator g;

    public TailFrameBarAppLandscape(Context context) {
        this(context, null);
    }

    public TailFrameBarAppLandscape(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void b() {
        inflate(getContext(), R.layout.ksad_video_tf_bar_app_landscape, this);
        this.f10992a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f10993b = (TextView) findViewById(R.id.ksad_app_name);
        this.c = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.d = (TextView) findViewById(R.id.ksad_app_download_count);
        this.e = (TextView) findViewById(R.id.ksad_app_introduce);
        this.f = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.f.setTextDimen(ao.a(getContext(), 16.0f));
        this.f.setTextColor(-1);
    }

    private void c() {
        if (this.g == null || !this.g.isRunning()) {
            this.g = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.g.setDuration(1200L);
            this.g.setRepeatCount(-1);
            this.g.setRepeatMode(1);
            this.g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    TailFrameBarAppLandscape.this.f.setScaleY(floatValue);
                    TailFrameBarAppLandscape.this.f.setScaleX(floatValue);
                }
            });
            this.g.start();
        }
    }

    public void a() {
        if (this.g == null || !this.g.isRunning()) {
            return;
        }
        this.g.cancel();
        this.g.end();
    }

    public void a(@NonNull AdInfo adInfo) {
        switch (adInfo.status) {
            case START:
            case DOWNLOADING:
            case PROGRESS:
                a();
                return;
            default:
                c();
                return;
        }
    }

    public TextProgressBar getTextProgressBar() {
        return this.f;
    }

    public void setModel(@NonNull AdTemplate adTemplate) {
        AdInfo j = c.j(adTemplate);
        KSImageLoader.loadAppIcon(this.f10992a, a.o(j), adTemplate, 16);
        this.f10993b.setText(a.q(j));
        float u = a.u(j);
        if (u >= 3.0f) {
            this.c.setScore(u);
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
        String t = a.t(j);
        if (TextUtils.isEmpty(t)) {
            this.d.setVisibility(8);
        } else {
            this.d.setText(t);
            this.d.setVisibility(0);
        }
        this.e.setText(a.n(j));
        this.f.a(a.w(j), 0);
        a(c.j(adTemplate));
    }
}
