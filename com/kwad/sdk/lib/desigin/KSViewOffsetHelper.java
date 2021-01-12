package com.kwad.sdk.lib.desigin;

import android.view.View;
import androidx.annotation.Keep;
import androidx.core.view.ViewCompat;
/* JADX INFO: Access modifiers changed from: package-private */
@Keep
/* loaded from: classes4.dex */
public class KSViewOffsetHelper {
    private int mLayoutLeft;
    private int mLayoutTop;
    private int mOffsetLeft;
    private int mOffsetTop;
    private final View mView;

    public KSViewOffsetHelper(View view) {
        this.mView = view;
    }

    private void updateOffsets() {
        ViewCompat.offsetTopAndBottom(this.mView, this.mOffsetTop - (this.mView.getTop() - this.mLayoutTop));
        ViewCompat.offsetLeftAndRight(this.mView, this.mOffsetLeft - (this.mView.getLeft() - this.mLayoutLeft));
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

    public boolean setLeftAndRightOffset(int i) {
        if (this.mOffsetLeft != i) {
            this.mOffsetLeft = i;
            updateOffsets();
            return true;
        }
        return false;
    }

    public boolean setTopAndBottomOffset(int i) {
        if (this.mOffsetTop != i) {
            this.mOffsetTop = i;
            updateOffsets();
            return true;
        }
        return false;
    }
}
