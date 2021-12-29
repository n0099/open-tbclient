package com.kwad.sdk.reward.widget.tailframe.appbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.a.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.ax;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.List;
/* loaded from: classes3.dex */
public class TailFrameBarAppLandscape extends LinearLayout {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59981b;

    /* renamed from: c  reason: collision with root package name */
    public AppScoreView f59982c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59983d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59984e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f59985f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f59986g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f59987h;

    /* renamed from: i  reason: collision with root package name */
    public View f59988i;

    /* renamed from: j  reason: collision with root package name */
    public Button f59989j;

    /* renamed from: k  reason: collision with root package name */
    public Button f59990k;
    @Nullable
    public Animator l;

    /* loaded from: classes3.dex */
    public static class a implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public TailFrameBarAppLandscape(Context context) {
        this(context, null);
    }

    public TailFrameBarAppLandscape(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    public static Animator a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    public static Animator a(final View view, float f2, final float f3) {
        final float f4 = f2 / f3;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f3);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view.getResources().getDimension(R.dimen.ksad_reward_apk_info_card_actionbar_text_size);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f5 = f4 * floatValue;
                float f6 = f3;
                if (f6 != 0.0f) {
                    float f7 = (floatValue / f6) * dimension;
                    View view2 = view;
                    if (view2 instanceof TextView) {
                        ((TextView) view2).setTextSize(0, f7);
                    }
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    layoutParams.width = (int) f5;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        return ofFloat;
    }

    public static Animator a(final View view, View view2, int i2, int i3) {
        Animator a2 = a(view);
        float f2 = i2;
        float f3 = i3;
        Animator a3 = a(view2, f2, f3);
        a3.addListener(new a() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.3
            @Override // com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.a, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.SCALE_X, 1.0f, 1.0f);
        ofFloat.setDuration(1600L);
        Animator a4 = a(view2);
        Animator a5 = a(view, f2, f3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(a2, a3, ofFloat, a4, a5);
        return animatorSet;
    }

    private void a(LinearLayout linearLayout, String str) {
        TextView textView = (TextView) LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.ksad_reward_apk_info_card_tag_item, (ViewGroup) linearLayout, false);
        textView.setText(str);
        this.f59987h.addView(textView);
    }

    private void c() {
        LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_bar_app_landscape, this);
        this.a = (ImageView) findViewById(R.id.ksad_app_icon);
        this.f59981b = (TextView) findViewById(R.id.ksad_app_name);
        this.f59982c = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.f59983d = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f59984e = (TextView) findViewById(R.id.ksad_app_introduce);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
        this.f59985f = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.f59985f.setTextColor(-1);
        this.f59987h = (LinearLayout) findViewById(R.id.ksad_reward_apk_info_tags);
        this.f59989j = (Button) findViewById(R.id.ksad_reward_apk_info_install_action);
        this.f59990k = (Button) findViewById(R.id.ksad_reward_apk_info_install_start);
        this.f59988i = findViewById(R.id.ksad_reward_apk_info_install_container);
    }

    private void d() {
        ValueAnimator valueAnimator = this.f59986g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.f59986g = ofFloat;
            ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.f59986g.setRepeatCount(-1);
            this.f59986g.setRepeatMode(1);
            this.f59986g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    TailFrameBarAppLandscape.this.f59985f.setScaleY(floatValue);
                    TailFrameBarAppLandscape.this.f59985f.setScaleX(floatValue);
                }
            });
            this.f59986g.start();
        }
    }

    public void a() {
        int height = this.f59988i.getHeight();
        int width = this.f59988i.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.l == null) {
            Animator a2 = a(this.f59990k, this.f59989j, width, height);
            this.l = a2;
            a2.addListener(new a() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.2
                @Override // com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.a, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(final Animator animator) {
                    ax.a(new Runnable() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            animator.start();
                        }
                    }, null, 1600L);
                }
            });
        }
        if (this.l.isStarted()) {
            return;
        }
        this.l.start();
    }

    public void a(@NonNull AdInfo adInfo) {
        int i2 = adInfo.status;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            b();
        } else {
            d();
        }
    }

    public void b() {
        ValueAnimator valueAnimator = this.f59986g;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f59986g.cancel();
            this.f59986g.end();
        }
        Animator animator = this.l;
        if (animator == null || !animator.isRunning()) {
            return;
        }
        this.l.cancel();
        this.l.end();
    }

    public TextProgressBar getTextProgressBar() {
        return this.f59985f;
    }

    public void setModel(@NonNull AdTemplate adTemplate) {
        ImageView imageView;
        String au;
        TextView textView;
        String t;
        AdInfo j2 = d.j(adTemplate);
        if (d.v(adTemplate)) {
            imageView = this.a;
            au = com.kwad.sdk.core.response.a.a.aE(j2);
        } else {
            imageView = this.a;
            au = com.kwad.sdk.core.response.a.a.au(j2);
        }
        KSImageLoader.loadAppIcon(imageView, au, adTemplate, 12);
        if (d.v(adTemplate)) {
            textView = this.f59981b;
            t = com.kwad.sdk.core.response.a.a.u(j2);
        } else {
            textView = this.f59981b;
            t = com.kwad.sdk.core.response.a.a.t(j2);
        }
        textView.setText(t);
        int i2 = 0;
        if (!d.v(adTemplate)) {
            float x = com.kwad.sdk.core.response.a.a.x(j2);
            if (x >= 3.0f) {
                this.f59982c.setScore(x);
                this.f59982c.setVisibility(0);
            } else {
                this.f59982c.setVisibility(8);
            }
            String w = com.kwad.sdk.core.response.a.a.w(j2);
            if (TextUtils.isEmpty(w)) {
                this.f59983d.setVisibility(8);
            } else {
                this.f59983d.setText(w);
                this.f59983d.setVisibility(0);
            }
        }
        this.f59984e.setText(com.kwad.sdk.core.response.a.a.s(j2));
        if (d.v(adTemplate)) {
            this.f59985f.setVisibility(8);
            this.f59988i.setVisibility(0);
            this.f59990k.setText("查看详情");
            Button button = this.f59989j;
            button.setText(String.format("浏览详情页%s秒，领取奖励", b.aA() + ""));
            this.f59988i.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.1
                @Override // java.lang.Runnable
                public void run() {
                    TailFrameBarAppLandscape.this.a();
                }
            }, 1600L);
        } else {
            this.f59985f.setVisibility(0);
            this.f59988i.setVisibility(8);
            a(d.j(adTemplate));
        }
        if (d.v(adTemplate)) {
            List<String> i3 = c.i(adTemplate);
            if (i3 == null || i3.size() <= 0) {
                this.f59987h.setVisibility(8);
            } else {
                this.f59987h.setVisibility(0);
            }
            for (String str : i3) {
                i2++;
                if (i2 > 3) {
                    return;
                }
                a(this.f59987h, str);
            }
        }
    }
}
