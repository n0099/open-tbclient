package com.facebook.drawee.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.common.internal.VisibleForTesting;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class GestureDetector {
    @VisibleForTesting
    public long mActionDownTime;
    @VisibleForTesting
    public float mActionDownX;
    @VisibleForTesting
    public float mActionDownY;
    @VisibleForTesting
    @Nullable
    public ClickListener mClickListener;
    @VisibleForTesting
    public boolean mIsCapturingGesture;
    @VisibleForTesting
    public boolean mIsClickCandidate;
    @VisibleForTesting
    public final float mSingleTapSlopPx;

    /* loaded from: classes5.dex */
    public interface ClickListener {
        boolean onClick();
    }

    public GestureDetector(Context context) {
        this.mSingleTapSlopPx = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static GestureDetector newInstance(Context context) {
        return new GestureDetector(context);
    }

    public void init() {
        this.mClickListener = null;
        reset();
    }

    public boolean isCapturingGesture() {
        return this.mIsCapturingGesture;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ClickListener clickListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mIsCapturingGesture = true;
            this.mIsClickCandidate = true;
            this.mActionDownTime = motionEvent.getEventTime();
            this.mActionDownX = motionEvent.getX();
            this.mActionDownY = motionEvent.getY();
        } else if (action == 1) {
            this.mIsCapturingGesture = false;
            if (Math.abs(motionEvent.getX() - this.mActionDownX) > this.mSingleTapSlopPx || Math.abs(motionEvent.getY() - this.mActionDownY) > this.mSingleTapSlopPx) {
                this.mIsClickCandidate = false;
            }
            if (this.mIsClickCandidate && motionEvent.getEventTime() - this.mActionDownTime <= ViewConfiguration.getLongPressTimeout() && (clickListener = this.mClickListener) != null) {
                clickListener.onClick();
            }
            this.mIsClickCandidate = false;
        } else if (action != 2) {
            if (action == 3) {
                this.mIsCapturingGesture = false;
                this.mIsClickCandidate = false;
            }
        } else if (Math.abs(motionEvent.getX() - this.mActionDownX) > this.mSingleTapSlopPx || Math.abs(motionEvent.getY() - this.mActionDownY) > this.mSingleTapSlopPx) {
            this.mIsClickCandidate = false;
        }
        return true;
    }

    public void reset() {
        this.mIsCapturingGesture = false;
        this.mIsClickCandidate = false;
    }

    public void setClickListener(ClickListener clickListener) {
        this.mClickListener = clickListener;
    }
}
