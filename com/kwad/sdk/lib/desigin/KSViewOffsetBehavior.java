package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
@Keep
/* loaded from: classes6.dex */
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

    public void layoutChild(KSCoordinatorLayout kSCoordinatorLayout, V v, int i) {
        kSCoordinatorLayout.onLayoutChild(v, i);
    }

    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onLayoutChild(KSCoordinatorLayout kSCoordinatorLayout, V v, int i) {
        layoutChild(kSCoordinatorLayout, v, i);
        if (this.mViewOffsetHelper == null) {
            this.mViewOffsetHelper = new KSViewOffsetHelper(v);
        }
        this.mViewOffsetHelper.onViewLayout();
        int i2 = this.mTempTopBottomOffset;
        if (i2 != 0) {
            this.mViewOffsetHelper.setTopAndBottomOffset(i2);
            this.mTempTopBottomOffset = 0;
        }
        int i3 = this.mTempLeftRightOffset;
        if (i3 != 0) {
            this.mViewOffsetHelper.setLeftAndRightOffset(i3);
            this.mTempLeftRightOffset = 0;
            return true;
        }
        return true;
    }

    public boolean setLeftAndRightOffset(int i) {
        KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
        if (kSViewOffsetHelper != null) {
            return kSViewOffsetHelper.setLeftAndRightOffset(i);
        }
        this.mTempLeftRightOffset = i;
        return false;
    }

    public boolean setTopAndBottomOffset(int i) {
        KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
        if (kSViewOffsetHelper != null) {
            return kSViewOffsetHelper.setTopAndBottomOffset(i);
        }
        this.mTempTopBottomOffset = i;
        return false;
    }
}
