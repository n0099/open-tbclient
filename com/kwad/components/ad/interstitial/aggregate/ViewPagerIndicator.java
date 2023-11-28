package com.kwad.components.ad.interstitial.aggregate;

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
/* loaded from: classes10.dex */
public class ViewPagerIndicator extends View {
    public int iU;
    public int ja;
    public int jb;
    public int jc;
    public float jd;
    public float je;
    public Paint jf;
    public float jg;
    public float jh;
    public float ji;
    public int jj;
    public Paint jk;
    public float jl;
    public boolean jm;
    public a jn;
    public ValueAnimator jo;
    public final Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void cw();
    }

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    private void b(Canvas canvas) {
        if (!this.jm && this.iU == 0) {
            RectF rectF = new RectF(0.0f, 0.0f, this.jl, this.jg);
            float f = this.jg;
            canvas.drawRoundRect(rectF, f / 2.0f, f / 2.0f, this.jk);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    public void setFirstAdShowTime(int i) {
        this.jj = i;
    }

    public void setPlayProgressListener(a aVar) {
        this.jn = aVar;
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            return;
        }
        int count = adapter.getCount();
        this.jc = count;
        if (count <= 1) {
            return;
        }
        this.jm = false;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                ViewPagerIndicator.this.iU = i;
                ViewPagerIndicator.this.jd = 0.0f;
                ViewPagerIndicator.this.invalidate();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
                ViewPagerIndicator.this.iU = i;
                ViewPagerIndicator.this.jd = f;
                ViewPagerIndicator.this.invalidate();
            }
        });
        cB();
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        setWillNotDraw(false);
        a(context, attributeSet, i);
        cA();
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ViewPagerIndicator, i, 0);
        this.je = obtainStyledAttributes.getDimension(1, com.kwad.sdk.d.a.a.a(this.mContext, 5.0f));
        this.jg = obtainStyledAttributes.getDimension(2, com.kwad.sdk.d.a.a.a(this.mContext, 6.0f));
        this.jh = obtainStyledAttributes.getDimension(3, com.kwad.sdk.d.a.a.a(this.mContext, 50.0f));
        this.ji = obtainStyledAttributes.getDimension(4, com.kwad.sdk.d.a.a.a(this.mContext, 6.0f));
        this.jb = obtainStyledAttributes.getColor(0, getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f06078f));
        this.ja = obtainStyledAttributes.getColor(5, getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f0607b4));
        obtainStyledAttributes.recycle();
    }

    private void a(Canvas canvas) {
        RectF rectF = new RectF();
        for (int i = 0; i < this.jc; i++) {
            int i2 = this.iU;
            if (i < i2) {
                float f = this.je;
                float f2 = this.ji;
                float f3 = i * (f + f2);
                rectF.left = f3;
                rectF.right = f3 + f2;
                this.jf.setColor(this.jb);
            } else if (i == i2) {
                float f4 = this.je;
                float f5 = this.ji;
                float f6 = i * (f4 + f5);
                rectF.left = f6;
                rectF.right = f6 + f5 + ((this.jh - f5) * (1.0f - this.jd));
                if (this.jm) {
                    this.jf.setColor(this.ja);
                    this.jf.setAlpha((int) (((1.0f - this.jd) * 127.0f) + 127.0f));
                } else {
                    this.jf.setColor(this.jb);
                }
            } else if (i == i2 + 1) {
                float f7 = this.je;
                float f8 = this.ji;
                float f9 = this.jh;
                float f10 = this.jd;
                float f11 = ((i - 1) * (f7 + f8)) + f8 + ((f9 - f8) * (1.0f - f10)) + f7;
                rectF.left = f11;
                rectF.right = f11 + (f10 * (f9 - f8)) + f8;
                if (this.jm) {
                    this.jf.setColor(this.ja);
                    this.jf.setAlpha((int) (255.0f - ((1.0f - this.jd) * 127.0f)));
                } else {
                    this.jf.setColor(this.jb);
                }
            } else {
                float f12 = this.je;
                float f13 = this.ji;
                float f14 = ((i - 1) * (f12 + f13)) + f12 + this.jh;
                rectF.left = f14;
                rectF.right = f14 + f13;
                this.jf.setColor(this.jb);
            }
            rectF.top = 0.0f;
            float f15 = this.jg;
            rectF.bottom = 0.0f + f15;
            canvas.drawRoundRect(rectF, f15 / 2.0f, f15 / 2.0f, this.jf);
        }
    }

    public static /* synthetic */ boolean a(ViewPagerIndicator viewPagerIndicator, boolean z) {
        viewPagerIndicator.jm = true;
        return true;
    }

    private void cA() {
        Paint paint = new Paint(1);
        this.jf = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.jf.setStrokeWidth(1.0f);
        this.jf.setColor(this.jb);
        Paint paint2 = new Paint(1);
        this.jk = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.jk.setStrokeWidth(1.0f);
        this.jk.setColor(this.ja);
    }

    private void cB() {
        if (this.jj <= 0) {
            setVisibility(8);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.ji, this.jh);
        this.jo = ofFloat;
        ofFloat.setDuration(this.jj * 1000);
        this.jo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewPagerIndicator.this.jl = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewPagerIndicator.this.invalidate();
            }
        });
        this.jo.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ViewPagerIndicator.a(ViewPagerIndicator.this, true);
                if (ViewPagerIndicator.this.jn != null) {
                    ViewPagerIndicator.this.jn.cw();
                }
            }
        });
        this.jo.start();
    }

    @RequiresApi(api = 19)
    public final void cC() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    @RequiresApi(api = 19)
    public final void cD() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                size2 = (int) this.jg;
            } else {
                size2 = 0;
            }
        }
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                int i3 = this.jc;
                if (i3 > 1) {
                    size = (int) (this.jh + ((i3 - 1) * (this.je + this.ji)));
                } else {
                    size = (int) this.jh;
                }
            } else {
                size = 0;
            }
        }
        setMeasuredDimension(size, size2);
    }
}
