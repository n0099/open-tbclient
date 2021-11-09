package com.kwad.sdk.core.page.recycle;

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
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f64914a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView.LayoutManager f64915b;

    public f(RecyclerView recyclerView) {
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
        this.f64914a = recyclerView;
        this.f64915b = recyclerView.getLayoutManager();
    }

    private View a(int i2, int i3, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            OrientationHelper createVerticalHelper = this.f64915b.canScrollVertically() ? OrientationHelper.createVerticalHelper(this.f64915b) : OrientationHelper.createHorizontalHelper(this.f64915b);
            int startAfterPadding = createVerticalHelper.getStartAfterPadding();
            int endAfterPadding = createVerticalHelper.getEndAfterPadding();
            int i4 = i3 > i2 ? 1 : -1;
            View view = null;
            while (i2 != i3) {
                View childAt = this.f64915b.getChildAt(i2);
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

    public static f a(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, recyclerView)) == null) {
            if (recyclerView != null) {
                return new f(recyclerView);
            }
            throw new NullPointerException("Recycler View is null");
        }
        return (f) invokeL.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View a2 = a(0, this.f64915b.getChildCount(), false, true);
            if (a2 == null) {
                return -1;
            }
            return this.f64914a.getChildAdapterPosition(a2);
        }
        return invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View a2 = a(this.f64915b.getChildCount() - 1, -1, false, true);
            if (a2 == null) {
                return -1;
            }
            return this.f64914a.getChildAdapterPosition(a2);
        }
        return invokeV.intValue;
    }
}
