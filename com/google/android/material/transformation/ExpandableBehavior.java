package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;
@Deprecated
/* loaded from: classes10.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    public static final int STATE_COLLAPSED = 2;
    public static final int STATE_EXPANDED = 1;
    public static final int STATE_UNINITIALIZED = 0;
    public int currentState;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view2, View view3);

    public abstract boolean onExpandedStateChange(View view2, View view3, boolean z, boolean z2);

    public ExpandableBehavior() {
        this.currentState = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentState = 0;
    }

    @Nullable
    public static <T extends ExpandableBehavior> T from(@NonNull View view2, @NonNull Class<T> cls) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof ExpandableBehavior) {
                return cls.cast(behavior);
            }
            throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    @Nullable
    public ExpandableWidget findExpandableWidget(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view2) {
        List<View> dependencies = coordinatorLayout.getDependencies(view2);
        int size = dependencies.size();
        for (int i = 0; i < size; i++) {
            View view3 = dependencies.get(i);
            if (layoutDependsOn(coordinatorLayout, view2, view3)) {
                return (ExpandableWidget) view3;
            }
        }
        return null;
    }

    private boolean didStateChange(boolean z) {
        if (z) {
            int i = this.currentState;
            if (i != 0 && i != 2) {
                return false;
            }
            return true;
        } else if (this.currentState != 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view2, View view3) {
        int i;
        ExpandableWidget expandableWidget = (ExpandableWidget) view3;
        if (didStateChange(expandableWidget.isExpanded())) {
            if (expandableWidget.isExpanded()) {
                i = 1;
            } else {
                i = 2;
            }
            this.currentState = i;
            return onExpandedStateChange((View) expandableWidget, view2, expandableWidget.isExpanded(), true);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull final View view2, int i) {
        final ExpandableWidget findExpandableWidget;
        final int i2;
        if (!ViewCompat.isLaidOut(view2) && (findExpandableWidget = findExpandableWidget(coordinatorLayout, view2)) != null && didStateChange(findExpandableWidget.isExpanded())) {
            if (findExpandableWidget.isExpanded()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            this.currentState = i2;
            view2.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.transformation.ExpandableBehavior.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    view2.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (ExpandableBehavior.this.currentState == i2) {
                        ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                        ExpandableWidget expandableWidget = findExpandableWidget;
                        expandableBehavior.onExpandedStateChange((View) expandableWidget, view2, expandableWidget.isExpanded(), false);
                    }
                    return false;
                }
            });
            return false;
        }
        return false;
    }
}
