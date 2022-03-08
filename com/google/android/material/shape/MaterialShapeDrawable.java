package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
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
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    public static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    public static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    public static final String TAG;
    public static final Paint clearPaint;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitSet containsIncompatibleShadowOp;
    public final ShapePath.ShadowCompatOperation[] cornerShadowOperation;
    public MaterialShapeDrawableState drawableState;
    public final ShapePath.ShadowCompatOperation[] edgeShadowOperation;
    public final Paint fillPaint;
    public final RectF insetRectF;
    public final Matrix matrix;
    public final Path path;
    @NonNull
    public final RectF pathBounds;
    public boolean pathDirty;
    public final Path pathInsetByStroke;
    public final ShapeAppearancePathProvider pathProvider;
    @NonNull
    public final ShapeAppearancePathProvider.PathListener pathShadowListener;
    public final RectF rectF;
    public final Region scratchRegion;
    public boolean shadowBitmapDrawingEnable;
    public final ShadowRenderer shadowRenderer;
    public final Paint strokePaint;
    public ShapeAppearanceModel strokeShapeAppearance;
    @Nullable
    public PorterDuffColorFilter strokeTintFilter;
    @Nullable
    public PorterDuffColorFilter tintFilter;
    public final Region transparentRegion;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface CompatibilityShadowMode {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1042519837, "Lcom/google/android/material/shape/MaterialShapeDrawable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1042519837, "Lcom/google/android/material/shape/MaterialShapeDrawable;");
                return;
            }
        }
        TAG = MaterialShapeDrawable.class.getSimpleName();
        clearPaint = new Paint(1);
    }

    @Nullable
    private PorterDuffColorFilter calculatePaintColorTintFilter(@NonNull Paint paint, boolean z) {
        InterceptResult invokeLZ;
        int color;
        int compositeElevationOverlayIfNeeded;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, this, paint, z)) == null) {
            if (!z || (compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded((color = paint.getColor()))) == color) {
                return null;
            }
            return new PorterDuffColorFilter(compositeElevationOverlayIfNeeded, PorterDuff.Mode.SRC_IN);
        }
        return (PorterDuffColorFilter) invokeLZ.objValue;
    }

    private void calculatePath(@NonNull RectF rectF, @NonNull Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, rectF, path) == null) {
            calculatePathForSize(rectF, path);
            if (this.drawableState.scale != 1.0f) {
                this.matrix.reset();
                Matrix matrix = this.matrix;
                float f2 = this.drawableState.scale;
                matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
                path.transform(this.matrix);
            }
            path.computeBounds(this.pathBounds, true);
        }
    }

    private void calculateStrokePath() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            ShapeAppearanceModel withTransformedCornerSizes = getShapeAppearanceModel().withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator(this, -getStrokeInsetLength()) { // from class: com.google.android.material.shape.MaterialShapeDrawable.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MaterialShapeDrawable this$0;
                public final /* synthetic */ float val$strokeInsetLength;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Float.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$strokeInsetLength = r7;
                }

                @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
                @NonNull
                public CornerSize apply(@NonNull CornerSize cornerSize) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cornerSize)) == null) ? cornerSize instanceof RelativeCornerSize ? cornerSize : new AdjustedCornerSize(this.val$strokeInsetLength, cornerSize) : (CornerSize) invokeL.objValue;
                }
            });
            this.strokeShapeAppearance = withTransformedCornerSizes;
            this.pathProvider.calculatePath(withTransformedCornerSizes, this.drawableState.interpolation, getBoundsInsetByStroke(), this.pathInsetByStroke);
        }
    }

    @NonNull
    private PorterDuffColorFilter calculateTintColorTintFilter(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65550, this, colorStateList, mode, z)) == null) {
            int colorForState = colorStateList.getColorForState(getState(), 0);
            if (z) {
                colorForState = compositeElevationOverlayIfNeeded(colorForState);
            }
            return new PorterDuffColorFilter(colorForState, mode);
        }
        return (PorterDuffColorFilter) invokeLLZ.objValue;
    }

    @NonNull
    private PorterDuffColorFilter calculateTintFilter(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, this, new Object[]{colorStateList, mode, paint, Boolean.valueOf(z)})) == null) {
            if (colorStateList != null && mode != null) {
                return calculateTintColorTintFilter(colorStateList, mode, z);
            }
            return calculatePaintColorTintFilter(paint, z);
        }
        return (PorterDuffColorFilter) invokeCommon.objValue;
    }

    @ColorInt
    private int compositeElevationOverlayIfNeeded(@ColorInt int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, this, i2)) == null) {
            float z = getZ() + getParentAbsoluteElevation();
            ElevationOverlayProvider elevationOverlayProvider = this.drawableState.elevationOverlayProvider;
            return elevationOverlayProvider != null ? elevationOverlayProvider.compositeOverlayIfNeeded(i2, z) : i2;
        }
        return invokeI.intValue;
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) ? createWithElevationOverlay(context, 0.0f) : (MaterialShapeDrawable) invokeL.objValue;
    }

    private void drawCompatShadow(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, canvas) == null) {
            this.containsIncompatibleShadowOp.cardinality();
            if (this.drawableState.shadowCompatOffset != 0) {
                canvas.drawPath(this.path, this.shadowRenderer.getShadowPaint());
            }
            for (int i2 = 0; i2 < 4; i2++) {
                this.cornerShadowOperation[i2].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
                this.edgeShadowOperation[i2].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
            }
            if (this.shadowBitmapDrawingEnable) {
                int shadowOffsetX = getShadowOffsetX();
                int shadowOffsetY = getShadowOffsetY();
                canvas.translate(-shadowOffsetX, -shadowOffsetY);
                canvas.drawPath(this.path, clearPaint);
                canvas.translate(shadowOffsetX, shadowOffsetY);
            }
        }
    }

    private void drawFillShape(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, canvas) == null) {
            drawShape(canvas, this.fillPaint, this.path, this.drawableState.shapeAppearanceModel, getBoundsAsRectF());
        }
    }

    private void drawStrokeShape(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, canvas) == null) {
            drawShape(canvas, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
        }
    }

    @NonNull
    private RectF getBoundsInsetByStroke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            this.insetRectF.set(getBoundsAsRectF());
            float strokeInsetLength = getStrokeInsetLength();
            this.insetRectF.inset(strokeInsetLength, strokeInsetLength);
            return this.insetRectF;
        }
        return (RectF) invokeV.objValue;
    }

    private float getStrokeInsetLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            if (hasStroke()) {
                return this.strokePaint.getStrokeWidth() / 2.0f;
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    private boolean hasCompatShadow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            int i2 = materialShapeDrawableState.shadowCompatMode;
            return i2 != 1 && materialShapeDrawableState.shadowCompatRadius > 0 && (i2 == 2 || requiresCompatShadow());
        }
        return invokeV.booleanValue;
    }

    private boolean hasFill() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            Paint.Style style = this.drawableState.paintStyle;
            return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
        }
        return invokeV.booleanValue;
    }

    private boolean hasStroke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            Paint.Style style = this.drawableState.paintStyle;
            return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f;
        }
        return invokeV.booleanValue;
    }

    private void invalidateSelfIgnoreShape() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            super.invalidateSelf();
        }
    }

    private void maybeDrawCompatShadow(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65565, this, canvas) == null) && hasCompatShadow()) {
            canvas.save();
            prepareCanvasForShadow(canvas);
            if (!this.shadowBitmapDrawingEnable) {
                drawCompatShadow(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.pathBounds.width() - getBounds().width());
            int height = (int) (this.pathBounds.height() - getBounds().height());
            if (width >= 0 && height >= 0) {
                Bitmap createBitmap = Bitmap.createBitmap(((int) this.pathBounds.width()) + (this.drawableState.shadowCompatRadius * 2) + width, ((int) this.pathBounds.height()) + (this.drawableState.shadowCompatRadius * 2) + height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f2 = (getBounds().left - this.drawableState.shadowCompatRadius) - width;
                float f3 = (getBounds().top - this.drawableState.shadowCompatRadius) - height;
                canvas2.translate(-f2, -f3);
                drawCompatShadow(canvas2);
                canvas.drawBitmap(createBitmap, f2, f3, (Paint) null);
                createBitmap.recycle();
                canvas.restore();
                return;
            }
            throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
        }
    }

    public static int modulateAlpha(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65566, null, i2, i3)) == null) ? (i2 * (i3 + (i3 >>> 7))) >>> 8 : invokeII.intValue;
    }

    private void prepareCanvasForShadow(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, canvas) == null) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            if (Build.VERSION.SDK_INT < 21 && this.shadowBitmapDrawingEnable) {
                Rect clipBounds = canvas.getClipBounds();
                int i2 = this.drawableState.shadowCompatRadius;
                clipBounds.inset(-i2, -i2);
                clipBounds.offset(shadowOffsetX, shadowOffsetY);
                canvas.clipRect(clipBounds, Region.Op.REPLACE);
            }
            canvas.translate(shadowOffsetX, shadowOffsetY);
        }
    }

    private boolean updateColorsForState(int[] iArr) {
        InterceptResult invokeL;
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, this, iArr)) == null) {
            if (this.drawableState.fillColor == null || color2 == (colorForState2 = this.drawableState.fillColor.getColorForState(iArr, (color2 = this.fillPaint.getColor())))) {
                z = false;
            } else {
                this.fillPaint.setColor(colorForState2);
                z = true;
            }
            if (this.drawableState.strokeColor == null || color == (colorForState = this.drawableState.strokeColor.getColorForState(iArr, (color = this.strokePaint.getColor())))) {
                return z;
            }
            this.strokePaint.setColor(colorForState);
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean updateTintFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
            PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            this.tintFilter = calculateTintFilter(materialShapeDrawableState.tintList, materialShapeDrawableState.tintMode, this.fillPaint, true);
            MaterialShapeDrawableState materialShapeDrawableState2 = this.drawableState;
            this.strokeTintFilter = calculateTintFilter(materialShapeDrawableState2.strokeTintList, materialShapeDrawableState2.tintMode, this.strokePaint, false);
            MaterialShapeDrawableState materialShapeDrawableState3 = this.drawableState;
            if (materialShapeDrawableState3.useTintColorForShadow) {
                this.shadowRenderer.setShadowColor(materialShapeDrawableState3.tintList.getColorForState(getState(), 0));
            }
            return (ObjectsCompat.equals(porterDuffColorFilter, this.tintFilter) && ObjectsCompat.equals(porterDuffColorFilter2, this.strokeTintFilter)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void updateZ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            float z = getZ();
            this.drawableState.shadowCompatRadius = (int) Math.ceil(0.75f * z);
            this.drawableState.shadowCompatOffset = (int) Math.ceil(z * 0.25f);
            updateTintFilter();
            invalidateSelfIgnoreShape();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void calculatePathForSize(@NonNull RectF rectF, @NonNull Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, rectF, path) == null) {
            ShapeAppearancePathProvider shapeAppearancePathProvider = this.pathProvider;
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            shapeAppearancePathProvider.calculatePath(materialShapeDrawableState.shapeAppearanceModel, materialShapeDrawableState.interpolation, rectF, this.pathShadowListener, path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.fillPaint.setColorFilter(this.tintFilter);
            int alpha = this.fillPaint.getAlpha();
            this.fillPaint.setAlpha(modulateAlpha(alpha, this.drawableState.alpha));
            this.strokePaint.setColorFilter(this.strokeTintFilter);
            this.strokePaint.setStrokeWidth(this.drawableState.strokeWidth);
            int alpha2 = this.strokePaint.getAlpha();
            this.strokePaint.setAlpha(modulateAlpha(alpha2, this.drawableState.alpha));
            if (this.pathDirty) {
                calculateStrokePath();
                calculatePath(getBoundsAsRectF(), this.path);
                this.pathDirty = false;
            }
            maybeDrawCompatShadow(canvas);
            if (hasFill()) {
                drawFillShape(canvas);
            }
            if (hasStroke()) {
                drawStrokeShape(canvas);
            }
            this.fillPaint.setAlpha(alpha);
            this.strokePaint.setAlpha(alpha2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void drawShape(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, canvas, paint, path, rectF) == null) {
            drawShape(canvas, paint, path, this.drawableState.shapeAppearanceModel, rectF);
        }
    }

    public float getBottomLeftCornerResolvedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.drawableState.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(getBoundsAsRectF()) : invokeV.floatValue;
    }

    public float getBottomRightCornerResolvedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.drawableState.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(getBoundsAsRectF()) : invokeV.floatValue;
    }

    @NonNull
    public RectF getBoundsAsRectF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.rectF.set(getBounds());
            return this.rectF;
        }
        return (RectF) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.drawableState : (Drawable.ConstantState) invokeV.objValue;
    }

    public float getElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.drawableState.elevation : invokeV.floatValue;
    }

    @Nullable
    public ColorStateList getFillColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.drawableState.fillColor : (ColorStateList) invokeV.objValue;
    }

    public float getInterpolation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.drawableState.interpolation : invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, outline) == null) || this.drawableState.shadowCompatMode == 2) {
            return;
        }
        if (isRoundRect()) {
            outline.setRoundRect(getBounds(), getTopLeftCornerResolvedSize() * this.drawableState.interpolation);
            return;
        }
        calculatePath(getBoundsAsRectF(), this.path);
        if (this.path.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.path);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, rect)) == null) {
            Rect rect2 = this.drawableState.padding;
            if (rect2 != null) {
                rect.set(rect2);
                return true;
            }
            return super.getPadding(rect);
        }
        return invokeL.booleanValue;
    }

    public Paint.Style getPaintStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.drawableState.paintStyle : (Paint.Style) invokeV.objValue;
    }

    public float getParentAbsoluteElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.drawableState.parentAbsoluteElevation : invokeV.floatValue;
    }

    @Deprecated
    public void getPathForSize(int i2, int i3, @NonNull Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048591, this, i2, i3, path) == null) {
            calculatePathForSize(new RectF(0.0f, 0.0f, i2, i3), path);
        }
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.drawableState.scale : invokeV.floatValue;
    }

    public int getShadowCompatRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.drawableState.shadowCompatRotation : invokeV.intValue;
    }

    public int getShadowCompatibilityMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.drawableState.shadowCompatMode : invokeV.intValue;
    }

    @Deprecated
    public int getShadowElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (int) getElevation() : invokeV.intValue;
    }

    public int getShadowOffsetX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            return (int) (materialShapeDrawableState.shadowCompatOffset * Math.sin(Math.toRadians(materialShapeDrawableState.shadowCompatRotation)));
        }
        return invokeV.intValue;
    }

    public int getShadowOffsetY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            return (int) (materialShapeDrawableState.shadowCompatOffset * Math.cos(Math.toRadians(materialShapeDrawableState.shadowCompatRotation)));
        }
        return invokeV.intValue;
    }

    public int getShadowRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.drawableState.shadowCompatRadius : invokeV.intValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getShadowVerticalOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.drawableState.shadowCompatOffset : invokeV.intValue;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.drawableState.shapeAppearanceModel : (ShapeAppearanceModel) invokeV.objValue;
    }

    @Nullable
    @Deprecated
    public ShapePathModel getShapedViewModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel();
            if (shapeAppearanceModel instanceof ShapePathModel) {
                return (ShapePathModel) shapeAppearanceModel;
            }
            return null;
        }
        return (ShapePathModel) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.drawableState.strokeColor : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getStrokeTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.drawableState.strokeTintList : (ColorStateList) invokeV.objValue;
    }

    public float getStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.drawableState.strokeWidth : invokeV.floatValue;
    }

    @Nullable
    public ColorStateList getTintList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.drawableState.tintList : (ColorStateList) invokeV.objValue;
    }

    public float getTopLeftCornerResolvedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.drawableState.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF()) : invokeV.floatValue;
    }

    public float getTopRightCornerResolvedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.drawableState.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(getBoundsAsRectF()) : invokeV.floatValue;
    }

    public float getTranslationZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.drawableState.translationZ : invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            this.transparentRegion.set(getBounds());
            calculatePath(getBoundsAsRectF(), this.path);
            this.scratchRegion.setPath(this.path, this.transparentRegion);
            this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
            return this.transparentRegion;
        }
        return (Region) invokeV.objValue;
    }

    public float getZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? getElevation() + getTranslationZ() : invokeV.floatValue;
    }

    public void initializeElevationOverlay(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, context) == null) {
            this.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context);
            updateZ();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.pathDirty = true;
            super.invalidateSelf();
        }
    }

    public boolean isElevationOverlayEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            ElevationOverlayProvider elevationOverlayProvider = this.drawableState.elevationOverlayProvider;
            return elevationOverlayProvider != null && elevationOverlayProvider.isThemeElevationOverlayEnabled();
        }
        return invokeV.booleanValue;
    }

    public boolean isElevationOverlayInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.drawableState.elevationOverlayProvider != null : invokeV.booleanValue;
    }

    public boolean isPointInTransparentRegion(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048615, this, i2, i3)) == null) ? getTransparentRegion().contains(i2, i3) : invokeII.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.drawableState.shapeAppearanceModel.isRoundRect(getBoundsAsRectF()) : invokeV.booleanValue;
    }

    @Deprecated
    public boolean isShadowEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            int i2 = this.drawableState.shadowCompatMode;
            return i2 == 0 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? super.isStateful() || ((colorStateList = this.drawableState.tintList) != null && colorStateList.isStateful()) || (((colorStateList2 = this.drawableState.strokeTintList) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.drawableState.strokeColor) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.drawableState.fillColor) != null && colorStateList4.isStateful()))) : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            this.drawableState = new MaterialShapeDrawableState(this.drawableState);
            return this;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, rect) == null) {
            this.pathDirty = true;
            super.onBoundsChange(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, iArr)) == null) {
            boolean z = updateColorsForState(iArr) || updateTintFilter();
            if (z) {
                invalidateSelf();
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean requiresCompatShadow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? Build.VERSION.SDK_INT < 21 || !(isRoundRect() || this.path.isConvex() || Build.VERSION.SDK_INT >= 29) : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.alpha != i2) {
                materialShapeDrawableState.alpha = i2;
                invalidateSelfIgnoreShape();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, colorFilter) == null) {
            this.drawableState.colorFilter = colorFilter;
            invalidateSelfIgnoreShape();
        }
    }

    public void setCornerSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048625, this, f2) == null) {
            setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(f2));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEdgeIntersectionCheckEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.pathProvider.setEdgeIntersectionCheckEnable(z);
        }
    }

    public void setElevation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048628, this, f2) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.elevation != f2) {
                materialShapeDrawableState.elevation = f2;
                updateZ();
            }
        }
    }

    public void setFillColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, colorStateList) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.fillColor != colorStateList) {
                materialShapeDrawableState.fillColor = colorStateList;
                onStateChange(getState());
            }
        }
    }

    public void setInterpolation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048630, this, f2) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.interpolation != f2) {
                materialShapeDrawableState.interpolation = f2;
                this.pathDirty = true;
                invalidateSelf();
            }
        }
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048631, this, i2, i3, i4, i5) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.padding == null) {
                materialShapeDrawableState.padding = new Rect();
            }
            this.drawableState.padding.set(i2, i3, i4, i5);
            invalidateSelf();
        }
    }

    public void setPaintStyle(Paint.Style style) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, style) == null) {
            this.drawableState.paintStyle = style;
            invalidateSelfIgnoreShape();
        }
    }

    public void setParentAbsoluteElevation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048633, this, f2) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.parentAbsoluteElevation != f2) {
                materialShapeDrawableState.parentAbsoluteElevation = f2;
                updateZ();
            }
        }
    }

    public void setScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048634, this, f2) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.scale != f2) {
                materialShapeDrawableState.scale = f2;
                invalidateSelf();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowBitmapDrawingEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.shadowBitmapDrawingEnable = z;
        }
    }

    public void setShadowColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            this.shadowRenderer.setShadowColor(i2);
            this.drawableState.useTintColorForShadow = false;
            invalidateSelfIgnoreShape();
        }
    }

    public void setShadowCompatRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.shadowCompatRotation != i2) {
                materialShapeDrawableState.shadowCompatRotation = i2;
                invalidateSelfIgnoreShape();
            }
        }
    }

    public void setShadowCompatibilityMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.shadowCompatMode != i2) {
                materialShapeDrawableState.shadowCompatMode = i2;
                invalidateSelfIgnoreShape();
            }
        }
    }

    @Deprecated
    public void setShadowElevation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            setElevation(i2);
        }
    }

    @Deprecated
    public void setShadowEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            setShadowCompatibilityMode(!z ? 1 : 0);
        }
    }

    @Deprecated
    public void setShadowRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            this.drawableState.shadowCompatRadius = i2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowVerticalOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.shadowCompatOffset != i2) {
                materialShapeDrawableState.shadowCompatOffset = i2;
                invalidateSelfIgnoreShape();
            }
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, shapeAppearanceModel) == null) {
            this.drawableState.shapeAppearanceModel = shapeAppearanceModel;
            invalidateSelf();
        }
    }

    @Deprecated
    public void setShapedViewModel(@NonNull ShapePathModel shapePathModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, shapePathModel) == null) {
            setShapeAppearanceModel(shapePathModel);
        }
    }

    public void setStroke(float f2, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            setStrokeWidth(f2);
            setStrokeColor(ColorStateList.valueOf(i2));
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, colorStateList) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.strokeColor != colorStateList) {
                materialShapeDrawableState.strokeColor = colorStateList;
                onStateChange(getState());
            }
        }
    }

    public void setStrokeTint(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, colorStateList) == null) {
            this.drawableState.strokeTintList = colorStateList;
            updateTintFilter();
            invalidateSelfIgnoreShape();
        }
    }

    public void setStrokeWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048650, this, f2) == null) {
            this.drawableState.strokeWidth = f2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, colorStateList) == null) {
            this.drawableState.tintList = colorStateList;
            updateTintFilter();
            invalidateSelfIgnoreShape();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, mode) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.tintMode != mode) {
                materialShapeDrawableState.tintMode = mode;
                updateTintFilter();
                invalidateSelfIgnoreShape();
            }
        }
    }

    public void setTranslationZ(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048654, this, f2) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.translationZ != f2) {
                materialShapeDrawableState.translationZ = f2;
                updateZ();
            }
        }
    }

    public void setUseTintColorForShadow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048655, this, z) == null) {
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            if (materialShapeDrawableState.useTintColorForShadow != z) {
                materialShapeDrawableState.useTintColorForShadow = z;
                invalidateSelf();
            }
        }
    }

    public void setZ(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048656, this, f2) == null) {
            setTranslationZ(f2 - getElevation());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((ShapeAppearanceModel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65554, null, context, f2)) == null) {
            int color = MaterialColors.getColor(context, (int) R.attr.colorSurface, MaterialShapeDrawable.class.getSimpleName());
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.initializeElevationOverlay(context);
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
            materialShapeDrawable.setElevation(f2);
            return materialShapeDrawable;
        }
        return (MaterialShapeDrawable) invokeLF.objValue;
    }

    private void drawShape(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull ShapeAppearanceModel shapeAppearanceModel, @NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65557, this, canvas, paint, path, shapeAppearanceModel, rectF) == null) {
            if (shapeAppearanceModel.isRoundRect(rectF)) {
                float cornerSize = shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) * this.drawableState.interpolation;
                canvas.drawRoundRect(rectF, cornerSize, cornerSize, paint);
                return;
            }
            canvas.drawPath(path, paint);
        }
    }

    public void setCornerSize(@NonNull CornerSize cornerSize) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, cornerSize) == null) {
            setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(cornerSize));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialShapeDrawable(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        this(ShapeAppearanceModel.builder(context, attributeSet, i2, i3).build());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                this((ShapeAppearanceModel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void setStroke(float f2, @Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Float.valueOf(f2), colorStateList}) == null) {
            setStrokeWidth(f2);
            setStrokeColor(colorStateList);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public MaterialShapeDrawable(@NonNull ShapePathModel shapePathModel) {
        this((ShapeAppearanceModel) shapePathModel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {shapePathModel};
            interceptable.invokeUnInit(65542, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((ShapeAppearanceModel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
    }

    public void setStrokeTint(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i2) == null) {
            setStrokeTint(ColorStateList.valueOf(i2));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialShapeDrawable(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this(new MaterialShapeDrawableState(shapeAppearanceModel, null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {shapeAppearanceModel};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((MaterialShapeDrawableState) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    public MaterialShapeDrawable(@NonNull MaterialShapeDrawableState materialShapeDrawableState) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {materialShapeDrawableState};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.cornerShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.edgeShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        this.fillPaint = new Paint(1);
        this.strokePaint = new Paint(1);
        this.shadowRenderer = new ShadowRenderer();
        this.pathProvider = new ShapeAppearancePathProvider();
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = materialShapeDrawableState;
        this.strokePaint.setStyle(Paint.Style.STROKE);
        this.fillPaint.setStyle(Paint.Style.FILL);
        clearPaint.setColor(-1);
        clearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new ShapeAppearancePathProvider.PathListener(this) { // from class: com.google.android.material.shape.MaterialShapeDrawable.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MaterialShapeDrawable this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
            public void onCornerPathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLI(1048576, this, shapePath, matrix, i4) == null) {
                    this.this$0.containsIncompatibleShadowOp.set(i4, shapePath.containsIncompatibleShadowOp());
                    this.this$0.cornerShadowOperation[i4] = shapePath.createShadowCompatOperation(matrix);
                }
            }

            @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
            public void onEdgePathCreated(@NonNull ShapePath shapePath, Matrix matrix, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shapePath, matrix, i4) == null) {
                    this.this$0.containsIncompatibleShadowOp.set(i4 + 4, shapePath.containsIncompatibleShadowOp());
                    this.this$0.edgeShadowOperation[i4] = shapePath.createShadowCompatOperation(matrix);
                }
            }
        };
    }

    /* loaded from: classes7.dex */
    public static final class MaterialShapeDrawableState extends Drawable.ConstantState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int alpha;
        @Nullable
        public ColorFilter colorFilter;
        public float elevation;
        @Nullable
        public ElevationOverlayProvider elevationOverlayProvider;
        @Nullable
        public ColorStateList fillColor;
        public float interpolation;
        @Nullable
        public Rect padding;
        public Paint.Style paintStyle;
        public float parentAbsoluteElevation;
        public float scale;
        public int shadowCompatMode;
        public int shadowCompatOffset;
        public int shadowCompatRadius;
        public int shadowCompatRotation;
        @NonNull
        public ShapeAppearanceModel shapeAppearanceModel;
        @Nullable
        public ColorStateList strokeColor;
        @Nullable
        public ColorStateList strokeTintList;
        public float strokeWidth;
        @Nullable
        public ColorStateList tintList;
        @Nullable
        public PorterDuff.Mode tintMode;
        public float translationZ;
        public boolean useTintColorForShadow;

        public MaterialShapeDrawableState(ShapeAppearanceModel shapeAppearanceModel, ElevationOverlayProvider elevationOverlayProvider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shapeAppearanceModel, elevationOverlayProvider};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.elevationOverlayProvider = elevationOverlayProvider;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
                materialShapeDrawable.pathDirty = true;
                return materialShapeDrawable;
            }
            return (Drawable) invokeV.objValue;
        }

        public MaterialShapeDrawableState(@NonNull MaterialShapeDrawableState materialShapeDrawableState) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {materialShapeDrawableState};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = materialShapeDrawableState.shapeAppearanceModel;
            this.elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
            this.strokeWidth = materialShapeDrawableState.strokeWidth;
            this.colorFilter = materialShapeDrawableState.colorFilter;
            this.fillColor = materialShapeDrawableState.fillColor;
            this.strokeColor = materialShapeDrawableState.strokeColor;
            this.tintMode = materialShapeDrawableState.tintMode;
            this.tintList = materialShapeDrawableState.tintList;
            this.alpha = materialShapeDrawableState.alpha;
            this.scale = materialShapeDrawableState.scale;
            this.shadowCompatOffset = materialShapeDrawableState.shadowCompatOffset;
            this.shadowCompatMode = materialShapeDrawableState.shadowCompatMode;
            this.useTintColorForShadow = materialShapeDrawableState.useTintColorForShadow;
            this.interpolation = materialShapeDrawableState.interpolation;
            this.parentAbsoluteElevation = materialShapeDrawableState.parentAbsoluteElevation;
            this.elevation = materialShapeDrawableState.elevation;
            this.translationZ = materialShapeDrawableState.translationZ;
            this.shadowCompatRadius = materialShapeDrawableState.shadowCompatRadius;
            this.shadowCompatRotation = materialShapeDrawableState.shadowCompatRotation;
            this.strokeTintList = materialShapeDrawableState.strokeTintList;
            this.paintStyle = materialShapeDrawableState.paintStyle;
            if (materialShapeDrawableState.padding != null) {
                this.padding = new Rect(materialShapeDrawableState.padding);
            }
        }
    }
}
