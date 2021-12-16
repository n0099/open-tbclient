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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] a;

    /* renamed from: b  reason: collision with root package name */
    public float f60380b;

    /* renamed from: c  reason: collision with root package name */
    public Path f60381c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f60382d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f60383e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60384f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public a f60385g;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f60386b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f60387c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f60388d;

        public a() {
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
            this.a = true;
            this.f60386b = true;
            this.f60387c = true;
            this.f60388d = true;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a = z;
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.booleanValue;
        }

        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f60386b = z;
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60386b : invokeV.booleanValue;
        }

        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                this.f60387c = z;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f60387c : invokeV.booleanValue;
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
                this.f60388d = z;
            }
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f60388d : invokeV.booleanValue;
        }
    }

    public i() {
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
        this.a = new float[8];
        this.f60385g = new a();
    }

    public i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new float[8];
        this.f60385g = aVar == null ? new a() : aVar;
    }

    private float[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            this.a[0] = this.f60385g.a() ? this.f60380b : 0.0f;
            this.a[1] = this.f60385g.a() ? this.f60380b : 0.0f;
            this.a[2] = this.f60385g.b() ? this.f60380b : 0.0f;
            this.a[3] = this.f60385g.b() ? this.f60380b : 0.0f;
            this.a[4] = this.f60385g.c() ? this.f60380b : 0.0f;
            this.a[5] = this.f60385g.c() ? this.f60380b : 0.0f;
            this.a[6] = this.f60385g.d() ? this.f60380b : 0.0f;
            this.a[7] = this.f60385g.d() ? this.f60380b : 0.0f;
            return this.a;
        }
        return (float[]) invokeV.objValue;
    }

    private Path b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            try {
                this.f60381c.reset();
            } catch (Exception unused) {
            }
            this.f60381c.addRoundRect(this.f60383e, this.f60380b == 0.0f ? this.a : a(), Path.Direction.CW);
            return this.f60381c;
        }
        return (Path) invokeV.objValue;
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.f60380b = f2;
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.f60383e.set(0.0f, 0.0f, i2, i3);
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
                this.f60380b = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i2), 0);
                this.f60384f = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i3), true);
                obtainStyledAttributes.recycle();
            }
            this.f60381c = new Path();
            this.f60382d = new Paint(1);
            this.f60383e = new RectF();
            this.f60382d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
    }

    public void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) && this.f60384f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.f60383e, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(b());
        }
    }

    public void a(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fArr) == null) {
            this.a = fArr;
        }
    }

    public void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) && this.f60384f) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.f60382d);
            }
            canvas.restore();
        }
    }

    public void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.f60383e, null, 31);
                return;
            }
            canvas.save();
            canvas.clipPath(b());
        }
    }

    public void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(b(), this.f60382d);
            }
            canvas.restore();
        }
    }
}
