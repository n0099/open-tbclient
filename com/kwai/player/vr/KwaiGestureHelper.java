package com.kwai.player.vr;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.kwai.player.vr.KwaiVR;
/* loaded from: classes4.dex */
public class KwaiGestureHelper {
    private static final int MODE_INIT = 0;
    private static final int MODE_PINCH = 1;
    private static final String TAG = "KwaiGestureHelperf";
    private static final float mDamping = 0.2f;
    private static final float mDensity = Resources.getSystem().getDisplayMetrics().density;
    private KwaiVR.IAdvanceGestureListener mAdvanceGestureListener;
    private GestureDetector mGestureDetector;
    private ValueAnimator valueAnimator;
    private int mCurrentMode = 0;
    private PinchInfo mPinchInfo = new PinchInfo();
    private boolean mGestureEnabled = false;
    private boolean mPinchEnabled = false;
    private float minScale = 1.0f;
    private float maxScale = 4.0f;
    private float mSensitivity = 1.0f;
    private float defaultScale = 1.0f;
    private float mGlobalScale = 1.0f;
    private float mTouchSensitivity = 1.0f;
    private float mPreDistanceX = 0.0f;
    private float mPreDistanceY = 0.0f;
    private boolean mFlingEnabled = true;
    private KwaiFlingConfig mFlingConfig = new KwaiFlingConfig();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class PinchInfo {
        private float currentScale;
        private float oDistance;
        private float prevScale;
        private float x1;
        private float x2;
        private float y1;
        private float y2;

        private PinchInfo() {
        }

        public void mark(float f, float f2, float f3, float f4) {
            this.x1 = f;
            this.y1 = f2;
            this.x2 = f3;
            this.y2 = f4;
            this.oDistance = KwaiGestureHelper.calDistance(f, f2, f3, f4);
            this.prevScale = this.currentScale;
        }

        public float pinch(float f) {
            if (this.oDistance == 0.0f) {
                this.oDistance = f;
            }
            this.currentScale = (((f / this.oDistance) - 1.0f) * KwaiGestureHelper.this.mSensitivity * 3.0f) + this.prevScale;
            this.currentScale = Math.max(this.currentScale, KwaiGestureHelper.this.minScale);
            this.currentScale = Math.min(this.currentScale, KwaiGestureHelper.this.maxScale);
            return this.currentScale;
        }

        public float reset() {
            return setScale(KwaiGestureHelper.this.defaultScale);
        }

        public float setScale(float f) {
            this.prevScale = f;
            this.currentScale = f;
            return this.currentScale;
        }
    }

    public KwaiGestureHelper(Context context) {
        this.mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.kwai.player.vr.KwaiGestureHelper.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (KwaiGestureHelper.this.mCurrentMode != 1 && KwaiGestureHelper.this.mFlingEnabled) {
                    KwaiGestureHelper.this.animStart(f, f2);
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (KwaiGestureHelper.this.mCurrentMode == 1) {
                    return false;
                }
                KwaiGestureHelper.this.onDrag(KwaiGestureHelper.this.scaled(f), KwaiGestureHelper.this.scaled(f2));
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return KwaiGestureHelper.this.mCurrentMode != 1;
            }
        });
    }

    private void animCancel() {
        if (this.valueAnimator != null) {
            this.valueAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animStart(float f, float f2) {
        animCancel();
        this.valueAnimator = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("vx", f, 0.0f), PropertyValuesHolder.ofFloat("vy", f2, 0.0f)).setDuration(this.mFlingConfig.getDuring());
        this.valueAnimator.setInterpolator(this.mFlingConfig.getInterpolator());
        this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwai.player.vr.KwaiGestureHelper.2
            private long lastTime = 0;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                long currentPlayTime = valueAnimator.getCurrentPlayTime();
                long j = currentPlayTime - this.lastTime;
                float sensitivity = KwaiGestureHelper.this.mFlingConfig.getSensitivity() * ((((Float) valueAnimator.getAnimatedValue("vx")).floatValue() * ((float) j)) / (-1000.0f));
                this.lastTime = currentPlayTime;
                KwaiGestureHelper.this.onDrag(KwaiGestureHelper.this.scaled(sensitivity), KwaiGestureHelper.this.scaled(((((Float) valueAnimator.getAnimatedValue("vy")).floatValue() * ((float) j)) / (-1000.0f)) * KwaiGestureHelper.this.mFlingConfig.getSensitivity()));
            }
        });
        this.valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float calDistance(float f, float f2, float f3, float f4) {
        return (float) Math.sqrt(Math.pow(f - f3, 2.0d) + Math.pow(f2 - f4, 2.0d));
    }

    private void handlePinch(float f) {
        if (this.mPinchEnabled) {
            setScaleInner(this.mPinchInfo.pinch(f));
        }
    }

    private void markPinchInfo(float f, float f2, float f3, float f4) {
        this.mPinchInfo.mark(f, f2, f3, f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDrag(float f, float f2) {
        if (this.mGestureEnabled) {
            float f3 = this.mPreDistanceX - ((f / mDensity) * 0.2f);
            float f4 = this.mPreDistanceY - ((f2 / mDensity) * 0.2f);
            if (this.mAdvanceGestureListener != null) {
                this.mAdvanceGestureListener.onDrag(f3, f4);
            }
            this.mPreDistanceX = f3;
            this.mPreDistanceY = f4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float scaled(float f) {
        return (f / this.mGlobalScale) * this.mTouchSensitivity;
    }

    private void setScaleInner(float f) {
        if (this.mAdvanceGestureListener != null) {
            this.mAdvanceGestureListener.onPinch(f);
        }
        this.mGlobalScale = f;
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            if (this.mCurrentMode == 1) {
            }
            this.mCurrentMode = 0;
        } else if (action == 6) {
            if (this.mCurrentMode == 1 && motionEvent.getPointerCount() > 2) {
                if ((motionEvent.getAction() >> 8) == 0) {
                    markPinchInfo(motionEvent.getX(1), motionEvent.getY(1), motionEvent.getX(2), motionEvent.getY(2));
                } else if ((motionEvent.getAction() >> 8) == 1) {
                    markPinchInfo(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(2), motionEvent.getY(2));
                }
            }
        } else if (action == 5) {
            this.mCurrentMode = 1;
            markPinchInfo(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
        } else if (action == 2) {
            if (this.mCurrentMode == 1 && motionEvent.getPointerCount() > 1) {
                handlePinch(calDistance(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1)));
            }
        } else if (action == 0) {
            animCancel();
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    public boolean isFlingEnabled() {
        return this.mFlingEnabled;
    }

    public boolean isGestureEnabled() {
        return this.mGestureEnabled;
    }

    public boolean isPinchEnabled() {
        return this.mPinchEnabled;
    }

    public void reset() {
        setScaleInner(this.mPinchInfo.reset());
    }

    public void scaleTo(float f) {
        setScaleInner(this.mPinchInfo.setScale(f));
    }

    public void setAdvanceGestureListener(KwaiVR.IAdvanceGestureListener iAdvanceGestureListener) {
        this.mAdvanceGestureListener = iAdvanceGestureListener;
    }

    public void setFlingEnabled(boolean z) {
        this.mFlingEnabled = z;
    }

    public void setGestureEnabled(boolean z) {
        this.mGestureEnabled = z;
    }

    public void setPinchEnabled(boolean z) {
        this.mPinchEnabled = z;
    }

    public void setTouchSensitivity(float f) {
        this.mTouchSensitivity = f;
    }
}
