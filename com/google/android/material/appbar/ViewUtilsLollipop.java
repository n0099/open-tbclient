package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.tieba.R;
import com.google.android.material.internal.ThemeEnforcement;
@RequiresApi(21)
/* loaded from: classes9.dex */
public class ViewUtilsLollipop {
    public static final int[] STATE_LIST_ANIM_ATTRS = {16843848};

    public static void setBoundsViewOutlineProvider(@NonNull View view2) {
        view2.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    public static void setDefaultAppBarLayoutStateListAnimator(@NonNull View view2, float f) {
        int integer = view2.getResources().getInteger(R.integer.obfuscated_res_0x7f0a0005);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = integer;
        stateListAnimator.addState(new int[]{16842766, R.attr.obfuscated_res_0x7f0406c9, -2130970314}, ObjectAnimator.ofFloat(view2, Key.ELEVATION, 0.0f).setDuration(j));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view2, Key.ELEVATION, f).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view2, Key.ELEVATION, 0.0f).setDuration(0L));
        view2.setStateListAnimator(stateListAnimator);
    }

    public static void setStateListAnimatorFromAttrs(@NonNull View view2, AttributeSet attributeSet, int i, int i2) {
        Context context = view2.getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, STATE_LIST_ANIM_ATTRS, i, i2, new int[0]);
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                view2.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, obtainStyledAttributes.getResourceId(0, 0)));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
