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
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public class ShadowRenderer {
    public static final int COLOR_ALPHA_END = 0;
    public static final int COLOR_ALPHA_MIDDLE = 20;
    public static final int COLOR_ALPHA_START = 68;
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
    public static final int[] edgeColors = new int[3];
    public static final float[] edgePositions = {0.0f, 0.5f, 1.0f};
    public static final int[] cornerColors = new int[4];
    public static final float[] cornerPositions = {0.0f, 0.0f, 0.5f, 1.0f};

    public ShadowRenderer() {
        this(-16777216);
    }

    @NonNull
    public Paint getShadowPaint() {
        return this.shadowPaint;
    }

    public ShadowRenderer(int i) {
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

    public void drawCornerShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i, float f, float f2) {
        boolean z;
        if (f2 < 0.0f) {
            z = true;
        } else {
            z = false;
        }
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

    public void drawEdgeShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i) {
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

    public void setShadowColor(int i) {
        this.shadowStartColor = ColorUtils.setAlphaComponent(i, 68);
        this.shadowMiddleColor = ColorUtils.setAlphaComponent(i, 20);
        this.shadowEndColor = ColorUtils.setAlphaComponent(i, 0);
        this.shadowPaint.setColor(this.shadowStartColor);
    }
}
