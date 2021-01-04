package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
@Keep
/* loaded from: classes5.dex */
public class KSViewOffsetBehavior<V extends View> extends KSCoordinatorLayout.Behavior<V> {
    private int mTempLeftRightOffset;
    private int mTempTopBottomOffset;
    private KSViewOffsetHelper mViewOffsetHelper;

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
        if (this.mViewOffsetHelper != null) {
            return this.mViewOffsetHelper.getLeftAndRightOffset();
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        if (this.mViewOffsetHelper != null) {
            return this.mViewOffsetHelper.getTopAndBottomOffset();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        if (this.mTempTopBottomOffset != 0) {
            this.mViewOffsetHelper.setTopAndBottomOffset(this.mTempTopBottomOffset);
            this.mTempTopBottomOffset = 0;
        }
        if (this.mTempLeftRightOffset != 0) {
            this.mViewOffsetHelper.setLeftAndRightOffset(this.mTempLeftRightOffset);
            this.mTempLeftRightOffset = 0;
            return true;
        }
        return true;
    }

    public boolean setLeftAndRightOffset(int i) {
        if (this.mViewOffsetHelper != null) {
            return this.mViewOffsetHelper.setLeftAndRightOffset(i);
        }
        this.mTempLeftRightOffset = i;
        return false;
    }

    public boolean setTopAndBottomOffset(int i) {
        if (this.mViewOffsetHelper != null) {
            return this.mViewOffsetHelper.setTopAndBottomOffset(i);
        }
        this.mTempTopBottomOffset = i;
        return false;
    }
}
