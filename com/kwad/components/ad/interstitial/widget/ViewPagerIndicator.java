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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
/* loaded from: classes7.dex */
public class ViewPagerIndicator extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes7.dex */
    public interface a {
        void dS();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPagerIndicator(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mContext = context;
        setWillNotDraw(false);
        a(context, attributeSet, i);
        eh();
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65542, this, context, attributeSet, i) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ViewPagerIndicator, i, 0);
            this.jk = obtainStyledAttributes.getDimension(1, com.kwad.sdk.b.kwai.a.a(this.mContext, 5.0f));
            this.jm = obtainStyledAttributes.getDimension(2, com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f));
            this.jn = obtainStyledAttributes.getDimension(3, com.kwad.sdk.b.kwai.a.a(this.mContext, 50.0f));
            this.jo = obtainStyledAttributes.getDimension(4, com.kwad.sdk.b.kwai.a.a(this.mContext, 6.0f));
            this.jg = obtainStyledAttributes.getColor(0, getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060770));
            this.jf = obtainStyledAttributes.getColor(5, getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f06078b));
            obtainStyledAttributes.recycle();
        }
    }

    private void a(Canvas canvas) {
        float f;
        float f2;
        Paint paint;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, canvas) == null) {
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
    }

    private void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, canvas) == null) && !this.js && this.ji == 0) {
            RectF rectF = new RectF(0.0f, 0.0f, this.jr, this.jm);
            float f = this.jm;
            canvas.drawRoundRect(rectF, f / 2.0f, f / 2.0f, this.jq);
        }
    }

    private void eh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
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
    }

    private void ei() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (this.jp <= 0) {
                setVisibility(8);
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.jo, this.jn);
            this.ju = ofFloat;
            ofFloat.setDuration(this.jp * 1000);
            this.ju.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.interstitial.widget.ViewPagerIndicator.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ViewPagerIndicator jv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.jv = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        this.jv.jr = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.jv.invalidate();
                    }
                }
            });
            this.ju.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.interstitial.widget.ViewPagerIndicator.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ViewPagerIndicator jv;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.jv = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.jv.js = true;
                        if (this.jv.jt != null) {
                            this.jv.jt.dS();
                        }
                    }
                }
            });
            this.ju.start();
        }
    }

    @RequiresApi(api = 19)
    public final void ej() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.ju) == null) {
            return;
        }
        valueAnimator.pause();
    }

    @RequiresApi(api = 19)
    public final void ek() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (valueAnimator = this.ju) == null) {
            return;
        }
        valueAnimator.resume();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            a(canvas);
            b(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
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
    }

    public void setFirstAdShowTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.jp = i;
        }
    }

    public void setPlayProgressListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.jt = aVar;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, viewPager) == null) || (adapter = viewPager.getAdapter()) == null) {
            return;
        }
        int count = adapter.getCount();
        this.jh = count;
        if (count <= 1) {
            return;
        }
        this.js = false;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) { // from class: com.kwad.components.ad.interstitial.widget.ViewPagerIndicator.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewPagerIndicator jv;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.jv = this;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
                    this.jv.ji = i;
                    this.jv.jj = f;
                    this.jv.invalidate();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                    this.jv.ji = i;
                    this.jv.jj = 0.0f;
                    this.jv.invalidate();
                }
            }
        });
        ei();
    }
}
