package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;
/* loaded from: classes9.dex */
public class ViewOffsetHelper {
    public int layoutLeft;
    public int layoutTop;
    public int offsetLeft;
    public int offsetTop;

    /* renamed from: view  reason: collision with root package name */
    public final View f1206view;
    public boolean verticalOffsetEnabled = true;
    public boolean horizontalOffsetEnabled = true;

    public ViewOffsetHelper(View view2) {
        this.f1206view = view2;
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        this.horizontalOffsetEnabled = z;
    }

    public boolean setLeftAndRightOffset(int i) {
        if (this.horizontalOffsetEnabled && this.offsetLeft != i) {
            this.offsetLeft = i;
            applyOffsets();
            return true;
        }
        return false;
    }

    public boolean setTopAndBottomOffset(int i) {
        if (this.verticalOffsetEnabled && this.offsetTop != i) {
            this.offsetTop = i;
            applyOffsets();
            return true;
        }
        return false;
    }

    public void setVerticalOffsetEnabled(boolean z) {
        this.verticalOffsetEnabled = z;
    }

    public void applyOffsets() {
        View view2 = this.f1206view;
        ViewCompat.offsetTopAndBottom(view2, this.offsetTop - (view2.getTop() - this.layoutTop));
        View view3 = this.f1206view;
        ViewCompat.offsetLeftAndRight(view3, this.offsetLeft - (view3.getLeft() - this.layoutLeft));
    }

    public int getLayoutLeft() {
        return this.layoutLeft;
    }

    public int getLayoutTop() {
        return this.layoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    public boolean isHorizontalOffsetEnabled() {
        return this.horizontalOffsetEnabled;
    }

    public boolean isVerticalOffsetEnabled() {
        return this.verticalOffsetEnabled;
    }

    public void onViewLayout() {
        this.layoutTop = this.f1206view.getTop();
        this.layoutLeft = this.f1206view.getLeft();
    }
}
