package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.text.BidiFormatter;
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
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class ChipDrawable extends MaterialShapeDrawable implements TintAwareDrawable, Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int[] DEFAULT_STATE;
    public static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    public static final ShapeDrawable closeIconRippleMask;
    public transient /* synthetic */ FieldHolder $fh;
    public int alpha;
    public boolean checkable;
    @Nullable
    public Drawable checkedIcon;
    @Nullable
    public ColorStateList checkedIconTint;
    public boolean checkedIconVisible;
    @Nullable
    public ColorStateList chipBackgroundColor;
    public float chipCornerRadius;
    public float chipEndPadding;
    @Nullable
    public Drawable chipIcon;
    public float chipIconSize;
    @Nullable
    public ColorStateList chipIconTint;
    public boolean chipIconVisible;
    public float chipMinHeight;
    public final Paint chipPaint;
    public float chipStartPadding;
    @Nullable
    public ColorStateList chipStrokeColor;
    public float chipStrokeWidth;
    @Nullable
    public ColorStateList chipSurfaceColor;
    @Nullable
    public Drawable closeIcon;
    @Nullable
    public CharSequence closeIconContentDescription;
    public float closeIconEndPadding;
    @Nullable
    public Drawable closeIconRipple;
    public float closeIconSize;
    public float closeIconStartPadding;
    public int[] closeIconStateSet;
    @Nullable
    public ColorStateList closeIconTint;
    public boolean closeIconVisible;
    @Nullable
    public ColorFilter colorFilter;
    @Nullable
    public ColorStateList compatRippleColor;
    @NonNull
    public final Context context;
    public boolean currentChecked;
    @ColorInt
    public int currentChipBackgroundColor;
    @ColorInt
    public int currentChipStrokeColor;
    @ColorInt
    public int currentChipSurfaceColor;
    @ColorInt
    public int currentCompatRippleColor;
    @ColorInt
    public int currentCompositeSurfaceBackgroundColor;
    @ColorInt
    public int currentTextColor;
    @ColorInt
    public int currentTint;
    @Nullable
    public final Paint debugPaint;
    @NonNull
    public WeakReference<Delegate> delegate;
    public final Paint.FontMetrics fontMetrics;
    public boolean hasChipIconTint;
    @Nullable
    public MotionSpec hideMotionSpec;
    public float iconEndPadding;
    public float iconStartPadding;
    public boolean isShapeThemingEnabled;
    public int maxWidth;
    public final PointF pointF;
    public final RectF rectF;
    @Nullable
    public ColorStateList rippleColor;
    public final Path shapePath;
    public boolean shouldDrawText;
    @Nullable
    public MotionSpec showMotionSpec;
    @Nullable
    public CharSequence text;
    @NonNull
    public final TextDrawableHelper textDrawableHelper;
    public float textEndPadding;
    public float textStartPadding;
    @Nullable
    public ColorStateList tint;
    @Nullable
    public PorterDuffColorFilter tintFilter;
    @Nullable
    public PorterDuff.Mode tintMode;
    public TextUtils.TruncateAt truncateAt;
    public boolean useCompatRipple;

    /* loaded from: classes7.dex */
    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(795261402, "Lcom/google/android/material/chip/ChipDrawable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(795261402, "Lcom/google/android/material/chip/ChipDrawable;");
                return;
            }
        }
        DEFAULT_STATE = new int[]{16842910};
        closeIconRippleMask = new ShapeDrawable(new OvalShape());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return Math.min(Math.round(this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding + this.textDrawableHelper.getTextWidth(getText().toString()) + this.textEndPadding + calculateCloseIconWidth() + this.chipEndPadding), this.maxWidth);
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipDrawable(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.chipCornerRadius = -1.0f;
        this.chipPaint = new Paint(1);
        this.fontMetrics = new Paint.FontMetrics();
        this.rectF = new RectF();
        this.pointF = new PointF();
        this.shapePath = new Path();
        this.alpha = 255;
        this.tintMode = PorterDuff.Mode.SRC_IN;
        Paint paint = null;
        this.delegate = new WeakReference<>(null);
        initializeElevationOverlay(context);
        this.context = context;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        this.text = "";
        textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        if (0 != 0) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(DEFAULT_STATE);
        setCloseIconState(DEFAULT_STATE);
        this.shouldDrawText = true;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            closeIconRippleMask.setTint(-1);
        }
    }

    private void applyChildDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, this, drawable) != null) || drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.closeIcon) {
            if (drawable.isStateful()) {
                drawable.setState(getCloseIconState());
            }
            DrawableCompat.setTintList(drawable, this.closeIconTint);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.chipIcon;
        if (drawable == drawable2 && this.hasChipIconTint) {
            DrawableCompat.setTintList(drawable2, this.chipIconTint);
        }
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        Drawable closeIcon;
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048671, this, drawable) == null) && (closeIcon = getCloseIcon()) != drawable) {
            float calculateCloseIconWidth = calculateCloseIconWidth();
            if (drawable != null) {
                drawable2 = DrawableCompat.wrap(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.closeIcon = drawable2;
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                updateFrameworkCloseIconRipple();
            }
            float calculateCloseIconWidth2 = calculateCloseIconWidth();
            unapplyChildDrawable(closeIcon);
            if (showsCloseIcon()) {
                applyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            if (calculateCloseIconWidth != calculateCloseIconWidth2) {
                onSizeChange();
            }
        }
    }

    private void calculateChipIconBounds(@NonNull Rect rect, @NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, rect, rectF) == null) {
            rectF.setEmpty();
            if (showsChipIcon() || showsCheckedIcon()) {
                float f = this.chipStartPadding + this.iconStartPadding;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    float f2 = rect.left + f;
                    rectF.left = f2;
                    rectF.right = f2 + this.chipIconSize;
                } else {
                    float f3 = rect.right - f;
                    rectF.right = f3;
                    rectF.left = f3 - this.chipIconSize;
                }
                float exactCenterY = rect.exactCenterY();
                float f4 = this.chipIconSize;
                float f5 = exactCenterY - (f4 / 2.0f);
                rectF.top = f5;
                rectF.bottom = f5 + f4;
            }
        }
    }

    private void calculateCloseIconBounds(@NonNull Rect rect, @NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, rect, rectF) == null) {
            rectF.setEmpty();
            if (showsCloseIcon()) {
                float f = this.chipEndPadding + this.closeIconEndPadding;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    float f2 = rect.right - f;
                    rectF.right = f2;
                    rectF.left = f2 - this.closeIconSize;
                } else {
                    float f3 = rect.left + f;
                    rectF.left = f3;
                    rectF.right = f3 + this.closeIconSize;
                }
                float exactCenterY = rect.exactCenterY();
                float f4 = this.closeIconSize;
                float f5 = exactCenterY - (f4 / 2.0f);
                rectF.top = f5;
                rectF.bottom = f5 + f4;
            }
        }
    }

    private void calculateCloseIconTouchBounds(@NonNull Rect rect, @NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, rect, rectF) == null) {
            rectF.setEmpty();
            if (showsCloseIcon()) {
                float f = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    float f2 = rect.right;
                    rectF.right = f2;
                    rectF.left = f2 - f;
                } else {
                    int i = rect.left;
                    rectF.left = i;
                    rectF.right = i + f;
                }
                rectF.top = rect.top;
                rectF.bottom = rect.bottom;
            }
        }
    }

    private void calculateTextBounds(@NonNull Rect rect, @NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, rect, rectF) == null) {
            rectF.setEmpty();
            if (this.text != null) {
                float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
                float calculateCloseIconWidth = this.chipEndPadding + calculateCloseIconWidth() + this.textEndPadding;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    rectF.left = rect.left + calculateChipIconWidth;
                    rectF.right = rect.right - calculateCloseIconWidth;
                } else {
                    rectF.left = rect.left + calculateCloseIconWidth;
                    rectF.right = rect.right - calculateChipIconWidth;
                }
                rectF.top = rect.top;
                rectF.bottom = rect.bottom;
            }
        }
    }

    private void drawChipStroke(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65551, this, canvas, rect) == null) && this.chipStrokeWidth > 0.0f && !this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipStrokeColor);
            this.chipPaint.setStyle(Paint.Style.STROKE);
            if (!this.isShapeThemingEnabled) {
                this.chipPaint.setColorFilter(getTintColorFilter());
            }
            RectF rectF = this.rectF;
            float f = this.chipStrokeWidth;
            rectF.set(rect.left + (f / 2.0f), rect.top + (f / 2.0f), rect.right - (f / 2.0f), rect.bottom - (f / 2.0f));
            float f2 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
            canvas.drawRoundRect(this.rectF, f2, f2, this.chipPaint);
        }
    }

    private void drawCloseIcon(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65553, this, canvas, rect) == null) && showsCloseIcon()) {
            calculateCloseIconBounds(rect, this.rectF);
            RectF rectF = this.rectF;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.closeIconRipple.setBounds(this.closeIcon.getBounds());
                this.closeIconRipple.jumpToCurrentState();
                this.closeIconRipple.draw(canvas);
            } else {
                this.closeIcon.draw(canvas);
            }
            canvas.translate(-f, -f2);
        }
    }

    private void drawCompatRipple(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, canvas, rect) == null) {
            this.chipPaint.setColor(this.currentCompatRippleColor);
            this.chipPaint.setStyle(Paint.Style.FILL);
            this.rectF.set(rect);
            if (!this.isShapeThemingEnabled) {
                canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
                return;
            }
            calculatePathForSize(new RectF(rect), this.shapePath);
            super.drawShape(canvas, this.chipPaint, this.shapePath, getBoundsAsRectF());
        }
    }

    @NonNull
    public Paint.Align calculateTextOriginAndAlignment(@NonNull Rect rect, @NonNull PointF pointF) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rect, pointF)) == null) {
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            if (this.text != null) {
                float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    pointF.x = rect.left + calculateChipIconWidth;
                    align = Paint.Align.LEFT;
                } else {
                    pointF.x = rect.right - calculateChipIconWidth;
                    align = Paint.Align.RIGHT;
                }
                pointF.y = rect.centerY() - calculateTextCenterFromBaseline();
            }
            return align;
        }
        return (Paint.Align) invokeLL.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048713, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean visible = super.setVisible(z, z2);
            if (showsChipIcon()) {
                visible |= this.chipIcon.setVisible(z, z2);
            }
            if (showsCheckedIcon()) {
                visible |= this.checkedIcon.setVisible(z, z2);
            }
            if (showsCloseIcon()) {
                visible |= this.closeIcon.setVisible(z, z2);
            }
            if (visible) {
                invalidateSelf();
            }
            return visible;
        }
        return invokeCommon.booleanValue;
    }

    private void calculateChipTouchBounds(@NonNull Rect rect, @NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, rect, rectF) == null) {
            rectF.set(rect);
            if (showsCloseIcon()) {
                float f = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    rectF.right = rect.right - f;
                } else {
                    rectF.left = rect.left + f;
                }
            }
        }
    }

    private void drawCheckedIcon(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, this, canvas, rect) == null) && showsCheckedIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            RectF rectF = this.rectF;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.checkedIcon.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void drawChipBackground(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, this, canvas, rect) == null) && !this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipBackgroundColor);
            this.chipPaint.setStyle(Paint.Style.FILL);
            this.chipPaint.setColorFilter(getTintColorFilter());
            this.rectF.set(rect);
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        }
    }

    private void drawChipIcon(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65550, this, canvas, rect) == null) && showsChipIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            RectF rectF = this.rectF;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.chipIcon.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void drawChipSurface(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65552, this, canvas, rect) == null) && !this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipSurfaceColor);
            this.chipPaint.setStyle(Paint.Style.FILL);
            this.rectF.set(rect);
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        }
    }

    private float calculateTextCenterFromBaseline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
            Paint.FontMetrics fontMetrics = this.fontMetrics;
            return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
        }
        return invokeV.floatValue;
    }

    private boolean canShowCheckedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.checkedIconVisible && this.checkedIcon != null && this.checkable) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    private ColorFilter getTintColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            ColorFilter colorFilter = this.colorFilter;
            if (colorFilter == null) {
                return this.tintFilter;
            }
            return colorFilter;
        }
        return (ColorFilter) invokeV.objValue;
    }

    private boolean showsCheckedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            if (this.checkedIconVisible && this.checkedIcon != null && this.currentChecked) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean showsChipIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) {
            if (this.chipIconVisible && this.chipIcon != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean showsCloseIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
            if (this.closeIconVisible && this.closeIcon != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void updateCompatRippleColor() {
        ColorStateList colorStateList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            if (this.useCompatRipple) {
                colorStateList = RippleUtils.sanitizeRippleDrawableColor(this.rippleColor);
            } else {
                colorStateList = null;
            }
            this.compatRippleColor = colorStateList;
        }
    }

    @TargetApi(21)
    private void updateFrameworkCloseIconRipple() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            this.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(getRippleColor()), this.closeIcon, closeIconRippleMask);
        }
    }

    public float calculateChipIconWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!showsChipIcon() && !showsCheckedIcon()) {
                return 0.0f;
            }
            return this.iconStartPadding + this.chipIconSize + this.iconEndPadding;
        }
        return invokeV.floatValue;
    }

    public float calculateCloseIconWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (showsCloseIcon()) {
                return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.alpha;
        }
        return invokeV.intValue;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.checkedIcon;
        }
        return (Drawable) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.checkedIconTint;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.chipBackgroundColor;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public float getChipCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.isShapeThemingEnabled) {
                return getTopLeftCornerResolvedSize();
            }
            return this.chipCornerRadius;
        }
        return invokeV.floatValue;
    }

    public float getChipEndPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.chipEndPadding;
        }
        return invokeV.floatValue;
    }

    @Nullable
    public Drawable getChipIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Drawable drawable = this.chipIcon;
            if (drawable != null) {
                return DrawableCompat.unwrap(drawable);
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public float getChipIconSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.chipIconSize;
        }
        return invokeV.floatValue;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.chipIconTint;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public float getChipMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.chipMinHeight;
        }
        return invokeV.floatValue;
    }

    public float getChipStartPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.chipStartPadding;
        }
        return invokeV.floatValue;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.chipStrokeColor;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public float getChipStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.chipStrokeWidth;
        }
        return invokeV.floatValue;
    }

    @Nullable
    public Drawable getCloseIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Drawable drawable = this.closeIcon;
            if (drawable != null) {
                return DrawableCompat.unwrap(drawable);
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.closeIconContentDescription;
        }
        return (CharSequence) invokeV.objValue;
    }

    public float getCloseIconEndPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.closeIconEndPadding;
        }
        return invokeV.floatValue;
    }

    public float getCloseIconSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.closeIconSize;
        }
        return invokeV.floatValue;
    }

    public float getCloseIconStartPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.closeIconStartPadding;
        }
        return invokeV.floatValue;
    }

    @NonNull
    public int[] getCloseIconState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.closeIconStateSet;
        }
        return (int[]) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.closeIconTint;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.colorFilter;
        }
        return (ColorFilter) invokeV.objValue;
    }

    public TextUtils.TruncateAt getEllipsize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.truncateAt;
        }
        return (TextUtils.TruncateAt) invokeV.objValue;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.hideMotionSpec;
        }
        return (MotionSpec) invokeV.objValue;
    }

    public float getIconEndPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.iconEndPadding;
        }
        return invokeV.floatValue;
    }

    public float getIconStartPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.iconStartPadding;
        }
        return invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return (int) this.chipMinHeight;
        }
        return invokeV.intValue;
    }

    @Px
    public int getMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.maxWidth;
        }
        return invokeV.intValue;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.rippleColor;
        }
        return (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.showMotionSpec;
        }
        return (MotionSpec) invokeV.objValue;
    }

    @Nullable
    public CharSequence getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.text;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.textDrawableHelper.getTextAppearance();
        }
        return (TextAppearance) invokeV.objValue;
    }

    public float getTextEndPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.textEndPadding;
        }
        return invokeV.floatValue;
    }

    public float getTextStartPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.textStartPadding;
        }
        return invokeV.floatValue;
    }

    public boolean getUseCompatRipple() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.useCompatRipple;
        }
        return invokeV.booleanValue;
    }

    public boolean isCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.checkable;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return isCheckedIconVisible();
        }
        return invokeV.booleanValue;
    }

    public boolean isCheckedIconVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.checkedIconVisible;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return isChipIconVisible();
        }
        return invokeV.booleanValue;
    }

    public boolean isChipIconVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.chipIconVisible;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return isCloseIconVisible();
        }
        return invokeV.booleanValue;
    }

    public boolean isCloseIconStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return isStateful(this.closeIcon);
        }
        return invokeV.booleanValue;
    }

    public boolean isCloseIconVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.closeIconVisible;
        }
        return invokeV.booleanValue;
    }

    public boolean isShapeThemingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.isShapeThemingEnabled;
        }
        return invokeV.booleanValue;
    }

    public void onSizeChange() {
        Delegate delegate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048632, this) == null) && (delegate = this.delegate.get()) != null) {
            delegate.onChipDrawableSizeChange();
        }
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            onSizeChange();
            invalidateSelf();
        }
    }

    public boolean shouldDrawText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
            return this.shouldDrawText;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public static ChipDrawable createFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65546, null, context, attributeSet, i, i2)) == null) {
            ChipDrawable chipDrawable = new ChipDrawable(context, attributeSet, i, i2);
            chipDrawable.loadFromAttributes(attributeSet, i, i2);
            return chipDrawable;
        }
        return (ChipDrawable) invokeLLII.objValue;
    }

    @NonNull
    public static ChipDrawable createFromResource(@NonNull Context context, @XmlRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, context, i)) == null) {
            AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context, i, "chip");
            int styleAttribute = parseDrawableXml.getStyleAttribute();
            if (styleAttribute == 0) {
                styleAttribute = R.style.obfuscated_res_0x7f10035f;
            }
            return createFromAttributes(context, parseDrawableXml, R.attr.obfuscated_res_0x7f04014a, styleAttribute);
        }
        return (ChipDrawable) invokeLI.objValue;
    }

    public static boolean hasState(@Nullable int[] iArr, @AttrRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, iArr, i)) == null) {
            if (iArr == null) {
                return false;
            }
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048715, this, drawable, runnable) == null) && (callback = getCallback()) != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    private void drawDebug(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65555, this, canvas, rect) == null) && (paint = this.debugPaint) != null) {
            paint.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
            canvas.drawRect(rect, this.debugPaint);
            if (showsChipIcon() || showsCheckedIcon()) {
                calculateChipIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            if (this.text != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.debugPaint);
            }
            if (showsCloseIcon()) {
                calculateCloseIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            this.debugPaint.setColor(ColorUtils.setAlphaComponent(-65536, 127));
            calculateChipTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
            this.debugPaint.setColor(ColorUtils.setAlphaComponent(DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK, 127));
            calculateCloseIconTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
        }
    }

    private void drawText(@NonNull Canvas canvas, @NonNull Rect rect) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65556, this, canvas, rect) == null) && this.text != null) {
            Paint.Align calculateTextOriginAndAlignment = calculateTextOriginAndAlignment(rect, this.pointF);
            calculateTextBounds(rect, this.rectF);
            if (this.textDrawableHelper.getTextAppearance() != null) {
                this.textDrawableHelper.getTextPaint().drawableState = getState();
                this.textDrawableHelper.updateTextPaintDrawState(this.context);
            }
            this.textDrawableHelper.getTextPaint().setTextAlign(calculateTextOriginAndAlignment);
            int i = 0;
            if (Math.round(this.textDrawableHelper.getTextWidth(getText().toString())) > Math.round(this.rectF.width())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i = canvas.save();
                canvas.clipRect(this.rectF);
            }
            CharSequence charSequence = this.text;
            if (z && this.truncateAt != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.textDrawableHelper.getTextPaint(), this.rectF.width(), this.truncateAt);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.pointF;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.textDrawableHelper.getTextPaint());
            if (z) {
                canvas.restoreToCount(i);
            }
        }
    }

    public static boolean isStateful(@Nullable ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, colorStateList)) == null) {
            if (colorStateList != null && colorStateList.isStateful()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void setChipSurfaceColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, this, colorStateList) == null) && this.chipSurfaceColor != colorStateList) {
            this.chipSurfaceColor = colorStateList;
            onStateChange(getState());
        }
    }

    private void unapplyChildDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65568, this, drawable) == null) && drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void getChipTouchBounds(@NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, rectF) == null) {
            calculateChipTouchBounds(getBounds(), rectF);
        }
    }

    public void getCloseIconTouchBounds(@NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, rectF) == null) {
            calculateCloseIconTouchBounds(getBounds(), rectF);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, drawable) == null) && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(@NonNull int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, iArr)) == null) {
            if (this.isShapeThemingEnabled) {
                super.onStateChange(iArr);
            }
            return onStateChange(iArr, getCloseIconState());
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048636, this, i) == null) && this.alpha != i) {
            this.alpha = i;
            invalidateSelf();
        }
    }

    public void setCheckable(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048637, this, z) == null) && this.checkable != z) {
            this.checkable = z;
            float calculateChipIconWidth = calculateChipIconWidth();
            if (!z && this.currentChecked) {
                this.currentChecked = false;
            }
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCheckableResource(@BoolRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            setCheckable(this.context.getResources().getBoolean(i));
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048639, this, drawable) == null) && this.checkedIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.checkedIcon = drawable;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(this.checkedIcon);
            applyChildDrawable(this.checkedIcon);
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            setCheckedIconVisible(z);
        }
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
            setCheckedIconVisible(this.context.getResources().getBoolean(i));
        }
    }

    public void setCheckedIconResource(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i) == null) {
            setCheckedIcon(AppCompatResources.getDrawable(this.context, i));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048643, this, colorStateList) == null) && this.checkedIconTint != colorStateList) {
            this.checkedIconTint = colorStateList;
            if (canShowCheckedIcon()) {
                DrawableCompat.setTintList(this.checkedIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            setCheckedIconTint(AppCompatResources.getColorStateList(this.context, i));
        }
    }

    public void setCheckedIconVisible(@BoolRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            setCheckedIconVisible(this.context.getResources().getBoolean(i));
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048647, this, colorStateList) == null) && this.chipBackgroundColor != colorStateList) {
            this.chipBackgroundColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i) == null) {
            setChipBackgroundColor(AppCompatResources.getColorStateList(this.context, i));
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048649, this, f) == null) && this.chipCornerRadius != f) {
            this.chipCornerRadius = f;
            setShapeAppearanceModel(getShapeAppearanceModel().withCornerSize(f));
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i) == null) {
            setChipCornerRadius(this.context.getResources().getDimension(i));
        }
    }

    public void setChipEndPadding(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048651, this, f) == null) && this.chipEndPadding != f) {
            this.chipEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i) == null) {
            setChipEndPadding(this.context.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            setChipIconVisible(z);
        }
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i) == null) {
            setChipIconVisible(i);
        }
    }

    public void setChipIconResource(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i) == null) {
            setChipIcon(AppCompatResources.getDrawable(this.context, i));
        }
    }

    public void setChipIconSize(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048657, this, f) == null) && this.chipIconSize != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIconSize = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconSizeResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i) == null) {
            setChipIconSize(this.context.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, colorStateList) == null) {
            this.hasChipIconTint = true;
            if (this.chipIconTint != colorStateList) {
                this.chipIconTint = colorStateList;
                if (showsChipIcon()) {
                    DrawableCompat.setTintList(this.chipIcon, colorStateList);
                }
                onStateChange(getState());
            }
        }
    }

    public void setChipIconTintResource(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i) == null) {
            setChipIconTint(AppCompatResources.getColorStateList(this.context, i));
        }
    }

    public void setChipIconVisible(@BoolRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i) == null) {
            setChipIconVisible(this.context.getResources().getBoolean(i));
        }
    }

    public void setChipMinHeight(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048663, this, f) == null) && this.chipMinHeight != f) {
            this.chipMinHeight = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipMinHeightResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048664, this, i) == null) {
            setChipMinHeight(this.context.getResources().getDimension(i));
        }
    }

    public void setChipStartPadding(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048665, this, f) == null) && this.chipStartPadding != f) {
            this.chipStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048666, this, i) == null) {
            setChipStartPadding(this.context.getResources().getDimension(i));
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048667, this, colorStateList) == null) && this.chipStrokeColor != colorStateList) {
            this.chipStrokeColor = colorStateList;
            if (this.isShapeThemingEnabled) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i) == null) {
            setChipStrokeColor(AppCompatResources.getColorStateList(this.context, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048669, this, f) == null) && this.chipStrokeWidth != f) {
            this.chipStrokeWidth = f;
            this.chipPaint.setStrokeWidth(f);
            if (this.isShapeThemingEnabled) {
                super.setStrokeWidth(f);
            }
            invalidateSelf();
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048670, this, i) == null) {
            setChipStrokeWidth(this.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048672, this, charSequence) == null) && this.closeIconContentDescription != charSequence) {
            this.closeIconContentDescription = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z) == null) {
            setCloseIconVisible(z);
        }
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048674, this, i) == null) {
            setCloseIconVisible(i);
        }
    }

    public void setCloseIconEndPadding(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048675, this, f) == null) && this.closeIconEndPadding != f) {
            this.closeIconEndPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048676, this, i) == null) {
            setCloseIconEndPadding(this.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048677, this, i) == null) {
            setCloseIcon(AppCompatResources.getDrawable(this.context, i));
        }
    }

    public void setCloseIconSize(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048678, this, f) == null) && this.closeIconSize != f) {
            this.closeIconSize = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048679, this, i) == null) {
            setCloseIconSize(this.context.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048680, this, f) == null) && this.closeIconStartPadding != f) {
            this.closeIconStartPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048681, this, i) == null) {
            setCloseIconStartPadding(this.context.getResources().getDimension(i));
        }
    }

    public boolean setCloseIconState(@NonNull int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048682, this, iArr)) == null) {
            if (!Arrays.equals(this.closeIconStateSet, iArr)) {
                this.closeIconStateSet = iArr;
                if (showsCloseIcon()) {
                    return onStateChange(getState(), iArr);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048683, this, colorStateList) == null) && this.closeIconTint != colorStateList) {
            this.closeIconTint = colorStateList;
            if (showsCloseIcon()) {
                DrawableCompat.setTintList(this.closeIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCloseIconTintResource(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i) == null) {
            setCloseIconTint(AppCompatResources.getColorStateList(this.context, i));
        }
    }

    public void setCloseIconVisible(@BoolRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048685, this, i) == null) {
            setCloseIconVisible(this.context.getResources().getBoolean(i));
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048687, this, colorFilter) == null) && this.colorFilter != colorFilter) {
            this.colorFilter = colorFilter;
            invalidateSelf();
        }
    }

    public void setDelegate(@Nullable Delegate delegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, delegate) == null) {
            this.delegate = new WeakReference<>(delegate);
        }
    }

    public void setEllipsize(@Nullable TextUtils.TruncateAt truncateAt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, truncateAt) == null) {
            this.truncateAt = truncateAt;
        }
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, motionSpec) == null) {
            this.hideMotionSpec = motionSpec;
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048691, this, i) == null) {
            setHideMotionSpec(MotionSpec.createFromResource(this.context, i));
        }
    }

    public void setIconEndPadding(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048692, this, f) == null) && this.iconEndPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconEndPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048693, this, i) == null) {
            setIconEndPadding(this.context.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048694, this, f) == null) && this.iconStartPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconStartPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048695, this, i) == null) {
            setIconStartPadding(this.context.getResources().getDimension(i));
        }
    }

    public void setMaxWidth(@Px int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i) == null) {
            this.maxWidth = i;
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048697, this, colorStateList) == null) && this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    public void setRippleColorResource(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048698, this, i) == null) {
            setRippleColor(AppCompatResources.getColorStateList(this.context, i));
        }
    }

    public void setShouldDrawText(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z) == null) {
            this.shouldDrawText = z;
        }
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, motionSpec) == null) {
            this.showMotionSpec = motionSpec;
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048701, this, i) == null) {
            setShowMotionSpec(MotionSpec.createFromResource(this.context, i));
        }
    }

    public void setText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, charSequence) == null) {
            if (charSequence == null) {
                charSequence = "";
            }
            if (!TextUtils.equals(this.text, charSequence)) {
                this.text = charSequence;
                this.textDrawableHelper.setTextWidthDirty(true);
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, textAppearance) == null) {
            this.textDrawableHelper.setTextAppearance(textAppearance, this.context);
        }
    }

    public void setTextAppearanceResource(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048704, this, i) == null) {
            setTextAppearance(new TextAppearance(this.context, i));
        }
    }

    public void setTextEndPadding(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048705, this, f) == null) && this.textEndPadding != f) {
            this.textEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048706, this, i) == null) {
            setTextEndPadding(this.context.getResources().getDimension(i));
        }
    }

    public void setTextResource(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048707, this, i) == null) {
            setText(this.context.getResources().getString(i));
        }
    }

    public void setTextStartPadding(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048708, this, f) == null) && this.textStartPadding != f) {
            this.textStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048709, this, i) == null) {
            setTextStartPadding(this.context.getResources().getDimension(i));
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048710, this, colorStateList) == null) && this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048711, this, mode) == null) && this.tintMode != mode) {
            this.tintMode = mode;
            this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, mode);
            invalidateSelf();
        }
    }

    public void setUseCompatRipple(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048712, this, z) == null) && this.useCompatRipple != z) {
            this.useCompatRipple = z;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    public static boolean isStateful(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, drawable)) == null) {
            if (drawable != null && drawable.isStateful()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isStateful(@Nullable TextAppearance textAppearance) {
        InterceptResult invokeL;
        ColorStateList colorStateList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, textAppearance)) == null) {
            if (textAppearance != null && (colorStateList = textAppearance.textColor) != null && colorStateList.isStateful()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void loadFromAttributes(@Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65562, this, attributeSet, i, i2) == null) {
            TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.context, attributeSet, com.google.android.material.R.styleable.Chip, i, i2, new int[0]);
            this.isShapeThemingEnabled = obtainStyledAttributes.hasValue(36);
            setChipSurfaceColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, 23));
            setChipBackgroundColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, 10));
            setChipMinHeight(obtainStyledAttributes.getDimension(18, 0.0f));
            if (obtainStyledAttributes.hasValue(11)) {
                setChipCornerRadius(obtainStyledAttributes.getDimension(11, 0.0f));
            }
            setChipStrokeColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, 21));
            setChipStrokeWidth(obtainStyledAttributes.getDimension(22, 0.0f));
            setRippleColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, 35));
            setText(obtainStyledAttributes.getText(4));
            setTextAppearance(MaterialResources.getTextAppearance(this.context, obtainStyledAttributes, 0));
            int i3 = obtainStyledAttributes.getInt(2, 0);
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        setEllipsize(TextUtils.TruncateAt.END);
                    }
                } else {
                    setEllipsize(TextUtils.TruncateAt.MIDDLE);
                }
            } else {
                setEllipsize(TextUtils.TruncateAt.START);
            }
            setChipIconVisible(obtainStyledAttributes.getBoolean(17, false));
            if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "chipIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "chipIconVisible") == null) {
                setChipIconVisible(obtainStyledAttributes.getBoolean(14, false));
            }
            setChipIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, 13));
            if (obtainStyledAttributes.hasValue(16)) {
                setChipIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, 16));
            }
            setChipIconSize(obtainStyledAttributes.getDimension(15, 0.0f));
            setCloseIconVisible(obtainStyledAttributes.getBoolean(30, false));
            if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "closeIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "closeIconVisible") == null) {
                setCloseIconVisible(obtainStyledAttributes.getBoolean(25, false));
            }
            setCloseIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, 24));
            setCloseIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, 29));
            setCloseIconSize(obtainStyledAttributes.getDimension(27, 0.0f));
            setCheckable(obtainStyledAttributes.getBoolean(5, false));
            setCheckedIconVisible(obtainStyledAttributes.getBoolean(9, false));
            if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "checkedIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "checkedIconVisible") == null) {
                setCheckedIconVisible(obtainStyledAttributes.getBoolean(7, false));
            }
            setCheckedIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, 6));
            if (obtainStyledAttributes.hasValue(8)) {
                setCheckedIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, 8));
            }
            setShowMotionSpec(MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, 38));
            setHideMotionSpec(MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, 32));
            setChipStartPadding(obtainStyledAttributes.getDimension(20, 0.0f));
            setIconStartPadding(obtainStyledAttributes.getDimension(34, 0.0f));
            setIconEndPadding(obtainStyledAttributes.getDimension(33, 0.0f));
            setTextStartPadding(obtainStyledAttributes.getDimension(40, 0.0f));
            setTextEndPadding(obtainStyledAttributes.getDimension(39, 0.0f));
            setCloseIconStartPadding(obtainStyledAttributes.getDimension(28, 0.0f));
            setCloseIconEndPadding(obtainStyledAttributes.getDimension(26, 0.0f));
            setChipEndPadding(obtainStyledAttributes.getDimension(12, 0.0f));
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(3, Integer.MAX_VALUE));
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean onStateChange(@NonNull int[] iArr, @NonNull int[] iArr2) {
        InterceptResult invokeLL;
        int i;
        int i2;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        int i5;
        boolean z3;
        boolean z4;
        ColorStateList colorStateList;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, this, iArr, iArr2)) == null) {
            boolean onStateChange = super.onStateChange(iArr);
            ColorStateList colorStateList2 = this.chipSurfaceColor;
            if (colorStateList2 != null) {
                i = colorStateList2.getColorForState(iArr, this.currentChipSurfaceColor);
            } else {
                i = 0;
            }
            boolean z5 = true;
            if (this.currentChipSurfaceColor != i) {
                this.currentChipSurfaceColor = i;
                onStateChange = true;
            }
            ColorStateList colorStateList3 = this.chipBackgroundColor;
            if (colorStateList3 != null) {
                i2 = colorStateList3.getColorForState(iArr, this.currentChipBackgroundColor);
            } else {
                i2 = 0;
            }
            if (this.currentChipBackgroundColor != i2) {
                this.currentChipBackgroundColor = i2;
                onStateChange = true;
            }
            int layer = MaterialColors.layer(i, i2);
            if (this.currentCompositeSurfaceBackgroundColor != layer) {
                z = true;
            } else {
                z = false;
            }
            if (getFillColor() == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z | z2) {
                this.currentCompositeSurfaceBackgroundColor = layer;
                setFillColor(ColorStateList.valueOf(layer));
                onStateChange = true;
            }
            ColorStateList colorStateList4 = this.chipStrokeColor;
            if (colorStateList4 != null) {
                i3 = colorStateList4.getColorForState(iArr, this.currentChipStrokeColor);
            } else {
                i3 = 0;
            }
            if (this.currentChipStrokeColor != i3) {
                this.currentChipStrokeColor = i3;
                onStateChange = true;
            }
            if (this.compatRippleColor != null && RippleUtils.shouldDrawRippleCompat(iArr)) {
                i4 = this.compatRippleColor.getColorForState(iArr, this.currentCompatRippleColor);
            } else {
                i4 = 0;
            }
            if (this.currentCompatRippleColor != i4) {
                this.currentCompatRippleColor = i4;
                if (this.useCompatRipple) {
                    onStateChange = true;
                }
            }
            if (this.textDrawableHelper.getTextAppearance() != null && this.textDrawableHelper.getTextAppearance().textColor != null) {
                i5 = this.textDrawableHelper.getTextAppearance().textColor.getColorForState(iArr, this.currentTextColor);
            } else {
                i5 = 0;
            }
            if (this.currentTextColor != i5) {
                this.currentTextColor = i5;
                onStateChange = true;
            }
            if (hasState(getState(), 16842912) && this.checkable) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (this.currentChecked != z3 && this.checkedIcon != null) {
                float calculateChipIconWidth = calculateChipIconWidth();
                this.currentChecked = z3;
                if (calculateChipIconWidth != calculateChipIconWidth()) {
                    onStateChange = true;
                    z4 = true;
                    colorStateList = this.tint;
                    if (colorStateList == null) {
                        i6 = colorStateList.getColorForState(iArr, this.currentTint);
                    } else {
                        i6 = 0;
                    }
                    if (this.currentTint == i6) {
                        this.currentTint = i6;
                        this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, this.tintMode);
                    } else {
                        z5 = onStateChange;
                    }
                    if (isStateful(this.chipIcon)) {
                        z5 |= this.chipIcon.setState(iArr);
                    }
                    if (isStateful(this.checkedIcon)) {
                        z5 |= this.checkedIcon.setState(iArr);
                    }
                    if (isStateful(this.closeIcon)) {
                        int[] iArr3 = new int[iArr.length + iArr2.length];
                        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                        System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
                        z5 |= this.closeIcon.setState(iArr3);
                    }
                    if (RippleUtils.USE_FRAMEWORK_RIPPLE && isStateful(this.closeIconRipple)) {
                        z5 |= this.closeIconRipple.setState(iArr2);
                    }
                    if (z5) {
                        invalidateSelf();
                    }
                    if (z4) {
                        onSizeChange();
                    }
                    return z5;
                }
                onStateChange = true;
            }
            z4 = false;
            colorStateList = this.tint;
            if (colorStateList == null) {
            }
            if (this.currentTint == i6) {
            }
            if (isStateful(this.chipIcon)) {
            }
            if (isStateful(this.checkedIcon)) {
            }
            if (isStateful(this.closeIcon)) {
            }
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                z5 |= this.closeIconRipple.setState(iArr2);
            }
            if (z5) {
            }
            if (z4) {
            }
            return z5;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            Rect bounds = getBounds();
            if (!bounds.isEmpty() && getAlpha() != 0) {
                int i = 0;
                int i2 = this.alpha;
                if (i2 < 255) {
                    i = CanvasCompat.saveLayerAlpha(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i2);
                }
                drawChipSurface(canvas, bounds);
                drawChipBackground(canvas, bounds);
                if (this.isShapeThemingEnabled) {
                    super.draw(canvas);
                }
                drawChipStroke(canvas, bounds);
                drawCompatRipple(canvas, bounds);
                drawChipIcon(canvas, bounds);
                drawCheckedIcon(canvas, bounds);
                if (this.shouldDrawText) {
                    drawText(canvas, bounds);
                }
                drawCloseIcon(canvas, bounds);
                drawDebug(canvas, bounds);
                if (this.alpha < 255) {
                    canvas.restoreToCount(i);
                }
            }
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, outline) == null) {
            if (this.isShapeThemingEnabled) {
                super.getOutline(outline);
                return;
            }
            Rect bounds = getBounds();
            if (!bounds.isEmpty()) {
                outline.setRoundRect(bounds, this.chipCornerRadius);
            } else {
                outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.chipCornerRadius);
            }
            outline.setAlpha(getAlpha() / 255.0f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i)) == null) {
            boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
            if (showsChipIcon()) {
                onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.chipIcon, i);
            }
            if (showsCheckedIcon()) {
                onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.checkedIcon, i);
            }
            if (showsCloseIcon()) {
                onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.closeIcon, i);
            }
            if (onLayoutDirectionChanged) {
                invalidateSelf();
                return true;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i)) == null) {
            boolean onLevelChange = super.onLevelChange(i);
            if (showsChipIcon()) {
                onLevelChange |= this.chipIcon.setLevel(i);
            }
            if (showsCheckedIcon()) {
                onLevelChange |= this.checkedIcon.setLevel(i);
            }
            if (showsCloseIcon()) {
                onLevelChange |= this.closeIcon.setLevel(i);
            }
            if (onLevelChange) {
                invalidateSelf();
            }
            return onLevelChange;
        }
        return invokeI.booleanValue;
    }

    public void setCheckedIconVisible(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048646, this, z) == null) && this.checkedIconVisible != z) {
            boolean showsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z;
            boolean showsCheckedIcon2 = showsCheckedIcon();
            if (showsCheckedIcon != showsCheckedIcon2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (showsCheckedIcon2) {
                    applyChildDrawable(this.checkedIcon);
                } else {
                    unapplyChildDrawable(this.checkedIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        Drawable chipIcon;
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048653, this, drawable) == null) && (chipIcon = getChipIcon()) != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            if (drawable != null) {
                drawable2 = DrawableCompat.wrap(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.chipIcon = drawable2;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(chipIcon);
            if (showsChipIcon()) {
                applyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconVisible(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048662, this, z) == null) && this.chipIconVisible != z) {
            boolean showsChipIcon = showsChipIcon();
            this.chipIconVisible = z;
            boolean showsChipIcon2 = showsChipIcon();
            if (showsChipIcon != showsChipIcon2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (showsChipIcon2) {
                    applyChildDrawable(this.chipIcon);
                } else {
                    unapplyChildDrawable(this.chipIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setCloseIconVisible(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048686, this, z) == null) && this.closeIconVisible != z) {
            boolean showsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z;
            boolean showsCloseIcon2 = showsCloseIcon();
            if (showsCloseIcon != showsCloseIcon2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (showsCloseIcon2) {
                    applyChildDrawable(this.closeIcon);
                } else {
                    unapplyChildDrawable(this.closeIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (!isStateful(this.chipSurfaceColor) && !isStateful(this.chipBackgroundColor) && !isStateful(this.chipStrokeColor) && ((!this.useCompatRipple || !isStateful(this.compatRippleColor)) && !isStateful(this.textDrawableHelper.getTextAppearance()) && !canShowCheckedIcon() && !isStateful(this.chipIcon) && !isStateful(this.checkedIcon) && !isStateful(this.tint))) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{drawable, runnable, Long.valueOf(j)}) == null) && (callback = getCallback()) != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }
}
