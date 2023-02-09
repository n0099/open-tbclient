package com.kwad.components.ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.widget.e;
import com.kwad.components.core.widget.f;
import com.kwad.sdk.R;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes8.dex */
public class KSCouponLabelTextView extends TextView implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint mPaint;
    @ColorInt
    public int strokeColor;
    public Path wA;
    public boolean wB;
    public final Rect wn;
    public final RectF wo;
    public final RectF wr;
    public float wt;
    public float wu;
    public float wv;
    public final RectF ww;
    public final RectF wx;
    public final Path wy;
    public Path wz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSCouponLabelTextView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPaint = new Paint();
        this.wn = new Rect();
        this.wo = new RectF();
        this.ww = new RectF();
        this.wx = new RectF();
        this.wy = new Path();
        this.wr = new RectF();
        this.wB = true;
        a(context, null, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPaint = new Paint();
        this.wn = new Rect();
        this.wo = new RectF();
        this.ww = new RectF();
        this.wx = new RectF();
        this.wy = new Path();
        this.wr = new RectF();
        this.wB = true;
        a(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i) {
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
        this.mPaint = new Paint();
        this.wn = new Rect();
        this.wo = new RectF();
        this.ww = new RectF();
        this.wx = new RectF();
        this.wy = new Path();
        this.wr = new RectF();
        this.wB = true;
        a(context, attributeSet, i);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, context, attributeSet, i) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i, 0);
            int color = context.getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060785);
            this.wt = obtainStyledAttributes.getDimension(0, 8.0f);
            this.wu = obtainStyledAttributes.getDimension(3, 2.0f);
            this.strokeColor = obtainStyledAttributes.getColor(2, color);
            this.wv = obtainStyledAttributes.getDimension(1, 16.0f);
            obtainStyledAttributes.recycle();
            jd();
        }
    }

    @RequiresApi(api = 19)
    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{path, path2, path3, rectF, rectF2, rectF3}) == null) {
            path.reset();
            float f = this.wt;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
            path2.addArc(rectF2, 90.0f, -180.0f);
            path3.addArc(rectF3, 90.0f, 180.0f);
            path.op(this.wz, Path.Op.DIFFERENCE);
            path.op(this.wA, Path.Op.DIFFERENCE);
        }
    }

    private void a(RectF rectF, RectF rectF2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, rectF, rectF2) == null) {
            rectF2.set(rectF);
            float f = rectF2.left;
            float f2 = this.wv;
            float f3 = f - f2;
            rectF2.left = f3;
            rectF2.right = f3 + (f2 * 2.0f);
            float height = rectF.height();
            float f4 = this.wv;
            float f5 = rectF2.top + ((height - (f4 * 2.0f)) / 2.0f);
            rectF2.top = f5;
            rectF2.bottom = f5 + (f4 * 2.0f);
        }
    }

    private void b(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, this, path, rectF, rectF2, rectF3) == null) {
            path.reset();
            path.moveTo(rectF.left, rectF.top + this.wt);
            this.wr.set(rectF);
            RectF rectF4 = this.wr;
            float f = rectF4.top;
            float f2 = this.wt;
            rectF4.bottom = f + (f2 * 2.0f);
            rectF4.right = rectF4.left + (f2 * 2.0f);
            path.arcTo(rectF4, 180.0f, 90.0f);
            path.lineTo(rectF.width() - this.wt, rectF.top);
            this.wr.set(rectF);
            RectF rectF5 = this.wr;
            float f3 = rectF5.right;
            float f4 = this.wt;
            rectF5.left = f3 - (f4 * 2.0f);
            rectF5.bottom = rectF5.top + (f4 * 2.0f);
            path.arcTo(rectF5, 270.0f, 90.0f);
            path.lineTo(rectF.right, rectF3.top);
            path.arcTo(rectF3, 270.0f, -180.0f);
            path.lineTo(rectF.right, rectF.bottom - this.wt);
            this.wr.set(rectF);
            RectF rectF6 = this.wr;
            float f5 = rectF6.right;
            float f6 = this.wt;
            rectF6.left = f5 - (f6 * 2.0f);
            rectF6.top = rectF6.bottom - (f6 * 2.0f);
            path.arcTo(rectF6, 0.0f, 90.0f);
            path.lineTo(rectF.left + this.wt, rectF.bottom);
            this.wr.set(rectF);
            RectF rectF7 = this.wr;
            float f7 = rectF7.left;
            float f8 = this.wt;
            rectF7.right = f7 + (f8 * 2.0f);
            rectF7.top = rectF7.bottom - (f8 * 2.0f);
            path.arcTo(rectF7, 90.0f, 90.0f);
            path.lineTo(rectF.left, rectF2.bottom);
            path.arcTo(rectF2, 90.0f, -180.0f);
            path.close();
        }
    }

    private void b(RectF rectF, RectF rectF2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, rectF, rectF2) == null) {
            rectF2.set(rectF);
            float f = rectF2.right;
            float f2 = this.wv;
            float f3 = f + f2;
            rectF2.right = f3;
            rectF2.left = f3 - (f2 * 2.0f);
            float height = rectF.height();
            float f4 = this.wv;
            float f5 = rectF2.top + ((height - (f4 * 2.0f)) / 2.0f);
            rectF2.top = f5;
            rectF2.bottom = f5 + (f4 * 2.0f);
        }
    }

    private void jd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.mPaint.setColor(this.strokeColor);
            this.mPaint.setStrokeWidth(this.wu);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setAntiAlias(true);
        }
    }

    @Override // com.kwad.components.core.widget.e
    public final void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int color = getResources().getColor(com.baidu.tieba.R.color.obfuscated_res_0x7f060785);
            this.strokeColor = color;
            setTextColor(color);
            jd();
            invalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            this.wn.setEmpty();
            getDrawingRect(this.wn);
            float f = this.wu / 2.0f;
            this.wo.set(this.wn);
            RectF rectF = this.wo;
            rectF.left += f;
            rectF.top += f;
            rectF.right -= f;
            rectF.bottom -= f;
            a(rectF, this.ww);
            b(this.wo, this.wx);
            if (Build.VERSION.SDK_INT >= 19) {
                Path path = this.wz;
                if (path == null) {
                    this.wz = new Path();
                } else {
                    path.reset();
                }
                Path path2 = this.wA;
                if (path2 == null) {
                    this.wA = new Path();
                } else {
                    path2.reset();
                }
                a(this.wy, this.wz, this.wA, this.wo, this.ww, this.wx);
            } else {
                b(this.wy, this.wo, this.ww, this.wx);
            }
            canvas.drawPath(this.wy, this.mPaint);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            super.onMeasure(i, i2);
            if (this.wB) {
                if (((float) (getPaddingLeft() + getPaddingRight())) + getPaint().measureText(getText().toString()) <= ((float) getMeasuredWidth())) {
                    return;
                }
                setVisibility(8);
            }
        }
    }
}
