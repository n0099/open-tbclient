package com.kwai.library.widget.refresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.LayoutRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwai.library.widget.refresh.RefreshLayout;
/* loaded from: classes3.dex */
public class b extends RefreshLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @LayoutRes
    public int mRefreshLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public View getRefreshView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRefreshView : (View) invokeV.objValue;
    }

    @Override // com.kwai.library.widget.refresh.RefreshLayout
    public c onCreateDragDistanceConvert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(getContext()) : (c) invokeV.objValue;
    }

    @Override // com.kwai.library.widget.refresh.RefreshLayout
    public RefreshLayout.a onCreateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, attributeSet)) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CustomRefreshLayout);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.CustomRefreshLayout_refreshViewWidth, this.mRefreshViewSize);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.CustomRefreshLayout_refreshViewWidth, this.mRefreshViewSize);
            obtainStyledAttributes.recycle();
            return new RefreshLayout.a(dimensionPixelOffset, dimensionPixelOffset2);
        }
        return (RefreshLayout.a) invokeL.objValue;
    }

    @Override // com.kwai.library.widget.refresh.RefreshLayout
    public View onCreateRefreshView(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, attributeSet)) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CustomRefreshLayout);
            this.mRefreshLayout = obtainStyledAttributes.getResourceId(R.styleable.CustomRefreshLayout_refreshLayout, 0);
            obtainStyledAttributes.recycle();
            int a = g.a(getContext(), 22.5f);
            View kwaiRefreshView = this.mRefreshLayout == 0 ? new KwaiRefreshView(getContext()) : g.a(getContext(), this.mRefreshLayout);
            kwaiRefreshView.setPadding(a, a, a, a);
            return kwaiRefreshView;
        }
        return (View) invokeL.objValue;
    }

    public void setRefreshStatus(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.mRefreshStatus = fVar;
        }
    }

    public void setRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.mRefreshView = view;
        }
    }
}
