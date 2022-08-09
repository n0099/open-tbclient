package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class BorderDrawable extends Drawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DRAW_STROKE_WIDTH_MULTIPLE = 1.3333f;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ColorStateList borderTint;
    @Dimension
    public float borderWidth;
    @ColorInt
    public int bottomInnerStrokeColor;
    @ColorInt
    public int bottomOuterStrokeColor;
    public final RectF boundsRectF;
    @ColorInt
    public int currentBorderTintColor;
    public boolean invalidateShader;
    @NonNull
    public final Paint paint;
    public final ShapeAppearancePathProvider pathProvider;
    public final Rect rect;
    public final RectF rectF;
    public ShapeAppearanceModel shapeAppearanceModel;
    public final Path shapePath;
    public final BorderState state;
    @ColorInt
    public int topInnerStrokeColor;
    @ColorInt
    public int topOuterStrokeColor;

    /* renamed from: com.google.android.material.floatingactionbutton.BorderDrawable$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class BorderState extends Drawable.ConstantState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BorderDrawable this$0;

        public BorderState(BorderDrawable borderDrawable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {borderDrawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = borderDrawable;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0 : (Drawable) invokeV.objValue;
        }

        public /* synthetic */ BorderState(BorderDrawable borderDrawable, AnonymousClass1 anonymousClass1) {
            this(borderDrawable);
        }
    }

    public BorderDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {shapeAppearanceModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pathProvider = new ShapeAppearancePathProvider();
        this.shapePath = new Path();
        this.rect = new Rect();
        this.rectF = new RectF();
        this.boundsRectF = new RectF();
        this.state = new BorderState(this, null);
        this.invalidateShader = true;
        this.shapeAppearanceModel = shapeAppearanceModel;
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    private Shader createGradientShader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            Rect rect = this.rect;
            copyBounds(rect);
            float height = this.borderWidth / rect.height();
            return new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{ColorUtils.compositeColors(this.topOuterStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(this.topInnerStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.topInnerStrokeColor, 0), this.currentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.bottomInnerStrokeColor, 0), this.currentBorderTintColor), ColorUtils.compositeColors(this.bottomInnerStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(this.bottomOuterStrokeColor, this.currentBorderTintColor)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
        }
        return (Shader) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.invalidateShader) {
                this.paint.setShader(createGradientShader());
                this.invalidateShader = false;
            }
            float strokeWidth = this.paint.getStrokeWidth() / 2.0f;
            copyBounds(this.rect);
            this.rectF.set(this.rect);
            float min = Math.min(this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF()), this.rectF.width() / 2.0f);
            if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF())) {
                this.rectF.inset(strokeWidth, strokeWidth);
                canvas.drawRoundRect(this.rectF, min, min, this.paint);
            }
        }
    }

    @NonNull
    public RectF getBoundsAsRectF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.boundsRectF.set(getBounds());
            return this.boundsRectF;
        }
        return (RectF) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.state : (Drawable.ConstantState) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.borderWidth > 0.0f ? -3 : -2 : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, outline) == null) {
            if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF())) {
                outline.setRoundRect(getBounds(), this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF()));
                return;
            }
            copyBounds(this.rect);
            this.rectF.set(this.rect);
            this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.rectF, this.shapePath);
            if (this.shapePath.isConvex()) {
                outline.setConvexPath(this.shapePath);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rect)) == null) {
            if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF())) {
                int round = Math.round(this.borderWidth);
                rect.set(round, round, round, round);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.shapeAppearanceModel : (ShapeAppearanceModel) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ColorStateList colorStateList = this.borderTint;
            return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rect) == null) {
            this.invalidateShader = true;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        int colorForState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, iArr)) == null) {
            ColorStateList colorStateList = this.borderTint;
            if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.currentBorderTintColor)) != this.currentBorderTintColor) {
                this.invalidateShader = true;
                this.currentBorderTintColor = colorForState;
            }
            if (this.invalidateShader) {
                invalidateSelf();
            }
            return this.invalidateShader;
        }
        return invokeL.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.paint.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setBorderTint(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, colorStateList) == null) {
            if (colorStateList != null) {
                this.currentBorderTintColor = colorStateList.getColorForState(getState(), this.currentBorderTintColor);
            }
            this.borderTint = colorStateList;
            this.invalidateShader = true;
            invalidateSelf();
        }
    }

    public void setBorderWidth(@Dimension float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048588, this, f) == null) || this.borderWidth == f) {
            return;
        }
        this.borderWidth = f;
        this.paint.setStrokeWidth(f * 1.3333f);
        this.invalidateShader = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, colorFilter) == null) {
            this.paint.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    public void setGradientColors(@ColorInt int i, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048590, this, i, i2, i3, i4) == null) {
            this.topOuterStrokeColor = i;
            this.topInnerStrokeColor = i2;
            this.bottomOuterStrokeColor = i3;
            this.bottomInnerStrokeColor = i4;
        }
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, shapeAppearanceModel) == null) {
            this.shapeAppearanceModel = shapeAppearanceModel;
            invalidateSelf();
        }
    }
}
