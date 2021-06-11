package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
@Keep
/* loaded from: classes7.dex */
public class KSViewOffsetBehavior<V extends View> extends KSCoordinatorLayout.Behavior<V> {
    public int mTempLeftRightOffset;
    public int mTempTopBottomOffset;
    public KSViewOffsetHelper mViewOffsetHelper;

    public KSViewOffsetBehavior() {
        this.mTempTopBottomOffset = 0;
        this.mTempLeftRightOffset = 0;
    }

    public KSViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempTopBottomOffset = 0;
        this.mTempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
        if (kSViewOffsetHelper != null) {
            return kSViewOffsetHelper.getLeftAndRightOffset();
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
        if (kSViewOffsetHelper != null) {
            return kSViewOffsetHelper.getTopAndBottomOffset();
        }
        return 0;
    }

    public void layoutChild(KSCoordinatorLayout kSCoordinatorLayout, V v, int i2) {
        kSCoordinatorLayout.onLayoutChild(v, i2);
    }

    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onLayoutChild(KSCoordinatorLayout kSCoordinatorLayout, V v, int i2) {
        layoutChild(kSCoordinatorLayout, v, i2);
        if (this.mViewOffsetHelper == null) {
            this.mViewOffsetHelper = new KSViewOffsetHelper(v);
        }
        this.mViewOffsetHelper.onViewLayout();
        int i3 = this.mTempTopBottomOffset;
        if (i3 != 0) {
            this.mViewOffsetHelper.setTopAndBottomOffset(i3);
            this.mTempTopBottomOffset = 0;
        }
        int i4 = this.mTempLeftRightOffset;
        if (i4 != 0) {
            this.mViewOffsetHelper.setLeftAndRightOffset(i4);
            this.mTempLeftRightOffset = 0;
            return true;
        }
        return true;
    }

    public boolean setLeftAndRightOffset(int i2) {
        KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
        if (kSViewOffsetHelper != null) {
            return kSViewOffsetHelper.setLeftAndRightOffset(i2);
        }
        this.mTempLeftRightOffset = i2;
        return false;
    }

    public boolean setTopAndBottomOffset(int i2) {
        KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
        if (kSViewOffsetHelper != null) {
            return kSViewOffsetHelper.setTopAndBottomOffset(i2);
        }
        this.mTempTopBottomOffset = i2;
        return false;
    }
}
