package com.kwad.sdk.lib.desigin;

import android.view.View;
import androidx.annotation.Keep;
import androidx.core.view.ViewCompat;
@Keep
/* loaded from: classes7.dex */
public class KSViewOffsetHelper {
    public int mLayoutLeft;
    public int mLayoutTop;
    public int mOffsetLeft;
    public int mOffsetTop;
    public final View mView;

    public KSViewOffsetHelper(View view) {
        this.mView = view;
    }

    private void updateOffsets() {
        View view = this.mView;
        ViewCompat.offsetTopAndBottom(view, this.mOffsetTop - (view.getTop() - this.mLayoutTop));
        View view2 = this.mView;
        ViewCompat.offsetLeftAndRight(view2, this.mOffsetLeft - (view2.getLeft() - this.mLayoutLeft));
    }

    public int getLayoutLeft() {
        return this.mLayoutLeft;
    }

    public int getLayoutTop() {
        return this.mLayoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.mOffsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.mOffsetTop;
    }

    public void onViewLayout() {
        this.mLayoutTop = this.mView.getTop();
        this.mLayoutLeft = this.mView.getLeft();
        updateOffsets();
    }

    public boolean setLeftAndRightOffset(int i2) {
        if (this.mOffsetLeft != i2) {
            this.mOffsetLeft = i2;
            updateOffsets();
            return true;
        }
        return false;
    }

    public boolean setTopAndBottomOffset(int i2) {
        if (this.mOffsetTop != i2) {
            this.mOffsetTop = i2;
            updateOffsets();
            return true;
        }
        return false;
    }
}
