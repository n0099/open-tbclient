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
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
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
/* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public interface Delegate {
        void onChipDrawableSizeChange();
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipDrawable(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
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
        if (!(interceptable == null || interceptable.invokeL(65538, this, drawable) == null) || drawable == null) {
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

    private void calculateChipIconBounds(@NonNull Rect rect, @NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, rect, rectF) == null) {
            rectF.setEmpty();
            if (showsChipIcon() || showsCheckedIcon()) {
                float f2 = this.chipStartPadding + this.iconStartPadding;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    float f3 = rect.left + f2;
                    rectF.left = f3;
                    rectF.right = f3 + this.chipIconSize;
                } else {
                    float f4 = rect.right - f2;
                    rectF.right = f4;
                    rectF.left = f4 - this.chipIconSize;
                }
                float exactCenterY = rect.exactCenterY();
                float f5 = this.chipIconSize;
                float f6 = exactCenterY - (f5 / 2.0f);
                rectF.top = f6;
                rectF.bottom = f6 + f5;
            }
        }
    }

    private void calculateChipTouchBounds(@NonNull Rect rect, @NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, rect, rectF) == null) {
            rectF.set(rect);
            if (showsCloseIcon()) {
                float f2 = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    rectF.right = rect.right - f2;
                } else {
                    rectF.left = rect.left + f2;
                }
            }
        }
    }

    private void calculateCloseIconBounds(@NonNull Rect rect, @NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, rect, rectF) == null) {
            rectF.setEmpty();
            if (showsCloseIcon()) {
                float f2 = this.chipEndPadding + this.closeIconEndPadding;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    float f3 = rect.right - f2;
                    rectF.right = f3;
                    rectF.left = f3 - this.closeIconSize;
                } else {
                    float f4 = rect.left + f2;
                    rectF.left = f4;
                    rectF.right = f4 + this.closeIconSize;
                }
                float exactCenterY = rect.exactCenterY();
                float f5 = this.closeIconSize;
                float f6 = exactCenterY - (f5 / 2.0f);
                rectF.top = f6;
                rectF.bottom = f6 + f5;
            }
        }
    }

    private void calculateCloseIconTouchBounds(@NonNull Rect rect, @NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, rect, rectF) == null) {
            rectF.setEmpty();
            if (showsCloseIcon()) {
                float f2 = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    float f3 = rect.right;
                    rectF.right = f3;
                    rectF.left = f3 - f2;
                } else {
                    int i2 = rect.left;
                    rectF.left = i2;
                    rectF.right = i2 + f2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? this.checkedIconVisible && this.checkedIcon != null && this.checkable : invokeV.booleanValue;
    }

    @NonNull
    public static ChipDrawable createFromAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65546, null, context, attributeSet, i2, i3)) == null) {
            ChipDrawable chipDrawable = new ChipDrawable(context, attributeSet, i2, i3);
            chipDrawable.loadFromAttributes(attributeSet, i2, i3);
            return chipDrawable;
        }
        return (ChipDrawable) invokeLLII.objValue;
    }

    @NonNull
    public static ChipDrawable createFromResource(@NonNull Context context, @XmlRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, context, i2)) == null) {
            AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context, i2, "chip");
            int styleAttribute = parseDrawableXml.getStyleAttribute();
            if (styleAttribute == 0) {
                styleAttribute = R.style.Widget_MaterialComponents_Chip_Entry;
            }
            return createFromAttributes(context, parseDrawableXml, R.attr.chipStandaloneStyle, styleAttribute);
        }
        return (ChipDrawable) invokeLI.objValue;
    }

    private void drawCheckedIcon(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, this, canvas, rect) == null) && showsCheckedIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            RectF rectF = this.rectF;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.checkedIcon.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void drawChipBackground(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, this, canvas, rect) == null) || this.isShapeThemingEnabled) {
            return;
        }
        this.chipPaint.setColor(this.currentChipBackgroundColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.chipPaint.setColorFilter(getTintColorFilter());
        this.rectF.set(rect);
        canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
    }

    private void drawChipIcon(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65550, this, canvas, rect) == null) && showsChipIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            RectF rectF = this.rectF;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.chipIcon.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void drawChipStroke(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, this, canvas, rect) == null) || this.chipStrokeWidth <= 0.0f || this.isShapeThemingEnabled) {
            return;
        }
        this.chipPaint.setColor(this.currentChipStrokeColor);
        this.chipPaint.setStyle(Paint.Style.STROKE);
        if (!this.isShapeThemingEnabled) {
            this.chipPaint.setColorFilter(getTintColorFilter());
        }
        RectF rectF = this.rectF;
        float f2 = this.chipStrokeWidth;
        rectF.set(rect.left + (f2 / 2.0f), rect.top + (f2 / 2.0f), rect.right - (f2 / 2.0f), rect.bottom - (f2 / 2.0f));
        float f3 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
        canvas.drawRoundRect(this.rectF, f3, f3, this.chipPaint);
    }

    private void drawChipSurface(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, this, canvas, rect) == null) || this.isShapeThemingEnabled) {
            return;
        }
        this.chipPaint.setColor(this.currentChipSurfaceColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(rect);
        canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
    }

    private void drawCloseIcon(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65553, this, canvas, rect) == null) && showsCloseIcon()) {
            calculateCloseIconBounds(rect, this.rectF);
            RectF rectF = this.rectF;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.closeIconRipple.setBounds(this.closeIcon.getBounds());
                this.closeIconRipple.jumpToCurrentState();
                this.closeIconRipple.draw(canvas);
            } else {
                this.closeIcon.draw(canvas);
            }
            canvas.translate(-f2, -f3);
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

    private void drawDebug(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, this, canvas, rect) == null) || (paint = this.debugPaint) == null) {
            return;
        }
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
        this.debugPaint.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, 127));
        calculateChipTouchBounds(rect, this.rectF);
        canvas.drawRect(this.rectF, this.debugPaint);
        this.debugPaint.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
        calculateCloseIconTouchBounds(rect, this.rectF);
        canvas.drawRect(this.rectF, this.debugPaint);
    }

    private void drawText(@NonNull Canvas canvas, @NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, this, canvas, rect) == null) || this.text == null) {
            return;
        }
        Paint.Align calculateTextOriginAndAlignment = calculateTextOriginAndAlignment(rect, this.pointF);
        calculateTextBounds(rect, this.rectF);
        if (this.textDrawableHelper.getTextAppearance() != null) {
            this.textDrawableHelper.getTextPaint().drawableState = getState();
            this.textDrawableHelper.updateTextPaintDrawState(this.context);
        }
        this.textDrawableHelper.getTextPaint().setTextAlign(calculateTextOriginAndAlignment);
        int i2 = 0;
        boolean z = Math.round(this.textDrawableHelper.getTextWidth(getText().toString())) > Math.round(this.rectF.width());
        if (z) {
            i2 = canvas.save();
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
            canvas.restoreToCount(i2);
        }
    }

    @Nullable
    private ColorFilter getTintColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            ColorFilter colorFilter = this.colorFilter;
            return colorFilter != null ? colorFilter : this.tintFilter;
        }
        return (ColorFilter) invokeV.objValue;
    }

    public static boolean hasState(@Nullable int[] iArr, @AttrRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, iArr, i2)) == null) {
            if (iArr == null) {
                return false;
            }
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    private void loadFromAttributes(@Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65562, this, attributeSet, i2, i3) == null) {
            TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.context, attributeSet, R.styleable.Chip, i2, i3, new int[0]);
            this.isShapeThemingEnabled = obtainStyledAttributes.hasValue(R.styleable.Chip_shapeAppearance);
            setChipSurfaceColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_chipSurfaceColor));
            setChipBackgroundColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_chipBackgroundColor));
            setChipMinHeight(obtainStyledAttributes.getDimension(R.styleable.Chip_chipMinHeight, 0.0f));
            if (obtainStyledAttributes.hasValue(R.styleable.Chip_chipCornerRadius)) {
                setChipCornerRadius(obtainStyledAttributes.getDimension(R.styleable.Chip_chipCornerRadius, 0.0f));
            }
            setChipStrokeColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_chipStrokeColor));
            setChipStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.Chip_chipStrokeWidth, 0.0f));
            setRippleColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_rippleColor));
            setText(obtainStyledAttributes.getText(R.styleable.Chip_android_text));
            setTextAppearance(MaterialResources.getTextAppearance(this.context, obtainStyledAttributes, R.styleable.Chip_android_textAppearance));
            int i4 = obtainStyledAttributes.getInt(R.styleable.Chip_android_ellipsize, 0);
            if (i4 == 1) {
                setEllipsize(TextUtils.TruncateAt.START);
            } else if (i4 == 2) {
                setEllipsize(TextUtils.TruncateAt.MIDDLE);
            } else if (i4 == 3) {
                setEllipsize(TextUtils.TruncateAt.END);
            }
            setChipIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_chipIconVisible, false));
            if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "chipIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "chipIconVisible") == null) {
                setChipIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_chipIconEnabled, false));
            }
            setChipIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, R.styleable.Chip_chipIcon));
            if (obtainStyledAttributes.hasValue(R.styleable.Chip_chipIconTint)) {
                setChipIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_chipIconTint));
            }
            setChipIconSize(obtainStyledAttributes.getDimension(R.styleable.Chip_chipIconSize, 0.0f));
            setCloseIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_closeIconVisible, false));
            if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "closeIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "closeIconVisible") == null) {
                setCloseIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_closeIconEnabled, false));
            }
            setCloseIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, R.styleable.Chip_closeIcon));
            setCloseIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_closeIconTint));
            setCloseIconSize(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconSize, 0.0f));
            setCheckable(obtainStyledAttributes.getBoolean(R.styleable.Chip_android_checkable, false));
            setCheckedIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_checkedIconVisible, false));
            if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "checkedIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "checkedIconVisible") == null) {
                setCheckedIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_checkedIconEnabled, false));
            }
            setCheckedIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, R.styleable.Chip_checkedIcon));
            if (obtainStyledAttributes.hasValue(R.styleable.Chip_checkedIconTint)) {
                setCheckedIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_checkedIconTint));
            }
            setShowMotionSpec(MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, R.styleable.Chip_showMotionSpec));
            setHideMotionSpec(MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, R.styleable.Chip_hideMotionSpec));
            setChipStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_chipStartPadding, 0.0f));
            setIconStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_iconStartPadding, 0.0f));
            setIconEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_iconEndPadding, 0.0f));
            setTextStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_textStartPadding, 0.0f));
            setTextEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_textEndPadding, 0.0f));
            setCloseIconStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconStartPadding, 0.0f));
            setCloseIconEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconEndPadding, 0.0f));
            setChipEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_chipEndPadding, 0.0f));
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
            obtainStyledAttributes.recycle();
        }
    }

    private void setChipSurfaceColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65564, this, colorStateList) == null) || this.chipSurfaceColor == colorStateList) {
            return;
        }
        this.chipSurfaceColor = colorStateList;
        onStateChange(getState());
    }

    private boolean showsCheckedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) ? this.checkedIconVisible && this.checkedIcon != null && this.currentChecked : invokeV.booleanValue;
    }

    private boolean showsChipIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) ? this.chipIconVisible && this.chipIcon != null : invokeV.booleanValue;
    }

    private boolean showsCloseIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) ? this.closeIconVisible && this.closeIcon != null : invokeV.booleanValue;
    }

    private void unapplyChildDrawable(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65568, this, drawable) == null) || drawable == null) {
            return;
        }
        drawable.setCallback(null);
    }

    private void updateCompatRippleColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            this.compatRippleColor = this.useCompatRipple ? RippleUtils.sanitizeRippleDrawableColor(this.rippleColor) : null;
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
            if (showsChipIcon() || showsCheckedIcon()) {
                return this.iconStartPadding + this.chipIconSize + this.iconEndPadding;
            }
            return 0.0f;
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

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            Rect bounds = getBounds();
            if (bounds.isEmpty() || getAlpha() == 0) {
                return;
            }
            int i2 = this.alpha;
            int saveLayerAlpha = i2 < 255 ? CanvasCompat.saveLayerAlpha(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i2) : 0;
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
                canvas.restoreToCount(saveLayerAlpha);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.alpha : invokeV.intValue;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.checkedIcon : (Drawable) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.checkedIconTint : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.chipBackgroundColor : (ColorStateList) invokeV.objValue;
    }

    public float getChipCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isShapeThemingEnabled ? getTopLeftCornerResolvedSize() : this.chipCornerRadius : invokeV.floatValue;
    }

    public float getChipEndPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.chipEndPadding : invokeV.floatValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.chipIconSize : invokeV.floatValue;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.chipIconTint : (ColorStateList) invokeV.objValue;
    }

    public float getChipMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.chipMinHeight : invokeV.floatValue;
    }

    public float getChipStartPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.chipStartPadding : invokeV.floatValue;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.chipStrokeColor : (ColorStateList) invokeV.objValue;
    }

    public float getChipStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.chipStrokeWidth : invokeV.floatValue;
    }

    public void getChipTouchBounds(@NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, rectF) == null) {
            calculateChipTouchBounds(getBounds(), rectF);
        }
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.closeIconContentDescription : (CharSequence) invokeV.objValue;
    }

    public float getCloseIconEndPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.closeIconEndPadding : invokeV.floatValue;
    }

    public float getCloseIconSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.closeIconSize : invokeV.floatValue;
    }

    public float getCloseIconStartPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.closeIconStartPadding : invokeV.floatValue;
    }

    @NonNull
    public int[] getCloseIconState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.closeIconStateSet : (int[]) invokeV.objValue;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.closeIconTint : (ColorStateList) invokeV.objValue;
    }

    public void getCloseIconTouchBounds(@NonNull RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, rectF) == null) {
            calculateCloseIconTouchBounds(getBounds(), rectF);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.colorFilter : (ColorFilter) invokeV.objValue;
    }

    public TextUtils.TruncateAt getEllipsize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.truncateAt : (TextUtils.TruncateAt) invokeV.objValue;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.hideMotionSpec : (MotionSpec) invokeV.objValue;
    }

    public float getIconEndPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.iconEndPadding : invokeV.floatValue;
    }

    public float getIconStartPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.iconStartPadding : invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? (int) this.chipMinHeight : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? Math.min(Math.round(this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding + this.textDrawableHelper.getTextWidth(getText().toString()) + this.textEndPadding + calculateCloseIconWidth() + this.chipEndPadding), this.maxWidth) : invokeV.intValue;
    }

    @Px
    public int getMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.maxWidth : invokeV.intValue;
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

    @Nullable
    public ColorStateList getRippleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.rippleColor : (ColorStateList) invokeV.objValue;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.showMotionSpec : (MotionSpec) invokeV.objValue;
    }

    @Nullable
    public CharSequence getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.text : (CharSequence) invokeV.objValue;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.textDrawableHelper.getTextAppearance() : (TextAppearance) invokeV.objValue;
    }

    public float getTextEndPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.textEndPadding : invokeV.floatValue;
    }

    public float getTextStartPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.textStartPadding : invokeV.floatValue;
    }

    public boolean getUseCompatRipple() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.useCompatRipple : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, drawable) == null) || (callback = getCallback()) == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    public boolean isCheckable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.checkable : invokeV.booleanValue;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? isCheckedIconVisible() : invokeV.booleanValue;
    }

    public boolean isCheckedIconVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.checkedIconVisible : invokeV.booleanValue;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? isChipIconVisible() : invokeV.booleanValue;
    }

    public boolean isChipIconVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.chipIconVisible : invokeV.booleanValue;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? isCloseIconVisible() : invokeV.booleanValue;
    }

    public boolean isCloseIconStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? isStateful(this.closeIcon) : invokeV.booleanValue;
    }

    public boolean isCloseIconVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.closeIconVisible : invokeV.booleanValue;
    }

    public boolean isShapeThemingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.isShapeThemingEnabled : invokeV.booleanValue;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? isStateful(this.chipSurfaceColor) || isStateful(this.chipBackgroundColor) || isStateful(this.chipStrokeColor) || (this.useCompatRipple && isStateful(this.compatRippleColor)) || isStateful(this.textDrawableHelper.getTextAppearance()) || canShowCheckedIcon() || isStateful(this.chipIcon) || isStateful(this.checkedIcon) || isStateful(this.tint) : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i2)) == null) {
            boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
            if (showsChipIcon()) {
                onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.chipIcon, i2);
            }
            if (showsCheckedIcon()) {
                onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.checkedIcon, i2);
            }
            if (showsCloseIcon()) {
                onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.closeIcon, i2);
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
    public boolean onLevelChange(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) {
            boolean onLevelChange = super.onLevelChange(i2);
            if (showsChipIcon()) {
                onLevelChange |= this.chipIcon.setLevel(i2);
            }
            if (showsCheckedIcon()) {
                onLevelChange |= this.checkedIcon.setLevel(i2);
            }
            if (showsCloseIcon()) {
                onLevelChange |= this.closeIcon.setLevel(i2);
            }
            if (onLevelChange) {
                invalidateSelf();
            }
            return onLevelChange;
        }
        return invokeI.booleanValue;
    }

    public void onSizeChange() {
        Delegate delegate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || (delegate = this.delegate.get()) == null) {
            return;
        }
        delegate.onChipDrawableSizeChange();
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

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            onSizeChange();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{drawable, runnable, Long.valueOf(j)}) == null) || (callback = getCallback()) == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048636, this, i2) == null) || this.alpha == i2) {
            return;
        }
        this.alpha = i2;
        invalidateSelf();
    }

    public void setCheckable(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048637, this, z) == null) || this.checkable == z) {
            return;
        }
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

    public void setCheckableResource(@BoolRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            setCheckable(this.context.getResources().getBoolean(i2));
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048639, this, drawable) == null) || this.checkedIcon == drawable) {
            return;
        }
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

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            setCheckedIconVisible(z);
        }
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            setCheckedIconVisible(this.context.getResources().getBoolean(i2));
        }
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            setCheckedIcon(AppCompatResources.getDrawable(this.context, i2));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048643, this, colorStateList) == null) || this.checkedIconTint == colorStateList) {
            return;
        }
        this.checkedIconTint = colorStateList;
        if (canShowCheckedIcon()) {
            DrawableCompat.setTintList(this.checkedIcon, colorStateList);
        }
        onStateChange(getState());
    }

    public void setCheckedIconTintResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            setCheckedIconTint(AppCompatResources.getColorStateList(this.context, i2));
        }
    }

    public void setCheckedIconVisible(@BoolRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
            setCheckedIconVisible(this.context.getResources().getBoolean(i2));
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048647, this, colorStateList) == null) || this.chipBackgroundColor == colorStateList) {
            return;
        }
        this.chipBackgroundColor = colorStateList;
        onStateChange(getState());
    }

    public void setChipBackgroundColorResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i2) == null) {
            setChipBackgroundColor(AppCompatResources.getColorStateList(this.context, i2));
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048649, this, f2) == null) || this.chipCornerRadius == f2) {
            return;
        }
        this.chipCornerRadius = f2;
        setShapeAppearanceModel(getShapeAppearanceModel().withCornerSize(f2));
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            setChipCornerRadius(this.context.getResources().getDimension(i2));
        }
    }

    public void setChipEndPadding(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048651, this, f2) == null) || this.chipEndPadding == f2) {
            return;
        }
        this.chipEndPadding = f2;
        invalidateSelf();
        onSizeChange();
    }

    public void setChipEndPaddingResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            setChipEndPadding(this.context.getResources().getDimension(i2));
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        Drawable chipIcon;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048653, this, drawable) == null) || (chipIcon = getChipIcon()) == drawable) {
            return;
        }
        float calculateChipIconWidth = calculateChipIconWidth();
        this.chipIcon = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
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

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            setChipIconVisible(z);
        }
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i2) == null) {
            setChipIconVisible(i2);
        }
    }

    public void setChipIconResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i2) == null) {
            setChipIcon(AppCompatResources.getDrawable(this.context, i2));
        }
    }

    public void setChipIconSize(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048657, this, f2) == null) || this.chipIconSize == f2) {
            return;
        }
        float calculateChipIconWidth = calculateChipIconWidth();
        this.chipIconSize = f2;
        float calculateChipIconWidth2 = calculateChipIconWidth();
        invalidateSelf();
        if (calculateChipIconWidth != calculateChipIconWidth2) {
            onSizeChange();
        }
    }

    public void setChipIconSizeResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i2) == null) {
            setChipIconSize(this.context.getResources().getDimension(i2));
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

    public void setChipIconTintResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i2) == null) {
            setChipIconTint(AppCompatResources.getColorStateList(this.context, i2));
        }
    }

    public void setChipIconVisible(@BoolRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i2) == null) {
            setChipIconVisible(this.context.getResources().getBoolean(i2));
        }
    }

    public void setChipMinHeight(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048663, this, f2) == null) || this.chipMinHeight == f2) {
            return;
        }
        this.chipMinHeight = f2;
        invalidateSelf();
        onSizeChange();
    }

    public void setChipMinHeightResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048664, this, i2) == null) {
            setChipMinHeight(this.context.getResources().getDimension(i2));
        }
    }

    public void setChipStartPadding(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048665, this, f2) == null) || this.chipStartPadding == f2) {
            return;
        }
        this.chipStartPadding = f2;
        invalidateSelf();
        onSizeChange();
    }

    public void setChipStartPaddingResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048666, this, i2) == null) {
            setChipStartPadding(this.context.getResources().getDimension(i2));
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048667, this, colorStateList) == null) || this.chipStrokeColor == colorStateList) {
            return;
        }
        this.chipStrokeColor = colorStateList;
        if (this.isShapeThemingEnabled) {
            setStrokeColor(colorStateList);
        }
        onStateChange(getState());
    }

    public void setChipStrokeColorResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i2) == null) {
            setChipStrokeColor(AppCompatResources.getColorStateList(this.context, i2));
        }
    }

    public void setChipStrokeWidth(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048669, this, f2) == null) || this.chipStrokeWidth == f2) {
            return;
        }
        this.chipStrokeWidth = f2;
        this.chipPaint.setStrokeWidth(f2);
        if (this.isShapeThemingEnabled) {
            super.setStrokeWidth(f2);
        }
        invalidateSelf();
    }

    public void setChipStrokeWidthResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048670, this, i2) == null) {
            setChipStrokeWidth(this.context.getResources().getDimension(i2));
        }
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        Drawable closeIcon;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048671, this, drawable) == null) || (closeIcon = getCloseIcon()) == drawable) {
            return;
        }
        float calculateCloseIconWidth = calculateCloseIconWidth();
        this.closeIcon = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
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

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048672, this, charSequence) == null) || this.closeIconContentDescription == charSequence) {
            return;
        }
        this.closeIconContentDescription = BidiFormatter.getInstance().unicodeWrap(charSequence);
        invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z) == null) {
            setCloseIconVisible(z);
        }
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048674, this, i2) == null) {
            setCloseIconVisible(i2);
        }
    }

    public void setCloseIconEndPadding(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048675, this, f2) == null) || this.closeIconEndPadding == f2) {
            return;
        }
        this.closeIconEndPadding = f2;
        invalidateSelf();
        if (showsCloseIcon()) {
            onSizeChange();
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048676, this, i2) == null) {
            setCloseIconEndPadding(this.context.getResources().getDimension(i2));
        }
    }

    public void setCloseIconResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048677, this, i2) == null) {
            setCloseIcon(AppCompatResources.getDrawable(this.context, i2));
        }
    }

    public void setCloseIconSize(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048678, this, f2) == null) || this.closeIconSize == f2) {
            return;
        }
        this.closeIconSize = f2;
        invalidateSelf();
        if (showsCloseIcon()) {
            onSizeChange();
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048679, this, i2) == null) {
            setCloseIconSize(this.context.getResources().getDimension(i2));
        }
    }

    public void setCloseIconStartPadding(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048680, this, f2) == null) || this.closeIconStartPadding == f2) {
            return;
        }
        this.closeIconStartPadding = f2;
        invalidateSelf();
        if (showsCloseIcon()) {
            onSizeChange();
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048681, this, i2) == null) {
            setCloseIconStartPadding(this.context.getResources().getDimension(i2));
        }
    }

    public boolean setCloseIconState(@NonNull int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048682, this, iArr)) == null) {
            if (Arrays.equals(this.closeIconStateSet, iArr)) {
                return false;
            }
            this.closeIconStateSet = iArr;
            if (showsCloseIcon()) {
                return onStateChange(getState(), iArr);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048683, this, colorStateList) == null) || this.closeIconTint == colorStateList) {
            return;
        }
        this.closeIconTint = colorStateList;
        if (showsCloseIcon()) {
            DrawableCompat.setTintList(this.closeIcon, colorStateList);
        }
        onStateChange(getState());
    }

    public void setCloseIconTintResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i2) == null) {
            setCloseIconTint(AppCompatResources.getColorStateList(this.context, i2));
        }
    }

    public void setCloseIconVisible(@BoolRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048685, this, i2) == null) {
            setCloseIconVisible(this.context.getResources().getBoolean(i2));
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048687, this, colorFilter) == null) || this.colorFilter == colorFilter) {
            return;
        }
        this.colorFilter = colorFilter;
        invalidateSelf();
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

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048691, this, i2) == null) {
            setHideMotionSpec(MotionSpec.createFromResource(this.context, i2));
        }
    }

    public void setIconEndPadding(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048692, this, f2) == null) || this.iconEndPadding == f2) {
            return;
        }
        float calculateChipIconWidth = calculateChipIconWidth();
        this.iconEndPadding = f2;
        float calculateChipIconWidth2 = calculateChipIconWidth();
        invalidateSelf();
        if (calculateChipIconWidth != calculateChipIconWidth2) {
            onSizeChange();
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048693, this, i2) == null) {
            setIconEndPadding(this.context.getResources().getDimension(i2));
        }
    }

    public void setIconStartPadding(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048694, this, f2) == null) || this.iconStartPadding == f2) {
            return;
        }
        float calculateChipIconWidth = calculateChipIconWidth();
        this.iconStartPadding = f2;
        float calculateChipIconWidth2 = calculateChipIconWidth();
        invalidateSelf();
        if (calculateChipIconWidth != calculateChipIconWidth2) {
            onSizeChange();
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048695, this, i2) == null) {
            setIconStartPadding(this.context.getResources().getDimension(i2));
        }
    }

    public void setMaxWidth(@Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i2) == null) {
            this.maxWidth = i2;
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048697, this, colorStateList) == null) || this.rippleColor == colorStateList) {
            return;
        }
        this.rippleColor = colorStateList;
        updateCompatRippleColor();
        onStateChange(getState());
    }

    public void setRippleColorResource(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048698, this, i2) == null) {
            setRippleColor(AppCompatResources.getColorStateList(this.context, i2));
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

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048701, this, i2) == null) {
            setShowMotionSpec(MotionSpec.createFromResource(this.context, i2));
        }
    }

    public void setText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, charSequence) == null) {
            if (charSequence == null) {
                charSequence = "";
            }
            if (TextUtils.equals(this.text, charSequence)) {
                return;
            }
            this.text = charSequence;
            this.textDrawableHelper.setTextWidthDirty(true);
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, textAppearance) == null) {
            this.textDrawableHelper.setTextAppearance(textAppearance, this.context);
        }
    }

    public void setTextAppearanceResource(@StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048704, this, i2) == null) {
            setTextAppearance(new TextAppearance(this.context, i2));
        }
    }

    public void setTextEndPadding(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048705, this, f2) == null) || this.textEndPadding == f2) {
            return;
        }
        this.textEndPadding = f2;
        invalidateSelf();
        onSizeChange();
    }

    public void setTextEndPaddingResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048706, this, i2) == null) {
            setTextEndPadding(this.context.getResources().getDimension(i2));
        }
    }

    public void setTextResource(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048707, this, i2) == null) {
            setText(this.context.getResources().getString(i2));
        }
    }

    public void setTextStartPadding(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048708, this, f2) == null) || this.textStartPadding == f2) {
            return;
        }
        this.textStartPadding = f2;
        invalidateSelf();
        onSizeChange();
    }

    public void setTextStartPaddingResource(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048709, this, i2) == null) {
            setTextStartPadding(this.context.getResources().getDimension(i2));
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048710, this, colorStateList) == null) || this.tint == colorStateList) {
            return;
        }
        this.tint = colorStateList;
        onStateChange(getState());
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048711, this, mode) == null) || this.tintMode == mode) {
            return;
        }
        this.tintMode = mode;
        this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, mode);
        invalidateSelf();
    }

    public void setUseCompatRipple(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048712, this, z) == null) || this.useCompatRipple == z) {
            return;
        }
        this.useCompatRipple = z;
        updateCompatRippleColor();
        onStateChange(getState());
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

    public boolean shouldDrawText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? this.shouldDrawText : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048715, this, drawable, runnable) == null) || (callback = getCallback()) == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void setCheckedIconVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048646, this, z) == null) || this.checkedIconVisible == z) {
            return;
        }
        boolean showsCheckedIcon = showsCheckedIcon();
        this.checkedIconVisible = z;
        boolean showsCheckedIcon2 = showsCheckedIcon();
        if (showsCheckedIcon != showsCheckedIcon2) {
            if (showsCheckedIcon2) {
                applyChildDrawable(this.checkedIcon);
            } else {
                unapplyChildDrawable(this.checkedIcon);
            }
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipIconVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048662, this, z) == null) || this.chipIconVisible == z) {
            return;
        }
        boolean showsChipIcon = showsChipIcon();
        this.chipIconVisible = z;
        boolean showsChipIcon2 = showsChipIcon();
        if (showsChipIcon != showsChipIcon2) {
            if (showsChipIcon2) {
                applyChildDrawable(this.chipIcon);
            } else {
                unapplyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setCloseIconVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048686, this, z) == null) || this.closeIconVisible == z) {
            return;
        }
        boolean showsCloseIcon = showsCloseIcon();
        this.closeIconVisible = z;
        boolean showsCloseIcon2 = showsCloseIcon();
        if (showsCloseIcon != showsCloseIcon2) {
            if (showsCloseIcon2) {
                applyChildDrawable(this.closeIcon);
            } else {
                unapplyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            onSizeChange();
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
        boolean z;
        int colorForState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, this, iArr, iArr2)) == null) {
            boolean onStateChange = super.onStateChange(iArr);
            ColorStateList colorStateList = this.chipSurfaceColor;
            int colorForState2 = colorStateList != null ? colorStateList.getColorForState(iArr, this.currentChipSurfaceColor) : 0;
            boolean z2 = true;
            if (this.currentChipSurfaceColor != colorForState2) {
                this.currentChipSurfaceColor = colorForState2;
                onStateChange = true;
            }
            ColorStateList colorStateList2 = this.chipBackgroundColor;
            int colorForState3 = colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.currentChipBackgroundColor) : 0;
            if (this.currentChipBackgroundColor != colorForState3) {
                this.currentChipBackgroundColor = colorForState3;
                onStateChange = true;
            }
            int layer = MaterialColors.layer(colorForState2, colorForState3);
            if ((this.currentCompositeSurfaceBackgroundColor != layer) | (getFillColor() == null)) {
                this.currentCompositeSurfaceBackgroundColor = layer;
                setFillColor(ColorStateList.valueOf(layer));
                onStateChange = true;
            }
            ColorStateList colorStateList3 = this.chipStrokeColor;
            int colorForState4 = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.currentChipStrokeColor) : 0;
            if (this.currentChipStrokeColor != colorForState4) {
                this.currentChipStrokeColor = colorForState4;
                onStateChange = true;
            }
            int colorForState5 = (this.compatRippleColor == null || !RippleUtils.shouldDrawRippleCompat(iArr)) ? 0 : this.compatRippleColor.getColorForState(iArr, this.currentCompatRippleColor);
            if (this.currentCompatRippleColor != colorForState5) {
                this.currentCompatRippleColor = colorForState5;
                if (this.useCompatRipple) {
                    onStateChange = true;
                }
            }
            int colorForState6 = (this.textDrawableHelper.getTextAppearance() == null || this.textDrawableHelper.getTextAppearance().textColor == null) ? 0 : this.textDrawableHelper.getTextAppearance().textColor.getColorForState(iArr, this.currentTextColor);
            if (this.currentTextColor != colorForState6) {
                this.currentTextColor = colorForState6;
                onStateChange = true;
            }
            boolean z3 = hasState(getState(), 16842912) && this.checkable;
            if (this.currentChecked != z3 && this.checkedIcon != null) {
                float calculateChipIconWidth = calculateChipIconWidth();
                this.currentChecked = z3;
                if (calculateChipIconWidth != calculateChipIconWidth()) {
                    onStateChange = true;
                    z = true;
                    ColorStateList colorStateList4 = this.tint;
                    colorForState = colorStateList4 == null ? colorStateList4.getColorForState(iArr, this.currentTint) : 0;
                    if (this.currentTint == colorForState) {
                        this.currentTint = colorForState;
                        this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, this.tintMode);
                    } else {
                        z2 = onStateChange;
                    }
                    if (isStateful(this.chipIcon)) {
                        z2 |= this.chipIcon.setState(iArr);
                    }
                    if (isStateful(this.checkedIcon)) {
                        z2 |= this.checkedIcon.setState(iArr);
                    }
                    if (isStateful(this.closeIcon)) {
                        int[] iArr3 = new int[iArr.length + iArr2.length];
                        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                        System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
                        z2 |= this.closeIcon.setState(iArr3);
                    }
                    if (RippleUtils.USE_FRAMEWORK_RIPPLE && isStateful(this.closeIconRipple)) {
                        z2 |= this.closeIconRipple.setState(iArr2);
                    }
                    if (z2) {
                        invalidateSelf();
                    }
                    if (z) {
                        onSizeChange();
                    }
                    return z2;
                }
                onStateChange = true;
            }
            z = false;
            ColorStateList colorStateList42 = this.tint;
            if (colorStateList42 == null) {
            }
            if (this.currentTint == colorForState) {
            }
            if (isStateful(this.chipIcon)) {
            }
            if (isStateful(this.checkedIcon)) {
            }
            if (isStateful(this.closeIcon)) {
            }
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                z2 |= this.closeIconRipple.setState(iArr2);
            }
            if (z2) {
            }
            if (z) {
            }
            return z2;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isStateful(@Nullable ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, colorStateList)) == null) ? colorStateList != null && colorStateList.isStateful() : invokeL.booleanValue;
    }

    public static boolean isStateful(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, drawable)) == null) ? drawable != null && drawable.isStateful() : invokeL.booleanValue;
    }

    public static boolean isStateful(@Nullable TextAppearance textAppearance) {
        InterceptResult invokeL;
        ColorStateList colorStateList;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, textAppearance)) == null) ? (textAppearance == null || (colorStateList = textAppearance.textColor) == null || !colorStateList.isStateful()) ? false : true : invokeL.booleanValue;
    }
}
