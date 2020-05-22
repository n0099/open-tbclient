package com.kascend.chushou.widget.dispalymenu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends b {
    @Override // com.kascend.chushou.widget.dispalymenu.b
    public int a(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < this.a.getChildCount(); i4++) {
            View childAt = this.a.getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                i3 += childAt.getMeasuredHeight();
                if (i4 != this.a.getChildCount() - 1) {
                    i3 += this.d;
                }
            }
        }
        return i3;
    }

    @Override // com.kascend.chushou.widget.dispalymenu.b
    public int b(int i, int i2) {
        return i2;
    }

    @Override // com.kascend.chushou.widget.dispalymenu.b
    public int c(int i, int i2) {
        return this.e + i + this.b.getMeasuredHeight();
    }

    @Override // com.kascend.chushou.widget.dispalymenu.b
    public int dB(int i, int i2) {
        return i2;
    }

    @Override // com.kascend.chushou.widget.dispalymenu.b
    public void b(boolean z, int i, int i2, int i3, int i4) {
        int i5 = (i3 - i) / 2;
        int paddingTop = this.a.getPaddingTop();
        for (int i6 = 0; i6 < this.a.getChildCount(); i6++) {
            View childAt = this.a.getChildAt(i6);
            if (childAt.getVisibility() != 8 && childAt != this.b) {
                childAt.setTranslationX(0.0f);
                int measuredWidth = i5 - (childAt.getMeasuredWidth() / 2);
                childAt.layout(measuredWidth, paddingTop, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + paddingTop);
                paddingTop += childAt.getMeasuredHeight() + this.d;
            }
        }
        this.b.layout(0, 0, 0, 0);
    }

    @Override // com.kascend.chushou.widget.dispalymenu.b
    public void a(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7 = (i5 - i3) / 2;
        int paddingTop = this.a.getPaddingTop();
        boolean z2 = false;
        for (int i8 = 0; i8 < this.a.getChildCount(); i8++) {
            View childAt = this.a.getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (childAt == this.b || childAt == this.c) {
                    int measuredWidth = i7 - (childAt.getMeasuredWidth() / 2);
                    childAt.layout(measuredWidth, paddingTop, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + paddingTop);
                    paddingTop += this.e + i;
                } else {
                    childAt.setAlpha(1.0f);
                    childAt.setTranslationY(0.0f);
                    if (z2) {
                        int measuredWidth2 = i7 - (childAt.getMeasuredWidth() / 2);
                        int paddingTop2 = this.a.getPaddingTop();
                        childAt.layout(measuredWidth2, paddingTop2, childAt.getMeasuredWidth() + measuredWidth2, childAt.getMeasuredHeight() + paddingTop2);
                        childAt.setTranslationX(i);
                    } else {
                        int measuredWidth3 = i7 - (childAt.getMeasuredWidth() / 2);
                        int paddingTop3 = this.a.getPaddingTop();
                        childAt.layout(measuredWidth3, paddingTop3, childAt.getMeasuredWidth() + measuredWidth3, childAt.getMeasuredHeight() + paddingTop3);
                        z2 = true;
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.widget.dispalymenu.b
    public void a(ArrayList<Animator> arrayList, ArrayList<Animator> arrayList2, AnimatorSet animatorSet, int i, int i2) {
        boolean z = false;
        int i3 = 0;
        for (int i4 = 0; i4 < this.a.getChildCount(); i4++) {
            View childAt = this.a.getChildAt(i4);
            if (childAt == this.c && this.c.getVisibility() != 8) {
                i3 = (i3 - this.c.getMeasuredHeight()) - this.d;
            } else if (childAt == this.b) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", ((-this.b.getMeasuredHeight()) - this.e) - (i / 2), 0.0f);
                ofFloat.setStartDelay(870L);
                ofFloat.setDuration(330L);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(childAt, "alpha", 0.0f, 1.0f);
                ofFloat2.setStartDelay(870L);
                ofFloat2.setDuration(330L);
                animatorSet.playTogether(ofFloat, ofFloat2);
            } else if (childAt.getVisibility() != 8) {
                arrayList.add(ObjectAnimator.ofFloat(childAt, "translationY", i3, 0.0f));
                if (z) {
                    arrayList.add(ObjectAnimator.ofFloat(childAt, "alpha", 0.0f, 1.0f));
                }
                arrayList2.add(ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, i3));
                if (z) {
                    arrayList2.add(ObjectAnimator.ofFloat(childAt, "alpha", 1.0f, 0.0f));
                }
                z = true;
                i3 = (i3 - childAt.getMeasuredHeight()) - this.d;
            }
        }
    }
}
