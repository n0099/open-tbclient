package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ClipImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f68871a;

    /* renamed from: b  reason: collision with root package name */
    public Path f68872b;

    /* renamed from: c  reason: collision with root package name */
    public RectF f68873c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f68874d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f68875e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipImageView(Context context) {
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
        this.f68871a = true;
        a(context);
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f68872b = new Path();
            this.f68873c = new RectF();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            if (this.f68871a) {
                this.f68872b.reset();
                this.f68873c.set(0.0f, 0.0f, getWidth(), getHeight());
                float[] fArr = this.f68875e;
                if (fArr != null) {
                    this.f68872b.addRoundRect(this.f68873c, fArr, Path.Direction.CW);
                }
                canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
                canvas.clipPath(this.f68872b);
                Paint paint = this.f68874d;
                if (paint != null) {
                    canvas.drawPath(this.f68872b, paint);
                }
            }
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            Paint paint = new Paint(1);
            this.f68874d = paint;
            paint.setStyle(Paint.Style.FILL);
            this.f68874d.setColor(i2);
        }
    }

    public void setClip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f68871a = z;
        }
    }

    public void setRadius(float[] fArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, fArr) == null) && fArr != null && fArr.length == 8) {
            this.f68875e = fArr;
        }
    }

    public void setRoundRadius(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || i2 <= 0) {
            return;
        }
        float f2 = i2;
        setRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipImageView(Context context, AttributeSet attributeSet) {
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
        this.f68871a = true;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipImageView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f68871a = true;
        a(context);
    }
}
