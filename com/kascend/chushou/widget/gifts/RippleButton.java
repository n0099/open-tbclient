package com.kascend.chushou.widget.gifts;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kascend.chushou.a;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class RippleButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<a> f4277a;
    private Paint b;
    private int d;
    private int e;
    private int f;
    private ImageView g;
    private float h;
    private float i;
    private float j;
    private float k;
    private View.OnClickListener pCU;

    public RippleButton(@NonNull Context context) {
        this(context, null);
    }

    public RippleButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RippleButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4277a = new LinkedList<>();
        this.b = new Paint();
        this.h = 0.4f;
        this.i = 0.2f;
        this.j = this.i;
        this.k = 1.0f - this.j;
        this.g = new ImageView(context);
        this.g.setBackgroundColor(0);
        this.g.setClickable(true);
        this.g.setImageResource(a.e.bg_ripple_selector);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.g, layoutParams);
        setOnClickListener(null);
        setWillNotDraw(false);
        this.b.setAntiAlias(true);
        this.b.setColor(Color.parseColor("#FFFF5A7B"));
        this.b.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.pCU = onClickListener;
        this.g.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        final a aVar = new a(0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kascend.chushou.widget.gifts.RippleButton.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RippleButton.this.f4277a.poll();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                RippleButton.this.f4277a.offer(aVar);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kascend.chushou.widget.gifts.RippleButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                aVar.f4279a = valueAnimator.getAnimatedFraction();
                RippleButton.this.postInvalidate();
            }
        });
        ofFloat.start();
        if (this.pCU != null) {
            this.pCU.onClick(this);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g.post(new Runnable() { // from class: com.kascend.chushou.widget.gifts.RippleButton.3
            @Override // java.lang.Runnable
            public void run() {
                RippleButton.this.d = i / 2;
                RippleButton.this.e = i2 / 2;
                RippleButton.this.f = Math.min(i, i2) / 2;
                float width = (RippleButton.this.g.getWidth() / 2) * (1.0f - RippleButton.this.i);
                RippleButton.this.k = width / RippleButton.this.f;
                RippleButton.this.j = 1.0f - RippleButton.this.k;
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Iterator<a> it = this.f4277a.iterator();
        while (it.hasNext()) {
            a(it.next(), canvas, this.b);
        }
    }

    private void a(a aVar, Canvas canvas, Paint paint) {
        if (Math.abs(0.0f - aVar.f4279a) > 0.01d) {
            float f = this.f * this.j * aVar.f4279a;
            float f2 = this.f * (this.k + (this.j * aVar.f4279a));
            paint.setStrokeWidth(f);
            paint.setAlpha((int) (255.0f * this.h * (1.0f - aVar.f4279a)));
            canvas.drawCircle(this.d, this.e, f2 - (f / 2.0f), paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        float f4279a;

        a(float f) {
            this.f4279a = f;
        }
    }
}
