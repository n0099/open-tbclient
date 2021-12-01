package com.tachikoma.core.component.recyclerview.view;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class RecyclerViewPositionHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RecyclerView.LayoutManager layoutManager;
    public final RecyclerView recyclerView;

    public RecyclerViewPositionHelper(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.recyclerView = recyclerView;
        this.layoutManager = recyclerView.getLayoutManager();
    }

    public static RecyclerViewPositionHelper createHelper(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, recyclerView)) == null) {
            if (recyclerView != null) {
                return new RecyclerViewPositionHelper(recyclerView);
            }
            throw new NullPointerException("Recycler View is null");
        }
        return (RecyclerViewPositionHelper) invokeL.objValue;
    }

    private View findOneVisibleChild(int i2, int i3, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            OrientationHelper createVerticalHelper = this.layoutManager.canScrollVertically() ? OrientationHelper.createVerticalHelper(this.layoutManager) : OrientationHelper.createHorizontalHelper(this.layoutManager);
            int startAfterPadding = createVerticalHelper.getStartAfterPadding();
            int endAfterPadding = createVerticalHelper.getEndAfterPadding();
            int i4 = i3 > i2 ? 1 : -1;
            View view = null;
            while (i2 != i3) {
                View childAt = this.layoutManager.getChildAt(i2);
                int decoratedStart = createVerticalHelper.getDecoratedStart(childAt);
                int decoratedEnd = createVerticalHelper.getDecoratedEnd(childAt);
                if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                    if (!z) {
                        return childAt;
                    }
                    if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return childAt;
                    }
                    if (z2 && view == null) {
                        view = childAt;
                    }
                }
                i2 += i4;
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View findOneVisibleChild = findOneVisibleChild(0, this.layoutManager.getChildCount(), true, false);
            if (findOneVisibleChild == null) {
                return -1;
            }
            return this.recyclerView.getChildAdapterPosition(findOneVisibleChild);
        }
        return invokeV.intValue;
    }

    public int findFirstVisibleItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View findOneVisibleChild = findOneVisibleChild(0, this.layoutManager.getChildCount(), false, true);
            if (findOneVisibleChild == null) {
                return -1;
            }
            return this.recyclerView.getChildAdapterPosition(findOneVisibleChild);
        }
        return invokeV.intValue;
    }

    public int findLastCompletelyVisibleItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View findOneVisibleChild = findOneVisibleChild(this.layoutManager.getChildCount() - 1, -1, true, false);
            if (findOneVisibleChild == null) {
                return -1;
            }
            return this.recyclerView.getChildAdapterPosition(findOneVisibleChild);
        }
        return invokeV.intValue;
    }

    public int findLastVisibleItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View findOneVisibleChild = findOneVisibleChild(this.layoutManager.getChildCount() - 1, -1, false, true);
            if (findOneVisibleChild == null) {
                return -1;
            }
            return this.recyclerView.getChildAdapterPosition(findOneVisibleChild);
        }
        return invokeV.intValue;
    }

    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RecyclerView.LayoutManager layoutManager = this.layoutManager;
            if (layoutManager == null) {
                return 0;
            }
            return layoutManager.getItemCount();
        }
        return invokeV.intValue;
    }

    public int getVisibleItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RecyclerView.LayoutManager layoutManager = this.layoutManager;
            if (layoutManager == null) {
                return 0;
            }
            return layoutManager.getChildCount();
        }
        return invokeV.intValue;
    }
}
