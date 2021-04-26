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
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes6.dex */
public final class CollapsingTextHelper {
    public static final boolean DEBUG_DRAW = false;
    @NonNull
    public static final Paint DEBUG_DRAW_PAINT;
    public static final String ELLIPSIS_NORMAL = "…";
    public static final String TAG = "CollapsingTextHelper";
    public static final boolean USE_SCALING_TEXTURE;
    public boolean boundsChanged;
    public float collapsedDrawX;
    public float collapsedDrawY;
    public CancelableFontCallback collapsedFontCallback;
    public ColorStateList collapsedShadowColor;
    public float collapsedShadowDx;
    public float collapsedShadowDy;
    public float collapsedShadowRadius;
    public float collapsedTextBlend;
    public ColorStateList collapsedTextColor;
    public Typeface collapsedTypeface;
    public float currentDrawX;
    public float currentDrawY;
    public float currentTextSize;
    public Typeface currentTypeface;
    public boolean drawTitle;
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
    @Nullable
    public Bitmap expandedTitleTexture;
    public Typeface expandedTypeface;
    public boolean isRtl;
    public TimeInterpolator positionInterpolator;
    public float scale;
    public int[] state;
    @Nullable
    public CharSequence text;
    public StaticLayout textLayout;
    public TimeInterpolator textSizeInterpolator;
    @Nullable
    public CharSequence textToDraw;
    public CharSequence textToDrawCollapsed;
    public Paint texturePaint;
    public boolean useTexture;
    public final View view;
    public int expandedTextGravity = 16;
    public int collapsedTextGravity = 16;
    public float expandedTextSize = 15.0f;
    public float collapsedTextSize = 15.0f;
    public int maxLines = 1;
    @NonNull
    public final TextPaint textPaint = new TextPaint(129);
    @NonNull
    public final TextPaint tmpPaint = new TextPaint(this.textPaint);
    @NonNull
    public final Rect collapsedBounds = new Rect();
    @NonNull
    public final Rect expandedBounds = new Rect();
    @NonNull
    public final RectF currentBounds = new RectF();

    static {
        USE_SCALING_TEXTURE = Build.VERSION.SDK_INT < 18;
        Paint paint = null;
        DEBUG_DRAW_PAINT = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            DEBUG_DRAW_PAINT.setColor(-65281);
        }
    }

    public CollapsingTextHelper(View view) {
        this.view = view;
    }

    public static int blendColors(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i2) * f3) + (Color.alpha(i3) * f2)), (int) ((Color.red(i2) * f3) + (Color.red(i3) * f2)), (int) ((Color.green(i2) * f3) + (Color.green(i3) * f2)), (int) ((Color.blue(i2) * f3) + (Color.blue(i3) * f2)));
    }

    private void calculateBaseOffsets() {
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
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

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private boolean calculateIsRtl(@NonNull CharSequence charSequence) {
        return (isDefaultIsRtl() ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    private void calculateOffsets(float f2) {
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

    private void calculateUsingTextSize(float f2) {
        boolean z;
        float f3;
        boolean z2;
        if (this.text == null) {
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
        Bitmap bitmap = this.expandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.expandedTitleTexture = null;
        }
    }

    private StaticLayout createStaticLayout(int i2, float f2, boolean z) {
        StaticLayout staticLayout;
        try {
            staticLayout = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) f2).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(z).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(i2).build();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e2) {
            Log.e(TAG, e2.getCause().getMessage(), e2);
            staticLayout = null;
        }
        return (StaticLayout) Preconditions.checkNotNull(staticLayout);
    }

    private void drawMultinlineTransition(@NonNull Canvas canvas, float f2, float f3) {
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

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture != null || this.expandedBounds.isEmpty() || TextUtils.isEmpty(this.textToDraw)) {
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
        if (i3 == 17 || (i3 & 7) == 1) {
            return (i2 / 2.0f) - (calculateCollapsedTextWidth() / 2.0f);
        }
        return ((i3 & 8388613) == 8388613 || (i3 & 5) == 5) ? this.isRtl ? this.collapsedBounds.left : this.collapsedBounds.right - calculateCollapsedTextWidth() : this.isRtl ? this.collapsedBounds.right - calculateCollapsedTextWidth() : this.collapsedBounds.left;
    }

    private float getCollapsedTextRightBound(@NonNull RectF rectF, int i2, int i3) {
        if (i3 == 17 || (i3 & 7) == 1) {
            return (i2 / 2.0f) + (calculateCollapsedTextWidth() / 2.0f);
        }
        return ((i3 & 8388613) == 8388613 || (i3 & 5) == 5) ? this.isRtl ? rectF.left + calculateCollapsedTextWidth() : this.collapsedBounds.right : this.isRtl ? this.collapsedBounds.right : rectF.left + calculateCollapsedTextWidth();
    }

    @ColorInt
    private int getCurrentColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    @ColorInt
    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    private void getTextPaintCollapsed(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.collapsedTextSize);
        textPaint.setTypeface(this.collapsedTypeface);
    }

    private void getTextPaintExpanded(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.expandedTextSize);
        textPaint.setTypeface(this.expandedTypeface);
    }

    private void interpolateBounds(float f2) {
        this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, f2, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f2, this.positionInterpolator);
        this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, f2, this.positionInterpolator);
        this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, f2, this.positionInterpolator);
    }

    public static boolean isClose(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private boolean isDefaultIsRtl() {
        return ViewCompat.getLayoutDirection(this.view) == 1;
    }

    public static float lerp(float f2, float f3, float f4, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return AnimationUtils.lerp(f2, f3, f4);
    }

    public static boolean rectEquals(@NonNull Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    private void setCollapsedTextBlend(float f2) {
        this.collapsedTextBlend = f2;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean setCollapsedTypefaceInternal(Typeface typeface) {
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

    private void setExpandedTextBlend(float f2) {
        this.expandedTextBlend = f2;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean setExpandedTypefaceInternal(Typeface typeface) {
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

    private void setInterpolatedTextSize(float f2) {
        calculateUsingTextSize(f2);
        boolean z = USE_SCALING_TEXTURE && this.scale != 1.0f;
        this.useTexture = z;
        if (z) {
            ensureExpandedTexture();
        }
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private boolean shouldDrawMultiline() {
        return (this.maxLines <= 1 || this.isRtl || this.useTexture) ? false : true;
    }

    public float calculateCollapsedTextWidth() {
        if (this.text == null) {
            return 0.0f;
        }
        getTextPaintCollapsed(this.tmpPaint);
        TextPaint textPaint = this.tmpPaint;
        CharSequence charSequence = this.text;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void draw(@NonNull Canvas canvas) {
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

    public void getCollapsedTextActualBounds(@NonNull RectF rectF, int i2, int i3) {
        this.isRtl = calculateIsRtl(this.text);
        rectF.left = getCollapsedTextLeftBound(i2, i3);
        rectF.top = this.collapsedBounds.top;
        rectF.right = getCollapsedTextRightBound(rectF, i2, i3);
        rectF.bottom = this.collapsedBounds.top + getCollapsedTextHeight();
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.collapsedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @ColorInt
    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.expandedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.collapsedTextColor;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.expandedTextColor) != null && colorStateList.isStateful());
    }

    public void onBoundsChanged() {
        this.drawTitle = this.collapsedBounds.width() > 0 && this.collapsedBounds.height() > 0 && this.expandedBounds.width() > 0 && this.expandedBounds.height() > 0;
    }

    public void recalculate() {
        if (this.view.getHeight() <= 0 || this.view.getWidth() <= 0) {
            return;
        }
        calculateBaseOffsets();
        calculateCurrentOffsets();
    }

    public void setCollapsedBounds(int i2, int i3, int i4, int i5) {
        if (rectEquals(this.collapsedBounds, i2, i3, i4, i5)) {
            return;
        }
        this.collapsedBounds.set(i2, i3, i4, i5);
        this.boundsChanged = true;
        onBoundsChanged();
    }

    public void setCollapsedTextAppearance(int i2) {
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
        this.collapsedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.1
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setCollapsedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedTextGravity(int i2) {
        if (this.collapsedTextGravity != i2) {
            this.collapsedTextGravity = i2;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f2) {
        if (this.collapsedTextSize != f2) {
            this.collapsedTextSize = f2;
            recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (setCollapsedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpandedBounds(int i2, int i3, int i4, int i5) {
        if (rectEquals(this.expandedBounds, i2, i3, i4, i5)) {
            return;
        }
        this.expandedBounds.set(i2, i3, i4, i5);
        this.boundsChanged = true;
        onBoundsChanged();
    }

    public void setExpandedTextAppearance(int i2) {
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
        this.expandedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.2
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setExpandedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.expandedTextColor != colorStateList) {
            this.expandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextGravity(int i2) {
        if (this.expandedTextGravity != i2) {
            this.expandedTextGravity = i2;
            recalculate();
        }
    }

    public void setExpandedTextSize(float f2) {
        if (this.expandedTextSize != f2) {
            this.expandedTextSize = f2;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (setExpandedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpansionFraction(float f2) {
        float clamp = MathUtils.clamp(f2, 0.0f, 1.0f);
        if (clamp != this.expandedFraction) {
            this.expandedFraction = clamp;
            calculateCurrentOffsets();
        }
    }

    public void setMaxLines(int i2) {
        if (i2 != this.maxLines) {
            this.maxLines = i2;
            clearTexture();
            recalculate();
        }
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.positionInterpolator = timeInterpolator;
        recalculate();
    }

    public final boolean setState(int[] iArr) {
        this.state = iArr;
        if (isStateful()) {
            recalculate();
            return true;
        }
        return false;
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.textSizeInterpolator = timeInterpolator;
        recalculate();
    }

    public void setTypefaces(Typeface typeface) {
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        boolean expandedTypefaceInternal = setExpandedTypefaceInternal(typeface);
        if (collapsedTypefaceInternal || expandedTypefaceInternal) {
            recalculate();
        }
    }

    public void setCollapsedBounds(@NonNull Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setExpandedBounds(@NonNull Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
