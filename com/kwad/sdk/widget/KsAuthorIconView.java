package com.kwad.sdk.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.w;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes4.dex */
public class KsAuthorIconView extends FrameLayout {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public KSCornerImageView f58237b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f58238c;

    /* renamed from: d  reason: collision with root package name */
    public KSCornerImageView f58239d;

    /* renamed from: e  reason: collision with root package name */
    public KSCornerImageView f58240e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58241f;

    /* renamed from: g  reason: collision with root package name */
    public View f58242g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f58243h;

    public KsAuthorIconView(@NonNull Context context) {
        super(context);
        a(context, (AttributeSet) null, 0);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(View view) {
        float width = view.getWidth();
        if (width <= 0.0f) {
            return null;
        }
        float f2 = 1.2f * width;
        com.kwad.sdk.core.d.a.a("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f2);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(width, f2);
        ofFloat.addUpdateListener(b(view));
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(create);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f2, width);
        ofFloat2.addUpdateListener(b(view));
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.setInterpolator(create2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(View view, long j2) {
        if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(view.getWidth(), getResources().getDimension(R.dimen.ksad_reward_author_width));
        ofFloat.addUpdateListener(b(view));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 0.0f);
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j2);
        animatorSet.setInterpolator(create);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        FrameLayout.inflate(context, R.layout.ksad_author_icon, this);
        this.a = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
        this.f58238c = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
        this.f58237b = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
        this.f58239d = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
        this.f58240e = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
        this.f58241f = (TextView) findViewById(R.id.ksad_fans_count);
        this.f58242g = findViewById(R.id.ksad_author_btn_follow);
        this.f58243h = (ImageView) findViewById(R.id.ksad_author_arrow_down);
    }

    private void a(c cVar, Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.ksad_reward_author_icon_stroke_width), cVar.a());
        }
    }

    public static ValueAnimator.AnimatorUpdateListener b(final View view) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.widget.KsAuthorIconView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    int i2 = (int) floatValue;
                    layoutParams.width = i2;
                    layoutParams.height = i2;
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }

    public void a(AdTemplate adTemplate) {
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        String aE = com.kwad.sdk.core.response.a.a.aE(j2);
        if (!TextUtils.isEmpty(aE)) {
            KSImageLoader.loadImage(this.f58238c, aE, adTemplate);
        }
        this.f58241f.setText(com.kwad.sdk.core.response.a.a.aB(j2));
        this.f58239d.post(new Runnable() { // from class: com.kwad.sdk.widget.KsAuthorIconView.1
            @Override // java.lang.Runnable
            public void run() {
                KsAuthorIconView ksAuthorIconView = KsAuthorIconView.this;
                final Animator a = ksAuthorIconView.a(ksAuthorIconView.f58239d, 900L);
                KsAuthorIconView ksAuthorIconView2 = KsAuthorIconView.this;
                final Animator a2 = ksAuthorIconView2.a(ksAuthorIconView2.f58240e, 1000L);
                KsAuthorIconView ksAuthorIconView3 = KsAuthorIconView.this;
                final Animator a3 = ksAuthorIconView3.a(ksAuthorIconView3.f58238c);
                if (a == null || a2 == null || a3 == null) {
                    return;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(a3, a, a2);
                animatorSet.start();
                a3.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.widget.KsAuthorIconView.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.start();
                        a2.start();
                        a3.start();
                    }
                });
            }
        });
    }

    public void a(boolean z, c cVar) {
        ImageView imageView;
        int i2;
        w.a(cVar, this);
        if (z) {
            imageView = this.f58243h;
            i2 = R.drawable.ksad_reward_follow_arrow_down;
        } else {
            imageView = this.f58243h;
            i2 = R.drawable.ksad_reward_follow_arrow_down_orange;
        }
        imageView.setImageResource(i2);
        a(cVar, this.f58239d.getBackground());
        a(cVar, this.f58237b.getBackground());
        a(cVar, this.f58240e.getBackground());
        a(cVar, this.a.getBackground());
    }
}
