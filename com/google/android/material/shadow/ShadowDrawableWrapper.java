package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes8.dex */
public class ShadowDrawableWrapper extends DrawableWrapper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final double COS_45;
    public static final float SHADOW_BOTTOM_SCALE = 1.0f;
    public static final float SHADOW_HORIZ_SCALE = 0.5f;
    public static final float SHADOW_MULTIPLIER = 1.5f;
    public static final float SHADOW_TOP_SCALE = 0.25f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean addPaddingForCorners;
    @NonNull
    public final RectF contentBounds;
    public float cornerRadius;
    @NonNull
    public final Paint cornerShadowPaint;
    public Path cornerShadowPath;
    public boolean dirty;
    @NonNull
    public final Paint edgeShadowPaint;
    public float maxShadowSize;
    public boolean printedShadowClipWarning;
    public float rawMaxShadowSize;
    public float rawShadowSize;
    public float rotation;
    public final int shadowEndColor;
    public final int shadowMiddleColor;
    public float shadowSize;
    public final int shadowStartColor;

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-760130967, "Lcom/google/android/material/shadow/ShadowDrawableWrapper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-760130967, "Lcom/google/android/material/shadow/ShadowDrawableWrapper;");
                return;
            }
        }
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    public float getCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.cornerRadius;
        }
        return invokeV.floatValue;
    }

    public float getMaxShadowSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.rawMaxShadowSize;
        }
        return invokeV.floatValue;
    }

    public float getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            float f = this.rawMaxShadowSize;
            return (Math.max(f, this.cornerRadius + ((f * 1.5f) / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 1.5f * 2.0f);
        }
        return invokeV.floatValue;
    }

    public float getMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float f = this.rawMaxShadowSize;
            return (Math.max(f, this.cornerRadius + (f / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 2.0f);
        }
        return invokeV.floatValue;
    }

    public float getShadowSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.rawShadowSize;
        }
        return invokeV.floatValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShadowDrawableWrapper(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, drawable, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Drawable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.dirty = true;
        this.addPaddingForCorners = true;
        this.printedShadowClipWarning = false;
        this.shadowStartColor = ContextCompat.getColor(context, R.color.obfuscated_res_0x7f06071f);
        this.shadowMiddleColor = ContextCompat.getColor(context, R.color.obfuscated_res_0x7f06071e);
        this.shadowEndColor = ContextCompat.getColor(context, R.color.obfuscated_res_0x7f06071d);
        Paint paint = new Paint(5);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.cornerRadius = Math.round(f);
        this.contentBounds = new RectF();
        Paint paint2 = new Paint(this.cornerShadowPaint);
        this.edgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f2, f3);
    }

    private void buildComponents(@NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, rect) == null) {
            float f = this.rawMaxShadowSize;
            float f2 = 1.5f * f;
            this.contentBounds.set(rect.left + f, rect.top + f2, rect.right - f, rect.bottom - f2);
            Drawable wrappedDrawable = getWrappedDrawable();
            RectF rectF = this.contentBounds;
            wrappedDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            buildShadowCorners();
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rect)) == null) {
            int ceil = (int) Math.ceil(calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
            int ceil2 = (int) Math.ceil(calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
            rect.set(ceil2, ceil, ceil2, ceil);
            return true;
        }
        return invokeL.booleanValue;
    }

    private void buildShadowCorners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            float f = this.cornerRadius;
            RectF rectF = new RectF(-f, -f, f, f);
            RectF rectF2 = new RectF(rectF);
            float f2 = this.shadowSize;
            rectF2.inset(-f2, -f2);
            Path path = this.cornerShadowPath;
            if (path == null) {
                this.cornerShadowPath = new Path();
            } else {
                path.reset();
            }
            this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
            this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
            this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
            this.cornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
            this.cornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
            this.cornerShadowPath.close();
            float f3 = -rectF2.top;
            if (f3 > 0.0f) {
                float f4 = this.cornerRadius / f3;
                this.cornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, f4, ((1.0f - f4) / 2.0f) + f4, 1.0f}, Shader.TileMode.CLAMP));
            }
            this.edgeShadowPaint.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            this.edgeShadowPaint.setAntiAlias(false);
        }
    }

    public static float calculateHorizontalPadding(float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return (float) (f + ((1.0d - COS_45) * f2));
            }
            return f;
        }
        return invokeCommon.floatValue;
    }

    public static float calculateVerticalPadding(float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return (float) ((f * 1.5f) + ((1.0d - COS_45) * f2));
            }
            return f * 1.5f;
        }
        return invokeCommon.floatValue;
    }

    private void drawShadow(@NonNull Canvas canvas) {
        boolean z;
        boolean z2;
        int i;
        float f;
        int i2;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, canvas) == null) {
            int save = canvas.save();
            canvas.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
            float f5 = this.cornerRadius;
            float f6 = (-f5) - this.shadowSize;
            float f7 = f5 * 2.0f;
            if (this.contentBounds.width() - f7 > 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (this.contentBounds.height() - f7 > 0.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            float f8 = this.rawShadowSize;
            float f9 = f5 / ((f8 - (0.5f * f8)) + f5);
            float f10 = f5 / ((f8 - (0.25f * f8)) + f5);
            float f11 = f5 / ((f8 - (f8 * 1.0f)) + f5);
            int save2 = canvas.save();
            RectF rectF = this.contentBounds;
            canvas.translate(rectF.left + f5, rectF.top + f5);
            canvas.scale(f9, f10);
            canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
            if (z) {
                canvas.scale(1.0f / f9, 1.0f);
                i = save2;
                f = f11;
                i2 = save;
                f2 = f10;
                canvas.drawRect(0.0f, f6, this.contentBounds.width() - f7, -this.cornerRadius, this.edgeShadowPaint);
            } else {
                i = save2;
                f = f11;
                i2 = save;
                f2 = f10;
            }
            canvas.restoreToCount(i);
            int save3 = canvas.save();
            RectF rectF2 = this.contentBounds;
            canvas.translate(rectF2.right - f5, rectF2.bottom - f5);
            float f12 = f;
            canvas.scale(f9, f12);
            canvas.rotate(180.0f);
            canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
            if (z) {
                canvas.scale(1.0f / f9, 1.0f);
                f3 = f2;
                f4 = f12;
                canvas.drawRect(0.0f, f6, this.contentBounds.width() - f7, (-this.cornerRadius) + this.shadowSize, this.edgeShadowPaint);
            } else {
                f3 = f2;
                f4 = f12;
            }
            canvas.restoreToCount(save3);
            int save4 = canvas.save();
            RectF rectF3 = this.contentBounds;
            canvas.translate(rectF3.left + f5, rectF3.bottom - f5);
            canvas.scale(f9, f4);
            canvas.rotate(270.0f);
            canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
            if (z2) {
                canvas.scale(1.0f / f4, 1.0f);
                canvas.drawRect(0.0f, f6, this.contentBounds.height() - f7, -this.cornerRadius, this.edgeShadowPaint);
            }
            canvas.restoreToCount(save4);
            int save5 = canvas.save();
            RectF rectF4 = this.contentBounds;
            canvas.translate(rectF4.right - f5, rectF4.top + f5);
            float f13 = f3;
            canvas.scale(f9, f13);
            canvas.rotate(90.0f);
            canvas.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
            if (z2) {
                canvas.scale(1.0f / f13, 1.0f);
                canvas.drawRect(0.0f, f6, this.contentBounds.height() - f7, -this.cornerRadius, this.edgeShadowPaint);
            }
            canvas.restoreToCount(save5);
            canvas.restoreToCount(i2);
        }
    }

    public static int toEven(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65543, null, f)) == null) {
            int round = Math.round(f);
            if (round % 2 == 1) {
                return round - 1;
            }
            return round;
        }
        return invokeF.intValue;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.dirty) {
                buildComponents(getBounds());
                this.dirty = false;
            }
            drawShadow(canvas);
            super.draw(canvas);
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rect) == null) {
            this.dirty = true;
        }
    }

    public void setAddPaddingForCorners(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.addPaddingForCorners = z;
            invalidateSelf();
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.setAlpha(i);
            this.cornerShadowPaint.setAlpha(i);
            this.edgeShadowPaint.setAlpha(i);
        }
    }

    public void setCornerRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f) == null) {
            float round = Math.round(f);
            if (this.cornerRadius == round) {
                return;
            }
            this.cornerRadius = round;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public void setMaxShadowSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f) == null) {
            setShadowSize(this.rawShadowSize, f);
        }
    }

    public final void setRotation(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048589, this, f) == null) && this.rotation != f) {
            this.rotation = f;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
            setShadowSize(f, this.rawMaxShadowSize);
        }
    }

    public void setShadowSize(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            if (f >= 0.0f && f2 >= 0.0f) {
                float even = toEven(f);
                float even2 = toEven(f2);
                if (even > even2) {
                    if (!this.printedShadowClipWarning) {
                        this.printedShadowClipWarning = true;
                    }
                    even = even2;
                }
                if (this.rawShadowSize == even && this.rawMaxShadowSize == even2) {
                    return;
                }
                this.rawShadowSize = even;
                this.rawMaxShadowSize = even2;
                this.shadowSize = Math.round(even * 1.5f);
                this.maxShadowSize = even2;
                this.dirty = true;
                invalidateSelf();
                return;
            }
            throw new IllegalArgumentException("invalid shadow size");
        }
    }
}
