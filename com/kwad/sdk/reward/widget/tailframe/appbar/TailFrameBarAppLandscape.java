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
/* loaded from: classes5.dex */
public class TailFrameBarAppLandscape extends LinearLayout {
    public ImageView a;
    public TextView b;
    public AppScoreView c;
    public TextView d;
    public TextView e;
    public TextProgressBar f;
    public ValueAnimator g;
    public LinearLayout h;
    public View i;
    public Button j;
    public Button k;
    @Nullable
    public Animator l;

    /* loaded from: classes5.dex */
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

    public TailFrameBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    public static Animator a(View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.OPACITY, 1.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    public static Animator a(final View view2, float f, final float f2) {
        final float f3 = f / f2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f2);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f070374);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f4 = f3 * floatValue;
                float f5 = f2;
                if (f5 != 0.0f) {
                    float f6 = (floatValue / f5) * dimension;
                    View view3 = view2;
                    if (view3 instanceof TextView) {
                        ((TextView) view3).setTextSize(0, f6);
                    }
                }
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    layoutParams.width = (int) f4;
                    view2.setLayoutParams(layoutParams);
                }
            }
        });
        return ofFloat;
    }

    public static Animator a(final View view2, View view3, int i, int i2) {
        Animator a2 = a(view2);
        float f = i;
        float f2 = i2;
        Animator a3 = a(view3, f, f2);
        a3.addListener(new a() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.3
            @Override // com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.a, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view2.setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                    view2.setLayoutParams(layoutParams);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view3, AnimationProperty.SCALE_X, 1.0f, 1.0f);
        ofFloat.setDuration(1600L);
        Animator a4 = a(view3);
        Animator a5 = a(view2, f, f2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(a2, a3, ofFloat, a4, a5);
        return animatorSet;
    }

    private void a(LinearLayout linearLayout, String str) {
        TextView textView = (TextView) LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.obfuscated_res_0x7f0d045d, (ViewGroup) linearLayout, false);
        textView.setText(str);
        this.h.addView(textView);
    }

    private void c() {
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0479, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f091030);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091032);
        this.c = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091033);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f09102f);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091031);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091063);
        this.f = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.f.setTextColor(-1);
        this.h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0910e7);
        this.j = (Button) findViewById(R.id.obfuscated_res_0x7f0910e1);
        this.k = (Button) findViewById(R.id.obfuscated_res_0x7f0910e3);
        this.i = findViewById(R.id.obfuscated_res_0x7f0910e2);
    }

    private void d() {
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
            this.g = ofFloat;
            ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
            this.g.setRepeatCount(-1);
            this.g.setRepeatMode(1);
            this.g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    TailFrameBarAppLandscape.this.f.setScaleY(floatValue);
                    TailFrameBarAppLandscape.this.f.setScaleX(floatValue);
                }
            });
            this.g.start();
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
        int i = adInfo.status;
        if (i == 1 || i == 2 || i == 3) {
            b();
        } else {
            d();
        }
    }

    public void b() {
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.g.cancel();
            this.g.end();
        }
        Animator animator = this.l;
        if (animator == null || !animator.isRunning()) {
            return;
        }
        this.l.cancel();
        this.l.end();
    }

    public TextProgressBar getTextProgressBar() {
        return this.f;
    }

    public void setModel(@NonNull AdTemplate adTemplate) {
        ImageView imageView;
        String au;
        TextView textView;
        String t;
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
            textView = this.b;
            t = com.kwad.sdk.core.response.a.a.u(j);
        } else {
            textView = this.b;
            t = com.kwad.sdk.core.response.a.a.t(j);
        }
        textView.setText(t);
        int i = 0;
        if (!d.v(adTemplate)) {
            float x = com.kwad.sdk.core.response.a.a.x(j);
            if (x >= 3.0f) {
                this.c.setScore(x);
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
            String w = com.kwad.sdk.core.response.a.a.w(j);
            if (TextUtils.isEmpty(w)) {
                this.d.setVisibility(8);
            } else {
                this.d.setText(w);
                this.d.setVisibility(0);
            }
        }
        this.e.setText(com.kwad.sdk.core.response.a.a.s(j));
        if (d.v(adTemplate)) {
            this.f.setVisibility(8);
            this.i.setVisibility(0);
            this.k.setText("查看详情");
            Button button = this.j;
            button.setText(String.format("浏览详情页%s秒，领取奖励", b.aA() + ""));
            this.i.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.1
                @Override // java.lang.Runnable
                public void run() {
                    TailFrameBarAppLandscape.this.a();
                }
            }, 1600L);
        } else {
            this.f.setVisibility(0);
            this.i.setVisibility(8);
            a(d.j(adTemplate));
        }
        if (d.v(adTemplate)) {
            List<String> i2 = c.i(adTemplate);
            if (i2 == null || i2.size() <= 0) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
            }
            for (String str : i2) {
                i++;
                if (i > 3) {
                    return;
                }
                a(this.h, str);
            }
        }
    }
}
