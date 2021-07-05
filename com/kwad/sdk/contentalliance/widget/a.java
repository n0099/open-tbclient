package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.load.h;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class a implements h<Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.e f35855b;

    /* renamed from: c  reason: collision with root package name */
    public int f35856c;

    /* renamed from: d  reason: collision with root package name */
    public int f35857d;

    /* renamed from: e  reason: collision with root package name */
    public int f35858e;

    /* renamed from: f  reason: collision with root package name */
    public int f35859f;

    /* renamed from: g  reason: collision with root package name */
    public int f35860g;

    public a(Context context, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35855b = com.kwad.sdk.glide.c.a(context).a();
        this.f35856c = i2;
        this.f35857d = i3;
        this.f35859f = i5;
        this.f35858e = i4;
        this.f35860g = i6;
    }

    private void a(Canvas canvas, Paint paint, float f2, float f3, Paint paint2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{canvas, paint, Float.valueOf(f2), Float.valueOf(f3), paint2}) == null) {
            int i2 = this.f35857d;
            float f4 = f2 - i2;
            float f5 = f3 - i2;
            float f6 = this.f35858e / 2;
            Path path = new Path();
            float[] fArr = new float[8];
            int i3 = this.f35860g;
            for (int i4 = 3; i4 >= 0; i4--) {
                int i5 = i4 * 2;
                int i6 = i3 & 1;
                float f7 = 0.0f;
                fArr[i5 + 1] = i6 > 0 ? this.f35856c : 0.0f;
                if (i6 > 0) {
                    f7 = this.f35856c;
                }
                fArr[i5] = f7;
                i3 >>= 1;
            }
            int i7 = this.f35857d;
            path.addRoundRect(new RectF(i7 + f6, i7 + f6, f4 - f6, f5 - f6), fArr, Path.Direction.CW);
            canvas.drawPath(path, paint);
            canvas.drawPath(path, paint2);
        }
    }

    @Override // com.kwad.sdk.glide.load.h
    @NonNull
    public s<Bitmap> a(@NonNull Context context, @NonNull s<Bitmap> sVar, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, context, sVar, i2, i3)) == null) {
            Bitmap e2 = sVar.e();
            int width = e2.getWidth();
            int height = e2.getHeight();
            Bitmap a2 = this.f35855b.a(width, height, Bitmap.Config.ARGB_8888);
            if (a2 == null) {
                a2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(a2);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(e2, tileMode, tileMode));
            Paint paint2 = new Paint(1);
            paint2.setColor(this.f35859f);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(this.f35858e);
            a(canvas, paint, width, height, paint2);
            return com.kwad.sdk.glide.load.resource.bitmap.d.a(a2, this.f35855b);
        }
        return (s) invokeLLII.objValue;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageDigest) == null) {
        }
    }
}
