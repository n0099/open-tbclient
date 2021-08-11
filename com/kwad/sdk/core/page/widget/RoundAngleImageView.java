package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class RoundAngleImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Path f71726a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f71727b;

    /* renamed from: c  reason: collision with root package name */
    public RectF f71728c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundAngleImageView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f71726a = new Path();
        this.f71728c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            float[] fArr = this.f71727b;
            if (fArr == null || fArr.length != 8) {
                super.onDraw(canvas);
                return;
            }
            if (Build.VERSION.SDK_INT < 18) {
                setLayerType(1, null);
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float[] fArr2 = this.f71727b;
            float f2 = fArr2[1] + fArr2[7];
            this.f71726a.rewind();
            float f3 = measuredWidth;
            if (f3 >= fArr2[0] + fArr2[3]) {
                float f4 = measuredHeight;
                if (f4 > f2) {
                    this.f71728c.set(0.0f, 0.0f, f3, f4);
                    this.f71726a.addRoundRect(this.f71728c, this.f71727b, Path.Direction.CW);
                    canvas.clipPath(this.f71726a);
                }
            }
            super.onDraw(canvas);
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) != null) {
            return;
        }
        this.f71727b = new float[8];
        int i2 = 0;
        while (true) {
            float[] fArr = this.f71727b;
            if (i2 >= fArr.length) {
                return;
            }
            fArr[i2] = f2;
            i2++;
        }
    }

    public void setRadius(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fArr) != null) {
            return;
        }
        this.f71727b = new float[8];
        int i2 = 0;
        while (true) {
            float[] fArr2 = this.f71727b;
            if (i2 >= fArr2.length) {
                return;
            }
            fArr2[i2] = fArr[i2];
            i2++;
        }
    }
}
