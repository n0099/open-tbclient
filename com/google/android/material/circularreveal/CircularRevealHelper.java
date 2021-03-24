package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes6.dex */
public class CircularRevealHelper {
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    public static final boolean DEBUG = false;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY;
    public boolean buildingCircularRevealCache;
    public Paint debugPaint;
    public final Delegate delegate;
    public boolean hasCircularRevealCache;
    @Nullable
    public Drawable overlayDrawable;
    @Nullable
    public CircularRevealWidget.RevealInfo revealInfo;
    public final Paint revealPaint;
    public final Path revealPath;
    public final Paint scrimPaint;
    public final View view;

    /* loaded from: classes6.dex */
    public interface Delegate {
        void actualDraw(Canvas canvas);

        boolean actualIsOpaque();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Strategy {
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            STRATEGY = 2;
        } else if (i >= 18) {
            STRATEGY = 1;
        } else {
            STRATEGY = 0;
        }
    }

    public CircularRevealHelper(Delegate delegate) {
        this.delegate = delegate;
        View view = (View) delegate;
        this.view = view;
        view.setWillNotDraw(false);
        this.revealPath = new Path();
        this.revealPaint = new Paint(7);
        Paint paint = new Paint(1);
        this.scrimPaint = paint;
        paint.setColor(0);
    }

    private void drawDebugCircle(Canvas canvas, int i, float f2) {
        this.debugPaint.setColor(i);
        this.debugPaint.setStrokeWidth(f2);
        CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
        canvas.drawCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius - (f2 / 2.0f), this.debugPaint);
    }

    private void drawDebugMode(Canvas canvas) {
        this.delegate.actualDraw(canvas);
        if (shouldDrawScrim()) {
            CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
            canvas.drawCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius, this.scrimPaint);
        }
        if (shouldDrawCircularReveal()) {
            drawDebugCircle(canvas, -16777216, 10.0f);
            drawDebugCircle(canvas, -65536, 5.0f);
        }
        drawOverlayDrawable(canvas);
    }

    private void drawOverlayDrawable(Canvas canvas) {
        if (shouldDrawOverlayDrawable()) {
            Rect bounds = this.overlayDrawable.getBounds();
            float width = this.revealInfo.centerX - (bounds.width() / 2.0f);
            float height = this.revealInfo.centerY - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.overlayDrawable.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float getDistanceToFurthestCorner(CircularRevealWidget.RevealInfo revealInfo) {
        return MathUtils.distanceToFurthestCorner(revealInfo.centerX, revealInfo.centerY, 0.0f, 0.0f, this.view.getWidth(), this.view.getHeight());
    }

    private void invalidateRevealInfo() {
        if (STRATEGY == 1) {
            this.revealPath.rewind();
            CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
            if (revealInfo != null) {
                this.revealPath.addCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius, Path.Direction.CW);
            }
        }
        this.view.invalidate();
    }

    private boolean shouldDrawCircularReveal() {
        CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
        boolean z = revealInfo == null || revealInfo.isInvalid();
        return STRATEGY == 0 ? !z && this.hasCircularRevealCache : !z;
    }

    private boolean shouldDrawOverlayDrawable() {
        return (this.buildingCircularRevealCache || this.overlayDrawable == null || this.revealInfo == null) ? false : true;
    }

    private boolean shouldDrawScrim() {
        return (this.buildingCircularRevealCache || Color.alpha(this.scrimPaint.getColor()) == 0) ? false : true;
    }

    public void buildCircularRevealCache() {
        if (STRATEGY == 0) {
            this.buildingCircularRevealCache = true;
            this.hasCircularRevealCache = false;
            this.view.buildDrawingCache();
            Bitmap drawingCache = this.view.getDrawingCache();
            if (drawingCache == null && this.view.getWidth() != 0 && this.view.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap.Config.ARGB_8888);
                this.view.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.revealPaint;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.buildingCircularRevealCache = false;
            this.hasCircularRevealCache = true;
        }
    }

    public void destroyCircularRevealCache() {
        if (STRATEGY == 0) {
            this.hasCircularRevealCache = false;
            this.view.destroyDrawingCache();
            this.revealPaint.setShader(null);
            this.view.invalidate();
        }
    }

    public void draw(Canvas canvas) {
        if (shouldDrawCircularReveal()) {
            int i = STRATEGY;
            if (i == 0) {
                CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
                canvas.drawCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius, this.revealPaint);
                if (shouldDrawScrim()) {
                    CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
                    canvas.drawCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius, this.scrimPaint);
                }
            } else if (i == 1) {
                int save = canvas.save();
                canvas.clipPath(this.revealPath);
                this.delegate.actualDraw(canvas);
                if (shouldDrawScrim()) {
                    canvas.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
                }
                canvas.restoreToCount(save);
            } else if (i == 2) {
                this.delegate.actualDraw(canvas);
                if (shouldDrawScrim()) {
                    canvas.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
                }
            } else {
                throw new IllegalStateException("Unsupported strategy " + STRATEGY);
            }
        } else {
            this.delegate.actualDraw(canvas);
            if (shouldDrawScrim()) {
                canvas.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
            }
        }
        drawOverlayDrawable(canvas);
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.overlayDrawable;
    }

    @ColorInt
    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        CircularRevealWidget.RevealInfo revealInfo = this.revealInfo;
        if (revealInfo == null) {
            return null;
        }
        CircularRevealWidget.RevealInfo revealInfo2 = new CircularRevealWidget.RevealInfo(revealInfo);
        if (revealInfo2.isInvalid()) {
            revealInfo2.radius = getDistanceToFurthestCorner(revealInfo2);
        }
        return revealInfo2;
    }

    public boolean isOpaque() {
        return this.delegate.actualIsOpaque() && !shouldDrawCircularReveal();
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.overlayDrawable = drawable;
        this.view.invalidate();
    }

    public void setCircularRevealScrimColor(@ColorInt int i) {
        this.scrimPaint.setColor(i);
        this.view.invalidate();
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo revealInfo) {
        if (revealInfo == null) {
            this.revealInfo = null;
        } else {
            CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
            if (revealInfo2 == null) {
                this.revealInfo = new CircularRevealWidget.RevealInfo(revealInfo);
            } else {
                revealInfo2.set(revealInfo);
            }
            if (MathUtils.geq(revealInfo.radius, getDistanceToFurthestCorner(revealInfo), 1.0E-4f)) {
                this.revealInfo.radius = Float.MAX_VALUE;
            }
        }
        invalidateRevealInfo();
    }
}
