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
    public ImageView f36551a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f36552b;

    /* renamed from: c  reason: collision with root package name */
    public AppScoreView f36553c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36554d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36555e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f36556f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f36557g;

    /* renamed from: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36559a;

        static {
            int[] iArr = new int[DOWNLOADSTAUS.values().length];
            f36559a = iArr;
            try {
                iArr[DOWNLOADSTAUS.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36559a[DOWNLOADSTAUS.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36559a[DOWNLOADSTAUS.PROGRESS.ordinal()] = 3;
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
        this.f36551a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f36552b = (TextView) findViewById(R.id.ksad_app_name);
        this.f36553c = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f36554d = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f36555e = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.f36556f = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
        this.f36556f.setTextColor(-1);
    }

    private void c() {
        ValueAnimator valueAnimator = this.f36557g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.f36557g = ofFloat;
            ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.f36557g.setRepeatCount(-1);
            this.f36557g.setRepeatMode(1);
            this.f36557g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    TailFrameBarAppLandscape.this.f36556f.setScaleY(floatValue);
                    TailFrameBarAppLandscape.this.f36556f.setScaleX(floatValue);
                }
            });
            this.f36557g.start();
        }
    }

    public void a() {
        ValueAnimator valueAnimator = this.f36557g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f36557g.cancel();
        this.f36557g.end();
    }

    public void a(@NonNull AdInfo adInfo) {
        int i = AnonymousClass2.f36559a[adInfo.status.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            a();
        } else {
            c();
        }
    }

    public TextProgressBar getTextProgressBar() {
        return this.f36556f;
    }

    public void setModel(@NonNull AdTemplate adTemplate) {
        AdInfo j = c.j(adTemplate);
        KSImageLoader.loadAppIcon(this.f36551a, a.o(j), adTemplate, 16);
        this.f36552b.setText(a.q(j));
        float u = a.u(j);
        if (u >= 3.0f) {
            this.f36553c.setScore(u);
            this.f36553c.setVisibility(0);
        } else {
            this.f36553c.setVisibility(8);
        }
        String t = a.t(j);
        if (TextUtils.isEmpty(t)) {
            this.f36554d.setVisibility(8);
        } else {
            this.f36554d.setText(t);
            this.f36554d.setVisibility(0);
        }
        this.f36555e.setText(a.n(j));
        this.f36556f.a(a.w(j), 0);
        a(c.j(adTemplate));
    }
}
