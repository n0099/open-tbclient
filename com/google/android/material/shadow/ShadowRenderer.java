package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class ShadowRenderer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COLOR_ALPHA_END = 0;
    public static final int COLOR_ALPHA_MIDDLE = 20;
    public static final int COLOR_ALPHA_START = 68;
    public static final int[] cornerColors;
    public static final float[] cornerPositions;
    public static final int[] edgeColors;
    public static final float[] edgePositions;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Paint cornerShadowPaint;
    @NonNull
    public final Paint edgeShadowPaint;
    public final Path scratch;
    public int shadowEndColor;
    public int shadowMiddleColor;
    @NonNull
    public final Paint shadowPaint;
    public int shadowStartColor;
    public Paint transparentPaint;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(71875477, "Lcom/google/android/material/shadow/ShadowRenderer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(71875477, "Lcom/google/android/material/shadow/ShadowRenderer;");
                return;
            }
        }
        edgeColors = new int[3];
        edgePositions = new float[]{0.0f, 0.5f, 1.0f};
        cornerColors = new int[4];
        cornerPositions = new float[]{0.0f, 0.0f, 0.5f, 1.0f};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShadowRenderer() {
        this(-16777216);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void drawCornerShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, matrix, rectF, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            boolean z = f2 < 0.0f;
            Path path = this.scratch;
            if (z) {
                int[] iArr = cornerColors;
                iArr[0] = 0;
                iArr[1] = this.shadowEndColor;
                iArr[2] = this.shadowMiddleColor;
                iArr[3] = this.shadowStartColor;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f, f2);
                path.close();
                float f3 = -i;
                rectF.inset(f3, f3);
                int[] iArr2 = cornerColors;
                iArr2[0] = 0;
                iArr2[1] = this.shadowStartColor;
                iArr2[2] = this.shadowMiddleColor;
                iArr2[3] = this.shadowEndColor;
            }
            float width = rectF.width() / 2.0f;
            if (width <= 0.0f) {
                return;
            }
            float f4 = 1.0f - (i / width);
            float[] fArr = cornerPositions;
            fArr[1] = f4;
            fArr[2] = ((1.0f - f4) / 2.0f) + f4;
            this.cornerShadowPaint.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, cornerColors, cornerPositions, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            if (!z) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
                canvas.drawPath(path, this.transparentPaint);
            }
            canvas.drawArc(rectF, f, f2, true, this.cornerShadowPaint);
            canvas.restore();
        }
    }

    public void drawEdgeShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, matrix, rectF, i) == null) {
            rectF.bottom += i;
            rectF.offset(0.0f, -i);
            int[] iArr = edgeColors;
            iArr[0] = this.shadowEndColor;
            iArr[1] = this.shadowMiddleColor;
            iArr[2] = this.shadowStartColor;
            Paint paint = this.edgeShadowPaint;
            float f = rectF.left;
            paint.setShader(new LinearGradient(f, rectF.top, f, rectF.bottom, edgeColors, edgePositions, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            canvas.drawRect(rectF, this.edgeShadowPaint);
            canvas.restore();
        }
    }

    @NonNull
    public Paint getShadowPaint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.shadowPaint : (Paint) invokeV.objValue;
    }

    public void setShadowColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.shadowStartColor = ColorUtils.setAlphaComponent(i, 68);
            this.shadowMiddleColor = ColorUtils.setAlphaComponent(i, 20);
            this.shadowEndColor = ColorUtils.setAlphaComponent(i, 0);
            this.shadowPaint.setColor(this.shadowStartColor);
        }
    }

    public ShadowRenderer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.scratch = new Path();
        this.transparentPaint = new Paint();
        this.shadowPaint = new Paint();
        setShadowColor(i);
        this.transparentPaint.setColor(0);
        Paint paint = new Paint(4);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.edgeShadowPaint = new Paint(this.cornerShadowPaint);
    }
}
