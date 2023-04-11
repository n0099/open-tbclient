package com.kwad.components.ad.reflux;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.components.ad.reflux.KsRefluxContentView;
import com.kwad.components.ad.reward.c.c;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.e.b;
/* loaded from: classes8.dex */
public class KsRefluxView extends FrameLayout implements View.OnClickListener, KsRefluxContentView.a {
    public KsAdWebView bF;
    public KsRefluxNativeView kM;
    public View kN;
    public ImageView kO;
    public View kP;
    public a kQ;
    public volatile boolean kR;

    /* loaded from: classes8.dex */
    public interface a {
        void dh();

        void eI();
    }

    public KsRefluxView(@NonNull Context context) {
        super(context);
        this.kR = false;
        L(context);
    }

    public KsRefluxView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kR = false;
        L(context);
    }

    public KsRefluxView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kR = false;
        L(context);
    }

    @RequiresApi(api = 21)
    public KsRefluxView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.kR = false;
        L(context);
    }

    private void L(@NonNull Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0483, this);
        this.kN = findViewById(R.id.obfuscated_res_0x7f0912bd);
        this.kO = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912b0);
        this.bF = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f0912be);
        this.kM = (KsRefluxNativeView) findViewById(R.id.obfuscated_res_0x7f0912b9);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0912b7);
        this.kP = findViewById;
        findViewById.setOnClickListener(this);
        this.kO.setOnClickListener(this);
        ((KsRefluxContentView) findViewById(R.id.obfuscated_res_0x7f0912b8)).setContentViewListener(this);
    }

    @Nullable
    private Animator a(final View view2, final View view3) {
        if (view2 == null || view3 == null || view2.getMeasuredHeight() <= 0) {
            return null;
        }
        Drawable background = view3.getBackground();
        if (background instanceof GradientDrawable) {
            final GradientDrawable gradientDrawable = (GradientDrawable) background;
            ValueAnimator ofInt = ValueAnimator.ofInt(view2.getMeasuredHeight(), 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reflux.KsRefluxView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = intValue;
                        view2.setLayoutParams(layoutParams);
                    }
                }
            });
            ValueAnimator ofFloat = ValueAnimator.ofFloat(getResources().getDimension(R.dimen.obfuscated_res_0x7f0703a2), 0.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reflux.KsRefluxView.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    b.d("KsRefluxView", "actionBar radii value: " + floatValue);
                    gradientDrawable.setCornerRadii(new float[]{floatValue, floatValue, floatValue, floatValue, 0.0f, 0.0f, 0.0f, 0.0f});
                    view3.setBackground(gradientDrawable);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(300L);
            animatorSet.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
            animatorSet.playTogether(ofInt, ofFloat);
            return animatorSet;
        }
        return null;
    }

    @MainThread
    private void eG() {
        if (eH() || this.kR) {
            return;
        }
        Animator a2 = a(this.kO, this.kN);
        a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reflux.KsRefluxView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                KsRefluxView.this.kR = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                KsRefluxView.this.kR = true;
            }
        });
        a2.start();
    }

    private boolean eH() {
        ImageView imageView = this.kO;
        return imageView != null && imageView.getMeasuredHeight() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator j(final View view2) {
        int measuredHeight = view2.getMeasuredHeight();
        if (measuredHeight == 0) {
            return null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(measuredHeight, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07039c));
        ofInt.setDuration(300L);
        ofInt.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reflux.KsRefluxView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = intValue;
                    view2.setLayoutParams(layoutParams);
                }
            }
        });
        return ofInt;
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxContentView.a
    public final boolean eC() {
        return eH();
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxContentView.a
    public final boolean eD() {
        if (eH()) {
            return false;
        }
        eG();
        return true;
    }

    public KsRefluxNativeView getNativeView() {
        return this.kM;
    }

    public KsAdWebView getWebView() {
        return this.bF;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.kQ == null) {
            return;
        }
        if (view2.equals(this.kP)) {
            this.kQ.dh();
        } else if (view2.equals(this.kO)) {
            eG();
        }
    }

    public void setInnerAdInteractionListener(c cVar) {
        KsRefluxNativeView ksRefluxNativeView = this.kM;
        if (ksRefluxNativeView != null) {
            ksRefluxNativeView.setInnerAdInteractionListener(cVar);
        }
    }

    public void setViewListener(a aVar) {
        this.kQ = aVar;
    }

    public final void show() {
        setVisibility(0);
        this.kO.post(new Runnable() { // from class: com.kwad.components.ad.reflux.KsRefluxView.1
            @Override // java.lang.Runnable
            public final void run() {
                KsRefluxView ksRefluxView = KsRefluxView.this;
                Animator j = ksRefluxView.j(ksRefluxView.kO);
                if (j != null) {
                    j.start();
                }
                if (KsRefluxView.this.kQ != null) {
                    KsRefluxView.this.kQ.eI();
                }
            }
        });
    }

    public final void z(boolean z) {
        this.bF.setVisibility(z ? 0 : 4);
        this.kM.setVisibility(z ? 8 : 0);
    }
}
