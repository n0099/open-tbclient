package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class CollapsingTextHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG_DRAW = false;
    @NonNull
    public static final Paint DEBUG_DRAW_PAINT;
    public static final String ELLIPSIS_NORMAL = "…";
    public static final String TAG = "CollapsingTextHelper";
    public static final boolean USE_SCALING_TEXTURE;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean boundsChanged;
    @NonNull
    public final Rect collapsedBounds;
    public float collapsedDrawX;
    public float collapsedDrawY;
    public CancelableFontCallback collapsedFontCallback;
    public ColorStateList collapsedShadowColor;
    public float collapsedShadowDx;
    public float collapsedShadowDy;
    public float collapsedShadowRadius;
    public float collapsedTextBlend;
    public ColorStateList collapsedTextColor;
    public int collapsedTextGravity;
    public float collapsedTextSize;
    public Typeface collapsedTypeface;
    @NonNull
    public final RectF currentBounds;
    public float currentDrawX;
    public float currentDrawY;
    public float currentTextSize;
    public Typeface currentTypeface;
    public boolean drawTitle;
    @NonNull
    public final Rect expandedBounds;
    public float expandedDrawX;
    public float expandedDrawY;
    public float expandedFirstLineDrawX;
    public CancelableFontCallback expandedFontCallback;
    public float expandedFraction;
    public ColorStateList expandedShadowColor;
    public float expandedShadowDx;
    public float expandedShadowDy;
    public float expandedShadowRadius;
    public float expandedTextBlend;
    public ColorStateList expandedTextColor;
    public int expandedTextGravity;
    public float expandedTextSize;
    @Nullable
    public Bitmap expandedTitleTexture;
    public Typeface expandedTypeface;
    public boolean isRtl;
    public int maxLines;
    public TimeInterpolator positionInterpolator;
    public float scale;
    public int[] state;
    @Nullable
    public CharSequence text;
    public StaticLayout textLayout;
    @NonNull
    public final TextPaint textPaint;
    public TimeInterpolator textSizeInterpolator;
    @Nullable
    public CharSequence textToDraw;
    public CharSequence textToDrawCollapsed;
    public Paint texturePaint;
    @NonNull
    public final TextPaint tmpPaint;
    public boolean useTexture;
    public final View view;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1671437040, "Lcom/google/android/material/internal/CollapsingTextHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1671437040, "Lcom/google/android/material/internal/CollapsingTextHelper;");
                return;
            }
        }
        USE_SCALING_TEXTURE = Build.VERSION.SDK_INT < 18;
        Paint paint = null;
        DEBUG_DRAW_PAINT = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            DEBUG_DRAW_PAINT.setColor(-65281);
        }
    }

    public CollapsingTextHelper(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.expandedTextGravity = 16;
        this.collapsedTextGravity = 16;
        this.expandedTextSize = 15.0f;
        this.collapsedTextSize = 15.0f;
        this.maxLines = 1;
        this.view = view;
        this.textPaint = new TextPaint(129);
        this.tmpPaint = new TextPaint(this.textPaint);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
    }

    public static int blendColors(int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) {
            float f3 = 1.0f - f2;
            return Color.argb((int) ((Color.alpha(i2) * f3) + (Color.alpha(i3) * f2)), (int) ((Color.red(i2) * f3) + (Color.red(i3) * f2)), (int) ((Color.green(i2) * f3) + (Color.green(i3) * f2)), (int) ((Color.blue(i2) * f3) + (Color.blue(i3) * f2)));
        }
        return invokeCommon.intValue;
    }

    private void calculateBaseOffsets() {
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            float f2 = this.currentTextSize;
            calculateUsingTextSize(this.collapsedTextSize);
            CharSequence charSequence = this.textToDraw;
            if (charSequence != null && (staticLayout2 = this.textLayout) != null) {
                this.textToDrawCollapsed = TextUtils.ellipsize(charSequence, this.textPaint, staticLayout2.getWidth(), TextUtils.TruncateAt.END);
            }
            CharSequence charSequence2 = this.textToDrawCollapsed;
            float measureText = charSequence2 != null ? this.textPaint.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
            int absoluteGravity = GravityCompat.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
            int i2 = absoluteGravity & 112;
            if (i2 == 48) {
                this.collapsedDrawY = this.collapsedBounds.top;
            } else if (i2 != 80) {
                this.collapsedDrawY = this.collapsedBounds.centerY() - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
            } else {
                this.collapsedDrawY = this.collapsedBounds.bottom + this.textPaint.ascent();
            }
            int i3 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            if (i3 == 1) {
                this.collapsedDrawX = this.collapsedBounds.centerX() - (measureText / 2.0f);
            } else if (i3 != 5) {
                this.collapsedDrawX = this.collapsedBounds.left;
            } else {
                this.collapsedDrawX = this.collapsedBounds.right - measureText;
            }
            calculateUsingTextSize(this.expandedTextSize);
            float height = this.textLayout != null ? staticLayout.getHeight() : 0.0f;
            CharSequence charSequence3 = this.textToDraw;
            float measureText2 = charSequence3 != null ? this.textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
            StaticLayout staticLayout3 = this.textLayout;
            if (staticLayout3 != null && this.maxLines > 1 && !this.isRtl) {
                measureText2 = staticLayout3.getWidth();
            }
            StaticLayout staticLayout4 = this.textLayout;
            this.expandedFirstLineDrawX = staticLayout4 != null ? staticLayout4.getLineLeft(0) : 0.0f;
            int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
            int i4 = absoluteGravity2 & 112;
            if (i4 == 48) {
                this.expandedDrawY = this.expandedBounds.top;
            } else if (i4 != 80) {
                this.expandedDrawY = this.expandedBounds.centerY() - (height / 2.0f);
            } else {
                this.expandedDrawY = (this.expandedBounds.bottom - height) + this.textPaint.descent();
            }
            int i5 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            if (i5 == 1) {
                this.expandedDrawX = this.expandedBounds.centerX() - (measureText2 / 2.0f);
            } else if (i5 != 5) {
                this.expandedDrawX = this.expandedBounds.left;
            } else {
                this.expandedDrawX = this.expandedBounds.right - measureText2;
            }
            clearTexture();
            setInterpolatedTextSize(f2);
        }
    }

    private void calculateCurrentOffsets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            calculateOffsets(this.expandedFraction);
        }
    }

    private boolean calculateIsRtl(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, charSequence)) == null) {
            return (isDefaultIsRtl() ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
        }
        return invokeL.booleanValue;
    }

    private void calculateOffsets(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65542, this, f2) == null) {
            interpolateBounds(f2);
            this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f2, this.positionInterpolator);
            this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f2, this.positionInterpolator);
            setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f2, this.textSizeInterpolator));
            setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - f2, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            setExpandedTextBlend(lerp(1.0f, 0.0f, f2, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            if (this.collapsedTextColor != this.expandedTextColor) {
                this.textPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f2));
            } else {
                this.textPaint.setColor(getCurrentCollapsedTextColor());
            }
            this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f2, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f2, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f2, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f2));
            ViewCompat.postInvalidateOnAnimation(this.view);
        }
    }

    private void calculateUsingTextSize(float f2) {
        boolean z;
        float f3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(65543, this, f2) == null) || this.text == null) {
            return;
        }
        float width = this.collapsedBounds.width();
        float width2 = this.expandedBounds.width();
        if (isClose(f2, this.collapsedTextSize)) {
            f3 = this.collapsedTextSize;
            this.scale = 1.0f;
            Typeface typeface = this.currentTypeface;
            Typeface typeface2 = this.collapsedTypeface;
            if (typeface != typeface2) {
                this.currentTypeface = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            float f4 = this.expandedTextSize;
            Typeface typeface3 = this.currentTypeface;
            Typeface typeface4 = this.expandedTypeface;
            if (typeface3 != typeface4) {
                this.currentTypeface = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (isClose(f2, this.expandedTextSize)) {
                this.scale = 1.0f;
            } else {
                this.scale = f2 / this.expandedTextSize;
            }
            float f5 = this.collapsedTextSize / this.expandedTextSize;
            width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
            f3 = f4;
            z2 = z;
        }
        if (width > 0.0f) {
            z2 = this.currentTextSize != f3 || this.boundsChanged || z2;
            this.currentTextSize = f3;
            this.boundsChanged = false;
        }
        if (this.textToDraw == null || z2) {
            this.textPaint.setTextSize(this.currentTextSize);
            this.textPaint.setTypeface(this.currentTypeface);
            this.textPaint.setLinearText(this.scale != 1.0f);
            this.isRtl = calculateIsRtl(this.text);
            StaticLayout createStaticLayout = createStaticLayout(shouldDrawMultiline() ? this.maxLines : 1, width, this.isRtl);
            this.textLayout = createStaticLayout;
            this.textToDraw = createStaticLayout.getText();
        }
    }

    private void clearTexture() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (bitmap = this.expandedTitleTexture) == null) {
            return;
        }
        bitmap.recycle();
        this.expandedTitleTexture = null;
    }

    private StaticLayout createStaticLayout(int i2, float f2, boolean z) {
        StaticLayout staticLayout;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            try {
                staticLayout = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) f2).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(z).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(i2).build();
            } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e2) {
                e2.getCause().getMessage();
                staticLayout = null;
            }
            return (StaticLayout) Preconditions.checkNotNull(staticLayout);
        }
        return (StaticLayout) invokeCommon.objValue;
    }

    private void drawMultinlineTransition(@NonNull Canvas canvas, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            int alpha = this.textPaint.getAlpha();
            canvas.translate(f2, f3);
            float f4 = alpha;
            this.textPaint.setAlpha((int) (this.expandedTextBlend * f4));
            this.textLayout.draw(canvas);
            this.textPaint.setAlpha((int) (this.collapsedTextBlend * f4));
            int lineBaseline = this.textLayout.getLineBaseline(0);
            CharSequence charSequence = this.textToDrawCollapsed;
            float f5 = lineBaseline;
            canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, this.textPaint);
            String trim = this.textToDrawCollapsed.toString().trim();
            if (trim.endsWith("…")) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.textPaint.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.textLayout.getLineEnd(0), str.length()), 0.0f, f5, (Paint) this.textPaint);
        }
    }

    private void ensureExpandedTexture() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.expandedTitleTexture != null || this.expandedBounds.isEmpty() || TextUtils.isEmpty(this.textToDraw)) {
            return;
        }
        calculateOffsets(0.0f);
        int width = this.textLayout.getWidth();
        int height = this.textLayout.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.expandedTitleTexture = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.textLayout.draw(new Canvas(this.expandedTitleTexture));
        if (this.texturePaint == null) {
            this.texturePaint = new Paint(3);
        }
    }

    private float getCollapsedTextLeftBound(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65548, this, i2, i3)) == null) {
            if (i3 == 17 || (i3 & 7) == 1) {
                return (i2 / 2.0f) - (calculateCollapsedTextWidth() / 2.0f);
            }
            return ((i3 & 8388613) == 8388613 || (i3 & 5) == 5) ? this.isRtl ? this.collapsedBounds.left : this.collapsedBounds.right - calculateCollapsedTextWidth() : this.isRtl ? this.collapsedBounds.right - calculateCollapsedTextWidth() : this.collapsedBounds.left;
        }
        return invokeII.floatValue;
    }

    private float getCollapsedTextRightBound(@NonNull RectF rectF, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65549, this, rectF, i2, i3)) == null) {
            if (i3 == 17 || (i3 & 7) == 1) {
                return (i2 / 2.0f) + (calculateCollapsedTextWidth() / 2.0f);
            }
            return ((i3 & 8388613) == 8388613 || (i3 & 5) == 5) ? this.isRtl ? rectF.left + calculateCollapsedTextWidth() : this.collapsedBounds.right : this.isRtl ? this.collapsedBounds.right : rectF.left + calculateCollapsedTextWidth();
        }
        return invokeLII.floatValue;
    }

    @ColorInt
    private int getCurrentColor(@Nullable ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, colorStateList)) == null) {
            if (colorStateList == null) {
                return 0;
            }
            int[] iArr = this.state;
            if (iArr != null) {
                return colorStateList.getColorForState(iArr, 0);
            }
            return colorStateList.getDefaultColor();
        }
        return invokeL.intValue;
    }

    @ColorInt
    private int getCurrentExpandedTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? getCurrentColor(this.expandedTextColor) : invokeV.intValue;
    }

    private void getTextPaintCollapsed(@NonNull TextPaint textPaint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, textPaint) == null) {
            textPaint.setTextSize(this.collapsedTextSize);
            textPaint.setTypeface(this.collapsedTypeface);
        }
    }

    private void getTextPaintExpanded(@NonNull TextPaint textPaint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, textPaint) == null) {
            textPaint.setTextSize(this.expandedTextSize);
            textPaint.setTypeface(this.expandedTypeface);
        }
    }

    private void interpolateBounds(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65554, this, f2) == null) {
            this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, f2, this.positionInterpolator);
            this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f2, this.positionInterpolator);
            this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, f2, this.positionInterpolator);
            this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, f2, this.positionInterpolator);
        }
    }

    public static boolean isClose(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? Math.abs(f2 - f3) < 0.001f : invokeCommon.booleanValue;
    }

    private boolean isDefaultIsRtl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) ? ViewCompat.getLayoutDirection(this.view) == 1 : invokeV.booleanValue;
    }

    public static float lerp(float f2, float f3, float f4, @Nullable TimeInterpolator timeInterpolator) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), timeInterpolator})) == null) {
            if (timeInterpolator != null) {
                f4 = timeInterpolator.getInterpolation(f4);
            }
            return AnimationUtils.lerp(f2, f3, f4);
        }
        return invokeCommon.floatValue;
    }

    public static boolean rectEquals(@NonNull Rect rect, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{rect, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) ? rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5 : invokeCommon.booleanValue;
    }

    private void setCollapsedTextBlend(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65559, this, f2) == null) {
            this.collapsedTextBlend = f2;
            ViewCompat.postInvalidateOnAnimation(this.view);
        }
    }

    private boolean setCollapsedTypefaceInternal(Typeface typeface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, this, typeface)) == null) {
            CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
            if (cancelableFontCallback != null) {
                cancelableFontCallback.cancel();
            }
            if (this.collapsedTypeface != typeface) {
                this.collapsedTypeface = typeface;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void setExpandedTextBlend(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65561, this, f2) == null) {
            this.expandedTextBlend = f2;
            ViewCompat.postInvalidateOnAnimation(this.view);
        }
    }

    private boolean setExpandedTypefaceInternal(Typeface typeface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, typeface)) == null) {
            CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
            if (cancelableFontCallback != null) {
                cancelableFontCallback.cancel();
            }
            if (this.expandedTypeface != typeface) {
                this.expandedTypeface = typeface;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void setInterpolatedTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65563, this, f2) == null) {
            calculateUsingTextSize(f2);
            boolean z = USE_SCALING_TEXTURE && this.scale != 1.0f;
            this.useTexture = z;
            if (z) {
                ensureExpandedTexture();
            }
            ViewCompat.postInvalidateOnAnimation(this.view);
        }
    }

    private boolean shouldDrawMultiline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) ? (this.maxLines <= 1 || this.isRtl || this.useTexture) ? false : true : invokeV.booleanValue;
    }

    public float calculateCollapsedTextWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.text == null) {
                return 0.0f;
            }
            getTextPaintCollapsed(this.tmpPaint);
            TextPaint textPaint = this.tmpPaint;
            CharSequence charSequence = this.text;
            return textPaint.measureText(charSequence, 0, charSequence.length());
        }
        return invokeV.floatValue;
    }

    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int save = canvas.save();
            if (this.textToDraw == null || !this.drawTitle) {
                return;
            }
            boolean z = false;
            float lineLeft = (this.currentDrawX + this.textLayout.getLineLeft(0)) - (this.expandedFirstLineDrawX * 2.0f);
            this.textPaint.setTextSize(this.currentTextSize);
            float f2 = this.currentDrawX;
            float f3 = this.currentDrawY;
            if (this.useTexture && this.expandedTitleTexture != null) {
                z = true;
            }
            float f4 = this.scale;
            if (f4 != 1.0f) {
                canvas.scale(f4, f4, f2, f3);
            }
            if (z) {
                canvas.drawBitmap(this.expandedTitleTexture, f2, f3, this.texturePaint);
                canvas.restoreToCount(save);
                return;
            }
            if (shouldDrawMultiline()) {
                drawMultinlineTransition(canvas, lineLeft, f3);
            } else {
                canvas.translate(f2, f3);
                this.textLayout.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    public void getCollapsedTextActualBounds(@NonNull RectF rectF, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, rectF, i2, i3) == null) {
            this.isRtl = calculateIsRtl(this.text);
            rectF.left = getCollapsedTextLeftBound(i2, i3);
            rectF.top = this.collapsedBounds.top;
            rectF.right = getCollapsedTextRightBound(rectF, i2, i3);
            rectF.bottom = this.collapsedBounds.top + getCollapsedTextHeight();
        }
    }

    public ColorStateList getCollapsedTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.collapsedTextColor : (ColorStateList) invokeV.objValue;
    }

    public int getCollapsedTextGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.collapsedTextGravity : invokeV.intValue;
    }

    public float getCollapsedTextHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            getTextPaintCollapsed(this.tmpPaint);
            return -this.tmpPaint.ascent();
        }
        return invokeV.floatValue;
    }

    public float getCollapsedTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.collapsedTextSize : invokeV.floatValue;
    }

    public Typeface getCollapsedTypeface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Typeface typeface = this.collapsedTypeface;
            return typeface != null ? typeface : Typeface.DEFAULT;
        }
        return (Typeface) invokeV.objValue;
    }

    @ColorInt
    public int getCurrentCollapsedTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getCurrentColor(this.collapsedTextColor) : invokeV.intValue;
    }

    public ColorStateList getExpandedTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.expandedTextColor : (ColorStateList) invokeV.objValue;
    }

    public int getExpandedTextGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.expandedTextGravity : invokeV.intValue;
    }

    public float getExpandedTextHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            getTextPaintExpanded(this.tmpPaint);
            return -this.tmpPaint.ascent();
        }
        return invokeV.floatValue;
    }

    public float getExpandedTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.expandedTextSize : invokeV.floatValue;
    }

    public Typeface getExpandedTypeface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Typeface typeface = this.expandedTypeface;
            return typeface != null ? typeface : Typeface.DEFAULT;
        }
        return (Typeface) invokeV.objValue;
    }

    public float getExpansionFraction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.expandedFraction : invokeV.floatValue;
    }

    public int getMaxLines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.maxLines : invokeV.intValue;
    }

    @Nullable
    public CharSequence getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.text : (CharSequence) invokeV.objValue;
    }

    public final boolean isStateful() {
        InterceptResult invokeV;
        ColorStateList colorStateList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ColorStateList colorStateList2 = this.collapsedTextColor;
            return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.expandedTextColor) != null && colorStateList.isStateful());
        }
        return invokeV.booleanValue;
    }

    public void onBoundsChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.drawTitle = this.collapsedBounds.width() > 0 && this.collapsedBounds.height() > 0 && this.expandedBounds.width() > 0 && this.expandedBounds.height() > 0;
        }
    }

    public void recalculate() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.view.getHeight() <= 0 || this.view.getWidth() <= 0) {
            return;
        }
        calculateBaseOffsets();
        calculateCurrentOffsets();
    }

    public void setCollapsedBounds(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048596, this, i2, i3, i4, i5) == null) || rectEquals(this.collapsedBounds, i2, i3, i4, i5)) {
            return;
        }
        this.collapsedBounds.set(i2, i3, i4, i5);
        this.boundsChanged = true;
        onBoundsChanged();
    }

    public void setCollapsedTextAppearance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i2);
            ColorStateList colorStateList = textAppearance.textColor;
            if (colorStateList != null) {
                this.collapsedTextColor = colorStateList;
            }
            float f2 = textAppearance.textSize;
            if (f2 != 0.0f) {
                this.collapsedTextSize = f2;
            }
            ColorStateList colorStateList2 = textAppearance.shadowColor;
            if (colorStateList2 != null) {
                this.collapsedShadowColor = colorStateList2;
            }
            this.collapsedShadowDx = textAppearance.shadowDx;
            this.collapsedShadowDy = textAppearance.shadowDy;
            this.collapsedShadowRadius = textAppearance.shadowRadius;
            CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
            if (cancelableFontCallback != null) {
                cancelableFontCallback.cancel();
            }
            this.collapsedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont(this) { // from class: com.google.android.material.internal.CollapsingTextHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CollapsingTextHelper this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
                public void apply(Typeface typeface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, typeface) == null) {
                        this.this$0.setCollapsedTypeface(typeface);
                    }
                }
            }, textAppearance.getFallbackFont());
            textAppearance.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
            recalculate();
        }
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, colorStateList) == null) || this.collapsedTextColor == colorStateList) {
            return;
        }
        this.collapsedTextColor = colorStateList;
        recalculate();
    }

    public void setCollapsedTextGravity(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || this.collapsedTextGravity == i2) {
            return;
        }
        this.collapsedTextGravity = i2;
        recalculate();
    }

    public void setCollapsedTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048601, this, f2) == null) || this.collapsedTextSize == f2) {
            return;
        }
        this.collapsedTextSize = f2;
        recalculate();
    }

    public void setCollapsedTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, typeface) == null) && setCollapsedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpandedBounds(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048603, this, i2, i3, i4, i5) == null) || rectEquals(this.expandedBounds, i2, i3, i4, i5)) {
            return;
        }
        this.expandedBounds.set(i2, i3, i4, i5);
        this.boundsChanged = true;
        onBoundsChanged();
    }

    public void setExpandedTextAppearance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i2);
            ColorStateList colorStateList = textAppearance.textColor;
            if (colorStateList != null) {
                this.expandedTextColor = colorStateList;
            }
            float f2 = textAppearance.textSize;
            if (f2 != 0.0f) {
                this.expandedTextSize = f2;
            }
            ColorStateList colorStateList2 = textAppearance.shadowColor;
            if (colorStateList2 != null) {
                this.expandedShadowColor = colorStateList2;
            }
            this.expandedShadowDx = textAppearance.shadowDx;
            this.expandedShadowDy = textAppearance.shadowDy;
            this.expandedShadowRadius = textAppearance.shadowRadius;
            CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
            if (cancelableFontCallback != null) {
                cancelableFontCallback.cancel();
            }
            this.expandedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont(this) { // from class: com.google.android.material.internal.CollapsingTextHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CollapsingTextHelper this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
                public void apply(Typeface typeface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, typeface) == null) {
                        this.this$0.setExpandedTypeface(typeface);
                    }
                }
            }, textAppearance.getFallbackFont());
            textAppearance.getFontAsync(this.view.getContext(), this.expandedFontCallback);
            recalculate();
        }
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, colorStateList) == null) || this.expandedTextColor == colorStateList) {
            return;
        }
        this.expandedTextColor = colorStateList;
        recalculate();
    }

    public void setExpandedTextGravity(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i2) == null) || this.expandedTextGravity == i2) {
            return;
        }
        this.expandedTextGravity = i2;
        recalculate();
    }

    public void setExpandedTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048608, this, f2) == null) || this.expandedTextSize == f2) {
            return;
        }
        this.expandedTextSize = f2;
        recalculate();
    }

    public void setExpandedTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, typeface) == null) && setExpandedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpansionFraction(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048610, this, f2) == null) {
            float clamp = MathUtils.clamp(f2, 0.0f, 1.0f);
            if (clamp != this.expandedFraction) {
                this.expandedFraction = clamp;
                calculateCurrentOffsets();
            }
        }
    }

    public void setMaxLines(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048611, this, i2) == null) || i2 == this.maxLines) {
            return;
        }
        this.maxLines = i2;
        clearTexture();
        recalculate();
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, timeInterpolator) == null) {
            this.positionInterpolator = timeInterpolator;
            recalculate();
        }
    }

    public final boolean setState(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, iArr)) == null) {
            this.state = iArr;
            if (isStateful()) {
                recalculate();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setText(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, charSequence) == null) {
            if (charSequence == null || !TextUtils.equals(this.text, charSequence)) {
                this.text = charSequence;
                this.textToDraw = null;
                clearTexture();
                recalculate();
            }
        }
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, timeInterpolator) == null) {
            this.textSizeInterpolator = timeInterpolator;
            recalculate();
        }
    }

    public void setTypefaces(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, typeface) == null) {
            boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
            boolean expandedTypefaceInternal = setExpandedTypefaceInternal(typeface);
            if (collapsedTypefaceInternal || expandedTypefaceInternal) {
                recalculate();
            }
        }
    }

    public void setCollapsedBounds(@NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, rect) == null) {
            setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public void setExpandedBounds(@NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, rect) == null) {
            setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
        }
    }
}
