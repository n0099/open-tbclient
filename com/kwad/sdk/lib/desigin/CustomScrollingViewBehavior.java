package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
@Keep
/* loaded from: classes6.dex */
public class CustomScrollingViewBehavior extends KSAppBarLayout.ScrollingViewBehavior {
    public CustomScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.ScrollingViewBehavior, com.kwad.sdk.lib.desigin.KSHeaderScrollingViewBehavior
    @Keep
    public int getScrollRange(View view) {
        if (view instanceof KSAppBarLayout) {
            KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) view.getLayoutParams()).getBehavior();
            boolean z = behavior instanceof CustomAppBarCustomAttrListener;
            int totalScrollRange = ((KSAppBarLayout) view).getTotalScrollRange();
            return z ? totalScrollRange - ((CustomAppBarCustomAttrListener) behavior).getExtraFixedSize() : totalScrollRange;
        }
        return super.getScrollRange(view);
    }
}
