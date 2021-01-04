package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class StateListAnimator {
    private final ArrayList<Tuple> tuples = new ArrayList<>();
    private Tuple lastMatch = null;
    ValueAnimator runningAnimator = null;
    private final Animator.AnimatorListener animationListener = new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.StateListAnimator.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (StateListAnimator.this.runningAnimator == animator) {
                StateListAnimator.this.runningAnimator = null;
            }
        }
    };

    public void addState(int[] iArr, ValueAnimator valueAnimator) {
        Tuple tuple = new Tuple(iArr, valueAnimator);
        valueAnimator.addListener(this.animationListener);
        this.tuples.add(tuple);
    }

    public void setState(int[] iArr) {
        Tuple tuple;
        int size = this.tuples.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                tuple = null;
                break;
            }
            tuple = this.tuples.get(i);
            if (StateSet.stateSetMatches(tuple.specs, iArr)) {
                break;
            }
            i++;
        }
        if (tuple != this.lastMatch) {
            if (this.lastMatch != null) {
                cancel();
            }
            this.lastMatch = tuple;
            if (tuple != null) {
                start(tuple);
            }
        }
    }

    private void start(Tuple tuple) {
        this.runningAnimator = tuple.animator;
        this.runningAnimator.start();
    }

    private void cancel() {
        if (this.runningAnimator != null) {
            this.runningAnimator.cancel();
            this.runningAnimator = null;
        }
    }

    public void jumpToCurrentState() {
        if (this.runningAnimator != null) {
            this.runningAnimator.end();
            this.runningAnimator = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class Tuple {
        final ValueAnimator animator;
        final int[] specs;

        Tuple(int[] iArr, ValueAnimator valueAnimator) {
            this.specs = iArr;
            this.animator = valueAnimator;
        }
    }
}
