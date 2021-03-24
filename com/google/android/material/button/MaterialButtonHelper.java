package com.google.android.material.button;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes6.dex */
public class MaterialButtonHelper {
    public static final float CORNER_RADIUS_ADJUSTMENT = 1.0E-5f;
    public static final int DEFAULT_BACKGROUND_COLOR = -1;
    public static final boolean IS_LOLLIPOP;
    @Nullable
    public GradientDrawable backgroundDrawableLollipop;
    @Nullable
    public ColorStateList backgroundTint;
    @Nullable
    public PorterDuff.Mode backgroundTintMode;
    @Nullable
    public GradientDrawable colorableBackgroundDrawableCompat;
    public int cornerRadius;
    public int insetBottom;
    public int insetLeft;
    public int insetRight;
    public int insetTop;
    @Nullable
    public GradientDrawable maskDrawableLollipop;
    public final MaterialButton materialButton;
    @Nullable
    public ColorStateList rippleColor;
    @Nullable
    public GradientDrawable rippleDrawableCompat;
    @Nullable
    public ColorStateList strokeColor;
    @Nullable
    public GradientDrawable strokeDrawableLollipop;
    public int strokeWidth;
    @Nullable
    public Drawable tintableBackgroundDrawableCompat;
    @Nullable
    public Drawable tintableRippleDrawableCompat;
    public final Paint buttonStrokePaint = new Paint(1);
    public final Rect bounds = new Rect();
    public final RectF rectF = new RectF();
    public boolean backgroundOverwritten = false;

    static {
        IS_LOLLIPOP = Build.VERSION.SDK_INT >= 21;
    }

    public MaterialButtonHelper(MaterialButton materialButton) {
        this.materialButton = materialButton;
    }

    private Drawable createBackgroundCompat() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.colorableBackgroundDrawableCompat = gradientDrawable;
        gradientDrawable.setCornerRadius(this.cornerRadius + 1.0E-5f);
        this.colorableBackgroundDrawableCompat.setColor(-1);
        Drawable wrap = DrawableCompat.wrap(this.colorableBackgroundDrawableCompat);
        this.tintableBackgroundDrawableCompat = wrap;
        DrawableCompat.setTintList(wrap, this.backgroundTint);
        PorterDuff.Mode mode = this.backgroundTintMode;
        if (mode != null) {
            DrawableCompat.setTintMode(this.tintableBackgroundDrawableCompat, mode);
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.rippleDrawableCompat = gradientDrawable2;
        gradientDrawable2.setCornerRadius(this.cornerRadius + 1.0E-5f);
        this.rippleDrawableCompat.setColor(-1);
        Drawable wrap2 = DrawableCompat.wrap(this.rippleDrawableCompat);
        this.tintableRippleDrawableCompat = wrap2;
        DrawableCompat.setTintList(wrap2, this.rippleColor);
        return wrapDrawableWithInset(new LayerDrawable(new Drawable[]{this.tintableBackgroundDrawableCompat, this.tintableRippleDrawableCompat}));
    }

    @TargetApi(21)
    private Drawable createBackgroundLollipop() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.backgroundDrawableLollipop = gradientDrawable;
        gradientDrawable.setCornerRadius(this.cornerRadius + 1.0E-5f);
        this.backgroundDrawableLollipop.setColor(-1);
        updateTintAndTintModeLollipop();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.strokeDrawableLollipop = gradientDrawable2;
        gradientDrawable2.setCornerRadius(this.cornerRadius + 1.0E-5f);
        this.strokeDrawableLollipop.setColor(0);
        this.strokeDrawableLollipop.setStroke(this.strokeWidth, this.strokeColor);
        InsetDrawable wrapDrawableWithInset = wrapDrawableWithInset(new LayerDrawable(new Drawable[]{this.backgroundDrawableLollipop, this.strokeDrawableLollipop}));
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.maskDrawableLollipop = gradientDrawable3;
        gradientDrawable3.setCornerRadius(this.cornerRadius + 1.0E-5f);
        this.maskDrawableLollipop.setColor(-1);
        return new MaterialButtonBackgroundDrawable(RippleUtils.convertToRippleDrawableColor(this.rippleColor), wrapDrawableWithInset, this.maskDrawableLollipop);
    }

    @Nullable
    private GradientDrawable unwrapBackgroundDrawable() {
        if (!IS_LOLLIPOP || this.materialButton.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.materialButton.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    @Nullable
    private GradientDrawable unwrapStrokeDrawable() {
        if (!IS_LOLLIPOP || this.materialButton.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.materialButton.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private void updateStroke() {
        if (IS_LOLLIPOP && this.strokeDrawableLollipop != null) {
            this.materialButton.setInternalBackground(createBackgroundLollipop());
        } else if (IS_LOLLIPOP) {
        } else {
            this.materialButton.invalidate();
        }
    }

    private void updateTintAndTintModeLollipop() {
        GradientDrawable gradientDrawable = this.backgroundDrawableLollipop;
        if (gradientDrawable != null) {
            DrawableCompat.setTintList(gradientDrawable, this.backgroundTint);
            PorterDuff.Mode mode = this.backgroundTintMode;
            if (mode != null) {
                DrawableCompat.setTintMode(this.backgroundDrawableLollipop, mode);
            }
        }
    }

    private InsetDrawable wrapDrawableWithInset(Drawable drawable) {
        return new InsetDrawable(drawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    public void drawStroke(@Nullable Canvas canvas) {
        if (canvas == null || this.strokeColor == null || this.strokeWidth <= 0) {
            return;
        }
        this.bounds.set(this.materialButton.getBackground().getBounds());
        RectF rectF = this.rectF;
        Rect rect = this.bounds;
        int i = this.strokeWidth;
        rectF.set(rect.left + (i / 2.0f) + this.insetLeft, rect.top + (i / 2.0f) + this.insetTop, (rect.right - (i / 2.0f)) - this.insetRight, (rect.bottom - (i / 2.0f)) - this.insetBottom);
        float f2 = this.cornerRadius - (this.strokeWidth / 2.0f);
        canvas.drawRoundRect(this.rectF, f2, f2, this.buttonStrokePaint);
    }

    public int getCornerRadius() {
        return this.cornerRadius;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    public void loadFromAttributes(TypedArray typedArray) {
        this.insetLeft = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        this.cornerRadius = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, 0);
        this.strokeWidth = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.buttonStrokePaint.setStyle(Paint.Style.STROKE);
        this.buttonStrokePaint.setStrokeWidth(this.strokeWidth);
        Paint paint = this.buttonStrokePaint;
        ColorStateList colorStateList = this.strokeColor;
        paint.setColor(colorStateList != null ? colorStateList.getColorForState(this.materialButton.getDrawableState(), 0) : 0);
        int paddingStart = ViewCompat.getPaddingStart(this.materialButton);
        int paddingTop = this.materialButton.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.materialButton);
        int paddingBottom = this.materialButton.getPaddingBottom();
        this.materialButton.setInternalBackground(IS_LOLLIPOP ? createBackgroundLollipop() : createBackgroundCompat());
        ViewCompat.setPaddingRelative(this.materialButton, paddingStart + this.insetLeft, paddingTop + this.insetTop, paddingEnd + this.insetRight, paddingBottom + this.insetBottom);
    }

    public void setBackgroundColor(int i) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        if (IS_LOLLIPOP && (gradientDrawable2 = this.backgroundDrawableLollipop) != null) {
            gradientDrawable2.setColor(i);
        } else if (IS_LOLLIPOP || (gradientDrawable = this.colorableBackgroundDrawableCompat) == null) {
        } else {
            gradientDrawable.setColor(i);
        }
    }

    public void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    public void setCornerRadius(int i) {
        GradientDrawable gradientDrawable;
        if (this.cornerRadius != i) {
            this.cornerRadius = i;
            if (IS_LOLLIPOP && this.backgroundDrawableLollipop != null && this.strokeDrawableLollipop != null && this.maskDrawableLollipop != null) {
                if (Build.VERSION.SDK_INT == 21) {
                    float f2 = i + 1.0E-5f;
                    unwrapBackgroundDrawable().setCornerRadius(f2);
                    unwrapStrokeDrawable().setCornerRadius(f2);
                }
                float f3 = i + 1.0E-5f;
                this.backgroundDrawableLollipop.setCornerRadius(f3);
                this.strokeDrawableLollipop.setCornerRadius(f3);
                this.maskDrawableLollipop.setCornerRadius(f3);
            } else if (IS_LOLLIPOP || (gradientDrawable = this.colorableBackgroundDrawableCompat) == null || this.rippleDrawableCompat == null) {
            } else {
                float f4 = i + 1.0E-5f;
                gradientDrawable.setCornerRadius(f4);
                this.rippleDrawableCompat.setCornerRadius(f4);
                this.materialButton.invalidate();
            }
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            if (IS_LOLLIPOP && (this.materialButton.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.materialButton.getBackground()).setColor(colorStateList);
            } else if (IS_LOLLIPOP || (drawable = this.tintableRippleDrawableCompat) == null) {
            } else {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (this.strokeColor != colorStateList) {
            this.strokeColor = colorStateList;
            this.buttonStrokePaint.setColor(colorStateList != null ? colorStateList.getColorForState(this.materialButton.getDrawableState(), 0) : 0);
            updateStroke();
        }
    }

    public void setStrokeWidth(int i) {
        if (this.strokeWidth != i) {
            this.strokeWidth = i;
            this.buttonStrokePaint.setStrokeWidth(i);
            updateStroke();
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            if (IS_LOLLIPOP) {
                updateTintAndTintModeLollipop();
                return;
            }
            Drawable drawable = this.tintableBackgroundDrawableCompat;
            if (drawable != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            if (IS_LOLLIPOP) {
                updateTintAndTintModeLollipop();
                return;
            }
            Drawable drawable = this.tintableBackgroundDrawableCompat;
            if (drawable == null || mode == null) {
                return;
            }
            DrawableCompat.setTintMode(drawable, mode);
        }
    }

    public void updateMaskBounds(int i, int i2) {
        GradientDrawable gradientDrawable = this.maskDrawableLollipop;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.insetLeft, this.insetTop, i2 - this.insetRight, i - this.insetBottom);
        }
    }
}
