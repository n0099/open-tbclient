package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public final class ScaleProvider implements VisibilityAnimatorProvider {
    public boolean growing;
    public float incomingEndScale;
    public float incomingStartScale;
    public float outgoingEndScale;
    public float outgoingStartScale;
    public boolean scaleOnDisappear;

    public ScaleProvider() {
        this(true);
    }

    public static Animator createScaleAnimator(View view, float f2, float f3) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.SCALE_X, f2, f3), PropertyValuesHolder.ofFloat(View.SCALE_Y, f2, f3));
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.growing) {
            return createScaleAnimator(view, this.incomingStartScale, this.incomingEndScale);
        }
        return createScaleAnimator(view, this.outgoingEndScale, this.outgoingStartScale);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.scaleOnDisappear) {
            if (this.growing) {
                return createScaleAnimator(view, this.outgoingStartScale, this.outgoingEndScale);
            }
            return createScaleAnimator(view, this.incomingEndScale, this.incomingStartScale);
        }
        return null;
    }

    public float getIncomingEndScale() {
        return this.incomingEndScale;
    }

    public float getIncomingStartScale() {
        return this.incomingStartScale;
    }

    public float getOutgoingEndScale() {
        return this.outgoingEndScale;
    }

    public float getOutgoingStartScale() {
        return this.outgoingStartScale;
    }

    public boolean isGrowing() {
        return this.growing;
    }

    public boolean isScaleOnDisappear() {
        return this.scaleOnDisappear;
    }

    public void setGrowing(boolean z) {
        this.growing = z;
    }

    public void setIncomingEndScale(float f2) {
        this.incomingEndScale = f2;
    }

    public void setIncomingStartScale(float f2) {
        this.incomingStartScale = f2;
    }

    public void setOutgoingEndScale(float f2) {
        this.outgoingEndScale = f2;
    }

    public void setOutgoingStartScale(float f2) {
        this.outgoingStartScale = f2;
    }

    public void setScaleOnDisappear(boolean z) {
        this.scaleOnDisappear = z;
    }

    public ScaleProvider(boolean z) {
        this.outgoingStartScale = 1.0f;
        this.outgoingEndScale = 1.1f;
        this.incomingStartScale = 0.8f;
        this.incomingEndScale = 1.0f;
        this.scaleOnDisappear = true;
        this.growing = z;
    }
}
