package com.kwad.components.ad.interstitial.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
/* loaded from: classes8.dex */
public class ViewPagerIndicator extends View {
    public int jf;
    public int jg;
    public int jh;
    public int ji;
    public float jj;
    public float jk;
    public Paint jl;
    public float jm;
    public float jn;
    public float jo;
    public int jp;
    public Paint jq;
    public float jr;
    public boolean js;
    public a jt;
    public ValueAnimator ju;
    public final Context mContext;

    /* loaded from: classes8.dex */
    public interface a {
        void dS();
    }

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        setWillNotDraw(false);
        a(context, attributeSet, i);
        eh();
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ViewPagerIndicator, i, 0);
        this.jk = obtainStyledAttributes.getDimension(1, com.kwad.sdk.b.kwai.a.a(this.mContext, 5.0f));
        this.jm = obtainStyledAttributes.getDimension(2, com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f));
        this.jn = obtainStyledAttributes.getDimension(3, com.kwad.sdk.b.kwai.a.a(this.mContext, 50.0f));
        this.jo = obtainStyledAttributes.getDimension(4, com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f));
        this.jg = obtainStyledAttributes.getColor(0, getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f06060d));
        this.jf = obtainStyledAttributes.getColor(5, getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060628));
        obtainStyledAttributes.recycle();
    }

    private void a(Canvas canvas) {
        float f;
        float f2;
        Paint paint;
        int i;
        RectF rectF = new RectF();
        for (int i2 = 0; i2 < this.jh; i2++) {
            int i3 = this.ji;
            if (i2 < i3) {
                float f3 = this.jk;
                f = this.jo;
                f2 = i2 * (f3 + f);
            } else {
                if (i2 == i3) {
                    float f4 = this.jk;
                    float f5 = this.jo;
                    float f6 = i2 * (f4 + f5);
                    rectF.left = f6;
                    rectF.right = f6 + f5 + ((this.jn - f5) * (1.0f - this.jj));
                    if (this.js) {
                        this.jl.setColor(this.jf);
                        paint = this.jl;
                        i = (int) (((1.0f - this.jj) * 127.0f) + 127.0f);
                        paint.setAlpha(i);
                    }
                    this.jl.setColor(this.jg);
                } else if (i2 == i3 + 1) {
                    float f7 = this.jk;
                    float f8 = this.jo;
                    float f9 = this.jn;
                    float f10 = this.jj;
                    float f11 = ((i2 - 1) * (f7 + f8)) + f8 + ((f9 - f8) * (1.0f - f10)) + f7;
                    rectF.left = f11;
                    rectF.right = f11 + (f10 * (f9 - f8)) + f8;
                    if (this.js) {
                        this.jl.setColor(this.jf);
                        paint = this.jl;
                        i = (int) (255.0f - ((1.0f - this.jj) * 127.0f));
                        paint.setAlpha(i);
                    }
                    this.jl.setColor(this.jg);
                } else {
                    float f12 = this.jk;
                    f = this.jo;
                    f2 = ((i2 - 1) * (f12 + f)) + f12 + this.jn;
                }
                rectF.top = 0.0f;
                float f13 = this.jm;
                rectF.bottom = 0.0f + f13;
                canvas.drawRoundRect(rectF, f13 / 2.0f, f13 / 2.0f, this.jl);
            }
            rectF.left = f2;
            rectF.right = f2 + f;
            this.jl.setColor(this.jg);
            rectF.top = 0.0f;
            float f132 = this.jm;
            rectF.bottom = 0.0f + f132;
            canvas.drawRoundRect(rectF, f132 / 2.0f, f132 / 2.0f, this.jl);
        }
    }

    public static /* synthetic */ boolean a(ViewPagerIndicator viewPagerIndicator, boolean z) {
        viewPagerIndicator.js = true;
        return true;
    }

    private void b(Canvas canvas) {
        if (this.js || this.ji != 0) {
            return;
        }
        RectF rectF = new RectF(0.0f, 0.0f, this.jr, this.jm);
        float f = this.jm;
        canvas.drawRoundRect(rectF, f / 2.0f, f / 2.0f, this.jq);
    }

    private void eh() {
        Paint paint = new Paint(1);
        this.jl = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.jl.setStrokeWidth(1.0f);
        this.jl.setColor(this.jg);
        Paint paint2 = new Paint(1);
        this.jq = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.jq.setStrokeWidth(1.0f);
        this.jq.setColor(this.jf);
    }

    private void ei() {
        if (this.jp <= 0) {
            setVisibility(8);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.jo, this.jn);
        this.ju = ofFloat;
        ofFloat.setDuration(this.jp * 1000);
        this.ju.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.widget.ViewPagerIndicator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewPagerIndicator.this.jr = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewPagerIndicator.this.invalidate();
            }
        });
        this.ju.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.widget.ViewPagerIndicator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ViewPagerIndicator.a(ViewPagerIndicator.this, true);
                if (ViewPagerIndicator.this.jt != null) {
                    ViewPagerIndicator.this.jt.dS();
                }
            }
        });
        this.ju.start();
    }

    @RequiresApi(api = 19)
    public final void ej() {
        ValueAnimator valueAnimator = this.ju;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    @RequiresApi(api = 19)
    public final void ek() {
        ValueAnimator valueAnimator = this.ju;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? (int) this.jm : 0;
        }
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                int i3 = this.jh;
                size = i3 > 1 ? (int) (this.jn + ((i3 - 1) * (this.jk + this.jo))) : (int) this.jn;
            } else {
                size = 0;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setFirstAdShowTime(int i) {
        this.jp = i;
    }

    public void setPlayProgressListener(a aVar) {
        this.jt = aVar;
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            return;
        }
        int count = adapter.getCount();
        this.jh = count;
        if (count <= 1) {
            return;
        }
        this.js = false;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.widget.ViewPagerIndicator.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
                ViewPagerIndicator.this.ji = i;
                ViewPagerIndicator.this.jj = f;
                ViewPagerIndicator.this.invalidate();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                ViewPagerIndicator.this.ji = i;
                ViewPagerIndicator.this.jj = 0.0f;
                ViewPagerIndicator.this.invalidate();
            }
        });
        ei();
    }
}
