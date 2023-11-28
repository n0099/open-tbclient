package com.kwad.components.ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
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
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.components.core.s.i;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.utils.br;
/* loaded from: classes10.dex */
public class KsAuthorIconView extends FrameLayout implements br.a {
    public ViewGroup AA;
    public KSCornerImageView AB;
    public KSCornerImageView AC;
    public KSCornerImageView AE;
    public TextView AF;
    public View AG;
    public View AH;
    public ImageView AI;
    public View AJ;
    public View AK;
    public View AL;
    public View AM;
    public final br hh;
    public KSCornerImageView zy;

    public KsAuthorIconView(@NonNull Context context) {
        super(context);
        this.hh = new br(this);
        P(context);
    }

    public final void a(e eVar) {
        i.a(eVar, this);
        this.AI.setImageResource(R.drawable.obfuscated_res_0x7f080ec6);
        a(eVar, this.AC.getBackground());
        a(eVar, this.AB.getBackground());
        a(eVar, this.AE.getBackground());
        a(eVar, this.AA.getBackground());
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hh = new br(this);
        P(context);
    }

    private void a(e eVar, Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070505), eVar.tj());
        }
    }

    public static ValueAnimator.AnimatorUpdateListener f(final View view2, final boolean z) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.width = i;
                    if (!z) {
                        layoutParams.height = i;
                    }
                    view2.setLayoutParams(layoutParams);
                }
            }
        };
    }

    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hh = new br(this);
        P(context);
    }

    @RequiresApi(api = 21)
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.hh = new br(this);
        P(context);
    }

    private void P(@NonNull Context context) {
        l.inflate(context, R.layout.obfuscated_res_0x7f0d04b3, this);
        this.AA = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091310);
        this.zy = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f09130f);
        this.AB = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f091312);
        this.AC = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f09130b);
        this.AE = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f09130c);
        this.AF = (TextView) findViewById(R.id.obfuscated_res_0x7f091365);
        this.AH = findViewById(R.id.obfuscated_res_0x7f091366);
        this.AG = findViewById(R.id.obfuscated_res_0x7f09130e);
        this.AI = (ImageView) findViewById(R.id.obfuscated_res_0x7f09130d);
        this.AK = findViewById(R.id.obfuscated_res_0x7f0913e2);
        this.AJ = findViewById(R.id.obfuscated_res_0x7f0914de);
        this.AM = findViewById(R.id.obfuscated_res_0x7f091311);
        this.AL = findViewById(R.id.obfuscated_res_0x7f0914dd);
    }

    public final void b(AdTemplate adTemplate) {
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        String cf = a.cf(dP);
        if (!TextUtils.isEmpty(cf)) {
            KSImageLoader.loadImage(this.zy, cf, adTemplate);
        }
        int bf = a.bf(dP);
        if (a.cJ(com.kwad.sdk.core.response.b.e.dP(adTemplate))) {
            this.AF.setText("直播中");
            this.AH.setVisibility(8);
            this.AG.setVisibility(8);
            if (bf == 8) {
                this.AL.setVisibility(8);
                this.AI.setVisibility(8);
                this.AK.setVisibility(0);
            } else {
                this.AK.setVisibility(8);
                this.AI.setVisibility(0);
                this.AK.setVisibility(8);
            }
        } else {
            this.AF.setText(a.cE(dP));
        }
        this.hh.sendEmptyMessageAtTime(1, 500L);
    }

    private Animator c(View view2, long j) {
        if (view2 != null && view2.getWidth() != 0 && view2.getHeight() != 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(view2.getWidth(), getResources().getDimension(R.dimen.obfuscated_res_0x7f070506));
            ofFloat.addUpdateListener(f(view2, false));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 0.0f);
            Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(j);
            animatorSet.setInterpolator(create);
            animatorSet.playTogether(ofFloat, ofFloat2);
            return animatorSet;
        }
        return null;
    }

    public static Animator e(View view2, boolean z) {
        float width = view2.getWidth();
        if (width <= 0.0f) {
            return null;
        }
        float f = 0.9f * width;
        c.d("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(width, f);
        ofFloat.addUpdateListener(f(view2, false));
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(create);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f, width);
        ofFloat2.addUpdateListener(f(view2, false));
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.setInterpolator(create2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        return animatorSet;
    }

    public static Animator i(View view2, int i) {
        if (view2 == null) {
            return null;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        view2.setPivotX(width / 2.0f);
        view2.setPivotY(height);
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
        animatorSet.playTogether(ObjectAnimator.ofFloat(view2, Key.SCALE_X, 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view2, Key.SCALE_Y, 1.0f, 1.1f, 1.0f));
        animatorSet.setInterpolator(create);
        animatorSet.setDuration(250L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view2, Key.SCALE_X, 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view2, Key.SCALE_Y, 1.0f, 1.1f, 1.0f));
        animatorSet2.setInterpolator(create2);
        animatorSet2.setDuration(250L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet3.setDuration(500L);
        return animatorSet3;
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (message.what == 1) {
            c.d("KsAuthorIconView", "handleMsg MSG_CHECKING");
            final Animator c = c(this.AC, 900L);
            final Animator c2 = c(this.AE, 1000L);
            final Animator e = e(this.zy, false);
            final Animator i = i(this.AJ, 500);
            if (i != null && c != null && c2 != null && e != null) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(e, c, c2);
                animatorSet.start();
                e.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        c.start();
                        c2.start();
                        e.start();
                        i.start();
                    }
                });
                return;
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
