package com.kwad.sdk.lib.desigin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
import java.util.Arrays;
@Keep
/* loaded from: classes3.dex */
public abstract class CustomActionBarBehavior extends KSCoordinatorLayout.Behavior<RelativeLayout> {
    private int mActionBarBgColor;
    private float mActionBarColorChangeRange;
    private float mActionBarHeight;
    private Activity mActivity;

    public CustomActionBarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        int i2;
        if (context instanceof Activity) {
            this.mActivity = (Activity) context;
        }
        Resources resources = context.getResources();
        if (resources != null) {
            this.mActionBarBgColor = -1;
            i = (int) resources.getDimension(R.dimen.ksad_title_bar_height);
        } else {
            i = 0;
        }
        int i3 = R.attr.ksad_action_bar_height;
        int i4 = R.attr.ksad_action_bar_bg_color;
        int[] iArr = {i3, i4, R.attr.ksad_color_change_range};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.mActionBarHeight = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i3), i);
        this.mActionBarBgColor = obtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i4), this.mActionBarBgColor);
        this.mActionBarColorChangeRange = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i2), i);
        obtainStyledAttributes.recycle();
    }

    protected int getColorWithAlpha(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (255.0f * f))) << 24) + (16777215 & i);
    }

    protected abstract void initView(RelativeLayout relativeLayout);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean layoutDependsOn(KSCoordinatorLayout kSCoordinatorLayout, RelativeLayout relativeLayout, View view) {
        return view instanceof KSAppBarLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActionBarHeightChanged(RelativeLayout relativeLayout, float f) {
        initView(relativeLayout);
        relativeLayout.setBackgroundColor(getColorWithAlpha(transRatio(0.08f, 1.0f, f), this.mActionBarBgColor));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onDependentViewChanged(KSCoordinatorLayout kSCoordinatorLayout, RelativeLayout relativeLayout, View view) {
        onActionBarHeightChanged(relativeLayout, Math.min((-view.getTop()) / (this.mActionBarColorChangeRange - this.mActionBarHeight), 1.0f));
        return true;
    }

    public void setActionBarColorChangeRange(int i) {
        this.mActionBarColorChangeRange = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float transRatio(float f, float f2, float f3) {
        if (f3 < f) {
            return 0.0f;
        }
        if (f3 > f2) {
            return 1.0f;
        }
        return (f3 - f) / (f2 - f);
    }
}
