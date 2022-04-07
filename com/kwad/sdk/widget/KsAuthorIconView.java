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
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.w;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes5.dex */
public class KsAuthorIconView extends FrameLayout {
    public ViewGroup a;
    public KSCornerImageView b;
    public KSCornerImageView c;
    public KSCornerImageView d;
    public KSCornerImageView e;
    public TextView f;
    public View g;
    public ImageView h;

    public KsAuthorIconView(@NonNull Context context) {
        super(context);
        a(context, (AttributeSet) null, 0);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(View view2) {
        float width = view2.getWidth();
        if (width <= 0.0f) {
            return null;
        }
        float f = 1.2f * width;
        com.kwad.sdk.core.d.a.a("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(width, f);
        ofFloat.addUpdateListener(b(view2));
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(create);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f, width);
        ofFloat2.addUpdateListener(b(view2));
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.setInterpolator(create2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(View view2, long j) {
        if (view2 == null || view2.getWidth() == 0 || view2.getHeight() == 0) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(view2.getWidth(), getResources().getDimension(R.dimen.obfuscated_res_0x7f070384));
        ofFloat.addUpdateListener(b(view2));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, AnimationProperty.OPACITY, 1.0f, 0.0f);
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(create);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0420, this);
        this.a = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091039);
        this.c = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f091038);
        this.b = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f09103a);
        this.d = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f091034);
        this.e = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f091035);
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f09107d);
        this.g = findViewById(R.id.obfuscated_res_0x7f091037);
        this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f091036);
    }

    private void a(c cVar, Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070382), cVar.a());
        }
    }

    public static ValueAnimator.AnimatorUpdateListener b(final View view2) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.widget.KsAuthorIconView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.width = i;
                    layoutParams.height = i;
                    view2.setLayoutParams(layoutParams);
                }
            }
        };
    }

    public void a(AdTemplate adTemplate) {
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        String aE = com.kwad.sdk.core.response.a.a.aE(j);
        if (!TextUtils.isEmpty(aE)) {
            KSImageLoader.loadImage(this.c, aE, adTemplate);
        }
        this.f.setText(com.kwad.sdk.core.response.a.a.aB(j));
        this.d.post(new Runnable() { // from class: com.kwad.sdk.widget.KsAuthorIconView.1
            @Override // java.lang.Runnable
            public void run() {
                KsAuthorIconView ksAuthorIconView = KsAuthorIconView.this;
                final Animator a = ksAuthorIconView.a(ksAuthorIconView.d, 900L);
                KsAuthorIconView ksAuthorIconView2 = KsAuthorIconView.this;
                final Animator a2 = ksAuthorIconView2.a(ksAuthorIconView2.e, 1000L);
                KsAuthorIconView ksAuthorIconView3 = KsAuthorIconView.this;
                final Animator a3 = ksAuthorIconView3.a(ksAuthorIconView3.c);
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
        int i;
        w.a(cVar, this);
        if (z) {
            imageView = this.h;
            i = R.drawable.obfuscated_res_0x7f080c93;
        } else {
            imageView = this.h;
            i = R.drawable.obfuscated_res_0x7f080c94;
        }
        imageView.setImageResource(i);
        a(cVar, this.d.getBackground());
        a(cVar, this.b.getBackground());
        a(cVar, this.e.getBackground());
        a(cVar, this.a.getBackground());
    }
}
