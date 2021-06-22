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
/* loaded from: classes7.dex */
public class TailFrameBarAppPortraitVertical extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f37418a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f37419b;

    /* renamed from: c  reason: collision with root package name */
    public AppScoreView f37420c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f37421d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37422e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f37423f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f37424g;

    /* renamed from: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37426a;

        static {
            int[] iArr = new int[DOWNLOADSTAUS.values().length];
            f37426a = iArr;
            try {
                iArr[DOWNLOADSTAUS.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37426a[DOWNLOADSTAUS.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37426a[DOWNLOADSTAUS.PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

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
        this.f37418a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f37420c = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f37421d = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f37419b = (TextView) findViewById(R.id.ksad_app_name);
        this.f37422e = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.f37423f = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
        this.f37423f.setTextColor(-1);
    }

    private void c() {
        ValueAnimator valueAnimator = this.f37424g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.f37424g = ofFloat;
            ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.f37424g.setRepeatCount(-1);
            this.f37424g.setRepeatMode(1);
            this.f37424g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    TailFrameBarAppPortraitVertical.this.f37423f.setScaleY(floatValue);
                    TailFrameBarAppPortraitVertical.this.f37423f.setScaleX(floatValue);
                }
            });
            this.f37424g.start();
        }
    }

    public void a() {
        ValueAnimator valueAnimator = this.f37424g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f37424g.cancel();
        this.f37424g.end();
    }

    public void a(@NonNull AdInfo adInfo) {
        int i2 = AnonymousClass2.f37426a[adInfo.status.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            a();
        } else {
            c();
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        AdInfo j = c.j(adTemplate);
        KSImageLoader.loadAppIcon(this.f37418a, a.o(j), adTemplate, 12);
        this.f37419b.setText(a.q(j));
        float u = a.u(j);
        if (u >= 3.0f) {
            this.f37420c.setScore(u);
            this.f37420c.setVisibility(0);
        } else {
            this.f37420c.setVisibility(8);
        }
        String t = a.t(j);
        if (TextUtils.isEmpty(t)) {
            this.f37421d.setVisibility(8);
        } else {
            this.f37421d.setText(t);
            this.f37421d.setVisibility(0);
        }
        this.f37422e.setText(a.n(j));
        this.f37423f.a(a.w(j), 0);
        a(j);
    }

    public TextProgressBar getTextProgressBar() {
        return this.f37423f;
    }
}
