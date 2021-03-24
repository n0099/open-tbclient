package com.kwai.player.vr;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.kwai.player.vr.KwaiVR;
/* loaded from: classes6.dex */
public class KwaiGestureHelper {
    public static final int MODE_INIT = 0;
    public static final int MODE_PINCH = 1;
    public static final String TAG = "KwaiGestureHelperf";
    public static final float mDamping = 0.2f;
    public static final float mDensity = Resources.getSystem().getDisplayMetrics().density;
    public KwaiVR.IAdvanceGestureListener mAdvanceGestureListener;
    public GestureDetector mGestureDetector;
    public ValueAnimator valueAnimator;
    public int mCurrentMode = 0;
    public PinchInfo mPinchInfo = new PinchInfo();
    public boolean mGestureEnabled = false;
    public boolean mPinchEnabled = false;
    public float minScale = 1.0f;
    public float maxScale = 4.0f;
    public float mSensitivity = 1.0f;
    public float defaultScale = 1.0f;
    public float mGlobalScale = 1.0f;
    public float mTouchSensitivity = 1.0f;
    public float mPreDistanceX = 0.0f;
    public float mPreDistanceY = 0.0f;
    public boolean mFlingEnabled = true;
    public KwaiFlingConfig mFlingConfig = new KwaiFlingConfig();

    /* loaded from: classes6.dex */
    public class PinchInfo {
        public float currentScale;
        public float oDistance;
        public float prevScale;
        public float x1;
        public float x2;
        public float y1;
        public float y2;

        public PinchInfo() {
        }

        public void mark(float f2, float f3, float f4, float f5) {
            this.x1 = f2;
            this.y1 = f3;
            this.x2 = f4;
            this.y2 = f5;
            this.oDistance = KwaiGestureHelper.calDistance(f2, f3, f4, f5);
            this.prevScale = this.currentScale;
        }

        public float pinch(float f2) {
            if (this.oDistance == 0.0f) {
                this.oDistance = f2;
            }
            float f3 = this.prevScale + (((f2 / this.oDistance) - 1.0f) * KwaiGestureHelper.this.mSensitivity * 3.0f);
            this.currentScale = f3;
            float max = Math.max(f3, KwaiGestureHelper.this.minScale);
            this.currentScale = max;
            float min = Math.min(max, KwaiGestureHelper.this.maxScale);
            this.currentScale = min;
            return min;
        }

        public float reset() {
            return setScale(KwaiGestureHelper.this.defaultScale);
        }

        public float setScale(float f2) {
            this.prevScale = f2;
            this.currentScale = f2;
            return f2;
        }
    }

    public KwaiGestureHelper(Context context) {
        this.mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.kwai.player.vr.KwaiGestureHelper.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (KwaiGestureHelper.this.mCurrentMode != 1 && KwaiGestureHelper.this.mFlingEnabled) {
                    KwaiGestureHelper.this.animStart(f2, f3);
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (KwaiGestureHelper.this.mCurrentMode == 1) {
                    return false;
                }
                KwaiGestureHelper kwaiGestureHelper = KwaiGestureHelper.this;
                kwaiGestureHelper.onDrag(kwaiGestureHelper.scaled(f2), KwaiGestureHelper.this.scaled(f3));
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return KwaiGestureHelper.this.mCurrentMode != 1;
            }
        });
    }

    private void animCancel() {
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animStart(float f2, float f3) {
        animCancel();
        ValueAnimator duration = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("vx", f2, 0.0f), PropertyValuesHolder.ofFloat("vy", f3, 0.0f)).setDuration(this.mFlingConfig.getDuring());
        this.valueAnimator = duration;
        duration.setInterpolator(this.mFlingConfig.getInterpolator());
        this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwai.player.vr.KwaiGestureHelper.2
            public long lastTime = 0;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                long currentPlayTime = valueAnimator.getCurrentPlayTime();
                float f4 = (float) (currentPlayTime - this.lastTime);
                float floatValue = ((((Float) valueAnimator.getAnimatedValue("vy")).floatValue() * f4) / (-1000.0f)) * KwaiGestureHelper.this.mFlingConfig.getSensitivity();
                this.lastTime = currentPlayTime;
                KwaiGestureHelper kwaiGestureHelper = KwaiGestureHelper.this;
                kwaiGestureHelper.onDrag(kwaiGestureHelper.scaled(((((Float) valueAnimator.getAnimatedValue("vx")).floatValue() * f4) / (-1000.0f)) * KwaiGestureHelper.this.mFlingConfig.getSensitivity()), KwaiGestureHelper.this.scaled(floatValue));
            }
        });
        this.valueAnimator.start();
    }

    public static float calDistance(float f2, float f3, float f4, float f5) {
        return (float) Math.sqrt(Math.pow(f2 - f4, 2.0d) + Math.pow(f3 - f5, 2.0d));
    }

    private void handlePinch(float f2) {
        if (this.mPinchEnabled) {
            setScaleInner(this.mPinchInfo.pinch(f2));
        }
    }

    private void markPinchInfo(float f2, float f3, float f4, float f5) {
        this.mPinchInfo.mark(f2, f3, f4, f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDrag(float f2, float f3) {
        if (this.mGestureEnabled) {
            float f4 = this.mPreDistanceX;
            float f5 = mDensity;
            float f6 = f4 - ((f2 / f5) * 0.2f);
            float f7 = this.mPreDistanceY - ((f3 / f5) * 0.2f);
            KwaiVR.IAdvanceGestureListener iAdvanceGestureListener = this.mAdvanceGestureListener;
            if (iAdvanceGestureListener != null) {
                iAdvanceGestureListener.onDrag(f6, f7);
            }
            this.mPreDistanceX = f6;
            this.mPreDistanceY = f7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float scaled(float f2) {
        return (f2 / this.mGlobalScale) * this.mTouchSensitivity;
    }

    private void setScaleInner(float f2) {
        KwaiVR.IAdvanceGestureListener iAdvanceGestureListener = this.mAdvanceGestureListener;
        if (iAdvanceGestureListener != null) {
            iAdvanceGestureListener.onPinch(f2);
        }
        this.mGlobalScale = f2;
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        float x;
        float y;
        float x2;
        float y2;
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            this.mCurrentMode = 0;
        } else if (action == 6) {
            if (this.mCurrentMode == 1 && motionEvent.getPointerCount() > 2) {
                if ((motionEvent.getAction() >> 8) == 0) {
                    x = motionEvent.getX(1);
                    y = motionEvent.getY(1);
                } else if ((motionEvent.getAction() >> 8) == 1) {
                    x = motionEvent.getX(0);
                    y = motionEvent.getY(0);
                }
                x2 = motionEvent.getX(2);
                y2 = motionEvent.getY(2);
                markPinchInfo(x, y, x2, y2);
            }
        } else if (action == 5) {
            this.mCurrentMode = 1;
            x = motionEvent.getX(0);
            y = motionEvent.getY(0);
            x2 = motionEvent.getX(1);
            y2 = motionEvent.getY(1);
            markPinchInfo(x, y, x2, y2);
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

    public void scaleTo(float f2) {
        setScaleInner(this.mPinchInfo.setScale(f2));
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

    public void setTouchSensitivity(float f2) {
        this.mTouchSensitivity = f2;
    }
}
