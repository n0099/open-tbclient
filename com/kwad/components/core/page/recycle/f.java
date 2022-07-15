package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.aj;
/* loaded from: classes5.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RecyclerView a;
    public final RecyclerView.LayoutManager b;

    public f(RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = recyclerView;
        this.b = recyclerView.getLayoutManager();
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            OrientationHelper createVerticalHelper = this.b.canScrollVertically() ? OrientationHelper.createVerticalHelper(this.b) : OrientationHelper.createHorizontalHelper(this.b);
            int startAfterPadding = createVerticalHelper.getStartAfterPadding();
            int endAfterPadding = createVerticalHelper.getEndAfterPadding();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View childAt = this.b.getChildAt(i);
                int decoratedStart = createVerticalHelper.getDecoratedStart(childAt);
                int decoratedEnd = createVerticalHelper.getDecoratedEnd(childAt);
                if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                    return childAt;
                }
                i += i3;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public static f a(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, recyclerView)) == null) {
            aj.a(recyclerView);
            return new f(recyclerView);
        }
        return (f) invokeL.objValue;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View a = a(0, this.b.getChildCount(), false, true);
            if (a == null) {
                return -1;
            }
            return this.a.getChildAdapterPosition(a);
        }
        return invokeV.intValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View a = a(this.b.getChildCount() - 1, -1, false, true);
            if (a == null) {
                return -1;
            }
            return this.a.getChildAdapterPosition(a);
        }
        return invokeV.intValue;
    }
}
