package com.facebook.drawee.span;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Property;
import android.widget.TextView;
/* loaded from: classes6.dex */
public class SimpleDraweeSpanTextView extends TextView {
    private static final Property<c[], Float> ANIMATED_COLOR_SPAN_FLOAT_PROPERTY = new Property<c[], Float>(Float.class, "ANIMATED_COLOR_SPAN_FLOAT_PROPERTY") { // from class: com.facebook.drawee.span.SimpleDraweeSpanTextView.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        /* renamed from: a */
        public Float get(c[] cVarArr) {
            return Float.valueOf(0.0f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.Property
        /* renamed from: a */
        public void set(c[] cVarArr, Float f) {
            if (cVarArr != null && f.floatValue() != 0.0f) {
                for (int i = 0; i < cVarArr.length; i++) {
                    if (cVarArr[i] != null) {
                        cVarArr[i].aR(f.floatValue());
                    }
                }
            }
        }
    };
    private static final String TAG = "SimpleDraweeSpan";
    private com.facebook.drawee.span.b mAniDraweeStringBuilder;
    private com.facebook.drawee.span.b mDraweeStringBuilder;
    private boolean mIsAttached;
    private ObjectAnimator mObjectAnimator;
    private c[] mRainbowTextSpans;

    public SimpleDraweeSpanTextView(Context context) {
        super(context);
        this.mIsAttached = false;
    }

    public SimpleDraweeSpanTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsAttached = false;
    }

    public SimpleDraweeSpanTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsAttached = false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttached = true;
        if (this.mDraweeStringBuilder != null) {
            this.mDraweeStringBuilder.dr(this);
        }
        startAni();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.mIsAttached = true;
        if (this.mDraweeStringBuilder != null) {
            this.mDraweeStringBuilder.dr(this);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.mIsAttached = false;
        if (this.mDraweeStringBuilder != null) {
            this.mDraweeStringBuilder.ds(this);
        }
        endAni();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        this.mIsAttached = false;
        if (this.mDraweeStringBuilder != null) {
            this.mDraweeStringBuilder.ds(this);
        }
        super.onStartTemporaryDetach();
    }

    public void setDraweeSpanStringBuilder(com.facebook.drawee.span.b bVar) {
        setText(bVar, TextView.BufferType.SPANNABLE);
        this.mDraweeStringBuilder = bVar;
        this.mAniDraweeStringBuilder = bVar;
        if (this.mAniDraweeStringBuilder != null) {
            this.mRainbowTextSpans = (c[]) this.mAniDraweeStringBuilder.getSpans(0, this.mAniDraweeStringBuilder.length(), c.class);
            if (this.mRainbowTextSpans != null && this.mRainbowTextSpans.length > 0) {
                startAni();
            } else {
                endAni();
            }
        }
        if (this.mDraweeStringBuilder != null && this.mIsAttached) {
            this.mDraweeStringBuilder.dr(this);
        }
    }

    public void detachCurrentDraweeSpanStringBuilder() {
        if (this.mDraweeStringBuilder != null) {
            this.mDraweeStringBuilder.ds(this);
        }
        this.mDraweeStringBuilder = null;
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        detachCurrentDraweeSpanStringBuilder();
    }

    private void startAni() {
        if (this.mRainbowTextSpans != null && this.mRainbowTextSpans.length != 0 && this.mObjectAnimator == null) {
            this.mObjectAnimator = ObjectAnimator.ofFloat(this.mRainbowTextSpans, ANIMATED_COLOR_SPAN_FLOAT_PROPERTY, 0.0f, 100.0f);
            this.mObjectAnimator.setEvaluator(new a());
            this.mObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facebook.drawee.span.SimpleDraweeSpanTextView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (Float.parseFloat(valueAnimator.getAnimatedValue().toString()) != 0.0f) {
                        SimpleDraweeSpanTextView.this.postInvalidate();
                    }
                }
            });
            this.mObjectAnimator.setInterpolator(new b());
            this.mObjectAnimator.setDuration(360000L);
            this.mObjectAnimator.setRepeatCount(-1);
            this.mObjectAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b implements TimeInterpolator {
        int count;

        private b() {
            this.count = 0;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            this.count++;
            if (this.count < 8) {
                return 0.0f;
            }
            this.count = 0;
            return f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends FloatEvaluator {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.animation.TypeEvaluator
        public Float evaluate(float f, Number number, Number number2) {
            return f == 0.0f ? Float.valueOf(0.0f) : super.evaluate(f, number, number2);
        }
    }

    private void endAni() {
        if (this.mObjectAnimator != null) {
            this.mObjectAnimator.cancel();
            this.mObjectAnimator = null;
        }
    }
}
