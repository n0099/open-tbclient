package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class FadeDrawable extends ArrayDrawable {
    @VisibleForTesting
    public static final int TRANSITION_NONE = 2;
    @VisibleForTesting
    public static final int TRANSITION_RUNNING = 1;
    @VisibleForTesting
    public static final int TRANSITION_STARTING = 0;
    public static boolean sGlobalFadingEnable = true;
    public final int ACTUAL_IMAGE_INDEX;
    @VisibleForTesting
    public int mAlpha;
    @VisibleForTesting
    public int[] mAlphas;
    public boolean mCallOnFadeFinishedListener;
    public final int mDefaultLayerAlpha;
    public final boolean mDefaultLayerIsOn;
    @VisibleForTesting
    public int mDurationMs;
    @VisibleForTesting
    public boolean[] mIsLayerOn;
    public final Drawable[] mLayers;
    @Nullable
    public OnFadeFinishedListener mOnFadeFinishedListener;
    @VisibleForTesting
    public int mPreventInvalidateCount;
    @VisibleForTesting
    public int[] mStartAlphas;
    @VisibleForTesting
    public long mStartTimeMs;
    @VisibleForTesting
    public int mTransitionState;

    /* loaded from: classes8.dex */
    public interface OnFadeFinishedListener {
        void onFadeFinished();
    }

    public FadeDrawable(Drawable[] drawableArr) {
        this(drawableArr, false);
    }

    public static void setGlobalFadingEnable(boolean z) {
        sGlobalFadingEnable = z;
    }

    public void fadeInLayer(int i) {
        boolean z;
        if (i == 2) {
            z = true;
        } else {
            z = false;
        }
        this.mCallOnFadeFinishedListener = z;
        this.mTransitionState = 0;
        this.mIsLayerOn[i] = true;
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

    public void hideLayerImmediately(int i) {
        this.mIsLayerOn[i] = false;
        this.mAlphas[i] = 0;
        invalidateSelf();
    }

    public boolean isLayerOn(int i) {
        return this.mIsLayerOn[i];
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mAlpha != i) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    public void setOnFadeFinishedListener(OnFadeFinishedListener onFadeFinishedListener) {
        this.mOnFadeFinishedListener = onFadeFinishedListener;
    }

    public void setTransitionDuration(int i) {
        this.mDurationMs = i;
        if (this.mTransitionState == 1) {
            this.mTransitionState = 0;
        }
    }

    public void showLayerImmediately(int i) {
        this.mIsLayerOn[i] = true;
        this.mAlphas[i] = 255;
        invalidateSelf();
    }

    public FadeDrawable(Drawable[] drawableArr, boolean z) {
        super(drawableArr);
        this.ACTUAL_IMAGE_INDEX = 2;
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

    private void drawDrawableWithAlpha(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.mPreventInvalidateCount++;
            drawable.mutate().setAlpha(i);
            this.mPreventInvalidateCount--;
            drawable.draw(canvas);
        }
    }

    public static boolean getGlobalFadingEnable() {
        return sGlobalFadingEnable;
    }

    private void maybeNotifyOnFadeFinished() {
        OnFadeFinishedListener onFadeFinishedListener = this.mOnFadeFinishedListener;
        if (onFadeFinishedListener != null && this.mCallOnFadeFinishedListener) {
            onFadeFinishedListener.onFadeFinished();
            this.mCallOnFadeFinishedListener = false;
        }
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

    public void beginBatchMode() {
        this.mPreventInvalidateCount++;
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

    public void fadeOutAllLayers() {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, false);
        invalidateSelf();
    }

    public void finishTransitionImmediately() {
        int i;
        this.mTransitionState = 2;
        for (int i2 = 0; i2 < this.mLayers.length; i2++) {
            int[] iArr = this.mAlphas;
            if (this.mIsLayerOn[i2]) {
                i = 255;
            } else {
                i = 0;
            }
            iArr[i2] = i;
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

    public boolean isDefaultLayerIsOn() {
        return this.mDefaultLayerIsOn;
    }

    public void reset() {
        resetInternal();
        invalidateSelf();
    }

    private boolean updateAlphas(float f) {
        int i;
        boolean z = true;
        for (int i2 = 0; i2 < this.mLayers.length; i2++) {
            if (this.mIsLayerOn[i2]) {
                i = 1;
            } else {
                i = -1;
            }
            int[] iArr = this.mAlphas;
            iArr[i2] = (int) (this.mStartAlphas[i2] + (i * 255 * f));
            if (iArr[i2] < 0) {
                iArr[i2] = 0;
            }
            int[] iArr2 = this.mAlphas;
            if (iArr2[i2] > 255) {
                iArr2[i2] = 255;
            }
            if (this.mIsLayerOn[i2] && this.mAlphas[i2] < 255) {
                z = false;
            }
            if (!this.mIsLayerOn[i2] && this.mAlphas[i2] > 0) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x006d A[LOOP:0: B:36:0x0068->B:38:0x006d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f A[EDGE_INSN: B:42:0x007f->B:39:0x007f ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas) {
        boolean updateAlphas;
        Drawable[] drawableArr;
        boolean z;
        int i = this.mTransitionState;
        float f = 1.0f;
        int i2 = 2;
        int i3 = 0;
        boolean z2 = true;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    maybeNotifyOnFadeFinished();
                }
                while (true) {
                    drawableArr = this.mLayers;
                    if (i3 < drawableArr.length) {
                        break;
                    }
                    drawDrawableWithAlpha(canvas, drawableArr[i3], (this.mAlphas[i3] * this.mAlpha) / 255);
                    i3++;
                }
                if (z2) {
                    invalidateSelf();
                    return;
                }
                return;
            }
            if (this.mDurationMs > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
            if (sGlobalFadingEnable) {
                f = ((float) (getCurrentTimeMs() - this.mStartTimeMs)) / this.mDurationMs;
            }
            updateAlphas = updateAlphas(f);
            if (!updateAlphas) {
                i2 = 1;
            }
            this.mTransitionState = i2;
            if (updateAlphas) {
                maybeNotifyOnFadeFinished();
            }
        } else {
            System.arraycopy(this.mAlphas, 0, this.mStartAlphas, 0, this.mLayers.length);
            this.mStartTimeMs = getCurrentTimeMs();
            if (sGlobalFadingEnable && this.mDurationMs != 0) {
                f = 0.0f;
            }
            updateAlphas = updateAlphas(f);
            if (!updateAlphas) {
                i2 = 1;
            }
            this.mTransitionState = i2;
            if (updateAlphas) {
                maybeNotifyOnFadeFinished();
            }
        }
        z2 = updateAlphas;
        while (true) {
            drawableArr = this.mLayers;
            if (i3 < drawableArr.length) {
            }
            drawDrawableWithAlpha(canvas, drawableArr[i3], (this.mAlphas[i3] * this.mAlpha) / 255);
            i3++;
        }
        if (z2) {
        }
    }
}
