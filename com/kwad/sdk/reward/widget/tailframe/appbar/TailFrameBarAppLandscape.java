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
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class TailFrameBarAppLandscape extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f36935a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f36936b;

    /* renamed from: c  reason: collision with root package name */
    public AppScoreView f36937c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36938d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36939e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f36940f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f36941g;

    /* renamed from: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36943a;

        static {
            int[] iArr = new int[DOWNLOADSTAUS.values().length];
            f36943a = iArr;
            try {
                iArr[DOWNLOADSTAUS.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36943a[DOWNLOADSTAUS.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36943a[DOWNLOADSTAUS.PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

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
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_bar_app_landscape, this);
        this.f36935a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f36936b = (TextView) findViewById(R.id.ksad_app_name);
        this.f36937c = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f36938d = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f36939e = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.f36940f = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
        this.f36940f.setTextColor(-1);
    }

    private void c() {
        ValueAnimator valueAnimator = this.f36941g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.f36941g = ofFloat;
            ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.f36941g.setRepeatCount(-1);
            this.f36941g.setRepeatMode(1);
            this.f36941g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    TailFrameBarAppLandscape.this.f36940f.setScaleY(floatValue);
                    TailFrameBarAppLandscape.this.f36940f.setScaleX(floatValue);
                }
            });
            this.f36941g.start();
        }
    }

    public void a() {
        ValueAnimator valueAnimator = this.f36941g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f36941g.cancel();
        this.f36941g.end();
    }

    public void a(@NonNull AdInfo adInfo) {
        int i = AnonymousClass2.f36943a[adInfo.status.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            a();
        } else {
            c();
        }
    }

    public TextProgressBar getTextProgressBar() {
        return this.f36940f;
    }

    public void setModel(@NonNull AdTemplate adTemplate) {
        AdInfo j = c.j(adTemplate);
        KSImageLoader.loadAppIcon(this.f36935a, a.o(j), adTemplate, 16);
        this.f36936b.setText(a.q(j));
        float u = a.u(j);
        if (u >= 3.0f) {
            this.f36937c.setScore(u);
            this.f36937c.setVisibility(0);
        } else {
            this.f36937c.setVisibility(8);
        }
        String t = a.t(j);
        if (TextUtils.isEmpty(t)) {
            this.f36938d.setVisibility(8);
        } else {
            this.f36938d.setText(t);
            this.f36938d.setVisibility(0);
        }
        this.f36939e.setText(a.n(j));
        this.f36940f.a(a.w(j), 0);
        a(c.j(adTemplate));
    }
}
