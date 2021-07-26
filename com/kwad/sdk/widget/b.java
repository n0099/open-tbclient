package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float[] f36857a;

    /* renamed from: b  reason: collision with root package name */
    public float f36858b;

    /* renamed from: c  reason: collision with root package name */
    public Path f36859c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f36860d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f36861e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36862f;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36857a = new float[8];
    }

    private float[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            float[] fArr = this.f36857a;
            float f2 = this.f36858b;
            fArr[0] = f2;
            fArr[1] = f2;
            fArr[2] = f2;
            fArr[3] = f2;
            fArr[4] = f2;
            fArr[5] = f2;
            fArr[6] = f2;
            fArr[7] = f2;
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }

    private Path b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                this.f36859c.reset();
            } catch (Exception unused) {
            }
            this.f36859c.addRoundRect(this.f36861e, a(), Path.Direction.CW);
            return this.f36859c;
        }
        return (Path) invokeV.objValue;
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.f36858b = f2;
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.f36861e.set(0.0f, 0.0f, i2, i3);
        }
    }

    public void a(Context context, @Nullable AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) {
            if (attributeSet != null) {
                int i2 = R.attr.ksad_radius;
                int i3 = R.attr.ksad_clipBackground;
                int[] iArr = {i2, i3};
                Arrays.sort(iArr);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
                this.f36858b = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i2), 0);
                this.f36862f = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i3), true);
                obtainStyledAttributes.recycle();
            }
            this.f36859c = new Path();
            this.f36860d = new Paint(1);
            this.f36861e = new RectF();
            this.f36860d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) && this.f36862f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.f36861e, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(b());
        }
    }

    public void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) && this.f36862f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.f36860d);
            }
            canvas.restore();
        }
    }

    public void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.f36861e, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(b());
        }
    }

    public void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.f36860d);
            }
            canvas.restore();
        }
    }
}
