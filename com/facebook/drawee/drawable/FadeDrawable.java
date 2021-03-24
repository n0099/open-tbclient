package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class FadeDrawable extends ArrayDrawable {
    @VisibleForTesting
    public static final int TRANSITION_NONE = 2;
    @VisibleForTesting
    public static final int TRANSITION_RUNNING = 1;
    @VisibleForTesting
    public static final int TRANSITION_STARTING = 0;
    public static boolean sGlobalFadingEnable = true;
    @VisibleForTesting
    public int mAlpha;
    @VisibleForTesting
    public int[] mAlphas;
    public final int mDefaultLayerAlpha;
    public final boolean mDefaultLayerIsOn;
    @VisibleForTesting
    public int mDurationMs;
    @VisibleForTesting
    public boolean[] mIsLayerOn;
    public final Drawable[] mLayers;
    @VisibleForTesting
    public int mPreventInvalidateCount;
    @VisibleForTesting
    public int[] mStartAlphas;
    @VisibleForTesting
    public long mStartTimeMs;
    @VisibleForTesting
    public int mTransitionState;

    public FadeDrawable(Drawable[] drawableArr) {
        this(drawableArr, false);
    }

    private void drawDrawableWithAlpha(Canvas canvas, Drawable drawable, int i) {
        if (drawable == null || i <= 0) {
            return;
        }
        this.mPreventInvalidateCount++;
        drawable.mutate().setAlpha(i);
        this.mPreventInvalidateCount--;
        drawable.draw(canvas);
    }

    public static boolean getGlobalFadingEnable() {
        return sGlobalFadingEnable;
    }

    private void resetInternal() {
        this.mTransitionState = 2;
        Arrays.fill(this.mStartAlphas, this.mDefaultLayerAlpha);
        this.mStartAlphas[0] = 255;
        Arrays.fill(this.mAlphas, this.mDefaultLayerAlpha);
        this.mAlphas[0] = 255;
        Arrays.fill(this.mIsLayerOn, this.mDefaultLayerIsOn);
        this.mIsLayerOn[0] = true;
    }

    public static void setGlobalFadingEnable(boolean z) {
        sGlobalFadingEnable = z;
    }

    private boolean updateAlphas(float f2) {
        boolean z = true;
        for (int i = 0; i < this.mLayers.length; i++) {
            int i2 = this.mIsLayerOn[i] ? 1 : -1;
            int[] iArr = this.mAlphas;
            iArr[i] = (int) (this.mStartAlphas[i] + (i2 * 255 * f2));
            if (iArr[i] < 0) {
                iArr[i] = 0;
            }
            int[] iArr2 = this.mAlphas;
            if (iArr2[i] > 255) {
                iArr2[i] = 255;
            }
            if (this.mIsLayerOn[i] && this.mAlphas[i] < 255) {
                z = false;
            }
            if (!this.mIsLayerOn[i] && this.mAlphas[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    public void beginBatchMode() {
        this.mPreventInvalidateCount++;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005d A[LOOP:0: B:30:0x0058->B:32:0x005d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f A[EDGE_INSN: B:36:0x006f->B:33:0x006f ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas) {
        boolean updateAlphas;
        Drawable[] drawableArr;
        int i = this.mTransitionState;
        int i2 = 0;
        boolean z = true;
        if (i != 0) {
            if (i == 1) {
                Preconditions.checkState(this.mDurationMs > 0);
                updateAlphas = updateAlphas(sGlobalFadingEnable ? ((float) (getCurrentTimeMs() - this.mStartTimeMs)) / this.mDurationMs : 1.0f);
                this.mTransitionState = updateAlphas ? 2 : 1;
            }
            while (true) {
                drawableArr = this.mLayers;
                if (i2 < drawableArr.length) {
                    break;
                }
                drawDrawableWithAlpha(canvas, drawableArr[i2], (this.mAlphas[i2] * this.mAlpha) / 255);
                i2++;
            }
            if (z) {
                invalidateSelf();
                return;
            }
            return;
        }
        System.arraycopy(this.mAlphas, 0, this.mStartAlphas, 0, this.mLayers.length);
        this.mStartTimeMs = getCurrentTimeMs();
        if (sGlobalFadingEnable && this.mDurationMs != 0) {
            r1 = 0.0f;
        }
        updateAlphas = updateAlphas(r1);
        this.mTransitionState = updateAlphas ? 2 : 1;
        z = updateAlphas;
        while (true) {
            drawableArr = this.mLayers;
            if (i2 < drawableArr.length) {
            }
            drawDrawableWithAlpha(canvas, drawableArr[i2], (this.mAlphas[i2] * this.mAlpha) / 255);
            i2++;
        }
        if (z) {
        }
    }

    public void endBatchMode() {
        this.mPreventInvalidateCount--;
        invalidateSelf();
    }

    public void fadeInAllLayers() {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, true);
        invalidateSelf();
    }

    public void fadeInLayer(int i) {
        this.mTransitionState = 0;
        this.mIsLayerOn[i] = true;
        invalidateSelf();
    }

    public void fadeOutAllLayers() {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, false);
        invalidateSelf();
    }

    public void fadeOutLayer(int i) {
        this.mTransitionState = 0;
        this.mIsLayerOn[i] = false;
        invalidateSelf();
    }

    public void fadeToLayer(int i) {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, false);
        this.mIsLayerOn[i] = true;
        invalidateSelf();
    }

    public void fadeUpToLayer(int i) {
        this.mTransitionState = 0;
        int i2 = i + 1;
        Arrays.fill(this.mIsLayerOn, 0, i2, true);
        Arrays.fill(this.mIsLayerOn, i2, this.mLayers.length, false);
        invalidateSelf();
    }

    public void finishTransitionImmediately() {
        this.mTransitionState = 2;
        for (int i = 0; i < this.mLayers.length; i++) {
            this.mAlphas[i] = this.mIsLayerOn[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    public long getCurrentTimeMs() {
        return SystemClock.uptimeMillis();
    }

    public int getTransitionDuration() {
        return this.mDurationMs;
    }

    @VisibleForTesting
    public int getTransitionState() {
        return this.mTransitionState;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.mPreventInvalidateCount == 0) {
            super.invalidateSelf();
        }
    }

    public boolean isLayerOn(int i) {
        return this.mIsLayerOn[i];
    }

    public void reset() {
        resetInternal();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mAlpha != i) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    public void setTransitionDuration(int i) {
        this.mDurationMs = i;
        if (this.mTransitionState == 1) {
            this.mTransitionState = 0;
        }
    }

    public FadeDrawable(Drawable[] drawableArr, boolean z) {
        super(drawableArr);
        Preconditions.checkState(drawableArr.length >= 1, "At least one layer required!");
        this.mLayers = drawableArr;
        this.mStartAlphas = new int[drawableArr.length];
        this.mAlphas = new int[drawableArr.length];
        this.mAlpha = 255;
        this.mIsLayerOn = new boolean[drawableArr.length];
        this.mPreventInvalidateCount = 0;
        this.mDefaultLayerIsOn = z;
        this.mDefaultLayerAlpha = z ? 255 : 0;
        resetInternal();
    }
}
