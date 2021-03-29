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
public class TailFrameBarAppPortraitVertical extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f36569a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f36570b;

    /* renamed from: c  reason: collision with root package name */
    public AppScoreView f36571c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36572d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36573e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f36574f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f36575g;

    /* renamed from: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36577a;

        static {
            int[] iArr = new int[DOWNLOADSTAUS.values().length];
            f36577a = iArr;
            try {
                iArr[DOWNLOADSTAUS.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36577a[DOWNLOADSTAUS.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36577a[DOWNLOADSTAUS.PROGRESS.ordinal()] = 3;
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

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void b() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_bar_app_portrait_vertical, this);
        this.f36569a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f36571c = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f36572d = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f36570b = (TextView) findViewById(R.id.ksad_app_name);
        this.f36573e = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.f36574f = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
        this.f36574f.setTextColor(-1);
    }

    private void c() {
        ValueAnimator valueAnimator = this.f36575g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.f36575g = ofFloat;
            ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.f36575g.setRepeatCount(-1);
            this.f36575g.setRepeatMode(1);
            this.f36575g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    TailFrameBarAppPortraitVertical.this.f36574f.setScaleY(floatValue);
                    TailFrameBarAppPortraitVertical.this.f36574f.setScaleX(floatValue);
                }
            });
            this.f36575g.start();
        }
    }

    public void a() {
        ValueAnimator valueAnimator = this.f36575g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f36575g.cancel();
        this.f36575g.end();
    }

    public void a(@NonNull AdInfo adInfo) {
        int i = AnonymousClass2.f36577a[adInfo.status.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            a();
        } else {
            c();
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        AdInfo j = c.j(adTemplate);
        KSImageLoader.loadAppIcon(this.f36569a, a.o(j), adTemplate, 12);
        this.f36570b.setText(a.q(j));
        float u = a.u(j);
        if (u >= 3.0f) {
            this.f36571c.setScore(u);
            this.f36571c.setVisibility(0);
        } else {
            this.f36571c.setVisibility(8);
        }
        String t = a.t(j);
        if (TextUtils.isEmpty(t)) {
            this.f36572d.setVisibility(8);
        } else {
            this.f36572d.setText(t);
            this.f36572d.setVisibility(0);
        }
        this.f36573e.setText(a.n(j));
        this.f36574f.a(a.w(j), 0);
        a(j);
    }

    public TextProgressBar getTextProgressBar() {
        return this.f36574f;
    }
}
