package com.kwad.sdk.reward.widget.tailframe.appbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
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
import androidx.core.content.ContextCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tieba.R;
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
/* loaded from: classes7.dex */
public class TailFrameBarAppPortraitVertical extends LinearLayout {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f41208b;

    /* renamed from: c  reason: collision with root package name */
    public AppScoreView f41209c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f41210d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f41211e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f41212f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f41213g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f41214h;
    public View i;
    public Button j;
    public Button k;
    @Nullable
    public Animator l;
    public View m;

    /* loaded from: classes7.dex */
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

    public TailFrameBarAppPortraitVertical(Context context) {
        this(context, null);
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        final float dimension = view.getResources().getDimension(R.dimen.obfuscated_res_0x7f07036a);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.4
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

    public static Animator a(final View view, View view2, int i, int i2) {
        Animator a2 = a(view);
        float f2 = i;
        float f3 = i2;
        Animator a3 = a(view2, f2, f3);
        a3.addListener(new a() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.3
            @Override // com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.a, android.animation.Animator.AnimatorListener
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
        TextView textView = (TextView) LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0462, (ViewGroup) linearLayout, false);
        textView.setText(str);
        this.f41214h.addView(textView);
    }

    private void c() {
        this.m = LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0480, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f091036);
        this.f41209c = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091039);
        this.f41210d = (TextView) findViewById(R.id.obfuscated_res_0x7f091035);
        this.f41208b = (TextView) findViewById(R.id.obfuscated_res_0x7f091038);
        this.f41211e = (TextView) findViewById(R.id.obfuscated_res_0x7f091037);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091069);
        this.f41212f = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.f41212f.setTextColor(-1);
        this.f41214h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0910ed);
        this.j = (Button) findViewById(R.id.obfuscated_res_0x7f0910e7);
        this.k = (Button) findViewById(R.id.obfuscated_res_0x7f0910e9);
        this.i = findViewById(R.id.obfuscated_res_0x7f0910e8);
    }

    private void d() {
        ValueAnimator valueAnimator = this.f41213g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.f41213g = ofFloat;
            ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.f41213g.setRepeatCount(-1);
            this.f41213g.setRepeatMode(1);
            this.f41213g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    TailFrameBarAppPortraitVertical.this.f41212f.setScaleY(floatValue);
                    TailFrameBarAppPortraitVertical.this.f41212f.setScaleX(floatValue);
                }
            });
            this.f41213g.start();
        }
    }

    public void a() {
        int height = this.i.getHeight();
        int width = this.i.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.l == null) {
            Animator a2 = a(this.k, this.j, width, height);
            this.l = a2;
            a2.addListener(new a() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.2
                @Override // com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.a, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(final Animator animator) {
                    ax.a(new Runnable() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.2.1
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
        int i = adInfo.status;
        if (i == 1 || i == 2 || i == 3) {
            b();
        } else {
            d();
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        ImageView imageView;
        String au;
        TextView textView;
        String at;
        if (d.v(adTemplate)) {
            this.m.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f06075b));
            this.f41208b.setTextColor(Color.parseColor("#FFFFFF"));
            this.f41211e.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.m.setBackgroundColor(Color.parseColor("#E6FFFFFF"));
        }
        AdInfo j = d.j(adTemplate);
        if (d.v(adTemplate)) {
            imageView = this.a;
            au = com.kwad.sdk.core.response.a.a.aE(j);
        } else {
            imageView = this.a;
            au = com.kwad.sdk.core.response.a.a.au(j);
        }
        KSImageLoader.loadAppIcon(imageView, au, adTemplate, 12);
        if (d.v(adTemplate)) {
            textView = this.f41208b;
            at = com.kwad.sdk.core.response.a.a.u(j);
        } else {
            textView = this.f41208b;
            at = com.kwad.sdk.core.response.a.a.at(j);
        }
        textView.setText(at);
        int i = 0;
        if (!d.v(adTemplate)) {
            float x = com.kwad.sdk.core.response.a.a.x(j);
            if (x >= 3.0f) {
                this.f41209c.setScore(x);
                this.f41209c.setVisibility(0);
            } else {
                this.f41209c.setVisibility(8);
            }
            String w = com.kwad.sdk.core.response.a.a.w(j);
            if (TextUtils.isEmpty(w)) {
                this.f41210d.setVisibility(8);
            } else {
                this.f41210d.setText(w);
                this.f41210d.setVisibility(0);
            }
        }
        this.f41211e.setText(com.kwad.sdk.core.response.a.a.s(j));
        if (d.v(adTemplate)) {
            this.f41212f.setVisibility(8);
            this.i.setVisibility(0);
            this.k.setText("查看详情");
            Button button = this.j;
            button.setText(String.format("浏览详情页%s秒，领取奖励", b.aA() + ""));
            this.i.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.1
                @Override // java.lang.Runnable
                public void run() {
                    TailFrameBarAppPortraitVertical.this.a();
                }
            }, 1600L);
        } else {
            this.f41212f.setVisibility(0);
            this.i.setVisibility(8);
            a(d.j(adTemplate));
        }
        if (d.v(adTemplate)) {
            List<String> i2 = c.i(adTemplate);
            if (i2 == null || i2.size() <= 0) {
                this.f41214h.setVisibility(8);
            } else {
                this.f41214h.setVisibility(0);
            }
            for (String str : i2) {
                i++;
                if (i > 3) {
                    return;
                }
                a(this.f41214h, str);
            }
        }
    }

    public void b() {
        ValueAnimator valueAnimator = this.f41213g;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f41213g.cancel();
            this.f41213g.end();
        }
        Animator animator = this.l;
        if (animator == null || !animator.isRunning()) {
            return;
        }
        this.l.cancel();
        this.l.end();
    }

    public TextProgressBar getTextProgressBar() {
        return this.f41212f;
    }
}
