package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes7.dex */
public interface VisibilityAnimatorProvider {
    Animator createAppear(ViewGroup viewGroup, View view2);

    Animator createDisappear(ViewGroup viewGroup, View view2);
}
