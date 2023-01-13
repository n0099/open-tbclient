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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;
@Deprecated
/* loaded from: classes8.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_COLLAPSED = 2;
    public static final int STATE_EXPANDED = 1;
    public static final int STATE_UNINITIALIZED = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentState;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view2, View view3);

    public abstract boolean onExpandedStateChange(View view2, View view3, boolean z, boolean z2);

    public ExpandableBehavior() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.currentState = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.currentState = 0;
    }

    @Nullable
    public static <T extends ExpandableBehavior> T from(@NonNull View view2, @NonNull Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2, cls)) == null) {
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
        return (T) invokeLL.objValue;
    }

    private boolean didStateChange(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, this, z)) == null) {
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
        return invokeZ.booleanValue;
    }

    @Nullable
    public ExpandableWidget findExpandableWidget(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, coordinatorLayout, view2)) == null) {
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
        return (ExpandableWidget) invokeLL.objValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view2, View view3) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, coordinatorLayout, view2, view3)) == null) {
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
        return invokeLLL.booleanValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view2, int i) {
        InterceptResult invokeLLI;
        ExpandableWidget findExpandableWidget;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, coordinatorLayout, view2, i)) == null) {
            if (!ViewCompat.isLaidOut(view2) && (findExpandableWidget = findExpandableWidget(coordinatorLayout, view2)) != null && didStateChange(findExpandableWidget.isExpanded())) {
                if (findExpandableWidget.isExpanded()) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                this.currentState = i2;
                view2.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(this, view2, i2, findExpandableWidget) { // from class: com.google.android.material.transformation.ExpandableBehavior.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ExpandableBehavior this$0;
                    public final /* synthetic */ View val$child;
                    public final /* synthetic */ ExpandableWidget val$dep;
                    public final /* synthetic */ int val$expectedState;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, view2, Integer.valueOf(i2), findExpandableWidget};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$child = view2;
                        this.val$expectedState = i2;
                        this.val$dep = findExpandableWidget;
                    }

                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            this.val$child.getViewTreeObserver().removeOnPreDrawListener(this);
                            if (this.this$0.currentState == this.val$expectedState) {
                                ExpandableBehavior expandableBehavior = this.this$0;
                                ExpandableWidget expandableWidget = this.val$dep;
                                expandableBehavior.onExpandedStateChange((View) expandableWidget, this.val$child, expandableWidget.isExpanded(), false);
                            }
                            return false;
                        }
                        return invokeV.booleanValue;
                    }
                });
                return false;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }
}
