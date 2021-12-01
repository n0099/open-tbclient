package com.kwad.sdk.widget;

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
import com.kwad.sdk.R;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class KSCouponLabelTextView extends TextView implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f59698b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    public int f59699c;

    /* renamed from: d  reason: collision with root package name */
    public float f59700d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f59701e;

    /* renamed from: f  reason: collision with root package name */
    public final Rect f59702f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f59703g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f59704h;

    /* renamed from: i  reason: collision with root package name */
    public final RectF f59705i;

    /* renamed from: j  reason: collision with root package name */
    public final Path f59706j;

    /* renamed from: k  reason: collision with root package name */
    public Path f59707k;
    public Path l;
    public final RectF m;
    public boolean n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSCouponLabelTextView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59701e = new Paint();
        this.f59702f = new Rect();
        this.f59703g = new RectF();
        this.f59704h = new RectF();
        this.f59705i = new RectF();
        this.f59706j = new Path();
        this.m = new RectF();
        this.n = true;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59701e = new Paint();
        this.f59702f = new Rect();
        this.f59703g = new RectF();
        this.f59704h = new RectF();
        this.f59705i = new RectF();
        this.f59706j = new Path();
        this.m = new RectF();
        this.n = true;
        a(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f59701e = new Paint();
        this.f59702f = new Rect();
        this.f59703g = new RectF();
        this.f59704h = new RectF();
        this.f59705i = new RectF();
        this.f59706j = new Path();
        this.m = new RectF();
        this.n = true;
        a(context, attributeSet, i2);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f59701e.setColor(this.f59699c);
            this.f59701e.setStrokeWidth(this.f59698b);
            this.f59701e.setStyle(Paint.Style.STROKE);
            this.f59701e.setAntiAlias(true);
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, context, attributeSet, i2) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i2, 0);
            int color = context.getResources().getColor(R.color.ksad_reward_main_color);
            this.a = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_labelRadius, 8.0f);
            this.f59698b = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeSize, 2.0f);
            this.f59699c = obtainStyledAttributes.getColor(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeColor, color);
            this.f59700d = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_sideRadius, 16.0f);
            obtainStyledAttributes.recycle();
            a();
        }
    }

    @RequiresApi(api = 19)
    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{path, path2, path3, rectF, rectF2, rectF3}) == null) {
            path.reset();
            float f2 = this.a;
            path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
            path2.addArc(rectF2, 90.0f, -180.0f);
            path3.addArc(rectF3, 90.0f, 180.0f);
            path.op(this.f59707k, Path.Op.DIFFERENCE);
            path.op(this.l, Path.Op.DIFFERENCE);
        }
    }

    private void a(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, this, path, rectF, rectF2, rectF3) == null) {
            path.reset();
            path.moveTo(rectF.left, rectF.top + this.a);
            this.m.set(rectF);
            RectF rectF4 = this.m;
            float f2 = rectF4.top;
            float f3 = this.a;
            rectF4.bottom = f2 + (f3 * 2.0f);
            rectF4.right = rectF4.left + (f3 * 2.0f);
            path.arcTo(rectF4, 180.0f, 90.0f);
            path.lineTo(rectF.width() - this.a, rectF.top);
            this.m.set(rectF);
            RectF rectF5 = this.m;
            float f4 = rectF5.right;
            float f5 = this.a;
            rectF5.left = f4 - (f5 * 2.0f);
            rectF5.bottom = rectF5.top + (f5 * 2.0f);
            path.arcTo(rectF5, 270.0f, 90.0f);
            path.lineTo(rectF.right, rectF3.top);
            path.arcTo(rectF3, 270.0f, -180.0f);
            path.lineTo(rectF.right, rectF.bottom - this.a);
            this.m.set(rectF);
            RectF rectF6 = this.m;
            float f6 = rectF6.right;
            float f7 = this.a;
            rectF6.left = f6 - (f7 * 2.0f);
            rectF6.top = rectF6.bottom - (f7 * 2.0f);
            path.arcTo(rectF6, 0.0f, 90.0f);
            path.lineTo(rectF.left + this.a, rectF.bottom);
            this.m.set(rectF);
            RectF rectF7 = this.m;
            float f8 = rectF7.left;
            float f9 = this.a;
            rectF7.right = f8 + (f9 * 2.0f);
            rectF7.top = rectF7.bottom - (f9 * 2.0f);
            path.arcTo(rectF7, 90.0f, 90.0f);
            path.lineTo(rectF.left, rectF2.bottom);
            path.arcTo(rectF2, 90.0f, -180.0f);
            path.close();
        }
    }

    private void a(RectF rectF, RectF rectF2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, rectF, rectF2) == null) {
            rectF2.set(rectF);
            float f2 = rectF2.left;
            float f3 = this.f59700d;
            float f4 = f2 - f3;
            rectF2.left = f4;
            rectF2.right = f4 + (f3 * 2.0f);
            float height = rectF.height();
            float f5 = this.f59700d;
            float f6 = rectF2.top + ((height - (f5 * 2.0f)) / 2.0f);
            rectF2.top = f6;
            rectF2.bottom = f6 + (f5 * 2.0f);
        }
    }

    private void b(RectF rectF, RectF rectF2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, rectF, rectF2) == null) {
            rectF2.set(rectF);
            float f2 = rectF2.right;
            float f3 = this.f59700d;
            float f4 = f2 + f3;
            rectF2.right = f4;
            rectF2.left = f4 - (f3 * 2.0f);
            float height = rectF.height();
            float f5 = this.f59700d;
            float f6 = rectF2.top + ((height - (f5 * 2.0f)) / 2.0f);
            rectF2.top = f6;
            rectF2.bottom = f6 + (f5 * 2.0f);
        }
    }

    @Override // com.kwad.sdk.widget.b
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            int color = getResources().getColor(com.kwad.sdk.core.config.b.aM() ? R.color.ksad_reward_main_color : R.color.ksad_reward_main_color_orange);
            this.f59699c = color;
            setTextColor(color);
            a();
            invalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            this.f59702f.setEmpty();
            getDrawingRect(this.f59702f);
            float f2 = this.f59698b / 2.0f;
            this.f59703g.set(this.f59702f);
            RectF rectF = this.f59703g;
            rectF.left += f2;
            rectF.top += f2;
            rectF.right -= f2;
            rectF.bottom -= f2;
            a(rectF, this.f59704h);
            b(this.f59703g, this.f59705i);
            if (Build.VERSION.SDK_INT >= 19) {
                Path path = this.f59707k;
                if (path == null) {
                    this.f59707k = new Path();
                } else {
                    path.reset();
                }
                Path path2 = this.l;
                if (path2 == null) {
                    this.l = new Path();
                } else {
                    path2.reset();
                }
                a(this.f59706j, this.f59707k, this.l, this.f59703g, this.f59704h, this.f59705i);
            } else {
                a(this.f59706j, this.f59703g, this.f59704h, this.f59705i);
            }
            canvas.drawPath(this.f59706j, this.f59701e);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.n) {
                if (((float) (getPaddingLeft() + getPaddingRight())) + getPaint().measureText(getText().toString()) <= ((float) getMeasuredWidth())) {
                    return;
                }
                setVisibility(8);
            }
        }
    }
}
