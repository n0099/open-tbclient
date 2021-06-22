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
public class TailFrameBarAppPortraitHorizontal extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f37409a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f37410b;

    /* renamed from: c  reason: collision with root package name */
    public AppScoreView f37411c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f37412d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37413e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f37414f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f37415g;

    /* renamed from: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitHorizontal$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37417a;

        static {
            int[] iArr = new int[DOWNLOADSTAUS.values().length];
            f37417a = iArr;
            try {
                iArr[DOWNLOADSTAUS.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37417a[DOWNLOADSTAUS.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37417a[DOWNLOADSTAUS.PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public TailFrameBarAppPortraitHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private void b() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_bar_app_portrait_horizontal, this);
        this.f37409a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f37410b = (TextView) findViewById(R.id.ksad_app_name);
        this.f37411c = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f37412d = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f37413e = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.f37414f = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
        this.f37414f.setTextColor(-1);
    }

    private void c() {
        ValueAnimator valueAnimator = this.f37415g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.f37415g = ofFloat;
            ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.f37415g.setRepeatCount(-1);
            this.f37415g.setRepeatMode(1);
            this.f37415g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitHorizontal.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    TailFrameBarAppPortraitHorizontal.this.f37414f.setScaleY(floatValue);
                    TailFrameBarAppPortraitHorizontal.this.f37414f.setScaleX(floatValue);
                }
            });
            this.f37415g.start();
        }
    }

    public void a() {
        ValueAnimator valueAnimator = this.f37415g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f37415g.cancel();
        this.f37415g.end();
    }

    public void a(@NonNull AdInfo adInfo) {
        int i2 = AnonymousClass2.f37417a[adInfo.status.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            a();
        } else {
            c();
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        AdInfo j = c.j(adTemplate);
        KSImageLoader.loadAppIcon(this.f37409a, a.o(j), adTemplate, 20);
        this.f37410b.setText(a.q(j));
        float u = a.u(j);
        if (u >= 3.0f) {
            this.f37411c.setScore(u);
            this.f37411c.setVisibility(0);
        } else {
            this.f37411c.setVisibility(8);
        }
        String t = a.t(j);
        if (TextUtils.isEmpty(t)) {
            this.f37412d.setVisibility(8);
        } else {
            this.f37412d.setText(t);
            this.f37412d.setVisibility(0);
        }
        this.f37413e.setText(a.n(j));
        this.f37414f.a(a.w(j), 0);
        a(j);
    }

    public TextProgressBar getTextProgressBar() {
        return this.f37414f;
    }
}
