package com.kwad.sdk.reflux;

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
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.reflux.KsRefluxContentView;
/* loaded from: classes5.dex */
public class KsRefluxView extends FrameLayout implements View.OnClickListener, KsRefluxContentView.a {
    public KsAdWebView a;
    public KsRefluxNativeView b;
    public View c;
    public ImageView d;
    public View e;
    public a f;
    public volatile boolean g;

    /* loaded from: classes5.dex */
    public interface a {
        void d();

        void e();
    }

    public KsRefluxView(@NonNull Context context) {
        super(context);
        this.g = false;
        a(context, null, 0);
    }

    public KsRefluxView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = false;
        a(context, attributeSet, 0);
    }

    public KsRefluxView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = false;
        a(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsRefluxView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.g = false;
        a(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(final View view2) {
        int measuredHeight = view2.getMeasuredHeight();
        if (measuredHeight == 0) {
            return null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(measuredHeight, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07036d));
        ofInt.setDuration(300L);
        ofInt.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reflux.KsRefluxView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
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

    @Nullable
    private Animator a(final View view2, final View view3) {
        if (view2 == null || view3 == null || view2.getMeasuredHeight() <= 0) {
            return null;
        }
        Drawable background = view3.getBackground();
        if (background instanceof GradientDrawable) {
            final GradientDrawable gradientDrawable = (GradientDrawable) background;
            ValueAnimator ofInt = ValueAnimator.ofInt(view2.getMeasuredHeight(), 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reflux.KsRefluxView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = intValue;
                        view2.setLayoutParams(layoutParams);
                    }
                }
            });
            ValueAnimator ofFloat = ValueAnimator.ofFloat(getResources().getDimension(R.dimen.obfuscated_res_0x7f070373), 0.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reflux.KsRefluxView.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    com.kwad.sdk.core.d.a.a("KsRefluxView", "actionBar radii value: " + floatValue);
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

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0437, this);
        this.c = findViewById(R.id.obfuscated_res_0x7f091097);
        this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f09108a);
        this.a = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091098);
        this.b = (KsRefluxNativeView) findViewById(R.id.obfuscated_res_0x7f091093);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091091);
        this.e = findViewById;
        findViewById.setOnClickListener(this);
        this.d.setOnClickListener(this);
        ((KsRefluxContentView) findViewById(R.id.obfuscated_res_0x7f091092)).setContentViewListener(this);
    }

    private boolean e() {
        ImageView imageView = this.d;
        return imageView != null && imageView.getMeasuredHeight() == 0;
    }

    public void a(boolean z) {
        this.a.setVisibility(z ? 0 : 4);
        this.b.setVisibility(z ? 8 : 0);
    }

    @Override // com.kwad.sdk.reflux.KsRefluxContentView.a
    public boolean a() {
        return e();
    }

    @Override // com.kwad.sdk.reflux.KsRefluxContentView.a
    public boolean b() {
        if (e()) {
            return false;
        }
        d();
        return true;
    }

    public void c() {
        setVisibility(0);
        this.d.post(new Runnable() { // from class: com.kwad.sdk.reflux.KsRefluxView.1
            @Override // java.lang.Runnable
            public void run() {
                KsRefluxView ksRefluxView = KsRefluxView.this;
                Animator a2 = ksRefluxView.a(ksRefluxView.d);
                if (a2 != null) {
                    a2.start();
                }
                if (KsRefluxView.this.f != null) {
                    KsRefluxView.this.f.e();
                }
            }
        });
    }

    @MainThread
    public void d() {
        if (e() || this.g) {
            return;
        }
        Animator a2 = a(this.d, this.c);
        a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reflux.KsRefluxView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                KsRefluxView.this.g = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                KsRefluxView.this.g = true;
            }
        });
        a2.start();
    }

    public KsRefluxNativeView getNativeView() {
        return this.b;
    }

    public KsAdWebView getWebView() {
        return this.a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.f == null) {
            return;
        }
        if (view2.equals(this.e)) {
            this.f.d();
        } else if (view2.equals(this.d)) {
            d();
        }
    }

    public void setViewListener(a aVar) {
        this.f = aVar;
    }
}
