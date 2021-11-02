package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class ExpandableWidgetHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean expanded;
    @IdRes
    public int expandedComponentIdHint;
    @NonNull
    public final View widget;

    public ExpandableWidgetHelper(ExpandableWidget expandableWidget) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {expandableWidget};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.expanded = false;
        this.expandedComponentIdHint = 0;
        this.widget = (View) expandableWidget;
    }

    private void dispatchExpandedStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            ViewParent parent = this.widget.getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.widget);
            }
        }
    }

    @IdRes
    public int getExpandedComponentIdHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.expandedComponentIdHint : invokeV.intValue;
    }

    public boolean isExpanded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.expanded : invokeV.booleanValue;
    }

    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            this.expanded = bundle.getBoolean("expanded", false);
            this.expandedComponentIdHint = bundle.getInt("expandedComponentIdHint", 0);
            if (this.expanded) {
                dispatchExpandedStateChanged();
            }
        }
    }

    @NonNull
    public Bundle onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("expanded", this.expanded);
            bundle.putInt("expandedComponentIdHint", this.expandedComponentIdHint);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public boolean setExpanded(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (this.expanded != z) {
                this.expanded = z;
                dispatchExpandedStateChanged();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void setExpandedComponentIdHint(@IdRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.expandedComponentIdHint = i2;
        }
    }
}
