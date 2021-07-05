package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Paint f36766a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f36767b;

    /* renamed from: c  reason: collision with root package name */
    public int f36768c;

    /* renamed from: d  reason: collision with root package name */
    public int f36769d;

    /* renamed from: e  reason: collision with root package name */
    public int f36770e;

    /* renamed from: f  reason: collision with root package name */
    public int f36771f;

    /* renamed from: g  reason: collision with root package name */
    public int f36772g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f36773h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f36774i;

    /* renamed from: com.kwad.sdk.core.view.e$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f36775a;

        /* renamed from: b  reason: collision with root package name */
        public int f36776b;

        /* renamed from: c  reason: collision with root package name */
        public int f36777c;

        /* renamed from: d  reason: collision with root package name */
        public int f36778d;

        /* renamed from: e  reason: collision with root package name */
        public int f36779e;

        /* renamed from: f  reason: collision with root package name */
        public int f36780f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f36781g;

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
            this.f36775a = 1;
            this.f36776b = 12;
            this.f36777c = Color.parseColor("#4d000000");
            this.f36778d = 18;
            this.f36779e = 0;
            this.f36780f = 0;
            this.f36781g = r0;
            int[] iArr = {0};
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f36776b = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public e a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new e(this.f36775a, this.f36781g, this.f36776b, this.f36777c, this.f36778d, this.f36779e, this.f36780f, null) : (e) invokeV.objValue;
        }

        public a b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.f36777c = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f36778d = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f36779e = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.f36780f = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f36781g[0] = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    public e(int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), iArr, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36769d = i2;
        this.f36773h = iArr;
        this.f36770e = i3;
        this.f36768c = i5;
        this.f36771f = i6;
        this.f36772g = i7;
        Paint paint = new Paint();
        this.f36766a = paint;
        paint.setColor(0);
        this.f36766a.setAntiAlias(true);
        this.f36766a.setShadowLayer(i5, i6, i7, i4);
        this.f36766a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.f36767b = paint2;
        paint2.setAntiAlias(true);
    }

    public /* synthetic */ e(int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7, AnonymousClass1 anonymousClass1) {
        this(i2, iArr, i3, i4, i5, i6, i7);
    }

    public static void a(View view, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            e a2 = new a().f(i2).a(i3).b(i4).c(i5).d(i6).e(i7).a();
            view.setLayerType(1, null);
            view.setBackground(a2);
        }
    }

    public static void a(View view, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view, drawable) == null) {
            view.setLayerType(1, null);
            view.setBackground(drawable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int[] iArr = this.f36773h;
            if (iArr != null) {
                if (iArr.length == 1) {
                    this.f36767b.setColor(iArr[0]);
                } else {
                    Paint paint = this.f36767b;
                    RectF rectF = this.f36774i;
                    float f2 = rectF.left;
                    float height = rectF.height() / 2.0f;
                    RectF rectF2 = this.f36774i;
                    paint.setShader(new LinearGradient(f2, height, rectF2.right, rectF2.height() / 2.0f, this.f36773h, (float[]) null, Shader.TileMode.CLAMP));
                }
            }
            if (this.f36769d != 1) {
                canvas.drawCircle(this.f36774i.centerX(), this.f36774i.centerY(), Math.min(this.f36774i.width(), this.f36774i.height()) / 2.0f, this.f36766a);
                canvas.drawCircle(this.f36774i.centerX(), this.f36774i.centerY(), Math.min(this.f36774i.width(), this.f36774i.height()) / 2.0f, this.f36767b);
                return;
            }
            RectF rectF3 = this.f36774i;
            int i2 = this.f36770e;
            canvas.drawRoundRect(rectF3, i2, i2, this.f36766a);
            RectF rectF4 = this.f36774i;
            int i3 = this.f36770e;
            canvas.drawRoundRect(rectF4, i3, i3, this.f36767b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f36766a.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            super.setBounds(i2, i3, i4, i5);
            int i6 = this.f36768c;
            int i7 = this.f36771f;
            int i8 = this.f36772g;
            this.f36774i = new RectF((i2 + i6) - i7, (i3 + i6) - i8, (i4 - i6) - i7, (i5 - i6) - i8);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, colorFilter) == null) {
            this.f36766a.setColorFilter(colorFilter);
        }
    }
}
