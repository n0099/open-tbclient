package com.facebook.drawee.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.Rect;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.view.ViewGroup;
import com.facebook.drawee.drawable.ScalingUtils;
import javax.annotation.Nullable;
@TargetApi(19)
/* loaded from: classes8.dex */
public class DraweeTransition extends Transition {
    public static final String PROPNAME_BOUNDS = "draweeTransition:bounds";
    @Nullable
    public final PointF mFromFocusPoint;
    public final ScalingUtils.ScaleType mFromScale;
    @Nullable
    public final PointF mToFocusPoint;
    public final ScalingUtils.ScaleType mToScale;

    public DraweeTransition(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2) {
        this(scaleType, scaleType2, null, null);
    }

    public static TransitionSet createTransitionSet(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2) {
        return createTransitionSet(scaleType, scaleType2, null, null);
    }

    public DraweeTransition(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2, @Nullable PointF pointF, @Nullable PointF pointF2) {
        this.mFromScale = scaleType;
        this.mToScale = scaleType2;
        this.mFromFocusPoint = pointF;
        this.mToFocusPoint = pointF2;
    }

    public static TransitionSet createTransitionSet(ScalingUtils.ScaleType scaleType, ScalingUtils.ScaleType scaleType2, @Nullable PointF pointF, @Nullable PointF pointF2) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new DraweeTransition(scaleType, scaleType2, pointF, pointF2));
        return transitionSet;
    }

    private void captureValues(TransitionValues transitionValues) {
        if (transitionValues.view instanceof GenericDraweeView) {
            transitionValues.values.put(PROPNAME_BOUNDS, new Rect(0, 0, transitionValues.view.getWidth(), transitionValues.view.getHeight()));
        }
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.transition.Transition
    @Nullable
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues != null && transitionValues2 != null) {
            Rect rect = (Rect) transitionValues.values.get(PROPNAME_BOUNDS);
            Rect rect2 = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
            if (rect != null && rect2 != null) {
                if (this.mFromScale == this.mToScale && this.mFromFocusPoint == this.mToFocusPoint) {
                    return null;
                }
                final GenericDraweeView genericDraweeView = (GenericDraweeView) transitionValues.view;
                final ScalingUtils.InterpolatingScaleType interpolatingScaleType = new ScalingUtils.InterpolatingScaleType(this.mFromScale, this.mToScale, rect, rect2, this.mFromFocusPoint, this.mToFocusPoint);
                genericDraweeView.getHierarchy().setActualImageScaleType(interpolatingScaleType);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facebook.drawee.view.DraweeTransition.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        interpolatingScaleType.setValue(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.facebook.drawee.view.DraweeTransition.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        genericDraweeView.getHierarchy().setActualImageScaleType(DraweeTransition.this.mToScale);
                        if (DraweeTransition.this.mToFocusPoint != null) {
                            genericDraweeView.getHierarchy().setActualImageFocusPoint(DraweeTransition.this.mToFocusPoint);
                        }
                    }
                });
                return ofFloat;
            }
        }
        return null;
    }
}
