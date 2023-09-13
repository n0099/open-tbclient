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
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes9.dex */
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

    /* renamed from: view  reason: collision with root package name */
    public final View f1207view;
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
        boolean z;
        if (Build.VERSION.SDK_INT < 18) {
            z = true;
        } else {
            z = false;
        }
        USE_SCALING_TEXTURE = z;
        Paint paint = null;
        DEBUG_DRAW_PAINT = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            DEBUG_DRAW_PAINT.setColor(-65281);
        }
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private void clearTexture() {
        Bitmap bitmap = this.expandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.expandedTitleTexture = null;
        }
    }

    @ColorInt
    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    private boolean isDefaultIsRtl() {
        if (ViewCompat.getLayoutDirection(this.f1207view) == 1) {
            return true;
        }
        return false;
    }

    private boolean shouldDrawMultiline() {
        if (this.maxLines > 1 && !this.isRtl && !this.useTexture) {
            return true;
        }
        return false;
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
        if (typeface == null) {
            return Typeface.DEFAULT;
        }
        return typeface;
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
        if (typeface == null) {
            return Typeface.DEFAULT;
        }
        return typeface;
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
        if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.expandedTextColor) != null && colorStateList.isStateful())) {
            return true;
        }
        return false;
    }

    public void onBoundsChanged() {
        boolean z;
        if (this.collapsedBounds.width() > 0 && this.collapsedBounds.height() > 0 && this.expandedBounds.width() > 0 && this.expandedBounds.height() > 0) {
            z = true;
        } else {
            z = false;
        }
        this.drawTitle = z;
    }

    public void recalculate() {
        if (this.f1207view.getHeight() > 0 && this.f1207view.getWidth() > 0) {
            calculateBaseOffsets();
            calculateCurrentOffsets();
        }
    }

    public CollapsingTextHelper(View view2) {
        this.f1207view = view2;
    }

    public static int blendColors(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }

    private void calculateBaseOffsets() {
        float f;
        float f2;
        float f3;
        StaticLayout staticLayout;
        float f4 = this.currentTextSize;
        calculateUsingTextSize(this.collapsedTextSize);
        CharSequence charSequence = this.textToDraw;
        if (charSequence != null && (staticLayout = this.textLayout) != null) {
            this.textToDrawCollapsed = TextUtils.ellipsize(charSequence, this.textPaint, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.textToDrawCollapsed;
        float f5 = 0.0f;
        if (charSequence2 != null) {
            f = this.textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            f = 0.0f;
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        int i = absoluteGravity & 112;
        if (i != 48) {
            if (i != 80) {
                this.collapsedDrawY = this.collapsedBounds.centerY() - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
            } else {
                this.collapsedDrawY = this.collapsedBounds.bottom + this.textPaint.ascent();
            }
        } else {
            this.collapsedDrawY = this.collapsedBounds.top;
        }
        int i2 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i2 != 1) {
            if (i2 != 5) {
                this.collapsedDrawX = this.collapsedBounds.left;
            } else {
                this.collapsedDrawX = this.collapsedBounds.right - f;
            }
        } else {
            this.collapsedDrawX = this.collapsedBounds.centerX() - (f / 2.0f);
        }
        calculateUsingTextSize(this.expandedTextSize);
        StaticLayout staticLayout2 = this.textLayout;
        if (staticLayout2 != null) {
            f2 = staticLayout2.getHeight();
        } else {
            f2 = 0.0f;
        }
        CharSequence charSequence3 = this.textToDraw;
        if (charSequence3 != null) {
            f3 = this.textPaint.measureText(charSequence3, 0, charSequence3.length());
        } else {
            f3 = 0.0f;
        }
        StaticLayout staticLayout3 = this.textLayout;
        if (staticLayout3 != null && this.maxLines > 1 && !this.isRtl) {
            f3 = staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.textLayout;
        if (staticLayout4 != null) {
            f5 = staticLayout4.getLineLeft(0);
        }
        this.expandedFirstLineDrawX = f5;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int i3 = absoluteGravity2 & 112;
        if (i3 != 48) {
            if (i3 != 80) {
                this.expandedDrawY = this.expandedBounds.centerY() - (f2 / 2.0f);
            } else {
                this.expandedDrawY = (this.expandedBounds.bottom - f2) + this.textPaint.descent();
            }
        } else {
            this.expandedDrawY = this.expandedBounds.top;
        }
        int i4 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i4 != 1) {
            if (i4 != 5) {
                this.expandedDrawX = this.expandedBounds.left;
            } else {
                this.expandedDrawX = this.expandedBounds.right - f3;
            }
        } else {
            this.expandedDrawX = this.expandedBounds.centerX() - (f3 / 2.0f);
        }
        clearTexture();
        setInterpolatedTextSize(f4);
    }

    private boolean calculateIsRtl(@NonNull CharSequence charSequence) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        if (isDefaultIsRtl()) {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
        } else {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
        return textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
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

    private void getTextPaintCollapsed(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.collapsedTextSize);
        textPaint.setTypeface(this.collapsedTypeface);
    }

    private void getTextPaintExpanded(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.expandedTextSize);
        textPaint.setTypeface(this.expandedTypeface);
    }

    private void setCollapsedTextBlend(float f) {
        this.collapsedTextBlend = f;
        ViewCompat.postInvalidateOnAnimation(this.f1207view);
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

    private void setExpandedTextBlend(float f) {
        this.expandedTextBlend = f;
        ViewCompat.postInvalidateOnAnimation(this.f1207view);
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

    private void setInterpolatedTextSize(float f) {
        boolean z;
        calculateUsingTextSize(f);
        if (USE_SCALING_TEXTURE && this.scale != 1.0f) {
            z = true;
        } else {
            z = false;
        }
        this.useTexture = z;
        if (z) {
            ensureExpandedTexture();
        }
        ViewCompat.postInvalidateOnAnimation(this.f1207view);
    }

    public void setCollapsedBounds(@NonNull Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedTextGravity(int i) {
        if (this.collapsedTextGravity != i) {
            this.collapsedTextGravity = i;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f) {
        if (this.collapsedTextSize != f) {
            this.collapsedTextSize = f;
            recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (setCollapsedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpandedBounds(@NonNull Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.expandedTextColor != colorStateList) {
            this.expandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextGravity(int i) {
        if (this.expandedTextGravity != i) {
            this.expandedTextGravity = i;
            recalculate();
        }
    }

    public void setExpandedTextSize(float f) {
        if (this.expandedTextSize != f) {
            this.expandedTextSize = f;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (setExpandedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpansionFraction(float f) {
        float clamp = MathUtils.clamp(f, 0.0f, 1.0f);
        if (clamp != this.expandedFraction) {
            this.expandedFraction = clamp;
            calculateCurrentOffsets();
        }
    }

    public void setMaxLines(int i) {
        if (i != this.maxLines) {
            this.maxLines = i;
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

    private void calculateOffsets(float f) {
        interpolateBounds(f);
        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f, this.positionInterpolator);
        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
        setInterpolatedTextSize(lerp(this.expandedTextSize, this.collapsedTextSize, f, this.textSizeInterpolator));
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - f, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        setExpandedTextBlend(lerp(1.0f, 0.0f, f, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if (this.collapsedTextColor != this.expandedTextColor) {
            this.textPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f));
        } else {
            this.textPaint.setColor(getCurrentCollapsedTextColor());
        }
        this.textPaint.setShadowLayer(lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f, null), lerp(this.expandedShadowDx, this.collapsedShadowDx, f, null), lerp(this.expandedShadowDy, this.collapsedShadowDy, f, null), blendColors(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f));
        ViewCompat.postInvalidateOnAnimation(this.f1207view);
    }

    private void calculateUsingTextSize(float f) {
        boolean z;
        float f2;
        boolean z2;
        if (this.text == null) {
            return;
        }
        float width = this.collapsedBounds.width();
        float width2 = this.expandedBounds.width();
        boolean z3 = false;
        int i = 1;
        if (isClose(f, this.collapsedTextSize)) {
            f2 = this.collapsedTextSize;
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
            float f3 = this.expandedTextSize;
            Typeface typeface3 = this.currentTypeface;
            Typeface typeface4 = this.expandedTypeface;
            if (typeface3 != typeface4) {
                this.currentTypeface = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (isClose(f, this.expandedTextSize)) {
                this.scale = 1.0f;
            } else {
                this.scale = f / this.expandedTextSize;
            }
            float f4 = this.collapsedTextSize / this.expandedTextSize;
            if (width2 * f4 > width) {
                width = Math.min(width / f4, width2);
            } else {
                width = width2;
            }
            f2 = f3;
            z2 = z;
        }
        if (width > 0.0f) {
            if (this.currentTextSize == f2 && !this.boundsChanged && !z2) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.currentTextSize = f2;
            this.boundsChanged = false;
        }
        if (this.textToDraw == null || z2) {
            this.textPaint.setTextSize(this.currentTextSize);
            this.textPaint.setTypeface(this.currentTypeface);
            TextPaint textPaint = this.textPaint;
            if (this.scale != 1.0f) {
                z3 = true;
            }
            textPaint.setLinearText(z3);
            this.isRtl = calculateIsRtl(this.text);
            if (shouldDrawMultiline()) {
                i = this.maxLines;
            }
            StaticLayout createStaticLayout = createStaticLayout(i, width, this.isRtl);
            this.textLayout = createStaticLayout;
            this.textToDraw = createStaticLayout.getText();
        }
    }

    private StaticLayout createStaticLayout(int i, float f, boolean z) {
        StaticLayout staticLayout;
        try {
            staticLayout = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, (int) f).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(z).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(i).build();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e) {
            Log.e(TAG, e.getCause().getMessage(), e);
            staticLayout = null;
        }
        return (StaticLayout) Preconditions.checkNotNull(staticLayout);
    }

    private float getCollapsedTextRightBound(@NonNull RectF rectF, int i, int i2) {
        if (i2 != 17 && (i2 & 7) != 1) {
            if ((i2 & 8388613) != 8388613 && (i2 & 5) != 5) {
                if (this.isRtl) {
                    return this.collapsedBounds.right;
                }
                return rectF.left + calculateCollapsedTextWidth();
            } else if (this.isRtl) {
                return rectF.left + calculateCollapsedTextWidth();
            } else {
                return this.collapsedBounds.right;
            }
        }
        return (i / 2.0f) + (calculateCollapsedTextWidth() / 2.0f);
    }

    private void drawMultinlineTransition(@NonNull Canvas canvas, float f, float f2) {
        int alpha = this.textPaint.getAlpha();
        canvas.translate(f, f2);
        float f3 = alpha;
        this.textPaint.setAlpha((int) (this.expandedTextBlend * f3));
        this.textLayout.draw(canvas);
        this.textPaint.setAlpha((int) (this.collapsedTextBlend * f3));
        int lineBaseline = this.textLayout.getLineBaseline(0);
        CharSequence charSequence = this.textToDrawCollapsed;
        float f4 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f4, this.textPaint);
        String trim = this.textToDrawCollapsed.toString().trim();
        if (trim.endsWith(ELLIPSIS_NORMAL)) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.textPaint.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.textLayout.getLineEnd(0), str.length()), 0.0f, f4, (Paint) this.textPaint);
    }

    private void ensureExpandedTexture() {
        if (this.expandedTitleTexture == null && !this.expandedBounds.isEmpty() && !TextUtils.isEmpty(this.textToDraw)) {
            calculateOffsets(0.0f);
            int width = this.textLayout.getWidth();
            int height = this.textLayout.getHeight();
            if (width > 0 && height > 0) {
                this.expandedTitleTexture = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.textLayout.draw(new Canvas(this.expandedTitleTexture));
                if (this.texturePaint == null) {
                    this.texturePaint = new Paint(3);
                }
            }
        }
    }

    private float getCollapsedTextLeftBound(int i, int i2) {
        if (i2 != 17 && (i2 & 7) != 1) {
            if ((i2 & 8388613) != 8388613 && (i2 & 5) != 5) {
                if (this.isRtl) {
                    return this.collapsedBounds.right - calculateCollapsedTextWidth();
                }
                return this.collapsedBounds.left;
            } else if (this.isRtl) {
                return this.collapsedBounds.left;
            } else {
                return this.collapsedBounds.right - calculateCollapsedTextWidth();
            }
        }
        return (i / 2.0f) - (calculateCollapsedTextWidth() / 2.0f);
    }

    private void interpolateBounds(float f) {
        this.currentBounds.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, f, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
        this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, f, this.positionInterpolator);
        this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, f, this.positionInterpolator);
    }

    public void draw(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (this.textToDraw != null && this.drawTitle) {
            boolean z = false;
            float lineLeft = (this.currentDrawX + this.textLayout.getLineLeft(0)) - (this.expandedFirstLineDrawX * 2.0f);
            this.textPaint.setTextSize(this.currentTextSize);
            float f = this.currentDrawX;
            float f2 = this.currentDrawY;
            if (this.useTexture && this.expandedTitleTexture != null) {
                z = true;
            }
            float f3 = this.scale;
            if (f3 != 1.0f) {
                canvas.scale(f3, f3, f, f2);
            }
            if (z) {
                canvas.drawBitmap(this.expandedTitleTexture, f, f2, this.texturePaint);
                canvas.restoreToCount(save);
                return;
            }
            if (shouldDrawMultiline()) {
                drawMultinlineTransition(canvas, lineLeft, f2);
            } else {
                canvas.translate(f, f2);
                this.textLayout.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    public void setCollapsedTextAppearance(int i) {
        TextAppearance textAppearance = new TextAppearance(this.f1207view.getContext(), i);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            this.collapsedTextColor = colorStateList;
        }
        float f = textAppearance.textSize;
        if (f != 0.0f) {
            this.collapsedTextSize = f;
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
        textAppearance.getFontAsync(this.f1207view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setExpandedTextAppearance(int i) {
        TextAppearance textAppearance = new TextAppearance(this.f1207view.getContext(), i);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            this.expandedTextColor = colorStateList;
        }
        float f = textAppearance.textSize;
        if (f != 0.0f) {
            this.expandedTextSize = f;
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
        textAppearance.getFontAsync(this.f1207view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public static boolean isClose(float f, float f2) {
        if (Math.abs(f - f2) < 0.001f) {
            return true;
        }
        return false;
    }

    public static float lerp(float f, float f2, float f3, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return AnimationUtils.lerp(f, f2, f3);
    }

    public void setCollapsedBounds(int i, int i2, int i3, int i4) {
        if (!rectEquals(this.collapsedBounds, i, i2, i3, i4)) {
            this.collapsedBounds.set(i, i2, i3, i4);
            this.boundsChanged = true;
            onBoundsChanged();
        }
    }

    public void setExpandedBounds(int i, int i2, int i3, int i4) {
        if (!rectEquals(this.expandedBounds, i, i2, i3, i4)) {
            this.expandedBounds.set(i, i2, i3, i4);
            this.boundsChanged = true;
            onBoundsChanged();
        }
    }

    public static boolean rectEquals(@NonNull Rect rect, int i, int i2, int i3, int i4) {
        if (rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4) {
            return true;
        }
        return false;
    }

    public void getCollapsedTextActualBounds(@NonNull RectF rectF, int i, int i2) {
        this.isRtl = calculateIsRtl(this.text);
        rectF.left = getCollapsedTextLeftBound(i, i2);
        rectF.top = this.collapsedBounds.top;
        rectF.right = getCollapsedTextRightBound(rectF, i, i2);
        rectF.bottom = this.collapsedBounds.top + getCollapsedTextHeight();
    }
}
